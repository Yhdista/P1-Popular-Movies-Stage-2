/*
 * Copyright (C) 2013 The Android Open Source Project
 */
package com.yhdista.nanodegree.p2.fragments;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.yhdista.nanodegree.p2.R;
import com.yhdista.nanodegree.p2.abstracts.MyBasicFragment;
import com.yhdista.nanodegree.p2.constants.C;
import com.yhdista.nanodegree.p2.oodesign.Movie;
import com.yhdista.nanodegree.p2.utils.U;

/**
 * Detail Fragment
 */
public class DetailFragment extends MyBasicFragment {

    private TextView mTitleView;
    private TextView mSynopsisView;
    private TextView mRatingView;
    private TextView mDateView;
    private FrameLayout mPicassoView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_detail, container, false);

        mTitleView = (TextView) mRootView.findViewById(R.id.title_view);
        mSynopsisView = (TextView) mRootView.findViewById(R.id.synopsis_view);
        mRatingView = (TextView) mRootView.findViewById(R.id.rating_view);
        mDateView = (TextView) mRootView.findViewById(R.id.date_view);
        mPicassoView = (FrameLayout) mRootView.findViewById(R.id.picasso_view);


        Movie movie = mActivity.getIntent().getExtras().getParcelable(C.TAG_BUNDLE_MOVIE);

        if (movie != null) {
            mTitleView.setText(movie.getTitle());
            mDateView.setText("" + movie.getReleaseYear());
            mRatingView.setText("" + movie.getUserRating() + "/10");
            mSynopsisView.setText(movie.getOverview());
            Picasso.with(U.getCTX())
                    .load(C.MOVIEDB_AUTHORITY_URL + C.MOVIEDB_W185
                            + movie.getPosterPath())
                    .error(R.drawable.error_round)
                    .into(new ImageHolder(mPicassoView));

        }

        return mRootView;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        mTitleView = null;
        mPicassoView = null;
        mSynopsisView = null;
        mRatingView = null;
        mDateView = null;

    }

    // Holder object as a container for Picasso Target object
    private static class ImageHolder implements Target {

        private final FrameLayout mPicassoView;
        private final ImageView mImageView;
        private final ProgressBar mProgressBar;

        public ImageHolder(View v) {

            mPicassoView = (FrameLayout) v;
            mImageView = (ImageView) v.findViewById(R.id.image_view);
            mProgressBar = (ProgressBar) v.findViewById(R.id.progress_bar);

        }

        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            mImageView.setBackgroundDrawable(new BitmapDrawable(bitmap));
            setViewInvisible(mProgressBar);
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
            mImageView.setBackgroundDrawable(errorDrawable);
            setViewInvisible(mProgressBar);
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {
            mImageView.setBackgroundDrawable(placeHolderDrawable);
            setViewVisible(mProgressBar);
        }

        private void setViewVisible(View view) {
            view.setVisibility(View.VISIBLE);
        }

        private void setViewInvisible(View view) {
            view.setVisibility(View.INVISIBLE);
        }

    }



}
