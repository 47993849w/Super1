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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
public class MainActivityFragment extends Fragment {

    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    public MainActivityFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
            }


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
        items = new ArrayList<>(Arrays.asList(data));
        adapter = new ArrayAdapter<>(
                getContext(),
            R.layout.ly_pelis,
             R.id.tvPelis,
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
