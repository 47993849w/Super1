package com.example.tomecabello.super1.provider.movies;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.example.tomecabello.super1.provider.base.AbstractSelection;

/**
 * Selection for the {@code movies} table.
 */
public class MoviesSelection extends AbstractSelection<MoviesSelection> {
    @Override
    protected Uri baseUri() {
        return MoviesColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MoviesCursor} object, which is positioned before the first entry, or null.
     */
    public MoviesCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MoviesCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public MoviesCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MoviesCursor} object, which is positioned before the first entry, or null.
     */
    public MoviesCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MoviesCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public MoviesCursor query(Context context) {
        return query(context, null);
    }


    public MoviesSelection id(long... value) {
        addEquals("movies." + MoviesColumns._ID, toObjectArray(value));
        return this;
    }

    public MoviesSelection idNot(long... value) {
        addNotEquals("movies." + MoviesColumns._ID, toObjectArray(value));
        return this;
    }

    public MoviesSelection orderById(boolean desc) {
        orderBy("movies." + MoviesColumns._ID, desc);
        return this;
    }

    public MoviesSelection orderById() {
        return orderById(false);
    }

    public MoviesSelection title(String... value) {
        addEquals(MoviesColumns.TITLE, value);
        return this;
    }

    public MoviesSelection titleNot(String... value) {
        addNotEquals(MoviesColumns.TITLE, value);
        return this;
    }

    public MoviesSelection titleLike(String... value) {
        addLike(MoviesColumns.TITLE, value);
        return this;
    }

    public MoviesSelection titleContains(String... value) {
        addContains(MoviesColumns.TITLE, value);
        return this;
    }

    public MoviesSelection titleStartsWith(String... value) {
        addStartsWith(MoviesColumns.TITLE, value);
        return this;
    }

    public MoviesSelection titleEndsWith(String... value) {
        addEndsWith(MoviesColumns.TITLE, value);
        return this;
    }

    public MoviesSelection orderByTitle(boolean desc) {
        orderBy(MoviesColumns.TITLE, desc);
        return this;
    }

    public MoviesSelection orderByTitle() {
        orderBy(MoviesColumns.TITLE, false);
        return this;
    }

    public MoviesSelection criticsscore(Double... value) {
        addEquals(MoviesColumns.CRITICSSCORE, value);
        return this;
    }

    public MoviesSelection criticsscoreNot(Double... value) {
        addNotEquals(MoviesColumns.CRITICSSCORE, value);
        return this;
    }

    public MoviesSelection criticsscoreGt(double value) {
        addGreaterThan(MoviesColumns.CRITICSSCORE, value);
        return this;
    }

    public MoviesSelection criticsscoreGtEq(double value) {
        addGreaterThanOrEquals(MoviesColumns.CRITICSSCORE, value);
        return this;
    }

    public MoviesSelection criticsscoreLt(double value) {
        addLessThan(MoviesColumns.CRITICSSCORE, value);
        return this;
    }

    public MoviesSelection criticsscoreLtEq(double value) {
        addLessThanOrEquals(MoviesColumns.CRITICSSCORE, value);
        return this;
    }

    public MoviesSelection orderByCriticsscore(boolean desc) {
        orderBy(MoviesColumns.CRITICSSCORE, desc);
        return this;
    }

    public MoviesSelection orderByCriticsscore() {
        orderBy(MoviesColumns.CRITICSSCORE, false);
        return this;
    }

    public MoviesSelection audiencescore(Integer... value) {
        addEquals(MoviesColumns.AUDIENCESCORE, value);
        return this;
    }

    public MoviesSelection audiencescoreNot(Integer... value) {
        addNotEquals(MoviesColumns.AUDIENCESCORE, value);
        return this;
    }

    public MoviesSelection audiencescoreGt(int value) {
        addGreaterThan(MoviesColumns.AUDIENCESCORE, value);
        return this;
    }

    public MoviesSelection audiencescoreGtEq(int value) {
        addGreaterThanOrEquals(MoviesColumns.AUDIENCESCORE, value);
        return this;
    }

    public MoviesSelection audiencescoreLt(int value) {
        addLessThan(MoviesColumns.AUDIENCESCORE, value);
        return this;
    }

    public MoviesSelection audiencescoreLtEq(int value) {
        addLessThanOrEquals(MoviesColumns.AUDIENCESCORE, value);
        return this;
    }

    public MoviesSelection orderByAudiencescore(boolean desc) {
        orderBy(MoviesColumns.AUDIENCESCORE, desc);
        return this;
    }

    public MoviesSelection orderByAudiencescore() {
        orderBy(MoviesColumns.AUDIENCESCORE, false);
        return this;
    }

    public MoviesSelection consensus(String... value) {
        addEquals(MoviesColumns.CONSENSUS, value);
        return this;
    }

    public MoviesSelection consensusNot(String... value) {
        addNotEquals(MoviesColumns.CONSENSUS, value);
        return this;
    }

    public MoviesSelection consensusLike(String... value) {
        addLike(MoviesColumns.CONSENSUS, value);
        return this;
    }

    public MoviesSelection consensusContains(String... value) {
        addContains(MoviesColumns.CONSENSUS, value);
        return this;
    }

    public MoviesSelection consensusStartsWith(String... value) {
        addStartsWith(MoviesColumns.CONSENSUS, value);
        return this;
    }

    public MoviesSelection consensusEndsWith(String... value) {
        addEndsWith(MoviesColumns.CONSENSUS, value);
        return this;
    }

    public MoviesSelection orderByConsensus(boolean desc) {
        orderBy(MoviesColumns.CONSENSUS, desc);
        return this;
    }

    public MoviesSelection orderByConsensus() {
        orderBy(MoviesColumns.CONSENSUS, false);
        return this;
    }

    public MoviesSelection synopsis(String... value) {
        addEquals(MoviesColumns.SYNOPSIS, value);
        return this;
    }

    public MoviesSelection synopsisNot(String... value) {
        addNotEquals(MoviesColumns.SYNOPSIS, value);
        return this;
    }

    public MoviesSelection synopsisLike(String... value) {
        addLike(MoviesColumns.SYNOPSIS, value);
        return this;
    }

    public MoviesSelection synopsisContains(String... value) {
        addContains(MoviesColumns.SYNOPSIS, value);
        return this;
    }

    public MoviesSelection synopsisStartsWith(String... value) {
        addStartsWith(MoviesColumns.SYNOPSIS, value);
        return this;
    }

    public MoviesSelection synopsisEndsWith(String... value) {
        addEndsWith(MoviesColumns.SYNOPSIS, value);
        return this;
    }

    public MoviesSelection orderBySynopsis(boolean desc) {
        orderBy(MoviesColumns.SYNOPSIS, desc);
        return this;
    }

    public MoviesSelection orderBySynopsis() {
        orderBy(MoviesColumns.SYNOPSIS, false);
        return this;
    }

    public MoviesSelection releasedate(String... value) {
        addEquals(MoviesColumns.RELEASEDATE, value);
        return this;
    }

    public MoviesSelection releasedateNot(String... value) {
        addNotEquals(MoviesColumns.RELEASEDATE, value);
        return this;
    }

    public MoviesSelection releasedateLike(String... value) {
        addLike(MoviesColumns.RELEASEDATE, value);
        return this;
    }

    public MoviesSelection releasedateContains(String... value) {
        addContains(MoviesColumns.RELEASEDATE, value);
        return this;
    }

    public MoviesSelection releasedateStartsWith(String... value) {
        addStartsWith(MoviesColumns.RELEASEDATE, value);
        return this;
    }

    public MoviesSelection releasedateEndsWith(String... value) {
        addEndsWith(MoviesColumns.RELEASEDATE, value);
        return this;
    }

    public MoviesSelection orderByReleasedate(boolean desc) {
        orderBy(MoviesColumns.RELEASEDATE, desc);
        return this;
    }

    public MoviesSelection orderByReleasedate() {
        orderBy(MoviesColumns.RELEASEDATE, false);
        return this;
    }

    public MoviesSelection posterurl(String... value) {
        addEquals(MoviesColumns.POSTERURL, value);
        return this;
    }

    public MoviesSelection posterurlNot(String... value) {
        addNotEquals(MoviesColumns.POSTERURL, value);
        return this;
    }

    public MoviesSelection posterurlLike(String... value) {
        addLike(MoviesColumns.POSTERURL, value);
        return this;
    }

    public MoviesSelection posterurlContains(String... value) {
        addContains(MoviesColumns.POSTERURL, value);
        return this;
    }

    public MoviesSelection posterurlStartsWith(String... value) {
        addStartsWith(MoviesColumns.POSTERURL, value);
        return this;
    }

    public MoviesSelection posterurlEndsWith(String... value) {
        addEndsWith(MoviesColumns.POSTERURL, value);
        return this;
    }

    public MoviesSelection orderByPosterurl(boolean desc) {
        orderBy(MoviesColumns.POSTERURL, desc);
        return this;
    }

    public MoviesSelection orderByPosterurl() {
        orderBy(MoviesColumns.POSTERURL, false);
        return this;
    }

    public MoviesSelection synctime(Date... value) {
        addEquals(MoviesColumns.SYNCTIME, value);
        return this;
    }

    public MoviesSelection synctimeNot(Date... value) {
        addNotEquals(MoviesColumns.SYNCTIME, value);
        return this;
    }

    public MoviesSelection synctime(Long... value) {
        addEquals(MoviesColumns.SYNCTIME, value);
        return this;
    }

    public MoviesSelection synctimeAfter(Date value) {
        addGreaterThan(MoviesColumns.SYNCTIME, value);
        return this;
    }

    public MoviesSelection synctimeAfterEq(Date value) {
        addGreaterThanOrEquals(MoviesColumns.SYNCTIME, value);
        return this;
    }

    public MoviesSelection synctimeBefore(Date value) {
        addLessThan(MoviesColumns.SYNCTIME, value);
        return this;
    }

    public MoviesSelection synctimeBeforeEq(Date value) {
        addLessThanOrEquals(MoviesColumns.SYNCTIME, value);
        return this;
    }

    public MoviesSelection orderBySynctime(boolean desc) {
        orderBy(MoviesColumns.SYNCTIME, desc);
        return this;
    }

    public MoviesSelection orderBySynctime() {
        orderBy(MoviesColumns.SYNCTIME, false);
        return this;
    }
}
