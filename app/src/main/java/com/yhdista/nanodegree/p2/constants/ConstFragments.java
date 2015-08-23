package com.yhdista.nanodegree.p2.constants;

import android.content.res.Resources;

import com.yhdista.nanodegree.p2.R;
import com.yhdista.nanodegree.p2.utils.U;

/**
 * Created by Yhdista on 23.8.2015.
 */
public class ConstFragments {

    private static final Resources RES = U.getCTX().getResources();

    // fragments
    public static final String TAG_FRAGMENT_PROGRESS_DIALOG = "activityProgressDialog";
    public static final String TAG_FRAGMENT_ASYNC_TASK = "fragmentAsyncTask";
    public static final String TAG_FRAGMENT_MAIN = RES.getString(R.string.fragment_main);
    public static final String TAG_FRAGMENT_DETAIL = RES.getString(R.string.fragment_detail);
    public static final String TAG_FRAGMENT_SETTING_DIALOG = "fragmentSettingDialog" ;

}
