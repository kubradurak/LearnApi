package com.example.learnapi.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.learnapi.Adapters.AdapterBilgi;
import com.example.learnapi.Adapters.AdapterTodo;
import com.example.learnapi.Models.Bilgiler;
import com.example.learnapi.Models.Todo;
import com.example.learnapi.R;
import com.example.learnapi.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodoActivity extends AppCompatActivity {
    List<Todo> list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        tanimla();
        istek();
    }

    public void tanimla() {
        listView = findViewById(R.id.list_view);

    }

    public void istek(){
        list = new ArrayList<>();

        Call<List<Todo>> todoList = ManagerAll.getInstance().getirTodo();
        todoList.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {

                if (  response.isSuccessful()){
                    list = response.body();
                    AdapterTodo adapterTodo = new AdapterTodo(list, getApplicationContext());
                    listView.setAdapter(adapterTodo);

                }

            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {

            }
        });
    }
}
