package com.example.classactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private Button button_go;

    private static final String api_url="http://api.openweathermap.org/data/2.5/weather?q=";
    private static final String key="&appid=1d212675bfe07dc4807e300c3bda43d4";
    private String city;
    private String constructed_url;
    private EditText editText_cityName;
    private static AsyncHttpClient client = new AsyncHttpClient();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_go = findViewById(R.id.button_go);
        editText_cityName = findViewById(R.id.editText_cityName);

        button_go.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // handle what happens after button is clicked
                launchNextActivity(v);
            }
        });
    }

    private void launchNextActivity(View v) {

        // get text input
        city = editText_cityName.getText().toString();
        constructed_url=api_url+city+key+"&units=imperial";

        // set the header because of the api endpoint
        client.addHeader("Accept", "application/json");
        // send a get request to the api url
        client.get(constructed_url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                // when you get a 200 status code
                Log.d("api response", new String(responseBody));

                try {
                    JSONObject json = new JSONObject(new String(responseBody));
                    JSONObject sys = json.getJSONObject("sys");
                    JSONArray weatherArray = json.getJSONArray("weather");
                    JSONObject weather = weatherArray.getJSONObject(0);
                    JSONObject main = json.getJSONObject("main");

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    // add weather information into the intent
                    intent.putExtra("name", json.getString("name")+", ");
                    intent.putExtra("country", sys.getString("country"));
                    intent.putExtra("description", weather.getString("description"));
                    intent.putExtra("temp_max", "High");
                    intent.putExtra("temp_max_value", main.getString("temp_max"));
                    intent.putExtra("temp_min", "Low");
                    intent.putExtra("temp_min_value", main.getString("temp_min"));
                    intent.putExtra("feels_like", "Feels like");
                    intent.putExtra("feels_like_value", main.getString("feels_like"));

                    // convert any json data into a string to put into the intent
                    // when you receive the intent in the next activity
                    // convert it back into the json data
                    startActivity(intent);

                } catch (JSONException e) {
                    e.printStackTrace();

                }


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                // when you get a 400-499 status code
                // implement String that says "No city found."
                Log.e("api error", new String(responseBody));

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // no city found
                intent.putExtra("error", "No city found");

                startActivity(intent);
            }
        });
    }
}