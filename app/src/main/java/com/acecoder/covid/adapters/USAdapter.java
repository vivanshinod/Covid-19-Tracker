package com.acecoder.covid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.acecoder.covid.Data.USModel;
import com.acecoder.covid.R;
import com.acecoder.covid.model.IndiaModel;

import java.util.List;

public class USAdapter extends RecyclerView.Adapter<USAdapter.USViewHolder> {

    private Context context;
    private List<USModel> usModelList;

    public USAdapter(List<USModel> usModelList) {
        this.usModelList = usModelList;
    }

    @NonNull
    @Override
    public USAdapter.USViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_usa,parent,false);
        USViewHolder viewHolder = new USViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull USAdapter.USViewHolder holder, int position) {
        USModel model = usModelList.get(position);

        holder.itemView.setTag(model.getState());

        holder.tvState.setText(model.getState());
        holder.tvActive.setText(String.valueOf(model.getActive()));
        holder.tvTodayDeath.setText(String.valueOf(model.getTodayDeaths()));
        holder.tvDeath.setText(String.valueOf(model.getDeaths()));
        holder.tvCases.setText(String.valueOf(model.getCases()));
        holder.tvTodayCases.setText(String.valueOf(model.getTodayCases()));
    }

    @Override
    public int getItemCount() {
        return usModelList.size();
    }

    public class USViewHolder extends RecyclerView.ViewHolder {

        TextView tvState,tvCases,tvTodayCases,tvDeath,tvTodayDeath,tvActive;

        public USViewHolder(@NonNull View itemView) {
            super(itemView);

            tvState = itemView.findViewById(R.id.tvUSState);
            tvCases = itemView.findViewById(R.id.tvUSCases);
            tvTodayCases = itemView.findViewById(R.id.tvUSTodayCases);
            tvDeath = itemView.findViewById(R.id.tvUSDeaths);
            tvTodayDeath = itemView.findViewById(R.id.tvUSTodayDeaths);
            tvActive = itemView.findViewById(R.id.tvUSActives);
        }
    }
}
