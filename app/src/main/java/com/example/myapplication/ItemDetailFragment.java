package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.myapplication.dataobject.User;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private User mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null && getArguments().containsKey(ARG_ITEM)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = (User) getArguments().getSerializable(ARG_ITEM);

            Activity activity = this.getActivity();
            assert activity != null;
            CollapsingToolbarLayout appBarLayout = activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getLogin());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            String profileUrl = getString(R.string.profile_url, mItem.getHtml_url());
            String reposUrl = getString(R.string.repos_url, mItem.getRepos_url());
            String orgUrl = getString(R.string.org_url, mItem.getOrganizations_url());
            ((TextView) rootView.findViewById(R.id.profile_url)).setText(profileUrl);
            ((TextView) rootView.findViewById(R.id.repos_url)).setText(reposUrl);
            ((TextView) rootView.findViewById(R.id.org_url)).setText(orgUrl);
        }

        return rootView;
    }
}
