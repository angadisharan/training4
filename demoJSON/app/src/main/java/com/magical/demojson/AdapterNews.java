package com.magical.demojson;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.magical.demojson.model.ModelNews;

import java.util.List;

/**
 * Created by sharanangadi on 17/06/17.
 */

public class AdapterNews extends ArrayAdapter<ModelNews> {

    List<ModelNews> modelNewsList;
    Context mContext;

    public AdapterNews(@NonNull Context context, @NonNull List<ModelNews> objects) {
        super(context, -1, objects);
        modelNewsList = objects;
        mContext = context;
    }


    @Override
    public int getCount() {
        return modelNewsList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.news_item, null);
        }

        ModelNews modelNews = modelNewsList.get(position);

        ((TextView) convertView.findViewById(R.id.news_title)).setText(modelNews.getTitle());
        ((TextView) convertView.findViewById(R.id.news_publisher)).setText(modelNews.getPublisher());
        ((TextView) convertView.findViewById(R.id.news_date)).setText(modelNews.getDate());

        return convertView;
    }
}
