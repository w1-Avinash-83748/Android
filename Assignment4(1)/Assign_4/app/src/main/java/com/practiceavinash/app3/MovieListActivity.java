package com.practiceavinash.app3;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MovieListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Movie> movieList;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        toolbar=findViewById(R.id.toolbar);
        recyclerView=findViewById(R.id.recyclerView);
        setSupportActionBar(toolbar);
        movieList=new ArrayList<>();
        movieList.add(new Movie(1,"Star Wars: The Empire Strikes Back","Director: Irvin KershnerStarring: Mark Hamill, Harrison Ford, Carrie FisherIf Star Wars gave us a whole new cinematic galaxy, Empire made that galaxy feel so much larger, deeper, and richer.",7.0,R.drawable.empirestrikesback));
        movieList.add(new Movie(2,"Terminator 2: Judgment Day (1991)","Director: James CameronStarring: Arnold Schwarzenegger, Linda Hamilton, Edward FurlongAfter establishing a smart time-loop scenario in the original Terminator, James Cameron cranked everything up for this sequel – introducing a new liquid-metal android foe, reprogramming Arnie as the good guy, and plotting a new plan to disrupt the future and halt the impending nuclear 'judgment day'.",9.0,R.drawable.terminator));
        movieList.add(new Movie(3,"Avatar (2009)","Director: James CameronStarring: Sam Worthington, Zoe Saldana, Sigourney WeaverIconic sci-fi films conjure up distinctive new worlds – and few are as retina-dazzlingly vibrant as Pandora, Avatar's planet of bioluminescent flora, bright blue fauna, and giant floating rock formations. ",8.0,R.drawable.avatar));
        movieList.add(new Movie(4,"A.I. Artificial Intelligence (2001)","Director: Steven SpielbergStarring: Haley Joel Osment, Jude LawA.I.'s creation story saw it become a tantalising collaboration between two cinematic greats — it was a longtime project of Stanley Kubrick, who wanted to adapt Brian Aldiss' short story Supertoys Last All Summer Long, which was then passed to Steven Spielberg, who finally wrangled it on to screens after Kubrick's death and following years of frustrating development.",9.5,R.drawable.aiartificialintelligence));
        MovieAdapter movieAdapter = new MovieAdapter(this,movieList);
        recyclerView.setAdapter(movieAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
    }
    ActivityResultLauncher activityResultLauncher= registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult o)
        {
            Intent intent = o.getData();
            Movie movie = (Movie) intent.getSerializableExtra("movie");
            movie.setId(movieList.size()+1);
            movieList.add(movie);
        }
    });

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent intent = new Intent(this, InputMovieActivity.class);
        activityResultLauncher.launch(intent);
        return super.onOptionsItemSelected(item);
    }
}
