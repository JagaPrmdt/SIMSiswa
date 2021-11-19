package com.example.siswa.model;

import com.google.gson.annotations.SerializedName;

public class SppResponse{

	@SerializedName("hasil")
	private Hasil hasil;

	public Hasil getHasil(){
		return hasil;
	}
}