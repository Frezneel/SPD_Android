package com.spdapps.API;

import android.webkit.JavascriptInterface;

import com.google.gson.annotations.JsonAdapter;
import com.spdapps.Model.ResponseModel;
import com.spdapps.Model.ResponseModelAkunDosen;
import com.spdapps.Model.ResponseModelAkunMhs;
import com.spdapps.Model.ResponseModelKelas;

import java.math.BigInteger;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequestData {
    @GET("retrieve.php")
    Call<ResponseModel> ardRetrieveData();

    @FormUrlEncoded
    @POST("loginmhs.php")
    Call<ResponseModelAkunMhs> ardLoginDataMhs(
            @Field("nim") String nim,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("logindosen.php")
    Call<ResponseModelAkunDosen> ardLoginDataDosen(
            @Field("nip") String nim,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("kelas.php")
    Call<ResponseModelKelas> ardAmbilKelas(
        @Field("nip_dosen") String nip_dosen
    );

}
