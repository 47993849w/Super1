package com.example.tomecabello.super1;

import android.content.Context;
import android.graphics.Movie;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tomecabello.super1.R;
import com.example.tomecabello.super1.json.Result;
import com.squareup.picasso.Picasso;

import java.util.List;
//solvntado problema
/**
 * Created by tomeCabello on 09/11/2015.
 */

// Esta clase nos permite meter los valores del json dentro de lso campos del listview. Creado el adaptador personalizado

public class Peli extends ArrayAdapter<Result> {

    public Peli(Context context, int resource, List<Result> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Result result = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.ly_pelis, parent, false);
        }
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView popularity = (TextView) convertView.findViewById(R.id.popularity);
        TextView data = (TextView) convertView.findViewById(R.id.data);
        ImageView image3 = (ImageView) convertView.findViewById(R.id.imageView);

        title.setText(result.getTitle());
        popularity.setText(""+result.getPopularity());
        data.setText(result.getReleaseDate());
        final  String POSTERURLINI = "http://image.tmdb.org/t/p/";
        final String TMN = "w185";
        Picasso.with(this.getContext()).load(POSTERURLINI+TMN+result.getPosterPath()).into(image3);
        System.out.println(POSTERURLINI + TMN + result.getPosterPath());

        return convertView;
    }
}
