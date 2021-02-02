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
    private TextView textView_highNum;
    private TextView textView_lowNum;
    private TextView getTextView_feelsLikeNum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        // unpack the intent
        // put weather information into respective text views
        textView_city = findViewById(R.id.textView_city);
        textView_country = findViewById(R.id.textView_country);
        textView_description = findViewById(R.id.textView_description);
        textView_highNum = findViewById(R.id.textView_highNum);
        textView_lowNum = findViewById(R.id.textView_lowNum);
        getTextView_feelsLikeNum = findViewById(R.id.textView_feelsLikeNum);

        Intent intent = getIntent();
        textView_city.setText(intent.getStringExtra("name")+", ");
        // textView_country.setText(intent.getStringExtra("country"));
        // textView_description.setText(intent.getStringExtra("description"));
        // textView_highNum.setText(intent.getIntExtra("temp_max", 0));
        // textView_lowNum.setText(intent.getIntExtra("temp_min", 0));
        // textView_feelsLikeNum.setText(intent.getIntExtra("feels_like", 0));

    }
}
