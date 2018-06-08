package com.example.yoshizawarei.librarydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.gson.JsonObject;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goGetJokes(View view) {
        // Go to the url, get jokes
        Ion.with(this)
//                .load("https://api.chucknorris.io/jokes/random")
                .load("https://api.flickr.com/services/rest/?method=flickr.test.echo&name=value")
                .asJsonObject()
                .setCallback(new FutureCallback< JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        // display to the textView
//                        TextView tv = findViewById(R.id.jokeTV);
//                        tv.setText(result.get("value").getAsString());

                        ImageView imageView = findViewById(R.id.image);
                        imageView.setImageResource(result.get("url_h").getAsInt());

                    }
        });


    }

}
