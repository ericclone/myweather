package edu.sjsu.fa17cmpe277.myweather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CityListFragment extends Fragment {
    private RecyclerView mCityRecyclerView;
    private CityAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_city_list, container, false);
        mCityRecyclerView = v.findViewById(R.id.city_recycler_view);
        mCityRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return v;
    }

    private void updateUI() {
        CityList cityList = CityList.get(getActivity());
        List<City> cities = cityList.getCities();

        mAdapter = new CityAdapter(cities);
        mCityRecyclerView.setAdapter(mAdapter);
    }

    private class CityHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener {
        private TextView mCityName;
        private TextView mCityWeather;
        private TextView mCityTemperature;
        private City mCity;

        public CityHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_city, parent, false));
            mCityName = itemView.findViewById(R.id.city_name);
            mCityWeather = itemView.findViewById(R.id.city_weather);
            mCityTemperature = itemView.findViewById(R.id.city_temperature);
            itemView.setOnClickListener(this);
        }

        public void bind(City city) {
            mCity = city;
            mCityName.setText(city.getName());
            mCityWeather.setText(city.getWeather());
            mCityTemperature.setText(city.getTemperature());
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), mCity.getName() + " clicked", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    private class CityAdapter extends RecyclerView.Adapter<CityHolder> {
        private List<City> mCities;

        public CityAdapter(List<City> cities) {
            mCities = cities;
        }

        @Override
        public CityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CityHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(CityHolder holder, int position) {
            City city = mCities.get(position);
            holder.bind(city);
        }

        @Override
        public int getItemCount() {
            return mCities.size();
        }
    }
}
