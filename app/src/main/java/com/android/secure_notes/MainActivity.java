package com.android.secure_notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity{
    private static final String TAG = "MyActivity";
    private ArrayList<Container> containerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // init super
        super.onCreate(savedInstanceState);

        // init container list
        this.containerList = new ArrayList<>(0);

        // hide title bar
        Objects.requireNonNull(this.getSupportActionBar()).hide();

        // set content view
        setContentView(R.layout.activity_main);

        // init recyclerview for containers
        containersRecyclerViewInit();
    }

    private void containersRecyclerViewInit() {
        // get recycler view
        RecyclerView containersView = (RecyclerView) findViewById(R.id.containersRecyclerView);

        // create recycler view components
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        ContainersRecyclerAdapter containersAdapter = new ContainersRecyclerAdapter(containerList);

        // set recycler view components
        containersView.setLayoutManager(layoutManager);
        containersView.setItemAnimator(new DefaultItemAnimator());
        containersView.setAdapter(containersAdapter);

        // set listener for add button
        Container newItem = new Container("Added");
        FloatingActionButton addButton = (FloatingActionButton) findViewById(R.id.buttonAddContainer);
        addButton.setOnClickListener(view -> {
            containerList.add(newItem);

            containersAdapter.notifyItemInserted( containerList.size() - 1);
            Log.d(TAG, String.valueOf(containersAdapter.getItemCount()));
        });
    }
}