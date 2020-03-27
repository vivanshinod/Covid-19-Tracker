package com.acecoder.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.acecoder.covid.Province.ProvinceActivity;
import com.acecoder.covid.Province.USAProvinceActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class DashboardActivity extends AppCompatActivity {

    TextView tvDeath,tvConfirmCase,tvRecovered,tvUpdated;
    Button btnCountry,btnIndianData,btnUSAData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        init();
    }

    private void init(){
        tvDeath = findViewById(R.id.tvTotalDeath);
        tvUpdated = findViewById(R.id.tvUpdated);
        tvConfirmCase = findViewById(R.id.tvConfirmCases);
        tvRecovered = findViewById(R.id.tvTotalRecovered);
        btnCountry = findViewById(R.id.btnCountryData);
        btnIndianData = findViewById(R.id.btnIndianData);
        btnUSAData = findViewById(R.id.btnUSAData);
        firstGlobalCall();

        btnCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, CountriesActivity.class);
                startActivity(i);
            }
        });
        btnIndianData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, ProvinceActivity.class);
                startActivity(i);
            }
        });

        btnUSAData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, USAProvinceActivity.class);
                startActivity(i);
            }
        });

    }

    private void firstGlobalCall(){
        String url = "https://corona.lmao.ninja/all";

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String sCases = String.valueOf(response.getInt("cases"));
                    tvConfirmCase.setText(sCases);
                    String sDeath = String.valueOf(response.getInt("deaths"));
                    tvDeath.setText(sDeath);
                    String sRecovered = String.valueOf(response.getInt("recovered"));
                    tvRecovered.setText(sRecovered);
                    String sUpdated = String.valueOf(response.getInt("updated"));
                    tvUpdated.setText(sUpdated);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(jsonObjectRequest);
    }




}
