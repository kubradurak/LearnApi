package com.example.learnapi.RestApi;

import com.example.learnapi.Models.Bilgiler;
import com.example.learnapi.Models.Photos;
import com.example.learnapi.Models.Todo;

import java.util.List;

import retrofit2.Call;

public class ManagerAll  extends  BaseManager{

    private static ManagerAll ourIntance = new ManagerAll(); //ınstance oluştu


    public static synchronized ManagerAll getInstance(){

        return ourIntance;
    } // döndür

    public Call<List<Bilgiler>> getirBilgileri(){
        Call<List<Bilgiler>> call = getRestApiClient().bilgiGetir();

        return  call;
    }
    public Call<List<Todo>> getirTodo(){
        Call<List<Todo>> call_todo = getRestApiClient().todoGetir();

        return  call_todo;
    }
    public  Call<List<Photos>> photosGetir(){
        Call<List<Photos>> call_photos = getRestApiClient().photosGetir();

        return call_photos;
    }


}
