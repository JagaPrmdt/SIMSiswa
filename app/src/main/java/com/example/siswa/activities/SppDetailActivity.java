package com.example.siswa.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.siswa.R;
//import com.example.siswa.model.SppResponse;
import com.example.siswa.model.SppResponse;
import com.example.siswa.network.ServiceClient;
import com.example.siswa.network.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SppDetailActivity extends AppCompatActivity {

    TextView tvTahunajaran;
    TextView tvJuli, tvAgustus, tvSeptember, tvOktober, tvNovember, tvDesember, tvJanuari, tvFebruari, tvMaret, tvApril, tvMei, tvJuni;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spp_detail);

        tvTahunajaran = findViewById(R.id.tv_detail_spp_tahun_ajaran);
        tvJuli = findViewById(R.id.tv_ket_spp_juli);
        tvAgustus = findViewById(R.id.tv_ket_spp_agustus);
        tvSeptember = findViewById(R.id.tv_ket_spp_september);
        tvNovember = findViewById(R.id.tv_ket_spp_november);
        tvDesember = findViewById(R.id.tv_ket_spp_desember);
        tvJanuari = findViewById(R.id.tv_ket_spp_januari);
        tvFebruari = findViewById(R.id.tv_ket_spp_februari);
        tvMaret = findViewById(R.id.tv_ket_spp_maret);
        tvApril = findViewById(R.id.tv_ket_spp_april);
        tvMei = findViewById(R.id.tv_ket_spp_mei);
        tvJuni = findViewById(R.id.tv_ket_spp_juni);
        tvOktober = findViewById(R.id.tv_ket_spp_oktober);

        pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.setCancelable(false);
        pd.show();

        String tingkatan = getSharedPreferences("session",MODE_PRIVATE).getString("tingkatan","");
        String tahunAjaran = getSharedPreferences("session",MODE_PRIVATE).getString("tahunAjaran","");
        String kelas = getSharedPreferences("session",MODE_PRIVATE).getString("kelas","");
        String nis = getSharedPreferences("session",MODE_PRIVATE).getString("nis","");


        ServiceClient service = ServiceGenerator.createService(ServiceClient.class);

        Call<SppResponse> requestSpp = service.readSpp("loginSiswa","readSpp",tingkatan,tahunAjaran,kelas,nis);


        requestSpp.enqueue(new Callback<SppResponse>() {
            @Override
            public void onResponse(Call<SppResponse> call, Response<SppResponse> response) {
                pd.dismiss();
                if (!response.body().getHasil().getJuli().isEmpty()){
                    tvTahunajaran.setText(tahunAjaran);
                    tvJuli.setText(response.body().getHasil().getJuli());
                    tvAgustus.setText(response.body().getHasil().getAgustus());
                    tvSeptember.setText(response.body().getHasil().getSeptember());
                    tvOktober.setText(response.body().getHasil().getOktober());
                    tvNovember.setText(response.body().getHasil().getNovember());
                    tvDesember.setText(response.body().getHasil().getDesember());
                    tvJanuari.setText(response.body().getHasil().getJanuari());
                    tvFebruari.setText(response.body().getHasil().getFebruari());
                    tvMaret.setText(response.body().getHasil().getMaret());
                    tvApril.setText(response.body().getHasil().getApril());
                    tvMei.setText(response.body().getHasil().getMei());
                    tvJuni.setText(response.body().getHasil().getJuni());

                }
            }

            @Override
            public void onFailure(Call<SppResponse> call, Throwable t) {
                pd.dismiss();
                Toast.makeText(SppDetailActivity.this,""+t.getMessage(),Toast.LENGTH_SHORT);

            }
        });

    }
}