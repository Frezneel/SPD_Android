package com.spdapps.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spdsosialdanphysicaldistance.R;
import com.spdapps.Model.DataModelKelas;

import java.util.List;

public class AdapterKelas extends RecyclerView.Adapter<AdapterKelas.HolderKelas>{
    private Context ctx;
    private List<DataModelKelas> listKelas;

    public AdapterKelas(Context ctx, List<DataModelKelas> listKelas) {
        this.ctx = ctx;
        this.listKelas = listKelas;
    }

    @NonNull
    @Override
    public HolderKelas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_kelas, parent, false);
        HolderKelas holder = new HolderKelas(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder (@NonNull HolderKelas holder,int position){
        DataModelKelas DMK = listKelas.get(position);
        holder.tvnamaMatkul.setText(DMK.getNamaMatkul());
        holder.tvKelas.setText(DMK.getNamaRuangan());
        holder.tvRuangan.setText(DMK.getNamaRuangan());
        holder.tvnamaDosen.setText(DMK.getDosenNama());
    }

    @Override
    public int getItemCount () {
        return listKelas.size();
    }
    public class HolderKelas extends RecyclerView.ViewHolder {
        TextView tvid, tvnamaMatkul, tvKelas, tvRuangan, tvJam, tvnamaDosen;
        public HolderKelas(@NonNull View itemView) {
            super(itemView);

            tvnamaMatkul = itemView.findViewById(R.id.tv_namaMatkul);
            tvKelas = itemView.findViewById(R.id.tv_kelas);
            tvRuangan = itemView.findViewById(R.id.tv_jam);
            tvJam = itemView.findViewById(R.id.tv_jam);
            tvnamaDosen = itemView.findViewById(R.id.tv_namaDosen);


        }
    }
}
