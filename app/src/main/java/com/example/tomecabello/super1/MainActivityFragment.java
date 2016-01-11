package com.example.tomecabello.super1;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.tomecabello.super1.json.API;
import com.example.tomecabello.super1.json.Result;
import com.example.tomecabello.super1.provider.movies.MoviesColumns;

import java.util.ArrayList;

import retrofit.Retrofit;

public class MainActivityFragment extends Fragment implements android.support.v4.app.LoaderManager.LoaderCallbacks<Cursor>  {

    //declaramos nuestro adaptador personal
    private ArrayList<Result> items;
    private MoviesCursorAdapter adapter;
    private SwipeRefreshLayout srlRef;

    public MainActivityFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
            }


    //cada vez que monstramos este fragment,  recargamos la lista

    public void onStart() {
                super.onStart();

            getLoaderManager().restartLoader(0, null, this);
            }





    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        final ListView pelis = (ListView)rootView.findViewById(R.id.pelis);



        System.out.println("dddddddddddddddd");
        String[] data = {
                "Prueba 1",
                "Prueba 2",
                "Prueba 3"
        };
        items = new ArrayList<>();
        adapter = new MoviesCursorAdapter(
                getContext(),
            R.layout.ly_pelis,
                null,
                new String[]{
                        MoviesColumns.POSTERURL,
                        MoviesColumns.TITLE,
                        MoviesColumns.AUDIENCESCORE
                },
                new int[]{
                        R.id.imageView,
                        R.id.pelis,
                        R.id.popularity
                },
                0


                );
        getLoaderManager().initLoader(0,null,this);
        pelis.setAdapter(adapter);
        pelis.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getContext(), DetallesActivity.class);
                i.putExtra("movie._id", id);
                startActivity(i);
            }

        });


        return rootView;

    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_refresh) {
            refresh();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Aqui miraremso que opcion está seleccionada, y mostraremos la lista que pertoca
    private void refresh() {
//        srlRef.setRefreshing(true);
        Api api = new Api(getContext());

        //api.getPeliculesMesVistes(adapter);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String tipoConsulta = preferences.getString("tipoConsulta", "Mas vistas");
        if (tipoConsulta.equals("r")){
            api.getPeliculesMesVistes();
        }
        else {
            api.getPeliculesMesVotades();
        }

        //api.getPelicules;
      //  srlRef.setRefreshing(false);



    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getContext(),
            MoviesColumns.CONTENT_URI, null, null, null, null);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);

    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.swapCursor(null);

    }
}
