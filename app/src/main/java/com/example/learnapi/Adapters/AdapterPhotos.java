package com.example.learnapi.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.learnapi.Models.Photos;
import com.example.learnapi.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterPhotos extends BaseAdapter {
    List<Photos> photosList;
    Context context;

    public AdapterPhotos(List<Photos> photosList, Context context) {
        this.photosList = photosList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return photosList.size();
    }

    @Override
    public Object getItem(int position) {
        return photosList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        v = LayoutInflater.from(context).inflate(R.layout.photos_layout, parent, false);


        TextView albumId = v.findViewById(R.id.txt_album_id);
        TextView id = v.findViewById(R.id.txt_id);
        ImageView img = v.findViewById(R.id.img);


        albumId.setText(albumId.getText()+ ""+ photosList.get(position).getAlbumId());
        id.setText(id.getText()+""+photosList.get(position).getId());
        Picasso.with(v.getContext()).load(photosList.get(position).getThumbnailUrl()).into(img);


        return v;
    }
}
