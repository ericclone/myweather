package edu.sjsu.fa17cmpe277.myweather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CityFragment extends Fragment {
    private City mCity;
    private TextView mCityName;
    private TextView mCityWeather;
    private TextView mCityTemperature;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCity = new City("Wtf");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_city, container, false);
        mCityName = v.findViewById(R.id.city_name);
        mCityWeather = v.findViewById(R.id.city_weather);
        mCityTemperature = v.findViewById(R.id.city_temperature);

        mCityName.setText(mCity.getName());
        mCityWeather.setText(mCity.getWeather());
        mCityTemperature.setText(mCity.getTemperature());

        return v;
    }
}
