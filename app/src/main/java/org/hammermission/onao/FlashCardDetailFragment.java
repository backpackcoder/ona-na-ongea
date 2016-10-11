package org.hammermission.onao;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.hammermission.onao.dummy.Card;

/**
 * A fragment representing a single Card detail screen.
 * This fragment is either contained in a {@link FlashCardListActivity}
 * in two-pane mode (on tablets) or a {@link FlashCardDetailActivity}
 * on handsets.
 */
public class FlashCardDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Card mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FlashCardDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = Card.MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.kiiswahili);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.flashcard_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            String details = "English: " + mItem.english +" /n/n Image: " + mItem.imageResourceId +
                    " /n/n Audio: " +  mItem.audioResourceId;
            ((TextView) rootView.findViewById(R.id.flashcard_detail)).setText(details);
        }

        return rootView;
    }
}
