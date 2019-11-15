package com.agus.test.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note")
public class Note {
	
	
	@PrimaryKey(autoGenerate = true)
	@NonNull
	private int id;
	
	@ColumnInfo(name = "nama")
	private String nama;
	
	@ColumnInfo(name = "keterangan")
	private String keterangan;
	
	@ColumnInfo(name = "waktu")
	private String waktu;
	
//	public Note(String nama, String keterangan, String waktu) {
//		this.nama = nama;
//		this.keterangan = keterangan;
//		this.waktu = waktu;
//	}
	
	public Note() {
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNama() {
		return nama;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public String getKeterangan() {
		return keterangan;
	}
	
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	
	public String getWaktu() {
		return waktu;
	}
	
	public void setWaktu(String waktu) {
		this.waktu = waktu;
	}
}
