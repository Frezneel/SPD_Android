package com.spdapps.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseModelAkunDosen{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("data")
	private DataModelAkunDosen dataModelAkunDosen;

	@SerializedName("kode")
	private int kode;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setData(DataModelAkunDosen dataModelAkunDosen){
		this.dataModelAkunDosen = dataModelAkunDosen;
	}

	public DataModelAkunDosen getData(){
		return dataModelAkunDosen;
	}

	public void setKode(int kode){
		this.kode = kode;
	}

	public int getKode(){
		return kode;
	}
}