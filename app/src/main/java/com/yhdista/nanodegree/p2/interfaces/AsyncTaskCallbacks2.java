/*
 * Copyright (C) 2013 The Android Open Source Project
 */

package com.yhdista.nanodegree.p2.interfaces;

import com.yhdista.nanodegree.p2.constants.C;

import java.util.List;

/**
 * AsyncTask callback with Element result
 */
public interface AsyncTaskCallbacks2<E> {

    void onPreExecute();

    void onPostExecute(List<E> elements);

    void onCancelled();

    void onProgressUpdate(C.ErrorTag flag);
}
