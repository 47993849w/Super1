package com.example.tomecabello.super1;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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
import android.text.Html;
import com.example.tomecabello.super1.json.Result;
import com.example.tomecabello.super1.provider.movies.MoviesColumns;
import com.example.tomecabello.super1.provider.movies.MoviesCursor;
import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetallesActivityFragment extends Fragment {
    private long id;
    private TextView plot;

    public DetallesActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalles, container, false);

        //super.onCreate(savedInstanceState);
        // Intent i = getActivity().getIntent();
        //Result item = (Result) i.getSerializableExtra("item");
        // getActivity().setTitle(item.getTitle());
        // Toast.makeText(getContext(),item.getTitle() , Toast.LENGTH_LONG).show();

        TextView title = (TextView) view.findViewById(R.id.title);
        //SpannableString content = new SpannableString(item.getTitle());
        // content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        //title.setText(content);
        TextView popularity = (TextView) view.findViewById(R.id.popularity);
        TextView data = (TextView) view.findViewById(R.id.data);
        ImageView image3 = (ImageView) view.findViewById(R.id.imageView);
        TextView plot = (TextView) view.findViewById(R.id.arg);


        //Long movie_id = getActivity().getIntent().getLongExtra("movie_id", -1);
        // System.out.println(movie_id+"HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH///////////&787878787878787878787878787878787878323333333333333333333");
        Intent i = getActivity().getIntent();
        System.out.println(i+"OOOPPPPPPPUEEEEEEEEEEEEEHHHHHHHHHHHHHGGGGGGGGG");
        id = i.getLongExtra("movie._id", -1);
        System.out.println(id + "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH///////////&787878787878787878787878787878787878323333333333333333333");

        if (id != -1) {
            details();
        }
        return view;
    }

    public void details()

    {


        Cursor cursor = getContext().getContentResolver().query(
                MoviesColumns.CONTENT_URI,
                null,
                MoviesColumns._ID + " = ?",
                new String[]{String.valueOf(id)},
                null);
        MoviesCursor moviesCursor = new MoviesCursor(cursor);
        moviesCursor.moveToNext();
        //title.setText(item.getTitle());
//        popularity.setText("Popularidad:"+moviesCursor.getAudiencescore());
        // data.setText("Fecha:"+moviesCursor.getReleasedate());
        final String POSTERURLINI = "http://image.tmdb.org/t/p/";
        final String TMN = "w780";
        //Picasso.with(getContext()).load(moviesCursor.getPosterurl()).into(image3);
        // System.out.println(POSTERURLINI + TMN + item.getPosterPath());
        System.out.println(moviesCursor.getSynopsis()+"897y69876878979789079df789df8f9dejdnhf89ryfer9f8r");
        plot.setText(moviesCursor.getSynopsis());



    }

}
