package com.spdapps.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.spdsosialdanphysicaldistance.R;
import com.spdapps.API.APIRequestData;
import com.spdapps.API.RetroServer;
import com.spdapps.Model.DataModelAkunMhs;
import com.spdapps.Model.ResponseModelAkunMhs;
import com.spdapps.Model.SessionManagerMhs;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginMhs extends AppCompatActivity {
    private Button btLogin;
    private EditText etnim, etPassword;
    private String  username, password;
    private SessionManagerMhs sessionManagerMhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_mhs);

        etnim = findViewById(R.id.et_nim);
        etPassword = findViewById(R.id.et_password);
        btLogin = findViewById(R.id.bt_login);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = etnim.getText().toString();
                password = etPassword.getText().toString();

                if(username.trim().equals("")){
                    etnim.setError("Isi username");
                }
                else if(password.trim().equals("")){
                    etPassword.setError("Isi password");
                }
                else{
                    loginData();
                }

            }
        });

    }

    private void loginData(){
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModelAkunMhs> logindata = ardData.ardLoginDataMhs(username,password);

        logindata.enqueue(new Callback<ResponseModelAkunMhs>() {
            @Override
            public void onResponse(Call<ResponseModelAkunMhs> call, Response<ResponseModelAkunMhs> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                if(kode == 1){
                    sessionManagerMhs = new SessionManagerMhs(LoginMhs.this);
                    DataModelAkunMhs listDataAkun = response.body().getData();
                    sessionManagerMhs.createLoginSession(listDataAkun);

                    Toast.makeText(LoginMhs.this, "Kode : "+kode+" | Pesan : "+pesan, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginMhs.this, MainActivityMhs.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(LoginMhs.this, "Kode : "+kode+" | Pesan : "+pesan, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ResponseModelAkunMhs> call, Throwable t) {
                Toast.makeText(LoginMhs.this, "Gagal Mengubungi server : "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}