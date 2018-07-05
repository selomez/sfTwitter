package com.codepath.apps.restclienttemplate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.codepath.apps.restclienttemplate.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;
import org.parceler.Parcels;

import cz.msebera.android.httpclient.Header;

public class ComposeActivity extends AppCompatActivity {

    TwitterClient client;
    EditText simpleEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);
        // getting the text
        simpleEditText = (EditText) findViewById(R.id.etTweet);
        String strValue = simpleEditText.getText().toString();
        client =  TwitterApp.getRestClient(this);
        //   client.sendTweet(strValue, handler);
    }


    public void onCompose(View view) {

        client.sendTweet(simpleEditText.getText().toString(), new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try{
                    Tweet tweet = Tweet.fromJSON(response);
                    Intent data = new Intent();
                    data.putExtra("tweet", Parcels.wrap(tweet));
                    setResult(RESULT_OK,data);
                    finish();
                }catch(Exception e ){
                    e.printStackTrace();
                }
            }
        });

    }


}
