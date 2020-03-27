package com.acecoder.covid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.acecoder.covid.R;
import com.acecoder.covid.model.CountryModel;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder>  {

//    private LayoutInflater inflater;
    private Context context;
    private List<CountryModel> countryModelList;



    public CountryAdapter( List<CountryModel> countryList) {
        this.countryModelList = countryList;
    }

    @NonNull
    @Override
    public CountryAdapter.CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_countries,parent,false);
        CountryViewHolder viewHolder = new CountryViewHolder(view);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.CountryViewHolder holder, int position) {

        CountryModel model = countryModelList.get(position);

        holder.itemView.setTag(model.getCountry());

        holder.tvCountry.setText(model.getCountry());
        holder.tvTotalCases.setText(String.valueOf(model.getCases()));
        holder.tvTodayCases.setText(String.valueOf(model.getTodayCases()));
        holder.tvTotalDeaths.setText(String.valueOf(model.getDeaths()));
        holder.tvTodayDeath.setText(String.valueOf(model.getTodayDeaths()));
        holder.tvRecovered.setText(String.valueOf(model.getRecovered()));
        holder.tvActive.setText(String.valueOf(model.getActive()));
        holder.tvCritical.setText(String.valueOf(model.getCritical()));
        holder.tvCasesPerOneMillion.setText(String.valueOf(model.getCasesPerOneMillion()));
        holder.tvDeathsPerOneMillion.setText(String.valueOf(model.getDeathsPerOneMillion()));
    }

    @Override
    public int getItemCount() {
        return countryModelList.size();
    }






    public class CountryViewHolder extends RecyclerView.ViewHolder {

        TextView tvTotalCases,tvTodayCases,tvTotalDeaths,tvTodayDeath,tvCountry;
        TextView tvRecovered,tvActive,tvCritical,tvCasesPerOneMillion,tvDeathsPerOneMillion;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCountry = itemView.findViewById(R.id.tvCountryName);
            tvTotalCases = itemView.findViewById(R.id.tvRowTotalCases);
            tvTodayCases = itemView.findViewById(R.id.tvRowTodayCases);
            tvTotalDeaths = itemView.findViewById(R.id.tvRowTotalDeaths);
            tvTodayDeath = itemView.findViewById(R.id.tvRowTodayDeaths);
            tvRecovered = itemView.findViewById(R.id.tvRowRecovered);
            tvActive = itemView.findViewById(R.id.tvRowActive);
            tvCritical = itemView.findViewById(R.id.tvRowCritical);
            tvCasesPerOneMillion = itemView.findViewById(R.id.tvRowCPM);
            tvDeathsPerOneMillion = itemView.findViewById(R.id.tvRowDPM);

        }
    }
}
