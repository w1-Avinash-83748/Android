package com.practiceavinash.app3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;

public class MovieDetailsActivity extends AppCompatActivity {
TextView textMovieId,textTitle,textRating,textDescription;
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        textMovieId=findViewById(R.id.textMovieId);
        textTitle=findViewById(R.id.textTitle);
        textRating=findViewById(R.id.textRating);
        textDescription=findViewById(R.id.textDescription);
        imageView=findViewById(R.id.imageView);
        Intent intent = getIntent();
        Movie movie = (Movie) intent.getSerializableExtra("movie");
        imageView.setImageResource(movie.getImage());
        textMovieId.setText(""+movie.getId());
        textTitle.setText("Title : "+movie.getTitle());
        textDescription.setText("Description: "+movie.getDescription());
        textRating.setText("Rating "+movie.getRatings());





    }
}
