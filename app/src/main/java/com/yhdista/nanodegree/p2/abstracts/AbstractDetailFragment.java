package com.yhdista.nanodegree.p2.abstracts;

import android.app.Activity;

import com.yhdista.nanodegree.p2.utils.L;

/**
 * Created by Yhdista on 23.8.2015.
 */
public abstract class AbstractDetailFragment<T>  extends MyBasicFragment{


    public abstract void passData(T t);


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        L.lifeCycle(0, L.ATTACHED, this.toString());
    }


    @Override
    public void onDetach() {
        super.onDetach();
        L.lifeCycle(0, L.DETACHED, this.toString());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        L.lifeCycle(0, L.DESTROYED, this.toString());

    }
}
