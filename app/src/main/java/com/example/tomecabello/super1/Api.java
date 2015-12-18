package com.example.tomecabello.super1;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.tomecabello.super1.json.API;
import com.example.tomecabello.super1.json.Result;
import com.example.tomecabello.super1.provider.movies.MoviesColumns;
import com.example.tomecabello.super1.provider.movies.MoviesContentValues;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;

/**
 * Created by tomeCabello on 08/11/2015.
 */

//Creamos el cliente donde usaremos retrofit.
public class Api {
    final String API_KEY = "6cb54438ece271e5a26d8c532fac02ce";
    final String BASE_URL = "https://api.themoviedb.org/3/";//Parte "basica" de la url
    private final Context context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    Interface servei = retrofit.create(Interface.class);

    public Api(Context context){
        super();
        this.context=context;
    }



    //Com esto mostaremos las pelis más vistas
    public void getPeliculesMesVistes(){
        Call<API> call = servei.getPeliculesMesVistes();
        call.enqueue(new Callback<API>() { //Encolamos

            @Override
            public void onResponse(Response<API> response, Retrofit retrofit) { //Si responde, podemos usar el json y añadir a nuestro adapter la peli
                if (response.isSuccess()) {
                    Log.d(null, "OK");
                    API api = response.body();
                    Long syncTime =System.currentTimeMillis();

                    ArrayList<ContentValues> valuesList = new ArrayList<>();
                    for (Result peli : api.getResults()) {
                        //adapter.add(peli);
                        MoviesContentValues values = new MoviesContentValues();
                        values.putTitle(peli.getTitle());
                        values.putAudiencescore(peli.getPopularity());
                        //values.putConsensus(peli.getCriticsConsensus());
                        //values.putCriticsscore(peli.getRatings().getCriticsScore());
                        values.putPosterurl(peli.getPosterPath());
                        values.putReleasedate(peli.getReleaseDate());
                        values.putSynopsis(peli.getOverview());
                        values.putSynctime(syncTime);

                        context.getContentResolver().insert(
                                MoviesColumns.CONTENT_URI,
                                values.values()
                        );
                        Picasso.with(context).load(peli.getPosterPath()).fetch();

                    }
                    context.getContentResolver().delete(
                            MoviesColumns.CONTENT_URI,
                            MoviesColumns.SYNCTIME +" < ?",
                            new String[]{Long.toString(syncTime)}
                    );

                }

            }

            @Override
            public void onFailure(Throwable t) {


            }
        });

    }

    //Con esto, las votadas
    public void getPeliculesMesVotades() {
        Call<API> call = servei.getPeliculesMesVotades();
        call.enqueue(new Callback<API>() {

            @Override
            public void onResponse(Response<API> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    Log.d(null, "OK");
                    API api = response.body();

                    Long syncTime =System.currentTimeMillis();
                    ArrayList<ContentValues> valueList=new ArrayList<>();

                    for (Result peli : api.getResults()) {
                        Double vote = peli.getVoteAverage();
                        //adapter.add(peli);
                        MoviesContentValues values = new MoviesContentValues();
                        values.putTitle(peli.getTitle());
                        values.putAudiencescore(peli.getPopularity());
                        //values.putConsensus(peli.getCriticsConsensus());
                        //values.putCriticsscore(peli.getRatings().getCriticsScore());
                        values.putPosterurl(peli.getPosterPath());
                        values.putReleasedate(peli.getReleaseDate());
                        values.putSynopsis(peli.getOverview());
                        values.putSynctime(syncTime);
                        context.getContentResolver().insert(
                                MoviesColumns.CONTENT_URI,
                                values.values()

                        );

                    }

                }

            }

            @Override
            public void onFailure(Throwable t) {


            }
        });
    }


    //creamos la interfaz que llamara a la url del json.
    public interface Interface {
        @GET("discover/movie?sort_by=popularity.desc&api_key=6cb54438ece271e5a26d8c532fac02ce")
        Call<API> getPeliculesMesVistes();
        @GET("discover/movie?sort_by=vote_average.desc&api_key=6cb54438ece271e5a26d8c532fac02ce")
        Call<API> getPeliculesMesVotades();


    }


}
