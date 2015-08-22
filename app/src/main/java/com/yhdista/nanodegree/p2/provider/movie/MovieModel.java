package com.yhdista.nanodegree.p2.provider.movie;

import com.yhdista.nanodegree.p2.provider.base.BaseModel;

import java.util.Date;

/**
 * A human being which is part of a team.
 */
public interface MovieModel extends BaseModel {

    /**
     * Movie identification in themovie.org
     */
    long getMovieId();

    /**
     * Adult movie
     */
    boolean getAdult();

    /**
     * Backdrop path
     * Cannot be {@code null}.
     */
    String getBackdropPath();

    /**
     * Genre ids
     * Cannot be {@code null}.
     */
    String getGenreIds();

    /**
     * Original language
     * Cannot be {@code null}.
     */
    String getOriginalLanguage();

    /**
     * Original title
     * Cannot be {@code null}.
     */
    String getOriginalTitle();

    /**
     * Movie identification in themovie.org
     * Cannot be {@code null}.
     */
    String getOverview();

    /**
     * Release date
     */
    long getReleaseDate();

    /**
     * Poster path
     * Cannot be {@code null}.
     */
    String getPosterPath();

    /**
     * Popularity
     */
    double getPopularity();

    /**
     * Title
     * Cannot be {@code null}.
     */
    String getTitle();

    /**
     * Video
     */
    boolean getVideo();

    /**
     * Vote average, rating
     */
    double getVoteAverage();

    /**
     * Number of votes
     */
    int getVoteCount();
}
