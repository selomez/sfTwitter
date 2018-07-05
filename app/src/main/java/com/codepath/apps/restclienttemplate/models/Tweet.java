package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Parcel
public class Tweet {


    // the attributes of a tweet
    public String body;
    public long uid;
    public User user;
    public String createdAt;

public Tweet(){}

    //deserialize the JSON
    public static Tweet fromJSON(JSONObject object) throws JSONException{
        Tweet tweet = new Tweet();

        tweet.body = object.getString("text");
        tweet.uid = object.getLong("id");
        tweet.createdAt = object.getString("created_at");
        tweet.user =  User.fromJSON(object.getJSONObject("user"));
        return tweet;
    }


}
