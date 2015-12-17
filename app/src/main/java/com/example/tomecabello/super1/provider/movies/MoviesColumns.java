package com.example.tomecabello.super1.provider.movies;

import android.net.Uri;
import android.provider.BaseColumns;

import com.example.tomecabello.super1.provider.MoviesProvider;
import com.example.tomecabello.super1.provider.movies.MoviesColumns;

/**
 * Columns for the {@code movies} table.
 */
public class MoviesColumns implements BaseColumns {
    public static final String TABLE_NAME = "movies";
    public static final Uri CONTENT_URI = Uri.parse(MoviesProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String TITLE = "title";

    public static final String CRITICSSCORE = "criticsScore";

    public static final String AUDIENCESCORE = "audienceScore";

    public static final String CONSENSUS = "consensus";

    public static final String SYNOPSIS = "synopsis";

    public static final String RELEASEDATE = "releaseDate";

    public static final String POSTERURL = "posterUrl";

    public static final String SYNCTIME = "syncTime";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            TITLE,
            CRITICSSCORE,
            AUDIENCESCORE,
            CONSENSUS,
            SYNOPSIS,
            RELEASEDATE,
            POSTERURL,
            SYNCTIME
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(TITLE) || c.contains("." + TITLE)) return true;
            if (c.equals(CRITICSSCORE) || c.contains("." + CRITICSSCORE)) return true;
            if (c.equals(AUDIENCESCORE) || c.contains("." + AUDIENCESCORE)) return true;
            if (c.equals(CONSENSUS) || c.contains("." + CONSENSUS)) return true;
            if (c.equals(SYNOPSIS) || c.contains("." + SYNOPSIS)) return true;
            if (c.equals(RELEASEDATE) || c.contains("." + RELEASEDATE)) return true;
            if (c.equals(POSTERURL) || c.contains("." + POSTERURL)) return true;
            if (c.equals(SYNCTIME) || c.contains("." + SYNCTIME)) return true;
        }
        return false;
    }

}
