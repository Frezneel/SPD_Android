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
import com.spdapps.Model.DataModelAkunDosen;
import com.spdapps.Model.ResponseModelAkunDosen;
import com.spdapps.Model.SessionManagerDosen;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginDosen extends AppCompatActivity {
    private Button btLogin;
    private EditText etnip, etPassword;
    private String nip, password;
    private SessionManagerDosen sessionManagerDosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_dosen);

        etnip = findViewById(R.id.et_nip);
        etPassword = findViewById(R.id.et_password);
        btLogin = findViewById(R.id.bt_login);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nip = etnip.getText().toString();
                password = etPassword.getText().toString();

                if(nip.trim().equals("")){
                    etnip.setError("Isi nip");
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
        Call<ResponseModelAkunDosen> logindata = ardData.ardLoginDataDosen(nip,password);

        logindata.enqueue(new Callback<ResponseModelAkunDosen>() {
            @Override
            public void onResponse(Call<ResponseModelAkunDosen> call, Response<ResponseModelAkunDosen> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                if(kode == 1){
                    sessionManagerDosen = new SessionManagerDosen(LoginDosen.this);
                    DataModelAkunDosen listDataAkun = response.body().getData();
                    sessionManagerDosen.createLoginSession(listDataAkun);

                    Toast.makeText(LoginDosen.this, "Kode : "+kode+" | Pesan : "+pesan, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginDosen.this, MainActivityDosen.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(LoginDosen.this, "Kode : "+kode+" | Pesan : "+pesan, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ResponseModelAkunDosen> call, Throwable t) {
                Toast.makeText(LoginDosen.this, "Gagal Mengubungi server : "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}