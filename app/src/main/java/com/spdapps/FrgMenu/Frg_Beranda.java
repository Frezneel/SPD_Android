package com.spdapps.FrgMenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.spdsosialdanphysicaldistance.R;

public class Frg_Beranda extends Fragment {
    View view;
    TextView tvNama, tvNIM, tvJurusan, tvProdi, tvKelas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frg_beranda, container, false);

        tvNama = view.findViewById(R.id.tv_nama);
        tvNIM = view.findViewById(R.id.tv_nim);
        tvJurusan = view.findViewById(R.id.tv_jurusan);
        tvProdi = view.findViewById(R.id.tv_prodi);
        tvKelas = view.findViewById(R.id.tv_kelas);

        tvNama.setText(getArguments().getString("b_nama"));
        tvNIM.setText(getArguments().getString("b_nim"));
        tvJurusan.setText(getArguments().getString("b_jurusan"));
        tvProdi.setText(getArguments().getString("b_prodi"));
        tvKelas.setText(getArguments().getString("b_kelas"));

        return view;
    }
}
