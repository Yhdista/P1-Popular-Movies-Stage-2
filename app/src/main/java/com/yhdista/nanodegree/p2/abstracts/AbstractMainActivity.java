package com.yhdista.nanodegree.p2.abstracts;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import com.yhdista.nanodegree.p2.R;
import com.yhdista.nanodegree.p2.activities.DetailActivity;
import com.yhdista.nanodegree.p2.application.MyApplication;
import com.yhdista.nanodegree.p2.constants.ConstFragments;
import com.yhdista.nanodegree.p2.interfaces.OnMainItemSelectedListener;
import com.yhdista.nanodegree.p2.utils.U;


/**
 * Created by Yhdista on 23.8.2015.
 */
public abstract class AbstractMainActivity<T> extends AbstractAppCompatActivity
        implements OnMainItemSelectedListener<T> {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // check if activity has been switched from MultiPane to single mode
        // if so, remove DetailFragment!!!! before setContentView()
        if (!U.isMultiPane() && mFragmentManager.findFragmentByTag(ConstFragments.TAG_FRAGMENT_DETAIL) != null) {
            removeDetailFragmentImmediately();
        }

        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {

        // cancel Volley request, otherwise memory leaks
        MyApplication.getInstance().cancelVolleyRequest();

        super.onBackPressed();
    }

    /**
     * Evokes when selected item in AdapterView blabla // TODO
     *
     * @param t Parcelable object passes to DetailFragment / Activity
     * @throws ClassCastException
     */
    public void onMainItemSelected(T t) throws ClassCastException {
        AbstractDetailFragment fragment = (AbstractDetailFragment) mFragmentManager.findFragmentByTag(ConstFragments.TAG_FRAGMENT_DETAIL);
        if (U.isMultiPane()) {    // fragment != null && fragment.isInLayout()) {
            if (fragment != null) {
                //addDetailFragmentImmediately();
                fragment.passData(t);
            }

        } else {
            Intent intent = new Intent(getApplicationContext(),
                    DetailActivity.class);
            intent.putExtra(AbstractDetailActivity.EXTRA_DETAIL_OBJECT, (Parcelable) t);
            startActivity(intent);

        }
    }

    public void removeDetailFragmentImmediately() {
        mFragmentManager.beginTransaction()
                .remove(mFragmentManager.findFragmentByTag(ConstFragments.TAG_FRAGMENT_DETAIL))
                .commit();
        mFragmentManager.executePendingTransactions();
    }

}
