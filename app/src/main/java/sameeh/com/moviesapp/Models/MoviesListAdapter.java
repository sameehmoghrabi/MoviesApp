package sameeh.com.moviesapp.Models;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import sameeh.com.moviesapp.R;

/**
 * Created by samee on 3/12/2018.
 */

public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListAdapter.ViewHolder> {

    private List<MovieItem> moviesList = new ArrayList<>();;

    public MoviesListAdapter(List<MovieItem> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MovieItem movieItem = moviesList.get(position);
        Context context = holder.itemView.getContext();

        holder.title.setText(movieItem.getTitle());
        holder.year.setText(movieItem.getYear());
        holder.id.setText(movieItem.getId());
        holder.type.setText(movieItem.getType());

        String posterURL = movieItem.getPosterURL();
        if(!posterURL.equals("N/A"))
            Picasso.with(context).load(posterURL).into(holder.poster);

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView poster;
        TextView title;
        TextView year;
        TextView id;
        TextView type;

        public ViewHolder(View itemView) {
            super(itemView);

            poster = itemView.findViewById(R.id.movie_poster);
            title = itemView.findViewById(R.id.movie_title);
            year = itemView.findViewById(R.id.movie_year);
            id = itemView.findViewById(R.id.movie_imdbID);
            type = itemView.findViewById(R.id.movie_type);


        }
    }

}
