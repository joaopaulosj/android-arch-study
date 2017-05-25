package com.januzza.archweather.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.januzza.archweather.R;
import com.januzza.archweather.model.City;

import java.util.List;

/**
 * Created by jpsja_000 on 24/05/2017.
 */

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.CitiesViewHolder> {

    List<? extends City> mCityList;

    public CitiesAdapter() {
    }

    public void updateList(List<City> cityList) {
        mCityList = cityList;
        notifyDataSetChanged();
    }

    @Override
    public CitiesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_weather_list, parent, false);

        return new CitiesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CitiesViewHolder holder, int position) {
        City city = mCityList.get(position);

//        if(city.getIconUrl() != null)
//            Picasso.with(mContext).load(city.getIconUrl()).fit().into(viewHolder.icon);

        holder.city.setText(city.getName());
        holder.description.setText(city.getWeather().get(0).getDescription());
        holder.temp.setText(city.getMain().getTemp() + "º");
        holder.minTemp.setText(city.getMain().getTempMin() + "º");
        holder.maxTemp.setText(city.getMain().getTempMax() + "º");
//        holder.distance.setText(city.getDistanceFromUser(mCurLat, mCurLng));
    }

    @Override
    public int getItemCount() {
        return mCityList == null ? 0 : mCityList.size();
    }

    static class CitiesViewHolder extends RecyclerView.ViewHolder {

        private TextView city;
        private TextView description;
        private TextView temp;
        private TextView minTemp;
        private TextView maxTemp;
        private TextView distance;
        private ImageView icon;

        public CitiesViewHolder(View itemView) {
            super(itemView);
            city = (TextView) itemView.findViewById(R.id.tv_city);
            description = (TextView) itemView.findViewById(R.id.tv_description);
            temp = (TextView) itemView.findViewById(R.id.tv_temp);
            minTemp = (TextView) itemView.findViewById(R.id.tv_min_temp);
            maxTemp = (TextView) itemView.findViewById(R.id.tv_max_temp);
            distance = (TextView) itemView.findViewById(R.id.tv_distance);
            icon = (ImageView) itemView.findViewById(R.id.iv_weather);
        }
    }

}
