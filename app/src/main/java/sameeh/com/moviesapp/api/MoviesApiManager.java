package sameeh.com.moviesapp.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sameeh.com.moviesapp.Models.MovieInfo;
import sameeh.com.moviesapp.Models.MoviesListInfo;

/**
 * Created by samee on 3/12/2018.
 */

public class MoviesApiManager {

    private OkHttpClient okHttpClient;
    private Retrofit retrofit;
    private MoviesApi moviesApi;

    private final String MOVIES_BASE_URL = "http://www.omdbapi.com/";

    public MoviesApiManager(){
        Gson gson = new GsonBuilder().create();
        okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new MoviesInterceptor())
                .build();
        retrofit = new Retrofit
                .Builder()
                .client(okHttpClient)
                .baseUrl(MOVIES_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        moviesApi = retrofit.create(MoviesApi.class);
    }

    public Call<MoviesListInfo> getMoviesByTitle(String title){
        return moviesApi.getMoviesByTitle(title);
    }

    public Call<MovieInfo> getMovieByID(String movieID){
        return moviesApi.getMovieByID(movieID);
    }

    private class MoviesInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            HttpUrl originalUrl = request.url();
            HttpUrl modifiedUrl = originalUrl
                    .newBuilder()
                    .addQueryParameter("apiKey", "6d5a9f31")
                    .build();
            Request modifiedRequest = request.newBuilder().url(modifiedUrl).build();
            return chain.proceed(modifiedRequest);
        }
    }
}
