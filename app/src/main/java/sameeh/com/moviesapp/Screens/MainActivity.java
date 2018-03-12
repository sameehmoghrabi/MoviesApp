package sameeh.com.moviesapp.Screens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sameeh.com.moviesapp.Models.MoviesListInfo;
import sameeh.com.moviesapp.R;
import sameeh.com.moviesapp.api.MoviesApiManager;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_CODE = 100;
    public static final String MOVIES_RESULT_KEY = "MOVIES_RESULT_KEY";
    private MoviesApiManager moviesApiManager;
    private EditText titleEditText;
    private ImageView searchImageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moviesApiManager = new MoviesApiManager();
        titleEditText = findViewById(R.id.movie_name);
        searchImageView = findViewById(R.id.search_button);
        progressBar = findViewById(R.id.progress_bar);
        searchImageView.setOnClickListener(e -> searchButtonListener());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_CANCELED) {
            Toast.makeText(getApplicationContext(), data.getStringExtra("ErrorMessage"), Toast.LENGTH_LONG).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void searchButtonListener() {
        showProgressBar();
        String movieTitle = titleEditText.getText().toString();
        if (!TextUtils.isEmpty(movieTitle)) {
            moviesApiManager.getMoviesByTitle(movieTitle).enqueue(new Callback<MoviesListInfo>() {
                @Override
                public void onResponse(Call<MoviesListInfo> call, Response<MoviesListInfo> response) {
                    if (response.isSuccessful()) {
                        MoviesListInfo body = response.body();
                        if (body.getApiResponse().equals("True")) {
                            Intent i = new Intent(getApplicationContext(), MoviesActivity.class);
                            i.putExtra(MOVIES_RESULT_KEY, body);
                            startActivityForResult(i, RESULT_OK);
                        } else
                            Toast.makeText(getApplicationContext(), body.getApiError(), Toast.LENGTH_LONG).show();
                      }

                    hideProgressBar();
                }

                @Override
                public void onFailure(Call<MoviesListInfo> call, Throwable t) {
                    hideProgressBar();
                }
            });


        } else{
            hideProgressBar();
            Toast.makeText(getApplicationContext(), "Please enter a title", Toast.LENGTH_LONG).show();
           }

    }

    private void showProgressBar() {

        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {

        progressBar.setVisibility(View.INVISIBLE);
    }
}
