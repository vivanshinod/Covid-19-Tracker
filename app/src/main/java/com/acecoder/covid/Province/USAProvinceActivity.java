package com.acecoder.covid.Province;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;
import com.android.volley.Response;
import com.acecoder.covid.Data.USModel;
import com.acecoder.covid.R;
import com.acecoder.covid.adapters.USAdapter;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class USAProvinceActivity extends AppCompatActivity {

    RecyclerView rvUSA;
    private List<USModel> usaList = new ArrayList<>();
    USAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usaprovince);

        init();

    }
    private void init(){
        rvUSA = findViewById(R.id.rvUSA);
        getData();
    }

    private void getData(){
        String url = "https://corona.lmao.ninja/states";

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //  Toast.makeText(CountriesActivity.this, ""+response.toString(), Toast.LENGTH_SHORT).show();
                for(int z=0;z<response.length();z++){

                    USModel model = new USModel();

                    try {
                        JSONObject object = (JSONObject) response.get(z);
                        model.setState(object.getString("state"));
                        model.setCases(object.getInt("cases"));
                        model.setTodayCases(object.getInt("todayCases"));
                        model.setDeaths(object.getInt("deaths"));
                        model.setTodayCases(object.getInt("todayDeaths"));
                        model.setActive(object.getInt("active"));
                        usaList.add(model);
                        setAdapter();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(USAProvinceActivity.this, ""+error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(arrayRequest);
        arrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }


    private void setAdapter(){
        adapter = new USAdapter(usaList);
        rvUSA.setAdapter(adapter);
        rvUSA.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    }
}
