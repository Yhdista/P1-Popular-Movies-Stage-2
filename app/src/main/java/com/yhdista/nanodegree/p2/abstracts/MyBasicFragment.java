/*
 * Copyright (C) 2013 The Android Open Source Project
 */
package com.yhdista.nanodegree.p2.abstracts;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


/**
 * Custom template for general Fragment
 */
public abstract class MyBasicFragment extends Fragment {

    public static final boolean RETAINED = true;

    private static final String TAG_IS_RETAINED = "isRetained";

    protected FragmentManager mFragmentManager;
    protected AppCompatActivity mActivity;

    // Root View of the fragment to be inflated.
    protected View mRootView;


    // Protected method for setting retained fragment by putting value into fragment args.
    protected static void setRetain(Bundle bundleArgs, boolean isRetained) {
        if (bundleArgs != null) {
            bundleArgs.putBoolean(TAG_IS_RETAINED, isRetained);
            //setArguments(mBundleArg);
        }
    }


    /**
     * Convention Fragment constructor.
     *
     * @return new instance MyBasicFragment
     */



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mActivity = (AppCompatActivity) activity;
        mFragmentManager = mActivity.getSupportFragmentManager();

        //L.lifeCycle(0, L.ATTACHED, this.toString());

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // If fragment args has TAG_IS_RETAINED value true, the fragment would become retained.
        if (getArguments() != null) {
            setRetainInstance(getArguments().getBoolean(TAG_IS_RETAINED, false));
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();

        mActivity = null;
        mFragmentManager = null;

        //L.lifeCycle(0, L.DETACHED, this.toString());

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //L.lifeCycle(0, L.DESTROYED, this.toString());

    }

    @Override
    public void onDestroyView() {

        // all reference to Views must be destroyed
        mRootView = null;

        super.onDestroyView();

    }
}




