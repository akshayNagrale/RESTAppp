package com.example.restapp;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

public class GithubRepoAdapter extends ArrayAdapter<GithubRepo> {
    private TextView textView;

    private Context context;
    private List<GithubRepo> values;

    public GithubRepoAdapter(Context context, List<GithubRepo> values) {
        super(context, R.layout.list_item, values);

        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_item, parent, false);
        }

        textView = row.findViewById(R.id.textView);

        GithubRepo item = values.get(position);
        String message = item.getName();
        textView.setText(message);

        return row;
    }
}