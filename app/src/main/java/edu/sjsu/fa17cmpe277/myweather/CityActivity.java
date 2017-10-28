package edu.sjsu.fa17cmpe277.myweather;

import android.support.v4.app.Fragment;

public class CityActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CityFragment();
    }
}
