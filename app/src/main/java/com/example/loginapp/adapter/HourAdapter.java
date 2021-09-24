package com.example.loginapp.adapter;

import android.app.Activity;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.loginapp.R;
import com.example.loginapp.model.Wheather;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HourAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<Wheather> listWeather;

    public HourAdapter(Activity activity, List<Wheather> listWeather) {
        this.activity = activity;
        this.listWeather = listWeather;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View itemView = inflater.inflate(R.layout.item_hour,parent,false);
        HourHolder holder = new HourHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HourHolder vh = (HourHolder) holder;
        Wheather wheather = listWeather.get(position);
        vh.tvTime.setText(convertTime(wheather.getDateTime()));
        vh.tvTem.setText(wheather.getTemperature().getValue()+"*");
        String url ="";
        if(wheather.getWeatherIcon() <10){
            url="https://developer.accuweather.com/sites/default/files/0"+wheather.getWeatherIcon() + "-s.png";
        }else {
            url="https://developer.accuweather.com/sites/default/files/"+wheather.getWeatherIcon() + "-s.png";;
        }
        Glide.with(activity).load(url).into(vh.icon);

    }

    private String convertTime(String inputTime) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = inFormat.parse(inputTime);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("ha");
        String goal =outFormat.format(date);
        return goal;
    }

    @Override
    public int getItemCount() {
        return listWeather.size();
    }

    private class HourHolder  extends RecyclerView.ViewHolder{
        private TextView tvTime;
        private ImageView icon;
        private TextView tvTem;

        public HourHolder(@NonNull View itemView) {
            super(itemView);
            tvTime =(TextView) itemView.findViewById(R.id.tvTime);
            icon =(ImageView) itemView.findViewById(R.id.icon);
            tvTem = (TextView) itemView.findViewById(R.id.tvTem);
        }
    }
}
