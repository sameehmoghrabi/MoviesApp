package sameeh.com.moviesapp.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import sameeh.com.moviesapp.Models.MovieInfo;
import sameeh.com.moviesapp.Models.MoviesListInfo;

/**
 * Created by samee on 3/12/2018.
 */

public interface MoviesApi {
    @GET(".")
    Call<MoviesListInfo> getMoviesByTitle(@Query("s") String title);

    @GET(".")
    Call<MovieInfo> getMovieByID(@Query("i") String movieID);


}
