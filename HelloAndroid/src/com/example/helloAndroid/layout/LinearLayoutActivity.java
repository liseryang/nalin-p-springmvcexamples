package com.example.helloAndroid.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloAndroid.R;

public class LinearLayoutActivity extends Activity {
    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout);

        // binding "button_linear_layout" button action
        final Button button = (Button) findViewById(R.id.button_back_to_main);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                if data sending back to caller
//                Intent intent = new Intent();
//                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}