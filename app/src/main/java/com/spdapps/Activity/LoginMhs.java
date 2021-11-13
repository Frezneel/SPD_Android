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
import com.spdapps.Model.DataModelAkun;
import com.spdapps.Model.ResponseModelAkun;
import com.spdapps.Model.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginMhs extends AppCompatActivity {
    private Button btLogin;
    private EditText etUsername, etPassword;
    private String  username, password;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_mhs);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btLogin = findViewById(R.id.bt_login);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();

                if(username.trim().equals("")){
                    etUsername.setError("Isi username");
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
        Call<ResponseModelAkun> logindata = ardData.ardLoginData(username,password);

        logindata.enqueue(new Callback<ResponseModelAkun>() {
            @Override
            public void onResponse(Call<ResponseModelAkun> call, Response<ResponseModelAkun> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                if(kode == 1){
                    sessionManager = new SessionManager(LoginMhs.this);
                    DataModelAkun listDataAkun = response.body().getData();
                    sessionManager.createLoginSession(listDataAkun);

                    Toast.makeText(LoginMhs.this, "Kode : "+kode+" | Pesan : "+pesan, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginMhs.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(LoginMhs.this, "Kode : "+kode+" | Pesan : "+pesan, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ResponseModelAkun> call, Throwable t) {
                Toast.makeText(LoginMhs.this, "Gagal Mengubungi server : "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}