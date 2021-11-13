package com.spdapps.FrgMenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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

public class Frg_data_gedung extends Fragment {
    private RecyclerView rvDataFrg;
    private RecyclerView.Adapter adDataFrg;
    private RecyclerView.LayoutManager lmDataFrg;
    private List<DataModel> listData = new ArrayList<>();
    private SwipeRefreshLayout swRefresh1Frg;
    private ProgressBar pb1Frg;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frg_data_gedung, container, false);
        swRefresh1Frg = view.findViewById(R.id.sw_refresh_frg);
        pb1Frg = view.findViewById(R.id.pb_1_frg);
        rvDataFrg = view.findViewById(R.id.rv_data_masuk_frg);

        lmDataFrg = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        rvDataFrg.setLayoutManager(lmDataFrg);


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
        Call<ResponseModel> tampilData = ardData.ardRetrieveData();
        tampilData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                pb1Frg.setVisibility(View.INVISIBLE);
                listData = response.body().getData();
                adDataFrg = new AdapterData(getActivity(), listData);
                rvDataFrg.setAdapter(adDataFrg);
                adDataFrg.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                pb1Frg.setVisibility(View.INVISIBLE);
                Toast.makeText(getActivity(), "Gagal mengambil data", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        retriveData();
        Toast.makeText(getActivity(), "Start", Toast.LENGTH_SHORT).show();
    }

}
