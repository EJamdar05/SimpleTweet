package com.codepath.apps.restclienttemplate.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

public class User implements Parcelable {
    public String name;
    public String userName;
    public String profileImageURL;
    public static User fromJson(JSONObject jsonObject) throws JSONException {
        User user = new User();
        user.name = jsonObject.getString("name");
        user.userName = jsonObject.getString("screen_name");
        user.profileImageURL = jsonObject.getString("profile_image_url_https");
        return user;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.userName);
        dest.writeString(this.profileImageURL);
    }

    public void readFromParcel(Parcel source) {
        this.name = source.readString();
        this.userName = source.readString();
        this.profileImageURL = source.readString();
    }

    public User() {
    }

    protected User(Parcel in) {
        this.name = in.readString();
        this.userName = in.readString();
        this.profileImageURL = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
