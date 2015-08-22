/*
 * Copyright (C) 2013 The Android Open Source Project
 */

package com.yhdista.nanodegree.p2.fragments;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.yhdista.nanodegree.p2.R;
import com.yhdista.nanodegree.p2.abstracts.MyBasicDialogFragment;
import com.yhdista.nanodegree.p2.abstracts.MyBasicFragment;
import com.yhdista.nanodegree.p2.activities.DetailActivity;
import com.yhdista.nanodegree.p2.adapters.MoviesCursorAdapter;
import com.yhdista.nanodegree.p2.constants.C;
import com.yhdista.nanodegree.p2.interfaces.DatasetCallbacks;
import com.yhdista.nanodegree.p2.oodesign.Movie;
import com.yhdista.nanodegree.p2.oodesign.SortItems;
import com.yhdista.nanodegree.p2.provider.movie.MovieColumns;
import com.yhdista.nanodegree.p2.provider.movie.MovieSelection;
import com.yhdista.nanodegree.p2.utils.L;
import com.yhdista.nanodegree.p2.utils.U;
import com.yhdista.nanodegree.p2.utils.UtilsNet;

import java.util.ArrayList;
import java.util.List;


/**
 * Main Fragment.
 */
public class MainFragment extends MyBasicFragment implements LoaderManager.LoaderCallbacks<Cursor>, DatasetCallbacks<Movie> {

    private MyBasicDialogFragment mAsyncTaskFragment;

    private MoviesCursorAdapter mAdapter;
    private GridView mGridView;
    private List<Movie> mMovies;

    public MainFragment() {

        Bundle bundleArgs = new Bundle();
        setRetain(bundleArgs, true);
        setArguments(bundleArgs);

    }

/*
    public static MainFragment newRetainedInstance() {
        Bundle bundleArgs = new Bundle();
        setRetain(bundleArgs, true);

        MainFragment fragment = new MainFragment();
        fragment.setArguments(bundleArgs);

        return fragment;
    }

    public static MainFragment newNonRetainInstance() {
        return new MainFragment();
    }
*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_main, container, false);

        mGridView = (GridView) mRootView.findViewById(R.id.grid_view);
        mGridView.setNumColumns(2);

        initAdapter();

        setClickListener();

        return mRootView;

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            mMovies = savedInstanceState.getParcelableArrayList(C.TAG_BUNDLE_MOVIES);
        }

        if (mMovies == null) {
            if (mAsyncTaskFragment == null) {
                if (UtilsNet.isConnectingToInternet()) {
                    mAsyncTaskFragment = com.yhdista.nanodegree.p2.fragments.AsyncTaskFragment.newRetainedInstance();
                    mAsyncTaskFragment.show(mActivity.getSupportFragmentManager(), C.TAG_FRAGMENT_ASYNC_TASK);
                } else {
                    L.t(mActivity.getString(R.string.error_unknown_host_exception));
                }

            }
        } else {
            changeAdapterDataset(mMovies);
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mMovies != null) {
            outState.putParcelableArrayList(C.TAG_BUNDLE_MOVIES, (ArrayList<? extends Parcelable>) mMovies);
        }
    }

    private void initAdapter() {
        if (mAdapter == null) {
            mAdapter = new MoviesCursorAdapter(null);
        }
        // adapter is set to GridView in any case :-)
        mGridView.setAdapter(mAdapter);
    }

    private void changeAdapterDataset(List<Movie> movies) {
        mAdapter.setDataset(movies);
        mAdapter.notifyDataSetChanged();
    }


    /**
     * Set Movies dataset
     *
     * @param movies
     */
    @Override
    public void setData(List<Movie> movies) {
        mAsyncTaskFragment.dismissAllowingStateLoss();
        //mMovies = movies;
        //changeAdapterDataset(mMovies);

        // TODO
        mActivity.getSupportLoaderManager().restartLoader(0, null, this);

    }

    /**
     * Sort movies
     *
     * @param which to compare
     */
    @Override
    public void sortBy(final int which) {

        mActivity.getSupportLoaderManager().restartLoader(which, null, this);




        /*
        Collections.sort(mMovies, new Comparator<Movie>() {
            @Override
            public int compare(Movie lhs, Movie rhs) {

                if (which == SortItems.TITLE.getPosition()) {
                    return lhs.getTitle().compareTo(rhs.getTitle());
                } else if (which == SortItems.POPULARITY.getPosition()) {
                    return UtilsMath.compareDouble(rhs.getPopularity(), lhs.getPopularity());
                } else if (which == SortItems.HIGHEST_RATED.getPosition()) {
                    return UtilsMath.compareDouble(rhs.getUserRating(), lhs.getUserRating());
                } else if (which == SortItems.LOWES_RATED.getPosition()) {
                    return UtilsMath.compareDouble(lhs.getUserRating(), rhs.getUserRating());
                }
                return 0;
            }
        });
        mAdapter.notifyDataSetChanged();
        */

    }

    private void startDetailActivity(Movie movie) {
        Intent intent = new Intent(mActivity, DetailActivity.class);
        intent.putExtra(C.TAG_BUNDLE_MOVIE, movie);
        startActivity(intent);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.setItemSelected(-1);
                mAdapter.notifyDataSetChanged();
            }
        }, 400);

    }

    private void setClickListener() {
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mAdapter.setItemSelected(position);
                mAdapter.notifyDataSetChanged();
                startDetailActivity(mAdapter.getMovie(position));
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            showSetting();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // show sorting dialog
    private void showSetting() {
        com.yhdista.nanodegree.p2.fragments.SettingDialog mSettingDialog = com.yhdista.nanodegree.p2.fragments.SettingDialog.newRetainedInstance();
        mSettingDialog.show(mFragmentManager, C.TAG_FRAGMENT_SETTING_DIALOG);
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        //TODO

        MovieSelection selection = new MovieSelection();

        if (id == SortItems.TITLE.getPosition()) {
            selection.orderByTitle();
        } else if (id == SortItems.POPULARITY.getPosition()) {
            selection.orderByPopularity(true);
        } else if (id == SortItems.HIGHEST_RATED.getPosition()) {
            selection.orderByVoteAverage(true);
        } else if (id == SortItems.LOWES_RATED.getPosition()) {
            selection.orderByVoteAverage();
        }

        return new CursorLoader(
                U.getCTX(),                             // Parent activity context
                MovieColumns.CONTENT_URI,               // Table to query
                MovieColumns.ALL_COLUMNS,               // Projection to return
                null, //selection.sel(),                        // No selection clause
                null, //selection.args(),                       // No selection arguments
                selection.order()                                   // Default sort order
        );

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
