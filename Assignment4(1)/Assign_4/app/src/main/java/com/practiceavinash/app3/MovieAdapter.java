package com.practiceavinash.app3;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    Context context;
    List<Movie> movieList;

    public MovieAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // View view  = LayoutInflater.from(context).inflate(R.layout.list_movie,null);
        View view  = LayoutInflater.from(context).inflate(R.layout.list_movies2,null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textTitle.setText(movieList.get(position).getTitle());
        holder.textRating.setText(""+movieList.get(position).getRatings());
        holder.imageView.setImageResource(movieList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
        TextView textTitle,textRating;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle=itemView.findViewById(R.id.textTitle);
            textRating=itemView.findViewById(R.id.textRating);
            imageView=itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, MovieDetailsActivity.class);
            intent.putExtra("movie",movieList.get(getAdapterPosition()));
            context.startActivity(intent);
        }

        @Override
        public boolean onLongClick(View view) {
            PopupMenu popupMenu = new PopupMenu(context,view);
            popupMenu.getMenu().add("delete");
            popupMenu.show();
             popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                 @Override
                 public boolean onMenuItemClick(MenuItem item) {
                     movieList.remove(getAdapterPosition());
                     MovieAdapter.this.notifyDataSetChanged();
                     return false;
                 }
             });
            return false;
        }
    }
}
