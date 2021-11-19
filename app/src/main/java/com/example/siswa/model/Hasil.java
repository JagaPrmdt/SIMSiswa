package com.example.siswa.model;

import com.google.gson.annotations.SerializedName;

public class Hasil{

	@SerializedName("maret")
	private String maret;

	@SerializedName("mei")
	private String mei;

	@SerializedName("november")
	private String november;

	@SerializedName("september")
	private String september;

	@SerializedName("januari")
	private String januari;

	@SerializedName("februari")
	private String februari;

	@SerializedName("juni")
	private String juni;

	@SerializedName("agustus")
	private String agustus;

	@SerializedName("oktober")
	private String oktober;

	@SerializedName("juli")
	private String juli;

	@SerializedName("april")
	private String april;

	@SerializedName("desember")
	private String desember;

	public String getMaret(){
		return maret;
	}

	public String getMei(){
		return mei;
	}

	public String getNovember(){
		return november;
	}

	public String getSeptember(){
		return september;
	}

	public String getJanuari(){
		return januari;
	}

	public String getFebruari(){
		return februari;
	}

	public String getJuni(){
		return juni;
	}

	public String getAgustus(){
		return agustus;
	}

	public String getOktober(){
		return oktober;
	}

	public String getJuli(){
		return juli;
	}

	public String getApril(){
		return april;
	}

	public String getDesember(){
		return desember;
	}
}