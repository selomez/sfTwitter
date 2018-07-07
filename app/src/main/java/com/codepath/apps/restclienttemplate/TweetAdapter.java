package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class TweetAdapter extends RecyclerView.Adapter <TweetAdapter.ViewHolder>{


    private static List<Tweet> mTweets;
    static Context context;
    public TweetAdapter (List<Tweet>tweets){
        mTweets = tweets;
    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View tweetView = inflater.inflate(R.layout.item_tweet, parent, false);

        ViewHolder viewHolder = new ViewHolder(tweetView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {

        Tweet tweet = mTweets.get(position);


        holder.tvUsername.setText(tweet.user.name);
        holder.tvDate.setText(getRelativeTimeAgo(tweet.createdAt));
        holder.tvBody.setText(tweet.body);
        final String username = tweet.user.screenName;

        ImageButton reply = holder.ivReply;

        reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (context, ReplyActivity.class);
                intent.putExtra("username" , Parcels.wrap(username));
                context.startActivity(intent);

            }
        });

        Glide.with(context)
                .load(tweet.user.profileImageUrl)
                .into(holder.ivProfileImage);

    }

    public void clear() {
        mTweets.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mTweets.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView ivProfileImage;
        public TextView tvUsername;
        public TextView tvBody;
        public TextView tvDate;
        public ImageButton ivReply;


        public ViewHolder (View itemView){
            super(itemView);

            ivProfileImage = (ImageView )itemView.findViewById(R.id.ivProfile);
            tvUsername = (TextView ) itemView.findViewById(R.id.tvUsername);
            tvBody = (TextView)itemView.findViewById(R.id.tvBody);
            tvDate = (TextView)itemView.findViewById(R.id.tvDate);
            ivReply = (ImageButton) itemView.findViewById(R.id.ivReply);

            itemView.setOnClickListener(this);

            }
        @Override
        public void onClick (View view){
            int position = getAdapterPosition();

            if (position != RecyclerView.NO_POSITION){
                Tweet tweet = mTweets.get(position);
                Intent intent = new Intent (context, DetailsActivity.class);
                intent.putExtra(Tweet.class.getSimpleName(), Parcels.wrap(tweet));
                context.startActivity(intent);
            }


        }

    }

    // getRelativeTimeAgo("Mon Apr 01 21:16:23 +0000 2014");
    public static String getRelativeTimeAgo(String rawJsonDate) {
        String twitterFormat = "EEE MMM dd HH:mm:ss ZZZ yyyy";
        SimpleDateFormat sf = new SimpleDateFormat(twitterFormat, Locale.ENGLISH);
        sf.setLenient(true);

        String relativeDate = "";
        try {
            long dateMillis = sf.parse(rawJsonDate).getTime();
            relativeDate = DateUtils.getRelativeTimeSpanString(dateMillis,
                    System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS).toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return relativeDate;
    }


}



