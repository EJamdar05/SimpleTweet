package com.codepath.apps.restclienttemplate;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.codepath.apps.restclienttemplate.models.Tweet;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.w3c.dom.Text;

import okhttp3.Headers;

public class ComposeActivity extends AppCompatActivity {
    private android.widget.EditText EditText;
    private Button tweetButton;
    private TextView charsRemain;
    private String TAG = "TweetPublish";
    TwitterClient client;
    private int totalChars = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);
        EditText = findViewById(R.id.editTextTweet);
        tweetButton = findViewById(R.id.buttonTweet);
        charsRemain = findViewById(R.id.remainingChars);
        client = TwitterApp.getRestClient(this);
        //handling tweet
        EditText.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                charsRemain.setText(280 - editable.toString().length() + "/280");
            }
        });
        tweetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //obtain content from textfield
                String tweetContent = EditText.getText().toString();

                //make sure tweet is not empty and is within character limit
                if(tweetContent.length() > 0 && tweetContent.length() <= 280) {
                    Log.i(TAG,"Passed cond");
                    //TODO: API CALL
                    client.publishTweet(tweetContent, new JsonHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Headers headers, JSON json) {
                            Log.i(TAG,"Successfully sent tweet!");
                            try {
                                Tweet tweet = Tweet.fromJson(json.jsonObject);

                                Intent intent = new Intent();
                                intent.putExtra("tweet", tweet);
                                setResult(RESULT_OK, intent);
                                finish();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            //TODO Send tweet back in main timeline activity
                        }

                        @Override
                        public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                            Log.e(TAG, "Failed to publish tweet "+ response, throwable);
                        }
                    });

                }else if(tweetContent.isEmpty()){
                    Toast.makeText(ComposeActivity.this,"Tweet field cannot be empty",
                            Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(ComposeActivity.this,"Char count is 240",
                            Toast.LENGTH_SHORT).show();
                }
                //make API call to publish said tweet
            }
        });
    }
}