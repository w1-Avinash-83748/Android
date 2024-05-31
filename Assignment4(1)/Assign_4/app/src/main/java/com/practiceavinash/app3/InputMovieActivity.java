package com.practiceavinash.app3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InputMovieActivity extends AppCompatActivity {

    EditText editTitle,editRating,editDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_movie);
        editTitle=findViewById(R.id.editTitle);
        editRating=findViewById(R.id.editRating);
        editDescription=findViewById(R.id.editDescription);

    }

    public void save(View view)
    {
        Movie movie =new Movie();
        movie.setTitle(editTitle.getText().toString());
        movie.setDescription(editDescription.getText().toString());
        movie.setRatings(Double.parseDouble(editRating.getText().toString()));
        movie.setImage(R.drawable.defaultmovie);

        Intent intent = new Intent();
        intent.putExtra("movie",movie);
        setResult(0,intent);
        finish();

    }
}
