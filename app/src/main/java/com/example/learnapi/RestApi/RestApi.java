package com.example.learnapi.RestApi;

import com.example.learnapi.Models.Bilgiler;
import com.example.learnapi.Models.CommentResult;
import com.example.learnapi.Models.Comments;
import com.example.learnapi.Models.Photos;
import com.example.learnapi.Models.Todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestApi {

    @GET("/posts")
    Call<List<Bilgiler>> bilgiGetir();


    @GET("/todos")
    Call<List<Todo>> todoGetir();

    @GET("/photos")
    Call<List<Photos>> photosGetir();

    @GET("/comments")
    Call<List<Comments>> commentsGetir();

    @GET("/comments")
    Call<List<CommentResult>> commentsResult(@Query("postId") String postid, @Query("id") String id);


    @DELETE("/comments/{id}")
    Call<CommentResult> delete(@Path("id") String id);

    @FormUrlEncoded
    @POST("/posts")
    Call<Bilgiler> createPost(@Field("userId") int userId,
                              @Field("title") String title,
                              @Field("body") String text
                              );
}
