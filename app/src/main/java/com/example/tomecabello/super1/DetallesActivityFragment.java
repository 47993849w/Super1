package com.example.tomecabello.super1;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tomecabello.super1.json.Result;
import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetallesActivityFragment extends Fragment {

    public DetallesActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalles, container, false);
        Intent i = getActivity().getIntent();
        Result item = (Result) i.getSerializableExtra("item");
        Toast.makeText(getContext(),item.getTitle() , Toast.LENGTH_LONG).show();

        TextView title = (TextView) view.findViewById(R.id.title);
        TextView popularity = (TextView) view.findViewById(R.id.popularity);
        TextView data = (TextView) view.findViewById(R.id.data);
        ImageView image3 = (ImageView) view.findViewById(R.id.imageView);

        title.setText(item.getTitle());
        popularity.setText(""+item.getPopularity());
        data.setText(item.getReleaseDate());
        final  String POSTERURLINI = "http://image.tmdb.org/t/p/";
        final String TMN = "w185";
        Picasso.with(this.getContext()).load(POSTERURLINI+TMN+item.getPosterPath()).into(image3);
        System.out.println(POSTERURLINI + TMN + item.getPosterPath());


        return view;
    }

}
