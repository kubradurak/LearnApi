package com.example.learnapi.RestApi;

import com.example.learnapi.Models.Bilgiler;
import com.example.learnapi.Models.Photos;
import com.example.learnapi.Models.Todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {

    @GET("/posts")
    Call<List<Bilgiler>> bilgiGetir();


    @GET("/todos")
    Call<List<Todo>> todoGetir();

    @GET("/photos")
    Call<List<Photos>> photosGetir();


}
