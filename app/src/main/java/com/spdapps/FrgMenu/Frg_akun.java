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

public class Frg_akun extends Fragment {
    View view;
    Button btLogoutAkun;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frg_akun, container, false);
        btLogoutAkun = view.findViewById(R.id.bt_logoutAkun);
        btLogoutAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout = new Intent(getActivity(), LoginMhs.class);
                logout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(logout);
                getActivity().finish();
            }
        });

        return view;
    }
}
