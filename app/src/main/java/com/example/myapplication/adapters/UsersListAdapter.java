package com.example.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.ItemDetailActivity;
import com.example.myapplication.ItemDetailFragment;
import com.example.myapplication.ItemListActivity;
import com.example.myapplication.R;
import com.example.myapplication.dataobject.User;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class UsersListAdapter
        extends RecyclerView.Adapter<UsersListAdapter.ViewHolder> {

    private final ItemListActivity mParentActivity;
    private List<User> mValues;
    private final boolean mTwoPane;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            User item = (User) view.getTag();
            if (mTwoPane) {
                Bundle arguments = new Bundle();
                arguments.putSerializable(ItemDetailFragment.ARG_ITEM, item);
                ItemDetailFragment fragment = new ItemDetailFragment();
                fragment.setArguments(arguments);
                mParentActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.item_detail_container, fragment)
                        .commit();
            } else {
                Context context = view.getContext();
                Intent intent = new Intent(context, ItemDetailActivity.class);
                intent.putExtra(ItemDetailFragment.ARG_ITEM, item);

                context.startActivity(intent);
            }
        }
    };

    public UsersListAdapter(ItemListActivity parent,
                            List<User> items,
                            boolean twoPane) {
        mValues = items;
        mParentActivity = parent;
        mTwoPane = twoPane;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mContentView.setText(mValues.get(position).getLogin());

        holder.itemView.setTag(mValues.get(position));
        holder.itemView.setOnClickListener(mOnClickListener);
        Glide.with(mParentActivity)
                .load(mValues.get(position).getAvatar_url())
                .override(300, 300)
                .transform(new RoundedCornersTransformation(30, 10))
                .into(holder.mIvProfilePic);
    }

    @Override
    public int getItemCount() {
        if (mValues == null) {
            return 0;
        }
        return mValues.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView mIvProfilePic;
        final TextView mContentView;

        ViewHolder(View view) {
            super(view);
            mIvProfilePic = view.findViewById(R.id.iv_profile);
            mContentView = view.findViewById(R.id.content);
        }
    }

    public void refreshData(List<User> users) {
        mValues = users;
        notifyDataSetChanged();
    }
}