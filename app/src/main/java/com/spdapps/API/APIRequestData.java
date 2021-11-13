package com.spdapps.API;

import com.spdapps.Model.ResponseModel;
import com.spdapps.Model.ResponseModelAkun;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequestData {
    @GET("retrieve.php")
    Call<ResponseModel> ardRetrieveData();

    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseModelAkun> ardLoginData(
            @Field("nim") String nim,
            @Field("password") String password
    );
}
