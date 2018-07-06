package com.codepath.apps.restclienttemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

public class DetailsActivity extends AppCompatActivity {

    Tweet tweet;
    ImageView ivProfile;
    TextView tvUsername;
    TextView tvBody;
    TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        tvUsername = (TextView) findViewById(R.id.tvUsername);
        ivProfile = (ImageView) findViewById(R.id.ivProfile);
        tvBody = (TextView) findViewById(R.id.tvBody);
        tvDate =(TextView)  findViewById(R.id.tvDate);

        tweet = (Tweet) Parcels.unwrap(getIntent().getParcelableExtra(Tweet.class.getSimpleName()));
        Log.d("DetailsActivity", String.format("Showing details for %s", tweet.user.name));

        tvUsername.setText(tweet.user.name);
        tvBody.setText((tweet.body));

        Glide.with(this).load(tweet.user.profileImageUrl).into(ivProfile);


    }



}
