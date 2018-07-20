package com.example.donnyekosaputro.movieapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailMovieActivity extends AppCompatActivity {

    public static String EXTRA_TITLE="extra_title";
    public static String EXTRA_OVERVIEW="extra_overview";
    public static String EXTRA_RELEASE_DATE="extra_release_date";
    public static String EXTRA_POSTER="extra_poster";
    public static String EXTRA_RATE="extra_rate";
    public static String EXTRA_RATE_COUNT="extra_rate_count";

    private TextView tvDetailJudul, tvOverview,tvDate, tvRating ;
    private ImageView imgMovie;
    private Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        tvDetailJudul=(TextView)findViewById(R.id.detailJudul);
        tvOverview=(TextView)findViewById(R.id.detailOverview);
        tvDate=(TextView)findViewById(R.id.detailReleaseDate);
        tvRating=(TextView)findViewById(R.id.detailVote);
        imgMovie=(ImageView)findViewById(R.id.imgMovie);

        String title=getIntent().getStringExtra(EXTRA_TITLE);
        String overview=getIntent().getStringExtra(EXTRA_OVERVIEW);
        String rate=getIntent().getStringExtra(EXTRA_RATE);
        String rate_count=getIntent().getStringExtra(EXTRA_RATE_COUNT );
        String poster=getIntent().getStringExtra(EXTRA_POSTER);
        String release=getIntent().getStringExtra(EXTRA_RELEASE_DATE);

        SimpleDateFormat date_format=new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date date=date_format.parse(release);
            SimpleDateFormat new_date_format=new SimpleDateFormat("EEEE,MMM dd,yyyy");
            String date_of_release=new_date_format.format(date);
            tvDate.setText(date_of_release);
        }catch (ParseException e){
            e.printStackTrace();
        }
        tvDetailJudul.setText(title);
        tvOverview.setText(overview);
        tvRating.setText(rate_count+"Ratings ("+rate+"/10");
        Picasso.with(context).load("http://image.tmdb.org/t/p/w500/"+poster).into(imgMovie);
    }

}
