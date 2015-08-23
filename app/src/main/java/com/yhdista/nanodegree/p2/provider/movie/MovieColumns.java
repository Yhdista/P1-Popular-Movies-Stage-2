package com.yhdista.nanodegree.p2.provider.movie;

import android.net.Uri;
import android.provider.BaseColumns;

import com.yhdista.nanodegree.p2.provider.MovieProvider;

/**
 * A human being which is part of a team.
 */
public class MovieColumns implements BaseColumns {
    public static final String TABLE_NAME = "movie";
    public static final Uri CONTENT_URI = Uri.parse(MovieProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * Movie identification in themovie.org
     */
    public static final String MOVIE_ORG_ID = "movie_org_id";

    /**
     * Adult movie
     */
    public static final String ADULT = "adult";

    /**
     * Backdrop path
     */
    public static final String BACKDROP_PATH = "backdrop_path";

    /**
     * Genre ids
     */
    public static final String GENRE_IDS = "genre_ids";

    /**
     * Original language
     */
    public static final String ORIGINAL_LANGUAGE = "original_language";

    /**
     * Original title
     */
    public static final String ORIGINAL_TITLE = "original_title";

    /**
     * Movie identification in themovie.org
     */
    public static final String OVERVIEW = "overview";

    /**
     * Release date
     */
    public static final String RELEASE_DATE = "release_date";

    /**
     * Poster path
     */
    public static final String POSTER_PATH = "poster_path";

    /**
     * Popularity
     */
    public static final String POPULARITY = "popularity";

    /**
     * Title
     */
    public static final String TITLE = "title";

    /**
     * Video
     */
    public static final String VIDEO = "video";

    /**
     * Vote average, rating
     */
    public static final String VOTE_AVERAGE = "vote_average";

    /**
     * Number of votes
     */
    public static final String VOTE_COUNT = "vote_count";

    /**
     * Is favorite in local database
     */
    public static final String IS_FAVORITE = "is_favorite";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            MOVIE_ORG_ID,
            ADULT,
            BACKDROP_PATH,
            GENRE_IDS,
            ORIGINAL_LANGUAGE,
            ORIGINAL_TITLE,
            OVERVIEW,
            RELEASE_DATE,
            POSTER_PATH,
            POPULARITY,
            TITLE,
            VIDEO,
            VOTE_AVERAGE,
            VOTE_COUNT,
            IS_FAVORITE
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(MOVIE_ORG_ID) || c.contains("." + MOVIE_ORG_ID)) return true;
            if (c.equals(ADULT) || c.contains("." + ADULT)) return true;
            if (c.equals(BACKDROP_PATH) || c.contains("." + BACKDROP_PATH)) return true;
            if (c.equals(GENRE_IDS) || c.contains("." + GENRE_IDS)) return true;
            if (c.equals(ORIGINAL_LANGUAGE) || c.contains("." + ORIGINAL_LANGUAGE)) return true;
            if (c.equals(ORIGINAL_TITLE) || c.contains("." + ORIGINAL_TITLE)) return true;
            if (c.equals(OVERVIEW) || c.contains("." + OVERVIEW)) return true;
            if (c.equals(RELEASE_DATE) || c.contains("." + RELEASE_DATE)) return true;
            if (c.equals(POSTER_PATH) || c.contains("." + POSTER_PATH)) return true;
            if (c.equals(POPULARITY) || c.contains("." + POPULARITY)) return true;
            if (c.equals(TITLE) || c.contains("." + TITLE)) return true;
            if (c.equals(VIDEO) || c.contains("." + VIDEO)) return true;
            if (c.equals(VOTE_AVERAGE) || c.contains("." + VOTE_AVERAGE)) return true;
            if (c.equals(VOTE_COUNT) || c.contains("." + VOTE_COUNT)) return true;
            if (c.equals(IS_FAVORITE) || c.contains("." + IS_FAVORITE)) return true;
        }
        return false;
    }

}
