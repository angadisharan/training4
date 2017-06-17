package com.magical.demojson;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by sharanangadi on 17/06/17.
 */

public class ActivityNewsDetails extends AppCompatActivity {


    public static final String KEY_TITLE = "TITLE";
    public static final String KEY_PUBLISHER = "PUBLISHER";
    public static final String KEY_DATE = "DATE";


    TextView mTextViewNewsTitle;
    TextView mTextViewNewsPublisher;
    TextView mTextViewNewsDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_news_details);

        mTextViewNewsTitle = (TextView) findViewById(R.id.activiy_news_title);
        mTextViewNewsPublisher = (TextView) findViewById(R.id.activiy_news_publisher);
        mTextViewNewsDate = (TextView) findViewById(R.id.activiy_news_date);


        handleIntent(getIntent());

    }

    private void handleIntent(Intent intent) {
        mTextViewNewsTitle.setText(intent.getStringExtra(KEY_TITLE));
        mTextViewNewsPublisher.setText(intent.getStringExtra(KEY_PUBLISHER));
        mTextViewNewsDate.setText(intent.getStringExtra(KEY_DATE));

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);

    }
}
