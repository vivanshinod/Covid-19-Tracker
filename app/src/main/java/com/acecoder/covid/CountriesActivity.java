package com.acecoder.covid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.acecoder.covid.adapters.CountryAdapter;
import com.acecoder.covid.model.CountryModel;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CountriesActivity extends AppCompatActivity  {

    RecyclerView rvCountry;
    private List<CountryModel> countryList = new ArrayList<>();
    CountryAdapter adapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);


        init();
    }

    private void init() {
        rvCountry = findViewById(R.id.rvCountries);
        getCountryData();
    }

    private void getCountryData() {

        String url = "https://coronavirus-19-api.herokuapp.com/countries";

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //  Toast.makeText(CountriesActivity.this, ""+response.toString(), Toast.LENGTH_SHORT).show();
                for (int z = 0; z < response.length(); z++) {

                    CountryModel model = new CountryModel();

                    try {
                        JSONObject object = (JSONObject) response.get(z);
                        model.setCountry(object.getString("country"));
                        model.setCases(object.getInt("cases"));
                        model.setTodayCases(object.getInt("todayCases"));
                        model.setDeaths(object.getInt("deaths"));
                        model.setTodayCases(object.getInt("todayDeaths"));
                        model.setRecovered(object.getInt("recovered"));
                        model.setActive(object.getInt("active"));
                        model.setCritical(object.getInt("critical"));
                        model.setCasesPerOneMillion(object.getInt("casesPerOneMillion"));
                        model.setDeathsPerOneMillion(object.getInt("deathsPerOneMillion"));
                        countryList.add(model);
                        setAdapter();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CountriesActivity.this, "" + error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(arrayRequest);
        arrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }


    private void setAdapter() {


        adapter = new CountryAdapter( countryList);
        rvCountry.setAdapter(adapter);
        rvCountry.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    }






}
