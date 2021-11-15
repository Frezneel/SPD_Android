package com.spdapps.FrgMenuDosen;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.spdsosialdanphysicaldistance.R;
import com.spdapps.API.APIRequestData;
import com.spdapps.API.RetroServer;
import com.spdapps.Adapter.AdapterKelas;
import com.spdapps.Model.DataModelKelas;
import com.spdapps.Model.ResponseModelKelas;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class Frg_data_kelas_ds extends Fragment {
    private RecyclerView rvDataKelas;
    private RecyclerView.Adapter adDataKelas;
    private RecyclerView.LayoutManager lmDataKelas;
    private List<DataModelKelas> listData = new ArrayList<>();
    private SwipeRefreshLayout swRefresh1Frg;
    private ProgressBar pb1Frg;
    private String nip;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frg_kelas_ds, container, false);
        swRefresh1Frg = view.findViewById(R.id.sw_refreshKelas_frg);
        pb1Frg = view.findViewById(R.id.pb_1_kelasfrg);
        rvDataKelas = view.findViewById(R.id.rv_kelas);
        nip = getArguments().getString("b_nip");

        lmDataKelas = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        rvDataKelas.setLayoutManager(lmDataKelas);


        swRefresh1Frg.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swRefresh1Frg.setRefreshing(true);
                retriveData();
                swRefresh1Frg.setRefreshing(false);
            }
        });

        return view;
    }

    public void retriveData(){
        pb1Frg.setVisibility(View.VISIBLE);
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModelKelas> tampilData = ardData.ardAmbilKelas(nip);
        tampilData.enqueue(new Callback<ResponseModelKelas>() {
            @Override
            public void onResponse(Call<ResponseModelKelas> call, Response<ResponseModelKelas> response) {
                pb1Frg.setVisibility(View.INVISIBLE);
                String pesan = response.body().getPesan();
                listData = response.body().getData();
                adDataKelas = new AdapterKelas(getActivity(), listData);
                rvDataKelas.setAdapter(adDataKelas);
                adDataKelas.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseModelKelas> call, Throwable t) {
                pb1Frg.setVisibility(View.INVISIBLE);
                Toast.makeText(getActivity(), "Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                retriveData();
            }
        },150);

        Toast.makeText(getActivity(), "Start", Toast.LENGTH_SHORT).show();
    }

}
