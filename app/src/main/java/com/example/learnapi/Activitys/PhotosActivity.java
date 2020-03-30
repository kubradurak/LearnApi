package com.example.learnapi.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.learnapi.Adapters.AdapterPhotos;
import com.example.learnapi.Models.Photos;
import com.example.learnapi.Models.Todo;
import com.example.learnapi.R;
import com.example.learnapi.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosActivity extends AppCompatActivity {
    List<Photos> list;
    ListView listView;
    //---------------------------------------------------------------------------------
    /////////////////////////////////PİCASSO KULLANILDI//////////////////////////////
    //---------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        listView = findViewById(R.id.list_view);
        istek();

    }

    private void istek() {
        list = new ArrayList<>();
        Call<List<Photos>> photosList = ManagerAll.getInstance().photosGetir();
        photosList.enqueue(new Callback<List<Photos>>() {
            @Override
            public void onResponse(Call<List<Photos>> call, Response<List<Photos>> response) {
                if (response.isSuccessful()){
                    list = response.body();
                    AdapterPhotos adapterPhotos = new AdapterPhotos(list, getApplicationContext());
                    listView.setAdapter(adapterPhotos);

                }
            }

            @Override
            public void onFailure(Call<List<Photos>> call, Throwable t) {

            }
        });

    }
}
