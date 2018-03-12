package sameeh.com.moviesapp.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by samee on 3/12/2018.
 */

public class MovieItem implements Serializable{

    @SerializedName("Title")
    private String title;
    @SerializedName("Year")
    private String year;
    @SerializedName("imdbID")
    private String id;
    @SerializedName("Type")
    private String type;
    @SerializedName("Poster")
    private String posterURL;

    public MovieItem(String title, String year, String id, String type, String posterURL) {
        this.title = title;
        this.year = year;
        this.id = id;
        this.type = type;
        this.posterURL = posterURL;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getPosterURL() {
        return posterURL;
    }
}
