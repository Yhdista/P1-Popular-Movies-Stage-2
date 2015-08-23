package com.yhdista.nanodegree.p2.abstracts;

import android.os.Bundle;

import com.yhdista.nanodegree.p2.R;
import com.yhdista.nanodegree.p2.constants.ConstFragments;
import com.yhdista.nanodegree.p2.utils.U;

/**
 * Created by Yhdista on 23.8.2015.
 */
public class AbstractDetailActivity<T> extends AbstractAppCompatActivity {


    public static final String EXTRA_DETAIL_OBJECT = "extraDetailObject";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // check if activity has been switched to landscape mode
        // if yes, finish this activity
        if (U.isMultiPane()) {

            // check if activity has been switched from MultiPane to single mode
            // if so, remove DetailFragment!!!! before setContentView()


                mFragmentManager.beginTransaction()
                        .remove(mFragmentManager.findFragmentByTag(ConstFragments.TAG_FRAGMENT_DETAIL))
                        .commit();
                //mFragmentManager.executePendingTransactions();



            finish();
            return;
        }

        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            T t = extras.getParcelable(EXTRA_DETAIL_OBJECT);
            AbstractDetailFragment detailFragment = (AbstractDetailFragment) mFragmentManager
                    .findFragmentByTag(ConstFragments.TAG_FRAGMENT_DETAIL);
            detailFragment.passData(t);
        }
    }


}
