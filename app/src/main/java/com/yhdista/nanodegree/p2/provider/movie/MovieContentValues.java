package com.yhdista.nanodegree.p2.provider.movie;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;

import com.yhdista.nanodegree.p2.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code movie} table.
 */
public class MovieContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return MovieColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver,  MovieSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context,  MovieSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Movie identification in themovie.org
     */
    public MovieContentValues putMovieId(long value) {
        mContentValues.put(MovieColumns.MOVIE_ID, value);
        return this;
    }


    /**
     * Adult movie
     */
    public MovieContentValues putAdult(boolean value) {
        mContentValues.put(MovieColumns.ADULT, value);
        return this;
    }


    /**
     * Backdrop path
     */
    public MovieContentValues putBackdropPath(String value) {
        if (value == null) throw new IllegalArgumentException("backdropPath must not be null");
        mContentValues.put(MovieColumns.BACKDROP_PATH, value);
        return this;
    }


    /**
     * Genre ids
     */
    public MovieContentValues putGenreIds(String value) {
        if (value == null) throw new IllegalArgumentException("genreIds must not be null");
        mContentValues.put(MovieColumns.GENRE_IDS, value);
        return this;
    }


    /**
     * Original language
     */
    public MovieContentValues putOriginalLanguage(String value) {
        if (value == null) throw new IllegalArgumentException("originalLanguage must not be null");
        mContentValues.put(MovieColumns.ORIGINAL_LANGUAGE, value);
        return this;
    }


    /**
     * Original title
     */
    public MovieContentValues putOriginalTitle(String value) {
        if (value == null) throw new IllegalArgumentException("originalTitle must not be null");
        mContentValues.put(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }


    /**
     * Movie identification in themovie.org
     */
    public MovieContentValues putOverview(String value) {
        if (value == null) throw new IllegalArgumentException("overview must not be null");
        mContentValues.put(MovieColumns.OVERVIEW, value);
        return this;
    }


    /**
     * Release date
     */
    public MovieContentValues putReleaseDate(long value) {
        mContentValues.put(MovieColumns.RELEASE_DATE, value);
        return this;
    }


    /**
     * Poster path
     */
    public MovieContentValues putPosterPath(String value) {
        if (value == null) throw new IllegalArgumentException("posterPath must not be null");
        mContentValues.put(MovieColumns.POSTER_PATH, value);
        return this;
    }


    /**
     * Popularity
     */
    public MovieContentValues putPopularity(double value) {
        mContentValues.put(MovieColumns.POPULARITY, value);
        return this;
    }


    /**
     * Title
     */
    public MovieContentValues putTitle(String value) {
        if (value == null) throw new IllegalArgumentException("title must not be null");
        mContentValues.put(MovieColumns.TITLE, value);
        return this;
    }


    /**
     * Video
     */
    public MovieContentValues putVideo(boolean value) {
        mContentValues.put(MovieColumns.VIDEO, value);
        return this;
    }


    /**
     * Vote average, rating
     */
    public MovieContentValues putVoteAverage(double value) {
        mContentValues.put(MovieColumns.VOTE_AVERAGE, value);
        return this;
    }


    /**
     * Number of votes
     */
    public MovieContentValues putVoteCount(int value) {
        mContentValues.put(MovieColumns.VOTE_COUNT, value);
        return this;
    }

}
