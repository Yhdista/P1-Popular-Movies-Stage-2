package com.yhdista.nanodegree.p2.provider.movie;

import android.database.Cursor;

import com.yhdista.nanodegree.p2.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code movie} table.
 */
public class MovieCursor extends AbstractCursor implements MovieModel {
    public MovieCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(MovieColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Movie identification in themovie.org
     */
    public long getMovieOrgId() {
        Long res = getLongOrNull(MovieColumns.MOVIE_ORG_ID);
        if (res == null)
            throw new NullPointerException("The value of 'movie_org_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Adult movie
     */
    public boolean getAdult() {
        Boolean res = getBooleanOrNull(MovieColumns.ADULT);
        if (res == null)
            throw new NullPointerException("The value of 'adult' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Backdrop path
     * Cannot be {@code null}.
     */
    public String getBackdropPath() {
        String res = getStringOrNull(MovieColumns.BACKDROP_PATH);
        if (res == null)
            throw new NullPointerException("The value of 'backdrop_path' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Genre ids
     * Cannot be {@code null}.
     */
    public String getGenreIds() {
        String res = getStringOrNull(MovieColumns.GENRE_IDS);
        if (res == null)
            throw new NullPointerException("The value of 'genre_ids' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Original language
     * Cannot be {@code null}.
     */
    public String getOriginalLanguage() {
        String res = getStringOrNull(MovieColumns.ORIGINAL_LANGUAGE);
        if (res == null)
            throw new NullPointerException("The value of 'original_language' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Original title
     * Cannot be {@code null}.
     */
    public String getOriginalTitle() {
        String res = getStringOrNull(MovieColumns.ORIGINAL_TITLE);
        if (res == null)
            throw new NullPointerException("The value of 'original_title' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Movie identification in themovie.org
     * Cannot be {@code null}.
     */
    public String getOverview() {
        String res = getStringOrNull(MovieColumns.OVERVIEW);
        if (res == null)
            throw new NullPointerException("The value of 'overview' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Release date
     */
    public long getReleaseDate() {
        Long res = getLongOrNull(MovieColumns.RELEASE_DATE);
        if (res == null)
            throw new NullPointerException("The value of 'release_date' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Poster path
     * Cannot be {@code null}.
     */
    public String getPosterPath() {
        String res = getStringOrNull(MovieColumns.POSTER_PATH);
        if (res == null)
            throw new NullPointerException("The value of 'poster_path' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Popularity
     */
    public double getPopularity() {
        Double res = getDoubleOrNull(MovieColumns.POPULARITY);
        if (res == null)
            throw new NullPointerException("The value of 'popularity' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Title
     * Cannot be {@code null}.
     */
    public String getTitle() {
        String res = getStringOrNull(MovieColumns.TITLE);
        if (res == null)
            throw new NullPointerException("The value of 'title' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Video
     */
    public boolean getVideo() {
        Boolean res = getBooleanOrNull(MovieColumns.VIDEO);
        if (res == null)
            throw new NullPointerException("The value of 'video' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Vote average, rating
     */
    public double getVoteAverage() {
        Double res = getDoubleOrNull(MovieColumns.VOTE_AVERAGE);
        if (res == null)
            throw new NullPointerException("The value of 'vote_average' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Number of votes
     */
    public int getVoteCount() {
        Integer res = getIntegerOrNull(MovieColumns.VOTE_COUNT);
        if (res == null)
            throw new NullPointerException("The value of 'vote_count' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Is favorite in local database
     */
    public boolean getIsFavorite() {
        Boolean res = getBooleanOrNull(MovieColumns.IS_FAVORITE);
        if (res == null)
            throw new NullPointerException("The value of 'is_favorite' in the database was null, which is not allowed according to the model definition");
        return res;
    }
}
