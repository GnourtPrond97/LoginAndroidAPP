package com.example.loginapp.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginapp.R;
import com.example.loginapp.adapter.HourAdapter;
import com.example.loginapp.model.Wheather;
import com.example.loginapp.network.ApiManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHour;
    private TextView tvTem;
    private TextView tvStatus;
    @Override

    protected void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTem = (TextView) findViewById(R.id.tvTem);
        tvStatus =(TextView) findViewById(R.id.tvStatus);

        getHour();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        rvHour =(RecyclerView) findViewById(R.id.rvHour);
        rvHour.setLayoutManager(layoutManager);
    }

    private  void getHour(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManager.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiManager service  = retrofit.create(ApiManager.class);
        service.gethour().enqueue(new Callback<List<Wheather>>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<List<Wheather>> call, Response<List<Wheather>> response) {
                if (response.body() == null) return;

                List<Wheather> listWheather = response.body();
                HourAdapter adapter = new HourAdapter(MainActivity.this,listWheather);
                rvHour.setAdapter(adapter);

                Wheather wheather = listWheather.get(0);
                tvTem.setText(wheather.getTemperature().getValue().intValue()+ "'");
                tvStatus.setText(wheather.getIconPharase());
            }


            @Override
            public void onFailure(Call<List<Wheather>> call, Throwable t) {

            }
        });

    }


}
