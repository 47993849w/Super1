package com.example.tomecabello.super1;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

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


        items = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                getContext(),
            R.layout.ly_pelis,
             R.id.tvPelis,
            items
                );
        pelis.setAdapter(adapter);
        return rootView;
    }
}