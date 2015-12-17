package com.example.tomecabello.super1.provider.movies;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.tomecabello.super1.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code movies} table.
 */
public class MoviesContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return MoviesColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable MoviesSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable MoviesSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public MoviesContentValues putTitle(@Nullable String value) {
        mContentValues.put(MoviesColumns.TITLE, value);
        return this;
    }

    public MoviesContentValues putTitleNull() {
        mContentValues.putNull(MoviesColumns.TITLE);
        return this;
    }

    public MoviesContentValues putCriticsscore(@Nullable Double value) {
        mContentValues.put(MoviesColumns.CRITICSSCORE, value);
        return this;
    }

    public MoviesContentValues putCriticsscoreNull() {
        mContentValues.putNull(MoviesColumns.CRITICSSCORE);
        return this;
    }

    public MoviesContentValues putAudiencescore(@Nullable Double value) {
        mContentValues.put(MoviesColumns.AUDIENCESCORE, value);
        return this;
    }

    public MoviesContentValues putAudiencescoreNull() {
        mContentValues.putNull(MoviesColumns.AUDIENCESCORE);
        return this;
    }

    public MoviesContentValues putConsensus(@Nullable String value) {
        mContentValues.put(MoviesColumns.CONSENSUS, value);
        return this;
    }

    public MoviesContentValues putConsensusNull() {
        mContentValues.putNull(MoviesColumns.CONSENSUS);
        return this;
    }

    public MoviesContentValues putSynopsis(@Nullable String value) {
        mContentValues.put(MoviesColumns.SYNOPSIS, value);
        return this;
    }

    public MoviesContentValues putSynopsisNull() {
        mContentValues.putNull(MoviesColumns.SYNOPSIS);
        return this;
    }

    public MoviesContentValues putReleasedate(@Nullable String value) {
        mContentValues.put(MoviesColumns.RELEASEDATE, value);
        return this;
    }

    public MoviesContentValues putReleasedateNull() {
        mContentValues.putNull(MoviesColumns.RELEASEDATE);
        return this;
    }

    public MoviesContentValues putPosterurl(@Nullable String value) {
        mContentValues.put(MoviesColumns.POSTERURL, value);
        return this;
    }

    public MoviesContentValues putPosterurlNull() {
        mContentValues.putNull(MoviesColumns.POSTERURL);
        return this;
    }

    public MoviesContentValues putSynctime(@Nullable Date value) {
        mContentValues.put(MoviesColumns.SYNCTIME, value == null ? null : value.getTime());
        return this;
    }

    public MoviesContentValues putSynctimeNull() {
        mContentValues.putNull(MoviesColumns.SYNCTIME);
        return this;
    }

    public MoviesContentValues putSynctime(@Nullable Long value) {
        mContentValues.put(MoviesColumns.SYNCTIME, value);
        return this;
    }
}
