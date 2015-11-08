package com.example.tomecabello.super1;

import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.tomecabello.super1.json.API;
import com.example.tomecabello.super1.json.Result;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;

/**
 * Created by tomeCabello on 08/11/2015.
 */
public class Api {
    final String API_KEY = "6cb54438ece271e5a26d8c532fac02ce";
    final String BASE_URL = "https://api.themoviedb.org/3/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    Interface servei = retrofit.create(Interface.class);

    public Api(){
        super();
    }



    public void getPeliculesMesVistes(final ArrayAdapter adapter){
        Call<API> call = servei.getPeliculesMesVistes();
        call.enqueue(new Callback<API>() {

            @Override
            public void onResponse(Response<API> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    Log.d(null, "OK");
                    API api= response.body();
                    adapter.clear();
                    for (Result peli : api.getResults()) {
                        adapter.add(peli.getTitle());
                    }
                    System.out.println("BASURAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                }

            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("BASURAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAArfewqaf34erAAAAAAAAAAAAA");

            }
        });

    }


    public interface Interface {
        @GET("discover/movie?sort_by=popularity.desc&api_key=6cb54438ece271e5a26d8c532fac02ce")
        Call<API> getPeliculesMesVistes();
    }


}
