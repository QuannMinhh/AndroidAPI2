package com.example.androidapi2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder>{
    private List<StateObject> stateList;

    public StateAdapter(List<StateObject> stateList) {
        this.stateList = stateList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StateObject state = stateList.get(position);
        holder.stateNameTextView.setText(state.getSTATE_NAME());
    }

    @Override
    public int getItemCount() {
        return stateList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView stateNameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            stateNameTextView = itemView.findViewById(R.id.stateNameTextView);
        }
    }
}
