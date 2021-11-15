package com.spdapps.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseModelKelas{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("data")
	private List<DataModelKelas> data;

	@SerializedName("kode")
	private int kode;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setData(List<DataModelKelas> data){
		this.data = data;
	}

	public List<DataModelKelas> getData(){
		return data;
	}

	public void setKode(int kode){
		this.kode = kode;
	}

	public int getKode(){
		return kode;
	}
}