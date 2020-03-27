package com.example.learnapi.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.learnapi.Models.Bilgiler;
import com.example.learnapi.R;

import java.util.List;

public class AdapterBilgi extends BaseAdapter {

    List<Bilgiler> list;
    Context context;

    public AdapterBilgi(List<Bilgiler> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.list_layout, parent, false);
        TextView userId = convertView.findViewById(R.id.txt_user_id);
        TextView id = convertView.findViewById(R.id.txt_id);
        TextView title = convertView.findViewById(R.id.txt_title);
        TextView body = convertView.findViewById(R.id.txt_body);


        userId.setText(""+list.get(position).getUserId() );
        id.setText(""+list.get(position).getId());
        title.setText( ""+list.get(position).getTitle());
        body.setText(""+list.get(position).getBody());


        return convertView;
    }
}
