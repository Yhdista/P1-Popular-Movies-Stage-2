/*
 * Copyright (C) 2013 The Android Open Source Project
 */

package com.yhdista.nanodegree.p2.constants;

import android.content.res.Resources;

import com.yhdista.nanodegree.p2.BuildConfig;
import com.yhdista.nanodegree.p2.utils.U;

/**
 * Class of constants.
 */
public class C {

    // if DEBUG
    public static final boolean DEBUG = BuildConfig.DEBUG;

    public static final Resources RES = U.getCTX().getResources();

    //public  static final boolean IS_MULTI_PANE = RES.getBoolean(R.bool.multi_pane);


    // exceptions
    public enum ErrorTag {XML_PARSE_EXCEPTION, GENERIC_EXCEPTION, UNKNOWN_HOST_EXCEPTION}

    // tags for bundle arguments
    public static final String TAG_BUNDLE_MOVIES = "movies";
    public static final String TAG_BUNDLE_MOVIE = "movie";
    public static final String TAG_BUNDLE_IS_FAVORITE = "isFavorite";
    public static final String TAG_BUNDLE_SORT_BY = "sortBy";

    // base URL for themoviedb.org API
    public static final String MOVIEDB_AUTHORITY_URL = "http://image.tmdb.org/t/p/";

    // accessible size of images
    public static final String MOVIEDB_W185 = "w185";
    public static final String MOVIEDB_W342 = "w342";

}
