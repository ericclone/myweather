package edu.sjsu.fa17cmpe277.myweather;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class CityList {
    private static CityList sCityList;

    private List<City> mCities;

    public static CityList get(Context context) {
        if (sCityList == null) {
            sCityList = new CityList(context);
        }
        return sCityList;
    }

    private CityList(Context context) {
        mCities = new ArrayList<>();
        createFakeCities(10);
    }

    private void createFakeCities(int n) {
        for (int i = 0; i < n; ++i) {
            mCities.add(new City("City " + n));
        }
    }

    public List<City> getCities() {
        return mCities;
    }

    public City getCity(String name) {
        for (City c : mCities) {
            if (name.equals(c.getName())) {
                return c;
            }
        }
        return null;
    }
}
