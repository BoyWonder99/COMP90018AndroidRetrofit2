package io.cluo29.github.retrofit2test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        request();
    }

    public final String TAG = "haha";


    public void request() {

        // create Retrofit instance
        // Gson is a Google package to parse Json.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create the instance of interface
        Request_Interface request = retrofit.create(Request_Interface.class);

        // send HTTP call
        Call<Translation> call = request.getCall();

        // add the listener to the response
        call.enqueue(new Callback<Translation>() {
            // if successful
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                // do work with the response
                response.body().show();
            }

            // if failed
            @Override
            public void onFailure(Call<Translation> call, Throwable throwable) {
                Log.d(TAG, "Failed");
            }
        });
    }

    public class Translation {
        public int status;

        public content content;
        public class content {
            public String from;
            public String to;
            public String vendor;
            public String out;
            public int errNo;
        }


        public void show() {
            Log.d(TAG, "status: "+ status);
            // from what language
            Log.d(TAG, "from: "+ content.from);
            // to what language
            Log.d(TAG, "to: "+ content.to);
            Log.d(TAG, "vendor: "+ content.vendor);
            // result ouput
            Log.d(TAG, "out: "+ content.out);
            Log.d(TAG, "errNo: "+ content.errNo);
        }
    }
}
