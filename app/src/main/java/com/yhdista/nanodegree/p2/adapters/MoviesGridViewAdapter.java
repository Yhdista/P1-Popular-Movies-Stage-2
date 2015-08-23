/*
 * Copyright (C) 2013 The Android Open Source Project
 */

package com.yhdista.nanodegree.p2.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.yhdista.nanodegree.p2.R;
import com.yhdista.nanodegree.p2.constants.C;
import com.yhdista.nanodegree.p2.oodesign.Movie;
import com.yhdista.nanodegree.p2.utils.U;

import java.util.List;

/**
 * Custom adapter for GridView of Movies
 */
public class MoviesGridViewAdapter extends BaseAdapter {

    private List<Movie> mDataset;

    // position of selected item (after OnItemClicked) which is highlighted
    // default value is -1 which is non-existing position
    private int mItemSelected = -1;

    public MoviesGridViewAdapter(List<Movie> dataset) {
        mDataset = dataset;
    }

    /**
     * For change dataset of the Adapter
     *
     * @param dataset
     */
    public void setDataset(List<Movie> dataset) {
        mDataset = dataset;
    }

    @Override
    public int getCount() {
        return mDataset.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataset.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        View cell = convertView;

        if (cell == null) {
            cell = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.picasso_frame_layout, parent, false);
            holder = new ViewHolder(cell);
            cell.setTag(holder);
        } else {
            holder = (ViewHolder) cell.getTag();
        }

        //ImageView iv = (ImageView) v.findViewById(R.id.image_view);
        //ProgressBar pb = (ProgressBar) v.findViewById(R.id.progress_bar);

        Picasso.with(U.getCTX())
                .load(new StringBuilder(C.MOVIEDB_AUTHORITY_URL + C.MOVIEDB_W185
                        + mDataset.get(position).getPosterPath()).toString())
                .error(R.drawable.error_round)
                .into(holder);


        if (position == mItemSelected) {
            holder.setHighlightViewVisible();
        } else {
            holder.setHighlightViewInvisible();
        }

        return cell;

    }

    /**
     * Set the selected position in the list by ItemClick
     *
     * @param position
     */
    public void setItemSelected(int position) {
        mItemSelected = position;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder implements Target {

        // each data item is just a string in this case
        private final ImageView mImageView;
        private final FrameLayout mPicassoView;
        private final ProgressBar mProgressBar;
        private final View mHighLightView;

        // Layout params for Portrait/Landscape & 2/3 column configuration of FrameLayout
        private static final AbsListView.LayoutParams PARAMS2_PORTRAIT;
        private static final AbsListView.LayoutParams PARAMS3_PORTRAIT;
        private static final AbsListView.LayoutParams PARAMS2_LANDSCAPE;
        private static final AbsListView.LayoutParams PARAMS3_LANDSCAPE;

        static {

            int width;
            int height;
            int currentapiVersion = Build.VERSION.SDK_INT;
            if (currentapiVersion >= Build.VERSION_CODES.HONEYCOMB_MR2) {
                Display display = ((WindowManager) U.getCTX().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay(); // getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                width = size.x;
                height = size.y;
            } else {
                WindowManager wm = (WindowManager) U.getCTX().getSystemService(Context.WINDOW_SERVICE);
                Display display = wm.getDefaultDisplay();
                Point size = new Point();
                width = display.getWidth();
                height = display.getHeight();
            }

            if (U.getOrientation() != Configuration.ORIENTATION_PORTRAIT) {
                // swap numbers!!
                width = width + height;
                height = width - height;
                width = width - height;
            }

            PARAMS2_PORTRAIT = new AbsListView.LayoutParams(width / 2, (int) (1.5 * width / 2));
            PARAMS3_PORTRAIT = new AbsListView.LayoutParams(width / 3, (int) (1.5 * width / 3));
            PARAMS2_LANDSCAPE = new AbsListView.LayoutParams(height / 2, (int) (1.5 * height / 2));
            PARAMS3_LANDSCAPE = new AbsListView.LayoutParams(height / 3, (int) (1.5 * height / 3));
        }

        public ViewHolder(View v) {

            mPicassoView = (FrameLayout) v;
            mImageView = (ImageView) v.findViewById(R.id.image_view);
            mProgressBar = (ProgressBar) v.findViewById(R.id.progress_bar);
            mHighLightView = v.findViewById(R.id.highlight_view);

            setHighlightViewInvisible();

            // set Layout params either for portrait or landscape
            mPicassoView.setLayoutParams((U.getOrientation() ==
                    Configuration.ORIENTATION_PORTRAIT) ? PARAMS2_PORTRAIT : PARAMS2_LANDSCAPE);

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

        public void setHighlightViewVisible() {
            setViewVisible(mHighLightView.findViewById(R.id.hv1));
            setViewVisible(mHighLightView.findViewById(R.id.hv2));
        }

        public void setHighlightViewInvisible() {
            setViewInvisible(mHighLightView.findViewById(R.id.hv1));
            setViewInvisible(mHighLightView.findViewById(R.id.hv2));
        }

    }


}