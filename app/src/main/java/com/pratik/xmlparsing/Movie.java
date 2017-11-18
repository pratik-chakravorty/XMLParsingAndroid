package com.pratik.xmlparsing;

import java.io.Serializable;

/**
 * Created by Pratik on 11/14/2017.
 */

public class Movie implements Serializable {
    String movieName;
    String movieInfo;

    public Movie(String movieName, String movieInfo) {
        this.movieName = movieName;
        this.movieInfo = movieInfo;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieInfo() {
        return movieInfo;
    }
}
