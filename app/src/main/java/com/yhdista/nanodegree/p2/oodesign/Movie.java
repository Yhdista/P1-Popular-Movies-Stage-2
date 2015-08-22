/*
 * Copyright (C) 2013 The Android Open Source Project
 */

package com.yhdista.nanodegree.p2.oodesign;

import android.os.Parcel;
import android.os.Parcelable;

import com.yhdista.nanodegree.p2.utils.UtilsDate;
import com.yhdista.nanodegree.p2.utils.UtilsMath;

import java.util.Date;

/**
 * Design of Movie element
 * Object is Parcelable because of Intent transaction
 */
public class Movie implements Parcelable {

    public static final String RELEASE_DATE_FORMAT = "yyyy-mm-dd";

    public static final String TAG_MOVIE_ID = "id";
    public static final String TAG_ADULT = "adult";
    public static final String TAG_BACKDROP_PATH = "backdrop_path";
    public static final String TAG_GENRE_IDS = "genre_ids";
    public static final String TAG_ORIGINAL_LANGUAGE = "original_language";
    public static final String TAG_ORIGINAL_TITLE = "original_title";
    public static final String TAG_OVERVIEW = "overview";
    public static final String TAG_RELEASE_DATE = "release_date";
    public static final String TAG_POSTER_PATH = "poster_path";
    public static final String TAG_POPULARITY = "popularity";
    public static final String TAG_TITLE = "title";
    public static final String TAG_VIDEO = "video";
    public static final String TAG_VOTE_AVERAGE = "vote_average";
    public static final String TAG_VOTE_COUNT = "vote_count";

    private long mMovieId;                   // id	:	102899
    private boolean mAdult;             // adult	:	false
    private String mBackdropPath;       // backdrop_path	:	/kvXLZqY0Ngl1XSw7EaMQO0C1CCj.jpg
    private String mGenreIds;
    // 0	:	28
    // 1	:	12
    // 2	:	878
    private String mOriginalLanguage;   // original_language	:	en
    private String mOriginalTitle;      // original_title	:	Ant-Man
    private String mOverview;           // overview	:	Armed with the astonishing ability to shrink in scale but increase in strength, con-man Scott Lang must embrace his inner-hero and help his mentor, Dr. Hank Pym, protect the secret behind his spectacular Ant-Man suit from a new generation of towering threats. Against seemingly insurmountable obstacles, Pym and Lang must plan and pull off a heist that will save the world.
    private Date mReleaseDate;          // release_date	:	2015-07-17
    private String mPosterPath;         // poster_path	:	/7SGGUiTE6oc2fh9MjIk5M00dsQd.jpg
    private double mPopularity;         // popularity	:	52.680889
    private String mTitle;              // title	:	Ant-Man
    private boolean mVideo;             // video	:	false
    private double mVoteAverage;        // vote_average	:	7.1
    private int mVoteCount;         // vote_count	:	826

    // Constructor is hidden
    private Movie() {
    }

    private Movie(Builder builder) {

        mMovieId = builder.mMovieId;
        mAdult = builder.mAdult;
        mBackdropPath = builder.mBackdropPath;
        mGenreIds = builder.mGenreIds;
        mOriginalLanguage = builder.mOriginalLanguage;
        mOriginalTitle = builder.mOriginalTitle;
        mOverview = builder.mOverview;
        mReleaseDate = builder.mReleaseDate;
        mPosterPath = builder.mPosterPath;
        mPopularity = builder.mPopularity;
        mTitle = builder.mTitle;
        mVideo = builder.mVideo;
        mVoteAverage = builder.mVoteAverage;
        mVoteCount = builder.mVoteCount;


    }


    protected Movie(Parcel in) {
        mMovieId = in.readLong();
        mAdult = UtilsMath.convertInteger2Boolean(in.readInt());
        mBackdropPath = in.readString();
        mGenreIds = in.readString();
        mOriginalLanguage = in.readString();
        mOriginalTitle = in.readString();
        mOverview = in.readString();
        mReleaseDate = UtilsDate.getDateFromMillis(in.readLong());
        mPosterPath = in.readString();
        mPopularity = in.readDouble();
        mTitle = in.readString();
        mVideo = UtilsMath.convertInteger2Boolean(in.readInt());
        mVoteAverage = in.readDouble();
        mVoteCount = in.readInt();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mMovieId);
        dest.writeInt(UtilsMath.convertBoolean2Integer(mAdult));
        dest.writeString(mBackdropPath);
        dest.writeString(mGenreIds);
        dest.writeString(mOriginalLanguage);
        dest.writeString(mOriginalTitle);
        dest.writeString(mOverview);
        dest.writeLong(UtilsDate.getMillisFromDate(mReleaseDate));
        dest.writeString(mPosterPath);
        dest.writeDouble(mPopularity);
        dest.writeString(mTitle);
        dest.writeInt(UtilsMath.convertBoolean2Integer(mVideo));
        dest.writeDouble(mVoteAverage);
        dest.writeInt(mVoteCount);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getTitle() {
        return mTitle;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public String getOverview() {
        return mOverview;
    }

    public double getUserRating() {
        return mVoteAverage;
    }

    private long getReleaseDateInMillis() {
        return UtilsDate.getMillisFromDate(mReleaseDate);
    }

    public int getReleaseYear() {
        return UtilsDate.getTimeAsYear(mReleaseDate);
    }

    public double getPopularity() {
        return mPopularity;
    }


    /**
     * Movie Builder pattern
     */
    public static class Builder {

        private long mMovieId;
        private boolean mAdult;
        private String mBackdropPath;
        private String mGenreIds;
        private String mOriginalLanguage;
        private String mOriginalTitle;
        private String mOverview;
        private Date mReleaseDate;
        private double mPopularity;
        private final String mTitle;
        private final String mPosterPath;
        public boolean mVideo;
        private double mVoteAverage;
        public int mVoteCount;


        /**
         * Builder pattern for creating Movie element
         *
         * @param title
         * @param path
         */
        public Builder(String title, String path) {
            mTitle = title;
            mPosterPath = path;
        }

        public Builder setMovieId(long id) {
            mMovieId = id;
            return this;
        }

        public Builder setAdult(boolean adult) {
            mAdult = adult;
            return this;
        }

        public Builder setBackdropPath(String backdropPath) {
            mBackdropPath = backdropPath;
            return this;
        }

        public Builder setGenreIds(String genreIds) {
            mGenreIds = genreIds;
            return this;
        }

        public Builder setOriginalLanguage(String originalLanguage) {
            mOriginalLanguage = originalLanguage;
            return this;
        }

        public Builder setOriginalTitle(String originalTitle) {
            mOriginalTitle = originalTitle;
            return this;
        }

        public Builder setOverview(String overview) {
            mOverview = overview;
            return this;
        }

        public Builder setVideo(boolean video) {
            mVideo = video;
            return this;
        }

        public Builder setReleaseDate(Date date) {
            mReleaseDate = date;
            return this;
        }

        public Builder setPopularity(double popularity) {
            mPopularity = popularity;
            return this;
        }

        public Builder setVoteAverage(double voteAverage) {
            mVoteAverage = voteAverage;
            return this;
        }

        public Builder setVoteCount(int count) {
            mVoteCount = count;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }

    }

}
