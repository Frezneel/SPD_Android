package com.spdapps.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseModelAkunMhs {

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("data")
	private DataModelAkunMhs dataModelAkunMhs;

	@SerializedName("kode")
	private int kode;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setData(DataModelAkunMhs dataModelAkunMhs){
		this.dataModelAkunMhs = dataModelAkunMhs;
	}

	public DataModelAkunMhs getData(){
		return dataModelAkunMhs;
	}

	public void setKode(int kode){
		this.kode = kode;
	}

	public int getKode(){
		return kode;
	}
}