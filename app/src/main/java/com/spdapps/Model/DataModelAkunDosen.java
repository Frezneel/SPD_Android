package com.spdapps.Model;

import com.google.gson.annotations.SerializedName;

public class DataModelAkunDosen {

	@SerializedName("nip")
	private String nip;

	@SerializedName("nama")
	private String nama;

	@SerializedName("jurusan")
	private String jurusan;

	@SerializedName("id")
	private String id;

	public void setNip(String nip){
		this.nip = nip;
	}

	public String getNip(){
		return nip;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setJurusan(String jurusan){
		this.jurusan = jurusan;
	}

	public String getJurusan(){
		return jurusan;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}
}