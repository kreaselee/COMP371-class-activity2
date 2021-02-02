package com.example.classactivity2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class SecondActivity extends AppCompatActivity {

    private TextView textView_city;
    private TextView textView_country;
    private TextView textView_description;
    private TextView textView_high;
    private TextView textView_highValue;
    private TextView textView_low;
    private TextView textView_lowValue;
    private TextView textView_feelsLike;
    private TextView textView_feelsLikeValue;
    private TextView textView_error;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        // unpack the intent
        // put weather information into respective text views
        textView_city = findViewById(R.id.textView_city);
        textView_country = findViewById(R.id.textView_country);
        textView_description = findViewById(R.id.textView_description);
        textView_high = findViewById(R.id.textView_high);
        textView_highValue = findViewById(R.id.textView_highValue);
        textView_low = findViewById(R.id.textView_low);
        textView_lowValue = findViewById(R.id.textView_lowValue);
        textView_feelsLike = findViewById(R.id.textView_feelsLike);
        textView_feelsLikeValue = findViewById(R.id.textView_feelsLikeValue);
        textView_error = findViewById(R.id.textView_error);

        Intent intent = getIntent();
        textView_city.setText(intent.getStringExtra("name"));
        textView_country.setText(intent.getStringExtra("country"));
        textView_description.setText(intent.getStringExtra("description"));
        textView_high.setText(intent.getStringExtra("temp_max"));
        textView_highValue.setText(intent.getStringExtra("temp_max_value"));
        textView_low.setText(intent.getStringExtra("temp_min"));
        textView_lowValue.setText(intent.getStringExtra("temp_min_value"));
        textView_feelsLike.setText(intent.getStringExtra("feels_like"));
        textView_feelsLikeValue.setText(intent.getStringExtra("feels_like_value"));

        textView_error.setText(intent.getStringExtra("error"));
    }
}
