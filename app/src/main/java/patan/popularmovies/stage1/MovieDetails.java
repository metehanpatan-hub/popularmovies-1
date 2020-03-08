package patan.popularmovies.stage1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class MovieDetails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_movie_details);

        TextView originalTitleTV = (TextView) findViewById (R.id.title_tv);
        TextView ratingTV = (TextView) findViewById (R.id.rating_tv);
        TextView releaseDateTV = (TextView) findViewById (R.id.release_date_tv);
        TextView overviewTV = (TextView) findViewById (R.id.overview_tv);
        ImageView posterIV = (ImageView) findViewById (R.id.poster_iv);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        Movie movie = intent.getParcelableExtra("movie");

        //Set Data to Views
        originalTitleTV.setText(movie.getTitle());
        ratingTV.setText (String.valueOf(movie.getVote_average ()) + " / 10");
        Picasso.get()
                .load(movie.getPoster_path())
                .fit()
                .error(R.mipmap.ic_launcher_round)
                .placeholder(R.mipmap.ic_launcher_round)
                .into(posterIV);
        overviewTV.setText (movie.getOverview ());
        releaseDateTV.setText (movie.getRelease_date());
    }


    private void closeOnError() {
        finish();
        Toast.makeText(this, "No Connection!", Toast.LENGTH_SHORT).show();
    }
}
