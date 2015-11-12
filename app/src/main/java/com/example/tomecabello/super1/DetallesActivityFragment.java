package com.example.tomecabello.super1;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
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
        getActivity().setTitle(item.getTitle());
        Toast.makeText(getContext(),item.getTitle() , Toast.LENGTH_LONG).show();

        TextView title = (TextView) view.findViewById(R.id.title);
        SpannableString content = new SpannableString(item.getTitle());
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        title.setText(content);
        TextView popularity = (TextView) view.findViewById(R.id.popularity);
        TextView data = (TextView) view.findViewById(R.id.data);
        ImageView image3 = (ImageView) view.findViewById(R.id.imageView);
        TextView plot = (TextView) view.findViewById(R.id.arg);

        //title.setText(item.getTitle());
        popularity.setText("Popularidad:"+item.getPopularity());
        data.setText("Fecha:"+item.getReleaseDate());
        final  String POSTERURLINI = "http://image.tmdb.org/t/p/";
        final String TMN = "w780";
        Picasso.with(getContext()).load(POSTERURLINI + TMN+item.getPosterPath()).into(image3);
        System.out.println(POSTERURLINI + TMN + item.getPosterPath());
        plot.setText(item.getOverview());



        return view;
    }

}
