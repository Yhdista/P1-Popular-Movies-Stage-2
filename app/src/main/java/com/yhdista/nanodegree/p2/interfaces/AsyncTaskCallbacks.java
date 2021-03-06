/*
 * Copyright (C) 2013 The Android Open Source Project
 */

package com.yhdista.nanodegree.p2.interfaces;

import com.yhdista.nanodegree.p2.constants.C;

/**
 * AsyncTask callback with Element result
 */
public interface AsyncTaskCallbacks<T> {

    void onPreExecute();

    void onPostExecute(T t);

    void onCancelled();

    void onProgressUpdate(C.ErrorTag flag);
}
