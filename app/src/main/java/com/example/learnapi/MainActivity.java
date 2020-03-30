package com.example.learnapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.learnapi.Activitys.BilgilerActivity;
import com.example.learnapi.Activitys.CommentsActivity;
import com.example.learnapi.Activitys.PhotosActivity;
import com.example.learnapi.Activitys.TodoActivity;
import com.example.learnapi.Adapters.AdapterBilgi;
import com.example.learnapi.Dialogs.AddBilgiDialog;
import com.example.learnapi.Models.Bilgiler;
import com.example.learnapi.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btnBilgiler, btnTodo, btnPhotos, btnComments, btnAddBilgi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBilgiler = findViewById(R.id.btn_bilgiler);
        btnBilgiler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this , BilgilerActivity.class);
                startActivity(i);
            }
        });

        btnTodo = findViewById(R.id.btn_todo);
        btnTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this , TodoActivity.class);
                startActivity(i);
            }
        });

        btnPhotos = findViewById(R.id.btn_photos);
        btnPhotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PhotosActivity.class);
                startActivity(i);
            }
        });
        btnComments = findViewById(R.id.btn_comments);
        btnComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(MainActivity.this, CommentsActivity.class);
                startActivity(i);
            }
        });
        btnBilgiler = findViewById(R.id.btn_add_bilgi);
        btnBilgiler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddBilgiDialog addBilgiDialog = new AddBilgiDialog();
                addBilgiDialog.show(getSupportFragmentManager(),"AddBilgiDialog");
            }
        });


    }



}
