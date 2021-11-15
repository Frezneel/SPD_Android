package com.spdapps.Model;

import com.google.gson.annotations.SerializedName;

public class DataModelKelas {
	@SerializedName("nama_matkul")
	private String namaMatkul;

	@SerializedName("id_matkul")
	private String idMatkul;

	@SerializedName("id_ruangan")
	private String idRuangan;

	@SerializedName("id_jadwal")
	private String idJadwal;

	@SerializedName("dosen_nama")
	private String dosenNama;

	@SerializedName("nama_ruangan")
	private String namaRuangan;

	@SerializedName("nama_maksimal")
	private String namaMaksimal;

	@SerializedName("nama_gedung")
	private String namaGedung;

	public void setNamaMatkul(String namaMatkul){
		this.namaMatkul = namaMatkul;
	}

	public String getNamaMatkul(){
		return namaMatkul;
	}

	public void setIdMatkul(String idMatkul){
		this.idMatkul = idMatkul;
	}

	public String getIdMatkul(){
		return idMatkul;
	}

	public void setIdRuangan(String idRuangan){
		this.idRuangan = idRuangan;
	}

	public String getIdRuangan(){
		return idRuangan;
	}

	public void setIdJadwal(String idJadwal){
		this.idJadwal = idJadwal;
	}

	public String getIdJadwal(){
		return idJadwal;
	}

	public void setDosenNama(String dosenNama){
		this.dosenNama = dosenNama;
	}

	public String getDosenNama(){
		return dosenNama;
	}

	public void setNamaRuangan(String namaRuangan){
		this.namaRuangan = namaRuangan;
	}

	public String getNamaRuangan(){
		return namaRuangan;
	}

	public void setNamaMaksimal(String namaMaksimal){
		this.namaMaksimal = namaMaksimal;
	}

	public String getNamaMaksimal(){
		return namaMaksimal;
	}

	public void setNamaGedung(String namaGedung){
		this.namaGedung = namaGedung;
	}

	public String getNamaGedung(){
		return namaGedung;
	}
}