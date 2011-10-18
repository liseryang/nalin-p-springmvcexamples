package com.example.helloAndroid.activity.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helloAndroid.R;

public class UserTripsActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_user_trips);
       
        new TrippyApiDataTask().execute("https://graph.facebook.com/cocacola");

        final Button button = (Button) findViewById(R.id.user_trips_return_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
    
    private class TrippyApiDataTask extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... urls) {
            return getStringData(urls[0]);
        }
        protected void onPostExecute(String result) {
            final TextView t = (TextView)findViewById(R.id.user_trips_header);
            t.setText(result);
            Toast.makeText(getApplicationContext(),"Executed the query.",Toast.LENGTH_SHORT).show();
        }
    }
      
    private String getStringData(String url) {
        StringBuilder builder = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(
                new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
            } else {
                Log.e(UserTripsActivity.class.toString(), "Failed to download file");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

//  Posting data
//
//    private void connect(String url) {
//    HttpClient client = new DefaultHttpClient();
//    HttpPost post = new HttpPost(url);
//
//    try {
//
//        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
//        nameValuePairs.add(new BasicNameValuePair("Email", "-------@gmail.com"));
//        nameValuePairs
//                .add(new BasicNameValuePair("Passwd", "---------"));
//        nameValuePairs.add(new BasicNameValuePair("accountType", "GOOGLE"));
//        nameValuePairs.add(new BasicNameValuePair("source",
//                "Google-cURL-Example"));
//        nameValuePairs.add(new BasicNameValuePair("service", "ac2dm"));
//
//        post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//        HttpResponse response = client.execute(post);
//        BufferedReader rd = new BufferedReader(new InputStreamReader(
//                response.getEntity().getContent()));
//
//        String line = "";
//        while ((line = rd.readLine()) != null) {
//            System.out.println(line);
//            if (line.startsWith("Auth=")) {
//                String key = line.substring(5);
//                // Do something with the key
//            }
//
//        }
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}
}