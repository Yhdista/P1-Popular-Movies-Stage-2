/*
 * Copyright (C) 2013 The Android Open Source Project
 */

package com.yhdista.nanodegree.p2.utils;

import android.content.Context;
import android.content.res.Resources;

import com.yhdista.nanodegree.p2.R;
import com.yhdista.nanodegree.p2.application.MyApplication;


/**
 * Utils class (Context etc.)
 */
public class U {

    public static final Resources RES = U.getCTX().getResources();

/*
    public static void toggleToolbarProgressBar(int visible) {
        if (U.getActivity() != null) {
            if (!U.getActivity().isFinishing()) {
                //ProgressBar tpb = (ProgressBar) U.getActivity().findViewById(R.id.toolbar_progress_bar);
                tpb.setVisibility((visible == View.VISIBLE) ? View.VISIBLE : View.GONE);
            }
        }
    }
*/

    /**
     * Special case for toggling ProgressBar in onPreExecute method when
     * ProgressBar is already visible from the previous task
     */ /*
    public static void toggleToolbarProgressBarOnlyIfWasGone() {
        if (U.getActivity() != null) {
            if (!U.getActivity().isFinishing()) {
                ProgressBar tpb = (ProgressBar) U.getActivity().findViewById(R.id.toolbar_progress_bar);
                if (tpb.getVisibility() == View.GONE) {
                    tpb.setVisibility((tpb.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE);
                }
            }
        }
     }          */


    /**
     * Returns ApplicationContext
     *
     * @return Context
     */
    public static Context getCTX() {
        return MyApplication.getContext();
    }

    /**
     * Returns configuration
     *
     * @return 1 = Portrait, 2 = Landscape
     */
    public static int getOrientation() {
        return RES.getConfiguration().orientation;
    }

    public static boolean isMultiPane() {
        return RES.getBoolean(R.bool.multi_pane);
    }


}
