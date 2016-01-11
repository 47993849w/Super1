package com.example.tomecabello.super1;

import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.tomecabello.super1.json.API;
import com.example.tomecabello.super1.json.Result;
import com.example.tomecabello.super1.provider.movies.MoviesColumns;
import com.example.tomecabello.super1.provider.movies.MoviesContentValues;
import com.squareup.picasso.Picasso;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

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


    public void mv(){
        UpdateMovies1 updateMovies = new UpdateMovies1();
        updateMovies.execute();
    }

    public void mvt(){
        UpdateMovies2 updateMovies = new UpdateMovies2();
        updateMovies.execute();
    }

    //Com esto mostaremos las pelis más vistas
    public void getPeliculesMesVistes(){
        Call<API> call = servei.getPeliculesMesVistes();

        call.enqueue(new Callback<API>()


        { //Encolamos

            @Override
            public void onResponse(Response<API> response, Retrofit retrofit) { //Si responde, podemos usar el json y añadir a nuestro adapter la peli
                if (response.isSuccess()) {
                    Log.d(null, "OK");
                    API api = response.body();
                    ContentValues[] bulkToInsert;
                    List<ContentValues> mValueList = new ArrayList<>();
                    Long syncTime = System.currentTimeMillis();

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

                        // context.getContentResolver().insert(
                        //       MoviesColumns.CONTENT_URI,
                        //     values.values()
                        //);
                        Picasso.with(context).load(peli.getPosterPath()).fetch();
                        mValueList.add(values.values());

                    }
                    bulkToInsert = new ContentValues[mValueList.size()];
                    mValueList.toArray(bulkToInsert);
                    context.getContentResolver().bulkInsert(MoviesColumns.CONTENT_URI, bulkToInsert);


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
                    ContentValues[] bulkToInsert;
                    List<ContentValues> mValueList = new ArrayList<>();


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
                        //context.getContentResolver().insert(
                          //      MoviesColumns.CONTENT_URI,
                            //    values.values()

                        ///);

                        Picasso.with(context).load(peli.getPosterPath()).fetch();
                        mValueList.add(values.values());

                    }
                    bulkToInsert = new ContentValues[mValueList.size()];
                    mValueList.toArray(bulkToInsert);
                    context.getContentResolver().bulkInsert(MoviesColumns.CONTENT_URI, bulkToInsert);



                    }

                }



            @Override
            public void onFailure(Throwable t) {


            }
        });
    }


    public void borrar(long sync){
        context.getContentResolver().delete(
                MoviesColumns.CONTENT_URI,
                MoviesColumns.SYNCTIME + " < ?",
                new String[]{Long.toString(sync)}
        );
    }


    class UpdateMovies1 extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] params) {
            getPeliculesMesVistes();

            Long syncTime = System.currentTimeMillis();
            borrar(syncTime);

            return null;
        }
    }
    class UpdateMovies2 extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] params) {

            getPeliculesMesVotades();
            Long syncTime = System.currentTimeMillis();
            borrar(syncTime);

            return null;
        }
    }


    //creamos la interfaz que llamara a la url del json.
    public interface Interface {
        @GET("discover/movie?sort_by=popularity.desc&api_key=6cb54438ece271e5a26d8c532fac02ce")
        Call<API> getPeliculesMesVistes();
        @GET("discover/movie?sort_by=vote_average.desc&api_key=6cb54438ece271e5a26d8c532fac02ce")
        Call<API> getPeliculesMesVotades();


    }


}
