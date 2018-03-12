package sameeh.com.moviesapp.Screens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import sameeh.com.moviesapp.Models.MovieItem;
import sameeh.com.moviesapp.Models.MoviesListAdapter;
import sameeh.com.moviesapp.Models.MoviesListInfo;
import sameeh.com.moviesapp.R;

public class MoviesActivity extends AppCompatActivity {
    private RecyclerView moviesRecyclerView;
    private MoviesListAdapter adapter;
    private MoviesListInfo moviesListInfo;
    private final int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);


        Intent i = getIntent();
        moviesListInfo = (MoviesListInfo) i.getSerializableExtra(MainActivity.MOVIES_RESULT_KEY);


        moviesRecyclerView = findViewById(R.id.movies_list);
        moviesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadRecyclerViewData();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.movies:
                Intent intent = new Intent(this, MainActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void loadRecyclerViewData() {

        if (moviesListInfo != null) {
            showMoviesInfo(moviesListInfo);
        }

    }

    private void showMoviesInfo(MoviesListInfo info) {

        List<MovieItem> movieItems = info.getMoviesItems();
        adapter = new MoviesListAdapter(movieItems);
        moviesRecyclerView.setAdapter(adapter);
        Toast.makeText(getApplicationContext(), "Showing "+movieItems.size()+" out of "+info.getTotalResults(), Toast.LENGTH_LONG).show();
        Intent i = getIntent();
        setResult(RESULT_OK, i);
    }

    private void setScreenTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            setTitle(title);
        }
    }

}
