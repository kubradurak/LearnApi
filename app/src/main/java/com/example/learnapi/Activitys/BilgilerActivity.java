package com.example.learnapi.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.learnapi.Adapters.AdapterBilgi;
import com.example.learnapi.Models.Bilgiler;
import com.example.learnapi.R;
import com.example.learnapi.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BilgilerActivity extends AppCompatActivity {
    List<Bilgiler> list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilgiler);
        tanimla();
        istek();
    }
    public  void tanimla(){
        listView = findViewById(R.id.list_view);
    }
    public void  istek(){

        list = new ArrayList<>();

        Call<List<Bilgiler>> bilgiList = ManagerAll.getInstance().getirBilgileri();
        bilgiList.enqueue(new Callback<List<Bilgiler>>() {
            @Override
            public void onResponse(Call<List<Bilgiler>> call, Response<List<Bilgiler>> response) {

                if (  response.isSuccessful()){
                    list = response.body();
                    AdapterBilgi adapterBilgi = new AdapterBilgi(list, getApplicationContext());
                    listView.setAdapter(adapterBilgi);

                }

            }

            @Override
            public void onFailure(Call<List<Bilgiler>> call, Throwable t) {

            }
        });
    }


}
