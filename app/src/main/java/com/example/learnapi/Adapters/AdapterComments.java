package com.example.learnapi.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.learnapi.Activitys.CommentsItemActivity;
import com.example.learnapi.Models.Comments;
import com.example.learnapi.R;

import java.util.List;

public class AdapterComments extends BaseAdapter {

    List<Comments> commentsList;
    Context context;
    Activity activity;

    public AdapterComments(List<Comments> commentsList, Context context, Activity activity) {
        this.commentsList = commentsList;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return commentsList.size();
    }

    @Override
    public Object getItem(int position) {
        return commentsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {

        v = LayoutInflater.from(context).inflate(R.layout.comments_layout, parent, false);

        LinearLayout linearLayout = v.findViewById(R.id.layoutList);

        final TextView postId = v.findViewById(R.id.txt_post_id);
        TextView id = v.findViewById(R.id.txt_id);
        TextView name= v.findViewById(R.id.txt_name);
        TextView email = v.findViewById(R.id.txt_email);
        TextView body = v.findViewById(R.id.txt_body);

        postId.setText( ""+commentsList.get(position).getPostId());
        id.setText(""+commentsList.get(position).getId());
        name.setText( ""+commentsList.get(position).getName());
        email.setText( ""+commentsList.get(position).getEmail());
        body.setText(""+commentsList.get(position).getBody());

        final String post = ""+commentsList.get(position).getPostId();
        final String st_id = ""+commentsList.get(position).getId();
        final String st_name = ""+commentsList.get(position).getName();
        final String st_email = ""+commentsList.get(position).getEmail();
        final String st_body = ""+commentsList.get(position).getBody();



        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(activity, CommentsItemActivity.class); // Comments bir java classı olduğu için
              //  i.putExtra("POST_ID ", post);
              //  i.putExtra("ID ", st_id);
                i.putExtra("POST_ID", post);
                i.putExtra("ID",st_id);

               // i.putExtra("name ", st_name);
               // i.putExtra("email ", st_email);
                //i.putExtra("body ", st_body);

                activity.startActivity(i);
            }
        });


        return v;
    }
}
