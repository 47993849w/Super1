package com.example.tomecabello.super1;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.tomecabello.super1.json.Result;

import java.util.ArrayList;

public class MainActivityFragment extends Fragment {

    //declaramos nuestro adaptador personal
    private ArrayList<Result> items;
    private Peli adapter;

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
                refresh();
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
        items = new ArrayList<>();
        adapter = new Peli(
                getContext(),
            R.layout.ly_pelis,
            items

                );
        pelis.setAdapter(adapter);
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
        Api api = new Api();
        //api.getPeliculesMesVistes(adapter);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String tipoConsulta = preferences.getString("tipoConsulta", "Mas vistas");
        if (tipoConsulta.equals("r")){
            api.getPeliculesMesVistes(adapter);
        }
        else {
            api.getPeliculesMesVotades(adapter);
        }


    }



}
