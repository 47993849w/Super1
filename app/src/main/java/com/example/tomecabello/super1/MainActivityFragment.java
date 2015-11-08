package com.example.tomecabello.super1;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import com.example.tomecabello.super1.json.API;
import com.example.tomecabello.super1.json.Result;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ListView pelis = (ListView)rootView.findViewById(R.id.pelis);



        System.out.println("dddddddddddddddd");
        String[] data = {
                "Prueba 1",
                "Prueba 2",
                "Prueba 3"
        };
        items = new ArrayList<>(Arrays.asList(data));
        adapter = new ArrayAdapter<>(
                getContext(),
            R.layout.ly_pelis,
             R.id.tvPelis,
            items
                );
        pelis.setAdapter(adapter);
        final String API_KEY = "6cb54438ece271e5a26d8c532fac02ce";
        final String BASE_URL = "https://api.themoviedb.org/3/";
        Retrofit retrofit = new Retrofit.Builder()
                              .baseUrl(BASE_URL)
                               .addConverterFactory(GsonConverterFactory.create())
                               .build();

        Interface servei = retrofit.create(Interface.class);

        Call<API> call = servei.getPeliculesMesVistes();
        call.enqueue(new Callback<API>() {

            @Override
            public void onResponse(Response<API> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                        Log.d(null, "OK");
                    API api= response.body();
                    System.out.println("BASURAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                }

            }

            @Override
                       public void onFailure(Throwable t) {
                System.out.println("BASURAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAArfewqaf34erAAAAAAAAAAAAA");

            }
        });

        return rootView;

    }



    public interface Interface {
        @GET("discover/movie?sort_by=popularity.desc&api_key=6cb54438ece271e5a26d8c532fac02ce")
        Call<API> getPeliculesMesVistes();
            }
}
