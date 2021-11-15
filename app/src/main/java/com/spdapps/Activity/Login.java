package com.spdapps.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.spdsosialdanphysicaldistance.R;
import com.spdapps.Model.SessionManagerDosen;
import com.spdapps.Model.SessionManagerMhs;

public class Login extends AppCompatActivity {
    Button btLoginMhs, btLoginDosen;
    ImageButton ibLoginMhs, ibLoginDosen;
    private SessionManagerDosen sessionManagerDs;
    private SessionManagerMhs sessionManagerMhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sessionManagerDs = new SessionManagerDosen(Login.this);
        if(sessionManagerDs.isLoggedIn()){
            moveToDosen();
        }
        else {
            sessionManagerMhs = new SessionManagerMhs(Login.this);
            if (sessionManagerMhs.isLoggedIn()){
                moveToMhs();
            }
        }
        ibLoginMhs = findViewById(R.id.ib_mhs);
        ibLoginDosen = findViewById(R.id.ib_dosen);
        btLoginMhs = findViewById(R.id.bt_loginMhs);
        btLoginDosen = findViewById(R.id.bt_loginDosen);
    }

    private void moveToMhs() {
        Intent intent = new Intent(Login.this, MainActivityMhs.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    private void moveToDosen() {
        Intent intent = new Intent(Login.this, MainActivityDosen.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    public void loginMhs(View view){
        Intent mhs = new Intent(Login.this, LoginMhs.class);
        startActivity(mhs);
    }

    public void loginDosen(View view){
        Intent dosen = new Intent(Login.this, LoginDosen.class);
        startActivity(dosen);
    }

}