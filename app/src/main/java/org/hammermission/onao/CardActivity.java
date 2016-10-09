package org.hammermission.onao;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


public class CardActivity extends AppCompatActivity {
    public static final String TAG = CardActivity.class.getName();
    static final int REQUEST_TAKE_PHOTO = 1;

    private ImageView mPicture;
    private Uri mCurrentPhotoUri;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "Creating");
        setContentView(R.layout.activity_card);
        mPicture = (ImageView)findViewById(R.id.ivPicture);

        ImageButton button = (ImageButton)findViewById(R.id.butPicture);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mCurrentPhotoUri != null) {
            outState.putParcelable("photoUri", mCurrentPhotoUri);
            Log.d(TAG, "Saved uri " + mCurrentPhotoUri);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("photoUri")) {
            mCurrentPhotoUri = savedInstanceState.getParcelable("photoUri");
            mPicture.setImageURI(mCurrentPhotoUri);
            Log.d(TAG, "Loaded uri " + mCurrentPhotoUri);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_TAKE_PHOTO) {
            if (resultCode == RESULT_OK) {
                Log.d(TAG, "Image URI is " + data.getDataString());
                mCurrentPhotoUri = data.getData();
                mPicture.setImageURI(mCurrentPhotoUri);
            } else if (resultCode == RESULT_CANCELED) {
                // User cancelled the image capture
            } else {
                // Image capture failed, advise user
            }
        }
    }
}
