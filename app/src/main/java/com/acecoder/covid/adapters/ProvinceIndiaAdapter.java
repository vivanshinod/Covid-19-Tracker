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
import com.acecoder.covid.model.IndiaModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ProvinceIndiaAdapter extends RecyclerView.Adapter<ProvinceIndiaAdapter.ProvinceIndiaViewHolder>  {

    private Context context;
    private ArrayList<IndiaModel> countryModelList;

    public ProvinceIndiaAdapter(ArrayList<IndiaModel> countryModelList) {
        this.countryModelList = countryModelList;
    }


    @NonNull
    @Override
    public ProvinceIndiaAdapter.ProvinceIndiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_india,parent,false);
        ProvinceIndiaViewHolder viewHolder = new ProvinceIndiaViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProvinceIndiaViewHolder holder, int position) {
        IndiaModel model = countryModelList.get(position);

        holder.itemView.setTag(model.getLoc());

        holder.tvProvinceIndia.setText(model.getLoc());
        holder.tvDischargedIndians.setText(String.valueOf(model.getDischarged()));
        holder.tvDeaths.setText(String.valueOf(model.getDeaths()));
        holder.tvConfirmedCaseForeigners.setText(String.valueOf(model.getConfirmedCasesForeigners()));
        holder.tvConfirmedCaseIndian.setText(String.valueOf(model.getConfirmedCasesIndian()));
    }



    @Override
    public int getItemCount() {
        return countryModelList.size();
    }

    public class ProvinceIndiaViewHolder extends RecyclerView.ViewHolder {

        TextView tvProvinceIndia,tvConfirmedCaseIndian,tvConfirmedCaseForeigners,tvDischargedIndians,tvDeaths;

        public ProvinceIndiaViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDeaths = itemView.findViewById(R.id.tvDeaths);
            tvConfirmedCaseForeigners = itemView.findViewById(R.id.tvConfirmedCaseForeigners);
            tvDischargedIndians = itemView.findViewById(R.id.tvDischargedIndians);
            tvConfirmedCaseIndian = itemView.findViewById(R.id.tvConfirmedCaseIndian);
            tvProvinceIndia = itemView.findViewById(R.id.tvProvinceIndia);
        }
    }


}
