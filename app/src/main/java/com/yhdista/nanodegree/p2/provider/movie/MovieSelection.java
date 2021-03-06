package com.yhdista.nanodegree.p2.provider.movie;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.yhdista.nanodegree.p2.provider.base.AbstractSelection;

/**
 * Selection for the {@code movie} table.
 */
public class MovieSelection extends AbstractSelection<MovieSelection> {
    @Override
    protected Uri baseUri() {
        return MovieColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MovieCursor} object, which is positioned before the first entry, or null.
     */
    public MovieCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MovieCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public MovieCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MovieCursor} object, which is positioned before the first entry, or null.
     */
    public MovieCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MovieCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public MovieCursor query(Context context) {
        return query(context, null);
    }


    public MovieSelection id(long... value) {
        addEquals("movie." + MovieColumns._ID, toObjectArray(value));
        return this;
    }

    public MovieSelection idNot(long... value) {
        addNotEquals("movie." + MovieColumns._ID, toObjectArray(value));
        return this;
    }

    public MovieSelection orderById(boolean desc) {
        orderBy("movie." + MovieColumns._ID, desc);
        return this;
    }

    public MovieSelection orderById() {
        return orderById(false);
    }

    public MovieSelection movieOrgId(long... value) {
        addEquals(MovieColumns.MOVIE_ORG_ID, toObjectArray(value));
        return this;
    }

    public MovieSelection movieOrgIdNot(long... value) {
        addNotEquals(MovieColumns.MOVIE_ORG_ID, toObjectArray(value));
        return this;
    }

    public MovieSelection movieOrgIdGt(long value) {
        addGreaterThan(MovieColumns.MOVIE_ORG_ID, value);
        return this;
    }

    public MovieSelection movieOrgIdGtEq(long value) {
        addGreaterThanOrEquals(MovieColumns.MOVIE_ORG_ID, value);
        return this;
    }

    public MovieSelection movieOrgIdLt(long value) {
        addLessThan(MovieColumns.MOVIE_ORG_ID, value);
        return this;
    }

    public MovieSelection movieOrgIdLtEq(long value) {
        addLessThanOrEquals(MovieColumns.MOVIE_ORG_ID, value);
        return this;
    }

    public MovieSelection orderByMovieOrgId(boolean desc) {
        orderBy(MovieColumns.MOVIE_ORG_ID, desc);
        return this;
    }

    public MovieSelection orderByMovieOrgId() {
        orderBy(MovieColumns.MOVIE_ORG_ID, false);
        return this;
    }

    public MovieSelection adult(boolean value) {
        addEquals(MovieColumns.ADULT, toObjectArray(value));
        return this;
    }

    public MovieSelection orderByAdult(boolean desc) {
        orderBy(MovieColumns.ADULT, desc);
        return this;
    }

    public MovieSelection orderByAdult() {
        orderBy(MovieColumns.ADULT, false);
        return this;
    }

    public MovieSelection backdropPath(String... value) {
        addEquals(MovieColumns.BACKDROP_PATH, value);
        return this;
    }

    public MovieSelection backdropPathNot(String... value) {
        addNotEquals(MovieColumns.BACKDROP_PATH, value);
        return this;
    }

    public MovieSelection backdropPathLike(String... value) {
        addLike(MovieColumns.BACKDROP_PATH, value);
        return this;
    }

    public MovieSelection backdropPathContains(String... value) {
        addContains(MovieColumns.BACKDROP_PATH, value);
        return this;
    }

    public MovieSelection backdropPathStartsWith(String... value) {
        addStartsWith(MovieColumns.BACKDROP_PATH, value);
        return this;
    }

    public MovieSelection backdropPathEndsWith(String... value) {
        addEndsWith(MovieColumns.BACKDROP_PATH, value);
        return this;
    }

    public MovieSelection orderByBackdropPath(boolean desc) {
        orderBy(MovieColumns.BACKDROP_PATH, desc);
        return this;
    }

    public MovieSelection orderByBackdropPath() {
        orderBy(MovieColumns.BACKDROP_PATH, false);
        return this;
    }

    public MovieSelection genreIds(String... value) {
        addEquals(MovieColumns.GENRE_IDS, value);
        return this;
    }

    public MovieSelection genreIdsNot(String... value) {
        addNotEquals(MovieColumns.GENRE_IDS, value);
        return this;
    }

    public MovieSelection genreIdsLike(String... value) {
        addLike(MovieColumns.GENRE_IDS, value);
        return this;
    }

    public MovieSelection genreIdsContains(String... value) {
        addContains(MovieColumns.GENRE_IDS, value);
        return this;
    }

    public MovieSelection genreIdsStartsWith(String... value) {
        addStartsWith(MovieColumns.GENRE_IDS, value);
        return this;
    }

    public MovieSelection genreIdsEndsWith(String... value) {
        addEndsWith(MovieColumns.GENRE_IDS, value);
        return this;
    }

    public MovieSelection orderByGenreIds(boolean desc) {
        orderBy(MovieColumns.GENRE_IDS, desc);
        return this;
    }

    public MovieSelection orderByGenreIds() {
        orderBy(MovieColumns.GENRE_IDS, false);
        return this;
    }

    public MovieSelection originalLanguage(String... value) {
        addEquals(MovieColumns.ORIGINAL_LANGUAGE, value);
        return this;
    }

    public MovieSelection originalLanguageNot(String... value) {
        addNotEquals(MovieColumns.ORIGINAL_LANGUAGE, value);
        return this;
    }

    public MovieSelection originalLanguageLike(String... value) {
        addLike(MovieColumns.ORIGINAL_LANGUAGE, value);
        return this;
    }

    public MovieSelection originalLanguageContains(String... value) {
        addContains(MovieColumns.ORIGINAL_LANGUAGE, value);
        return this;
    }

    public MovieSelection originalLanguageStartsWith(String... value) {
        addStartsWith(MovieColumns.ORIGINAL_LANGUAGE, value);
        return this;
    }

    public MovieSelection originalLanguageEndsWith(String... value) {
        addEndsWith(MovieColumns.ORIGINAL_LANGUAGE, value);
        return this;
    }

    public MovieSelection orderByOriginalLanguage(boolean desc) {
        orderBy(MovieColumns.ORIGINAL_LANGUAGE, desc);
        return this;
    }

    public MovieSelection orderByOriginalLanguage() {
        orderBy(MovieColumns.ORIGINAL_LANGUAGE, false);
        return this;
    }

    public MovieSelection originalTitle(String... value) {
        addEquals(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieSelection originalTitleNot(String... value) {
        addNotEquals(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieSelection originalTitleLike(String... value) {
        addLike(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieSelection originalTitleContains(String... value) {
        addContains(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieSelection originalTitleStartsWith(String... value) {
        addStartsWith(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieSelection originalTitleEndsWith(String... value) {
        addEndsWith(MovieColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public MovieSelection orderByOriginalTitle(boolean desc) {
        orderBy(MovieColumns.ORIGINAL_TITLE, desc);
        return this;
    }

    public MovieSelection orderByOriginalTitle() {
        orderBy(MovieColumns.ORIGINAL_TITLE, false);
        return this;
    }

    public MovieSelection overview(String... value) {
        addEquals(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieSelection overviewNot(String... value) {
        addNotEquals(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieSelection overviewLike(String... value) {
        addLike(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieSelection overviewContains(String... value) {
        addContains(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieSelection overviewStartsWith(String... value) {
        addStartsWith(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieSelection overviewEndsWith(String... value) {
        addEndsWith(MovieColumns.OVERVIEW, value);
        return this;
    }

    public MovieSelection orderByOverview(boolean desc) {
        orderBy(MovieColumns.OVERVIEW, desc);
        return this;
    }

    public MovieSelection orderByOverview() {
        orderBy(MovieColumns.OVERVIEW, false);
        return this;
    }

    public MovieSelection releaseDate(long... value) {
        addEquals(MovieColumns.RELEASE_DATE, toObjectArray(value));
        return this;
    }

    public MovieSelection releaseDateNot(long... value) {
        addNotEquals(MovieColumns.RELEASE_DATE, toObjectArray(value));
        return this;
    }

    public MovieSelection releaseDateGt(long value) {
        addGreaterThan(MovieColumns.RELEASE_DATE, value);
        return this;
    }

    public MovieSelection releaseDateGtEq(long value) {
        addGreaterThanOrEquals(MovieColumns.RELEASE_DATE, value);
        return this;
    }

    public MovieSelection releaseDateLt(long value) {
        addLessThan(MovieColumns.RELEASE_DATE, value);
        return this;
    }

    public MovieSelection releaseDateLtEq(long value) {
        addLessThanOrEquals(MovieColumns.RELEASE_DATE, value);
        return this;
    }

    public MovieSelection orderByReleaseDate(boolean desc) {
        orderBy(MovieColumns.RELEASE_DATE, desc);
        return this;
    }

    public MovieSelection orderByReleaseDate() {
        orderBy(MovieColumns.RELEASE_DATE, false);
        return this;
    }

    public MovieSelection posterPath(String... value) {
        addEquals(MovieColumns.POSTER_PATH, value);
        return this;
    }

    public MovieSelection posterPathNot(String... value) {
        addNotEquals(MovieColumns.POSTER_PATH, value);
        return this;
    }

    public MovieSelection posterPathLike(String... value) {
        addLike(MovieColumns.POSTER_PATH, value);
        return this;
    }

    public MovieSelection posterPathContains(String... value) {
        addContains(MovieColumns.POSTER_PATH, value);
        return this;
    }

    public MovieSelection posterPathStartsWith(String... value) {
        addStartsWith(MovieColumns.POSTER_PATH, value);
        return this;
    }

    public MovieSelection posterPathEndsWith(String... value) {
        addEndsWith(MovieColumns.POSTER_PATH, value);
        return this;
    }

    public MovieSelection orderByPosterPath(boolean desc) {
        orderBy(MovieColumns.POSTER_PATH, desc);
        return this;
    }

    public MovieSelection orderByPosterPath() {
        orderBy(MovieColumns.POSTER_PATH, false);
        return this;
    }

    public MovieSelection popularity(double... value) {
        addEquals(MovieColumns.POPULARITY, toObjectArray(value));
        return this;
    }

    public MovieSelection popularityNot(double... value) {
        addNotEquals(MovieColumns.POPULARITY, toObjectArray(value));
        return this;
    }

    public MovieSelection popularityGt(double value) {
        addGreaterThan(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieSelection popularityGtEq(double value) {
        addGreaterThanOrEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieSelection popularityLt(double value) {
        addLessThan(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieSelection popularityLtEq(double value) {
        addLessThanOrEquals(MovieColumns.POPULARITY, value);
        return this;
    }

    public MovieSelection orderByPopularity(boolean desc) {
        orderBy(MovieColumns.POPULARITY, desc);
        return this;
    }

    public MovieSelection orderByPopularity() {
        orderBy(MovieColumns.POPULARITY, false);
        return this;
    }

    public MovieSelection title(String... value) {
        addEquals(MovieColumns.TITLE, value);
        return this;
    }

    public MovieSelection titleNot(String... value) {
        addNotEquals(MovieColumns.TITLE, value);
        return this;
    }

    public MovieSelection titleLike(String... value) {
        addLike(MovieColumns.TITLE, value);
        return this;
    }

    public MovieSelection titleContains(String... value) {
        addContains(MovieColumns.TITLE, value);
        return this;
    }

    public MovieSelection titleStartsWith(String... value) {
        addStartsWith(MovieColumns.TITLE, value);
        return this;
    }

    public MovieSelection titleEndsWith(String... value) {
        addEndsWith(MovieColumns.TITLE, value);
        return this;
    }

    public MovieSelection orderByTitle(boolean desc) {
        orderBy(MovieColumns.TITLE, desc);
        return this;
    }

    public MovieSelection orderByTitle() {
        orderBy(MovieColumns.TITLE, false);
        return this;
    }

    public MovieSelection video(boolean value) {
        addEquals(MovieColumns.VIDEO, toObjectArray(value));
        return this;
    }

    public MovieSelection orderByVideo(boolean desc) {
        orderBy(MovieColumns.VIDEO, desc);
        return this;
    }

    public MovieSelection orderByVideo() {
        orderBy(MovieColumns.VIDEO, false);
        return this;
    }

    public MovieSelection voteAverage(double... value) {
        addEquals(MovieColumns.VOTE_AVERAGE, toObjectArray(value));
        return this;
    }

    public MovieSelection voteAverageNot(double... value) {
        addNotEquals(MovieColumns.VOTE_AVERAGE, toObjectArray(value));
        return this;
    }

    public MovieSelection voteAverageGt(double value) {
        addGreaterThan(MovieColumns.VOTE_AVERAGE, value);
        return this;
    }

    public MovieSelection voteAverageGtEq(double value) {
        addGreaterThanOrEquals(MovieColumns.VOTE_AVERAGE, value);
        return this;
    }

    public MovieSelection voteAverageLt(double value) {
        addLessThan(MovieColumns.VOTE_AVERAGE, value);
        return this;
    }

    public MovieSelection voteAverageLtEq(double value) {
        addLessThanOrEquals(MovieColumns.VOTE_AVERAGE, value);
        return this;
    }

    public MovieSelection orderByVoteAverage(boolean desc) {
        orderBy(MovieColumns.VOTE_AVERAGE, desc);
        return this;
    }

    public MovieSelection orderByVoteAverage() {
        orderBy(MovieColumns.VOTE_AVERAGE, false);
        return this;
    }

    public MovieSelection voteCount(int... value) {
        addEquals(MovieColumns.VOTE_COUNT, toObjectArray(value));
        return this;
    }

    public MovieSelection voteCountNot(int... value) {
        addNotEquals(MovieColumns.VOTE_COUNT, toObjectArray(value));
        return this;
    }

    public MovieSelection voteCountGt(int value) {
        addGreaterThan(MovieColumns.VOTE_COUNT, value);
        return this;
    }

    public MovieSelection voteCountGtEq(int value) {
        addGreaterThanOrEquals(MovieColumns.VOTE_COUNT, value);
        return this;
    }

    public MovieSelection voteCountLt(int value) {
        addLessThan(MovieColumns.VOTE_COUNT, value);
        return this;
    }

    public MovieSelection voteCountLtEq(int value) {
        addLessThanOrEquals(MovieColumns.VOTE_COUNT, value);
        return this;
    }

    public MovieSelection orderByVoteCount(boolean desc) {
        orderBy(MovieColumns.VOTE_COUNT, desc);
        return this;
    }

    public MovieSelection orderByVoteCount() {
        orderBy(MovieColumns.VOTE_COUNT, false);
        return this;
    }

    public MovieSelection isFavorite(boolean value) {
        addEquals(MovieColumns.IS_FAVORITE, toObjectArray(value));
        return this;
    }

    public MovieSelection orderByIsFavorite(boolean desc) {
        orderBy(MovieColumns.IS_FAVORITE, desc);
        return this;
    }

    public MovieSelection orderByIsFavorite() {
        orderBy(MovieColumns.IS_FAVORITE, false);
        return this;
    }
}
