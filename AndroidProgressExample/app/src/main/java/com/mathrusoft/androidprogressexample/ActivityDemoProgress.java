package com.mathrusoft.androidprogressexample;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by sharanangadi on 27/06/17.
 */

public class ActivityDemoProgress extends AppCompatActivity {

    ProgressBar mProgressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_demo_progress);

        findViewById(R.id.mimic_progress).setOnClickListener(mOnClickListener);

        mProgressBar = (ProgressBar) findViewById(R.id.my_progress_bar);
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mProgressBar.setProgress(0);
            new MyMimicProgress().execute();
        }
    };


    class MyMimicProgress extends AsyncTask<Void, Intent, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {


            for (int i = 0; i < 100; i++) {
                //Mimic network call
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent();
                intent.putExtra("progress", i);
                publishProgress(intent);
            }


            return null;
        }

        @Override
        protected void onProgressUpdate(Intent... values) {
            mProgressBar.setProgress(values[0].getIntExtra("progress", 0));
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

}
