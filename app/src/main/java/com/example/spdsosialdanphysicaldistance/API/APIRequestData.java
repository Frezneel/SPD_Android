package com.example.spdsosialdanphysicaldistance.API;

import com.example.spdsosialdanphysicaldistance.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRequestData {
    @GET("retrieve.php")
    Call<ResponseModel> ardRetrieveData();
}
