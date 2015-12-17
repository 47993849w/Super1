package com.example.tomecabello.super1.provider.movies;

import com.example.tomecabello.super1.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Data model for the {@code movies} table.
 */
public interface MoviesModel extends BaseModel {

    /**
     * Get the {@code title} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTitle();

    /**
     * Get the {@code criticsscore} value.
     * Can be {@code null}.
     */
    @Nullable
    Double getCriticsscore();

    /**
     * Get the {@code audiencescore} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getAudiencescore();

    /**
     * Get the {@code consensus} value.
     * Can be {@code null}.
     */
    @Nullable
    String getConsensus();

    /**
     * Get the {@code synopsis} value.
     * Can be {@code null}.
     */
    @Nullable
    String getSynopsis();

    /**
     * Get the {@code releasedate} value.
     * Can be {@code null}.
     */
    @Nullable
    String getReleasedate();

    /**
     * Get the {@code posterurl} value.
     * Can be {@code null}.
     */
    @Nullable
    String getPosterurl();

    /**
     * Get the {@code synctime} value.
     * Can be {@code null}.
     */
    @Nullable
    Date getSynctime();
}
