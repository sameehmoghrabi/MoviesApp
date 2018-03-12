package sameeh.com.moviesapp.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by samee on 3/12/2018.
 */

public class MovieInfo implements Serializable {

    @SerializedName("Title")
    private String movieTitle;
    @SerializedName("Year")
    private String movieYear;
    @SerializedName("imdbID")
    private String movieID;
    @SerializedName("Type")
    private String movieType;
    @SerializedName("Poster")
    private String moviePosterUrl;

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public String getMovieID() {
        return movieID;
    }

    public String getMovieType() {
        return movieType;
    }

    public String getMoviePosterUrl() {
        return moviePosterUrl;
    }
}
