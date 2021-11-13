package com.spdapps.FrgMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.spdsosialdanphysicaldistance.R;
import com.spdapps.Activity.LoginMhs;
import com.spdapps.Activity.MainActivity;
import com.spdapps.Model.SessionManager;

public class Frg_akun extends Fragment {
    View view;
    Button btLogoutAkun;
    SessionManager sessionManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frg_akun, container, false);
        btLogoutAkun = view.findViewById(R.id.bt_logoutAkun);
        sessionManager = new SessionManager(getActivity());
        btLogoutAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout = new Intent(getActivity(), LoginMhs.class);
                sessionManager.logoutSession();
                startActivity(logout);
                getActivity().finish();
            }
        });

        return view;
    }
}
