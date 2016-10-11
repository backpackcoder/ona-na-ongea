package org.hammermission.onao;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.hammermission.onao.dummy.Card;


public class CardActivity extends AppCompatActivity {
    public static final String TAG = CardActivity.class.getSimpleName();
    private static final String STATE_CARD_ID = "card-id";
    private static final String STATE_ENGLISH_VISIBLE = "english-visible";

    private TextView mEnglishTextView;
    private ImageView mImageView;
    private int mEnglishVisibility = View.INVISIBLE;
    private int mCardId = 0;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_CARD_ID, mCardId);
        outState.putInt(STATE_ENGLISH_VISIBLE, mEnglishVisibility);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCardId = savedInstanceState.getInt(STATE_CARD_ID, 0);
        mEnglishVisibility =savedInstanceState.getInt(STATE_ENGLISH_VISIBLE, View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        mImageView = (ImageView)findViewById(R.id.picture);
        mEnglishTextView = ((TextView)findViewById(R.id.english));
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEnglishVisibility == View.INVISIBLE) {
                    mEnglishVisibility = View.VISIBLE;
                } else {
                    mEnglishVisibility = View.INVISIBLE;
                    nextCard();
                }
                renderCard(true);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        renderCard(false);
    }

    /**
     * Renders the current card
     * @param playSound {boolean} If true, then play the audio for the card
     */
    private void renderCard(boolean playSound) {
        Log.d(TAG, "Rendering card " + mCardId + " English text is visible: " +
                (mEnglishVisibility == View.VISIBLE));
        Card card = Card.LIST.get(mCardId);
        ((TextView)findViewById(R.id.kiswahili)).setText(card.kiiswahili);
        mImageView.setImageResource(card.imageResourceId);
        mEnglishTextView.setText(card.english);
        mEnglishTextView.setVisibility(mEnglishVisibility);
        if (mEnglishVisibility == View.VISIBLE && playSound) {
            Log.d(TAG, "Playing audio");
            MediaPlayer mediaPlayer = MediaPlayer.create(this, card.audioResourceId);
            mediaPlayer.start();
        }
    }

    /**
     * Moves to the next card
     */
    private void nextCard() {
        mCardId ++;
        if (mCardId == Card.LIST.size()) {
            mCardId = 0;
        }
    }
}
