package com.david.testrinnapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.david.testrinnapplication.adapters.ListUsersAdapter;
import com.david.testrinnapplication.models.User;
import com.david.testrinnapplication.utils.GoRestApi;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewResult;
    private RecyclerView recyclerView;
    private ListUsersAdapter listUsersAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextViewResult = findViewById(R.id.idTextView);

        //recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //listUsersAdapter = new ListUsersAdapter();
        //recyclerView.setAdapter(listUsersAdapter);
        //recyclerView.setHasFixedSize(true);
        //GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        //recyclerView.setLayoutManager(layoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gorest.co.in/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        GoRestApi goRestApi = retrofit.create(GoRestApi.class);


        goRestApi.getUsersByScalars().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.body());
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    Gson gson = new Gson();
                    Type type = new TypeToken<List<User>>() {}.getType();
                    List<User> lista = gson.fromJson(String.valueOf(jsonArray), type);
                    //testing - size = 2 but value Titulo is null
                    Log.i("LISTSIZE->", lista.size() + "");
                    for (User n : lista) {
                        Log.i("TITULO", n.getName());
                    }

                    Log.i("Here", "Stop");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}