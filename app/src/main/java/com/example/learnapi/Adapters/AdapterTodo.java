package com.example.learnapi.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.learnapi.Models.Todo;
import com.example.learnapi.R;

import java.util.List;

public class AdapterTodo extends BaseAdapter {
    List<Todo> todoList;
    Context context;

    public AdapterTodo(List<Todo> todoList, Context context) {
        this.todoList = todoList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return todoList.size();
    }

    @Override
    public Object getItem(int position) {
        return todoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.todo_layout, parent, false);
        TextView userId = convertView.findViewById(R.id.txt_user_id);
        TextView id = convertView.findViewById(R.id.txt_id);
        TextView title = convertView.findViewById(R.id.txt_title);
        CheckBox completed = convertView.findViewById(R.id.cb_complete);


        userId.setText(userId.getText()+ ""+todoList.get(position).getUserId() );
        id.setText(id.getText()+""+todoList.get(position).getId());
        title.setText( title.getText()+""+todoList.get(position).getTitle());

        Boolean deger =  todoList.get(position).isCompleted();
        if (deger == true){
            completed.setChecked(true);
        }else{
            completed.setChecked(false);
        }

        return convertView;
    }
}
