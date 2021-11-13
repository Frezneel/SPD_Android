package com.spdapps.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.spdapps.API.APIRequestData;
import com.spdapps.API.RetroServer;
import com.spdapps.Adapter.AdapterData;
import com.spdapps.Model.DataModel;
import com.spdapps.Model.ResponseModel;
import com.example.spdsosialdanphysicaldistance.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataMasukGedung extends AppCompatActivity {
    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<DataModel> listData = new ArrayList<>();
    private SwipeRefreshLayout swRefresh1;
    private ProgressBar pb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_masuk_gedung);

        rvData = findViewById(R.id.rv_data_masuk);
        swRefresh1 = findViewById(R.id.sw_refresh1);
        pb1 = findViewById(R.id.pb_1);

        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);

        swRefresh1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swRefresh1.setRefreshing(true);
                retriveData();
                swRefresh1.setRefreshing(false);
            }
        });
    }

    public void retriveData(){
        pb1.setVisibility(View.VISIBLE);
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> tampilData = ardData.ardRetrieveData();
        tampilData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();
                pb1.setVisibility(View.INVISIBLE);

                Toast.makeText(DataMasukGedung.this, "Kode : " +kode + " | Pesan : "+pesan, Toast.LENGTH_SHORT).show()  ;
                listData = response.body().getData();
                adData = new AdapterData(DataMasukGedung.this, listData);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                pb1.setVisibility(View.INVISIBLE);
                Toast.makeText(DataMasukGedung.this, "Gagal Menghubungi Server" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        retriveData();
    }
}