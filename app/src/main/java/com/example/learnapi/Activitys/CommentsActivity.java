package com.example.learnapi.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.learnapi.Adapters.AdapterComments;
import com.example.learnapi.Adapters.AdapterPhotos;
import com.example.learnapi.Models.Comments;
import com.example.learnapi.R;
import com.example.learnapi.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentsActivity extends AppCompatActivity {
    List<Comments> list;
    ListView listView;

    //-------------------------------------------------------------------------------------------
    //------------------------LİSTVİEW CLİCK İTEM İLE BAŞKA BİR ACTİVİTYE VERİ AKTARILDI---------
    //-------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        listView = findViewById(R.id.list_view);
        istek();

    }

    private void istek() {
        list = new ArrayList<>();
        Call<List<Comments>> commentsList = ManagerAll.getInstance().commentsGetir();
        commentsList.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                if (response.isSuccessful()){
                    list= response.body();
                    AdapterComments adapterComments = new AdapterComments(list, getApplicationContext(), CommentsActivity.this);
                    listView.setAdapter(adapterComments);
                }
            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {

            }
        });
    }

}
