/*
 * Copyright (C) 2013 The Android Open Source Project
 */

package com.yhdista.nanodegree.p2.fragments;


import android.annotation.TargetApi;
import android.database.Cursor;
import android.graphics.PorterDuff;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.ContextCompat;
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
import com.yhdista.nanodegree.p2.abstracts.AbstractMainFragment;
import com.yhdista.nanodegree.p2.abstracts.MyBasicDialogFragment;
import com.yhdista.nanodegree.p2.adapters.MoviesCursorAdapter;
import com.yhdista.nanodegree.p2.constants.C;
import com.yhdista.nanodegree.p2.constants.ConstFragments;
import com.yhdista.nanodegree.p2.interfaces.DatasetCallbacks;
import com.yhdista.nanodegree.p2.oodesign.Movie;
import com.yhdista.nanodegree.p2.oodesign.SortItems;
import com.yhdista.nanodegree.p2.provider.movie.MovieColumns;
import com.yhdista.nanodegree.p2.provider.movie.MovieSelection;
import com.yhdista.nanodegree.p2.utils.L;
import com.yhdista.nanodegree.p2.utils.U;
import com.yhdista.nanodegree.p2.utils.UtilsNet;


/**
 * Main Fragment.
 */
public class MainFragment extends AbstractMainFragment implements LoaderManager.LoaderCallbacks<Cursor>,
        DatasetCallbacks<Boolean> {

    private MyBasicDialogFragment mAsyncTaskFragment;

    private MoviesCursorAdapter mAdapter;
    private GridView mGridView;

    //private List<Movie> mMovies;

    private boolean mIsFavorite;
    private int mSortBy;

    private boolean mIsDatabaseOk;


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

        checkDatabase();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.fragment_main, container, false);

        mGridView = (GridView) mRootView.findViewById(R.id.grid_view);
        //mGridView.setNumColumns(2);


        setClickListener();

        return mRootView;

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        L.lifeCycle(2, L.ACTIVITYCREATED, this.toString());


        // now I know getView!
        initAdapter();


        if (savedInstanceState != null) {

            // TODO Spis dat do SharedPreferences
            mIsFavorite = savedInstanceState.getBoolean(C.TAG_BUNDLE_IS_FAVORITE);
            mSortBy = savedInstanceState.getInt(C.TAG_BUNDLE_SORT_BY);
        }

        if (!mIsDatabaseOk) {
            if (mAsyncTaskFragment == null) {
                if (UtilsNet.isConnectingToInternet()) {
                    mAsyncTaskFragment = AsyncTaskFragment.newRetainedInstance();
                    mAsyncTaskFragment.show(mActivity.getSupportFragmentManager(), ConstFragments.TAG_FRAGMENT_ASYNC_TASK);
                } else {
                    L.t(mActivity.getString(R.string.error_unknown_host_exception));
                }
            }
        } else {
            initLoader();
        }


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        /*if (mMovies != null) {
            outState.putParcelableArrayList(C.TAG_BUNDLE_MOVIES, (ArrayList<? extends Parcelable>) mMovies);
        }*/
        outState.putBoolean(C.TAG_BUNDLE_IS_FAVORITE, mIsFavorite);
        outState.putInt(C.TAG_BUNDLE_SORT_BY, mSortBy);
    }

    private void initAdapter() {

        if (mAdapter == null) {
            mAdapter = new MoviesCursorAdapter(null, this);
        } else {
            mAdapter.setCallback(this);
        }
        // adapter is set to GridView in any case :-)
        mGridView.setAdapter(mAdapter);
    }


    public void initLoader() {
        mActivity.getSupportLoaderManager().restartLoader(0, null, this);
    }


    /**
     * Set Movies dataset
     *
     * @param b
     */
    @Override
    public void setData(Boolean b) {
        mAsyncTaskFragment.dismissAllowingStateLoss();
        mAsyncTaskFragment = null;

        /* if the app was first launched, isDatabase() was executed in onCreate() method
           and returned false, now we must inform this fragment that database is OK; next
           launch of app is no problem, because method will return true
        */
        mIsDatabaseOk = true;

        if (b) initLoader();

    }

    private void checkDatabase() {

        new AsyncTask<Void, Void, Integer>() {
            @Override
            protected Integer doInBackground(Void... params) {
                Cursor cursor = U.getCTX().getContentResolver().
                        query(MovieColumns.CONTENT_URI, new String[]{MovieColumns._ID}, null, null, null);
                return (cursor != null) ? cursor.getCount() : 0;
            }

            @Override
            protected void onPostExecute(Integer count) {

                if (count > 0) {
                    mIsDatabaseOk = true;
                }

            }
        }.execute();
    }


    /**
     * Sort movies
     *
     * @param which to compare
     */
    @Override
    public void sortBy(final int which) {


        mActivity.getSupportLoaderManager().restartLoader(
                (which == 0) ? mSortBy : which, null, this);


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


    private void removeItemSelected() {
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

                Movie movie = mAdapter.getMovie(position);

                if (U.isMultiPane()) {


                   Fragment fragment = mFragmentManager
                           .findFragmentByTag(ConstFragments.TAG_FRAGMENT_DETAIL);
                    if (fragment == null) {
                        fragment = new DetailFragment();
                        mFragmentManager.beginTransaction()
                                .replace(R.id.container, fragment, ConstFragments.TAG_FRAGMENT_DETAIL)
                                .commit();
                        mFragmentManager.executePendingTransactions(); //immediately transaction!!!
                    }

                    updateDetail(movie);
                    //removeItemSelected();

                } else {
                    updateDetail(movie);
                    removeItemSelected();

                }

            }
        });
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
        updateFavoriteIcon(menu.getItem(0));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (id) {

            case R.id.action_favorite:
                setFavorite();
                updateFavoriteIcon(item);
                return true;
            case R.id.action_sort:
                showSetting();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    // show favorite
    private void setFavorite() {
        mIsFavorite = !mIsFavorite;
        sortBy(0);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void updateFavoriteIcon(MenuItem item) {
        if (mIsFavorite) {
            item.getIcon().setAlpha(255);
            item.getIcon().setColorFilter(ContextCompat.getColor(mActivity,
                    R.color.GreenYellow), PorterDuff.Mode.MULTIPLY);
        } else {
            item.getIcon().setColorFilter(null);
            item.getIcon().setAlpha(100);
        }
    }

    // show sorting dialog
    private void showSetting() {
        SettingDialog mSettingDialog = SettingDialog.newRetainedInstance();
        mSettingDialog.show(mFragmentManager, ConstFragments.TAG_FRAGMENT_SETTING_DIALOG);
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        //TODO

        MovieSelection selection = new MovieSelection();
        selection.isFavorite(mIsFavorite);


        if (id == SortItems.TITLE.getPosition()) {
            selection.orderByTitle();
        } else if (id == SortItems.POPULARITY.getPosition()) {
            selection.orderByPopularity(true);
        } else if (id == SortItems.HIGHEST_RATED.getPosition()) {
            selection.orderByVoteAverage(true);
        } else if (id == SortItems.LOWES_RATED.getPosition()) {
            selection.orderByVoteAverage();
        }

        mSortBy = id;

        return new CursorLoader(
                U.getCTX(),                             // Parent activity context
                MovieColumns.CONTENT_URI,               // Table to query
                MovieColumns.ALL_COLUMNS,               // Projection to return
                selection.sel(),                        // No selection clause
                selection.args(),                       // No selection arguments
                selection.order()                                   // Default sort order
        );

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        // problem with returning from DetailActivity solved with this condition!!!
        if (mAdapter != null) {
            mAdapter.swapCursor(data);
        }

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        // problem with returning from DetailActivity solved with this condition!!!
        if (mAdapter != null) {
            mAdapter.swapCursor(null);
        }
    }


    @Override
    public void onDestroyView() {

        mGridView = null;

        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mAdapter.clean();
    }

    @Override
    public void onDestroy() {

        mAdapter.clean();
        mAdapter = null;

        super.onDestroy();
    }
}
