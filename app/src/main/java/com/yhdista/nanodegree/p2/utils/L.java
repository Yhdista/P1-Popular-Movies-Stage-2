/*
 * Copyright (C) 2013 The Android Open Source Project
 */

package com.yhdista.nanodegree.p2.utils;

import android.util.Log;
import android.widget.Toast;

import com.yhdista.nanodegree.p2.constants.C;



/**
 * Loging helper class
 */
public class L {

    public static final String HELP = "HELP";
    public static final String LIFECYCLE = "LIFECYCLE";

    public static final String ATTACHED = " ATTACHED";
    public static final String DESTROYED = " DESTROYED";
    public static final String DETACHED = " DETACHED";
    public static final String CREATED = " CREATED";
    public static final String ACTIVITYCREATED = " ACTIVITY CREATED";

    /**
     * Create debug log into LogCat if debugging mod (Lifecycles)
     *
     * @param tag
     * @param message
     */
    public static void lifeCycle(int id, String tag, String message) {


        switch (id) {
            case 0:
                if (C.DEBUG) Log.d(LIFECYCLE, message + tag);
                break;

            case 1:
                if (C.DEBUG) Log.i(LIFECYCLE, message + tag);
                break;

            case 2:
                if (C.DEBUG) Log.w(LIFECYCLE, message + tag);
                break;

            case 3:
                if (C.DEBUG) Log.e(LIFECYCLE, message + tag);
                break;

            case 4:
                if (C.DEBUG) Log.v(LIFECYCLE, message + tag);
                break;
        }

/*        switch (tag) {
            case ATTACHED:
                if (C.DEBUG) Log.d(LIFECYCLE, message + tag);
                break;

            case CREATED:
                if (C.DEBUG) Log.i(LIFECYCLE, message + tag);
                break;

            case DETACHED:
                if (C.DEBUG) Log.w(LIFECYCLE, message + tag);
                break;

            case DESTROYED:
                if (C.DEBUG) Log.e(LIFECYCLE, message + tag);
                break;
        }*/


    }

    /**
     * Create debug log into LogCat if debugging mod.
     *
     * @param message
     */
    public static void m(String message)
    {
        if (C.DEBUG) Log.d(HELP, message);
    }

    /**
     * Create Debug Toast message
     *
     * @param message
     */
    public static void tdebug(String message)
    {
        if (C.DEBUG) Toast.makeText(com.yhdista.nanodegree.p2.utils.U.getCTX(), message, Toast.LENGTH_LONG).show();
    }


    /**
     * Create Toast message
     *
     * @param message
     */
    public static void t(String message)
    {
        Toast.makeText(com.yhdista.nanodegree.p2.utils.U.getCTX(), message, Toast.LENGTH_LONG).show();
    }

}
