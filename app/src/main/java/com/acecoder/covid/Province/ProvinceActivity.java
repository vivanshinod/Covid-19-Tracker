package com.acecoder.covid.Province;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import com.acecoder.covid.R;
import com.acecoder.covid.adapters.ProvinceIndiaAdapter;
import com.acecoder.covid.model.IndiaModel;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProvinceActivity extends AppCompatActivity {

    RecyclerView rvIndia;
    ProvinceIndiaAdapter indiaAdapter;
    ArrayList<IndiaModel> indiaModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_province);
        init();

    }

    private void init(){
        rvIndia = findViewById(R.id.rvProvinceIndia);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getProvinceData();
    }

    private void getProvinceData() {
        String url = "https://api.rootnet.in/covid19-in/stats/latest";
        Request.Priority priority = Request.Priority.HIGH;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject object = new JSONObject(String.valueOf(response.getJSONObject("data")));
                    indiaModelArrayList = new ArrayList<>();
                    JSONArray array = object.getJSONArray("regional");
                    for(int i=0;i<array.length();i++){
                        IndiaModel indiaModel = new IndiaModel();
                        JSONObject jsonObject = array.getJSONObject(i);

                        indiaModel.setLoc(jsonObject.getString("loc"));
                        indiaModel.setConfirmedCasesIndian(jsonObject.getInt("confirmedCasesIndian"));
                        indiaModel.setConfirmedCasesForeigners(jsonObject.getInt("confirmedCasesForeign"));
                        indiaModel.setDischarged(jsonObject.getInt("discharged"));
                        indiaModel.setDeaths(jsonObject.getInt("deaths"));

                        indiaModelArrayList.add(indiaModel);
                    }
                    setProvince();

                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue queue=Volley.newRequestQueue(this);
        queue.add(jsonObjectRequest);
    }



    private void setProvince(){
        indiaAdapter = new ProvinceIndiaAdapter(indiaModelArrayList);
        rvIndia.setAdapter(indiaAdapter);
        rvIndia.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
    }



}
