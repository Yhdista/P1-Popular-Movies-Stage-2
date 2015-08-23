package com.yhdista.nanodegree.p2.abstracts;

import android.app.Activity;

import com.yhdista.nanodegree.p2.interfaces.OnMainItemSelectedListener;
import com.yhdista.nanodegree.p2.utils.L;

/**
 * Created by Yhdista on 23.8.2015.
 */
public abstract class AbstractMainFragment<T> extends MyBasicFragment {

    private OnMainItemSelectedListener mListener;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnMainItemSelectedListener) {
            mListener = (OnMainItemSelectedListener) activity;
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implemenet OnItemSelectedListener");
        }

        L.lifeCycle(2, L.ATTACHED, this.toString());
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;

        L.lifeCycle(2, L.DETACHED, this.toString());

    }


    // may also be triggered from the Activity
    public void updateDetail(T t) {

        //TODO

        // inform the Activity about the change based
        // interface defintion
        mListener.onMainItemSelected(t);
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        L.lifeCycle(2, L.DESTROYED, this.toString());

    }


}

