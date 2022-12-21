package com.android.secure_notes;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContainersRecyclerAdapter
        extends RecyclerView.Adapter<ContainersRecyclerAdapter.ViewHolder> {
    private final ArrayList<Container> containerList;

    public ContainersRecyclerAdapter(ArrayList<Container> containerList) {
        this.containerList = containerList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.nameText = itemView.findViewById(R.id.textViewContainerName);
        }
    }

    @NonNull
    @Override
    public ContainersRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_container, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContainersRecyclerAdapter.ViewHolder holder, int position) {
        holder.nameText.setText(containerList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return containerList.size();
    }
}
