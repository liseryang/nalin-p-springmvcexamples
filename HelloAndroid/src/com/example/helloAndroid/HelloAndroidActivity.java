package com.example.helloAndroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloAndroid.activity.user.UserTripsActivity;
import com.example.helloAndroid.layout.LinearLayoutActivity;

public class HelloAndroidActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final Button button = (Button) findViewById(R.id.button_linear_layout);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), LinearLayoutActivity.class);
//                startActivityForResult(myIntent, 0);
                startActivity(myIntent);
            }
        });
        final Button button2 = (Button) findViewById(R.id.button_user_trips);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), UserTripsActivity.class);
                startActivity(myIntent);
            }
        });

    }
}