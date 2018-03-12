package sameeh.com.moviesapp.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by samee on 3/12/2018.
 */

public class MoviesListInfo implements Serializable{

    @SerializedName("Search")
    private List<MovieItem> moviesItems;

    @SerializedName("Response")
    private String apiResponse;

    @SerializedName("Error")
    private String apiError;

    @SerializedName("totalResults")
    private String totalResults;

    public MoviesListInfo(List<MovieItem> moviesItems, String apiResponse, String apiError, String totalResults) {
        this.moviesItems = moviesItems;
        this.apiResponse = apiResponse;
        this.apiError = apiError;
        this.totalResults = totalResults;
    }

    public List<MovieItem> getMoviesItems() {
        return moviesItems;
    }

    public String getApiResponse() {
        return apiResponse;
    }

    public String getApiError() {
        return apiError;
    }

    public String getTotalResults(){
        return totalResults;
    }
}
