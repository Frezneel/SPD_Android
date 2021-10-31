package com.example.spdsosialdanphysicaldistance.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.spdsosialdanphysicaldistance.API.APIRequestData;
import com.example.spdsosialdanphysicaldistance.API.RetroServer;
import com.example.spdsosialdanphysicaldistance.Adapter.AdapterData;
import com.example.spdsosialdanphysicaldistance.Model.DataModel;
import com.example.spdsosialdanphysicaldistance.Model.ResponseModel;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_masuk_gedung);

        rvData = findViewById(R.id.rv_data_masuk);
        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);

    }

    public void retriveData(){
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> tampilData = ardData.ardRetrieveData();
        tampilData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(DataMasukGedung.this, "Kode : " +kode + " | Pesan : "+pesan, Toast.LENGTH_SHORT).show()  ;
                listData = response.body().getData();
                adData = new AdapterData(DataMasukGedung.this, listData);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
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