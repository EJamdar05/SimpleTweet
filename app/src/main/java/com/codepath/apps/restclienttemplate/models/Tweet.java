package com.codepath.apps.restclienttemplate.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Tweet implements Parcelable {
    public String body;
    public String createdAt;
    public User user;
    public long id;

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.id = jsonObject.getLong("id");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        return tweet;
    }

    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();
        for(int i = 0 ; i < jsonArray.length() ; i++){
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return tweets;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.body);
        dest.writeString(this.createdAt);
         dest.writeParcelable((Parcelable) this.user, flags);
        dest.writeLong(this.id);
    }

    public void readFromParcel(Parcel source) {
        this.body = source.readString();
        this.createdAt = source.readString();
        this.user = source.readParcelable(User.class.getClassLoader());
        this.id = source.readLong();
    }

    public Tweet() {
    }

    protected Tweet(Parcel in) {
        this.body = in.readString();
        this.createdAt = in.readString();
        this.user = in.readParcelable(User.class.getClassLoader());
        this.id = in.readLong();
    }

    public static final Parcelable.Creator<Tweet> CREATOR = new Parcelable.Creator<Tweet>() {
        @Override
        public Tweet createFromParcel(Parcel source) {
            return new Tweet(source);
        }

        @Override
        public Tweet[] newArray(int size) {
            return new Tweet[size];
        }
    };
}
