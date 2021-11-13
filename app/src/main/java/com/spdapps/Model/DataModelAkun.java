package com.spdapps.Model;

import com.google.gson.annotations.SerializedName;

public class DataModelAkun {

	@SerializedName("nim")
	private String nim;

	@SerializedName("nama")
	private String nama;

	@SerializedName("kelas")
	private String kelas;

	@SerializedName("jurusan")
	private String jurusan;

	@SerializedName("id")
	private String id;

	@SerializedName("prodi")
	private String prodi;

	public void setNim(String nim){
		this.nim = nim;
	}

	public String getNim(){
		return nim;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setKelas(String kelas){
		this.kelas = kelas;
	}

	public String getKelas(){
		return kelas;
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

	public void setProdi(String prodi){
		this.prodi = prodi;
	}

	public String getProdi(){
		return prodi;
	}
}