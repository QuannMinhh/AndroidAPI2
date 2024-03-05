package com.example.androidapi2;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import java.util.Arrays;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);

        String apiEndpoint = "ApiServicePublic/OEE/V='4'";
        Call<String> call = apiService.getRawJsonData(apiEndpoint);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String jsonString = response.body();
                    List<StateObject> stateList = Arrays.asList(new Gson().fromJson(jsonString, StateObject[].class));
                    displayData(stateList);
                } else {
                    Log.e("API Request", "Unsuccessful response");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("API Request", "Failure: " + t.getMessage());
            }
        });
    }

    private void displayData(List<StateObject> stateList) {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        StateAdapter stateAdapter = new StateAdapter(stateList);
        recyclerView.setAdapter(stateAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}