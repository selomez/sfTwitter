package com.codepath.apps.restclienttemplate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.codepath.apps.restclienttemplate.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;
import org.parceler.Parcels;

import cz.msebera.android.httpclient.Header;

public class ReplyActivity extends AppCompatActivity {


    TwitterClient client;
    EditText simpleEditText;
    Tweet tweet;
    Button button;
    String username;
    EditText message;
    JsonHttpResponseHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);
        simpleEditText = (EditText) findViewById(R.id.etTweet);
        client =  TwitterApp.getRestClient(this);

        ImageButton button = (ImageButton) findViewById(R.id.button);

        tweet = Parcels.unwrap(getIntent().getParcelableExtra(Tweet.class.getSimpleName()));

        button = findViewById(R.id.button);

        username = "@" + Parcels.unwrap(getIntent().getParcelableExtra("username"));
        message.setText(username);

        handler = new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try{
                    tweet = new Tweet();
                    Tweet tweet = Tweet.fromJSON(response);
                    Intent intent = new Intent(ReplyActivity.this, TimelineActivity.class);
                    intent.putExtra(Tweet.class.getSimpleName(), Parcels.wrap(tweet));
                    startActivity(intent);
                }catch(Exception e ){
                    e.printStackTrace();

                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        };

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client.replyTweet(simpleEditText.getText().toString(), new JsonHttpResponseHandler() {

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        try{
                            Tweet tweet = Tweet.fromJSON(response);
                            Intent data = new Intent();
                            data.putExtra(Tweet.class.getSimpleName(), Parcels.wrap(tweet));
                            setResult(RESULT_OK,data);
                            finish();
                        }catch(Exception e ){
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "reply failed",Toast.LENGTH_LONG ).show();

                        }
                    }
                });
         }
        });
    }
}




