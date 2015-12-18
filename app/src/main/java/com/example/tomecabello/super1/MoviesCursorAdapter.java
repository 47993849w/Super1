package com.example.tomecabello.super1;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.tomecabello.super1.provider.movies.MoviesColumns;
import com.example.tomecabello.super1.provider.movies.MoviesCursor;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

/**
 * Created by 47993849w on 18/12/15.
 */




public class MoviesCursorAdapter extends SimpleCursorAdapter{
    private final Context context;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public MoviesCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        this.context=context;
    }
    public View getView(int position, View convertView, ViewGroup parent){

        Cursor cursor = getCursor();
        MoviesCursor moviesCursor = new MoviesCursor(cursor);
        moviesCursor.moveToPosition(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView=inflater.inflate(R.layout.ly_pelis, parent, false);
        }

        TextView titulo = (TextView ) convertView.findViewById(R.id.fragment);
        TextView valor = (TextView) convertView.findViewById(R.id.popularity);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);

//        titulo.setText(moviesCursor.getTitle());
        valor.setText(""+moviesCursor.getCriticsscore());
        Picasso.with(context).load(moviesCursor.getPosterurl()).fit().into(imageView);
        return convertView;

    }
}
