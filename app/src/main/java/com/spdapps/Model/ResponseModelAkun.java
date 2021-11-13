package com.spdapps.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseModelAkun{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("data")
	private DataModelAkun dataModelAkun;

	@SerializedName("kode")
	private int kode;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setData(DataModelAkun dataModelAkun){
		this.dataModelAkun = dataModelAkun;
	}

	public DataModelAkun getData(){
		return dataModelAkun;
	}

	public void setKode(int kode){
		this.kode = kode;
	}

	public int getKode(){
		return kode;
	}
}