/*
 * Copyright (C) 2013 The Android Open Source Project
 */

package com.yhdista.nanodegree.p2.activities;


import android.os.Bundle;

import com.yhdista.nanodegree.p2.R;
import com.yhdista.nanodegree.p2.abstracts.MyAppCompatActivity;
import com.yhdista.nanodegree.p2.utils.UtilsActivity;

/**
 * Detail Activity for details about Movie
 */
public class DetailActivity extends MyAppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        UtilsActivity.setToolbarAsSupportActionBar(this, mToolbar, R.id.my_toolbar);
        UtilsActivity.setSupportActionBarHomeButton(this);

    }




}
