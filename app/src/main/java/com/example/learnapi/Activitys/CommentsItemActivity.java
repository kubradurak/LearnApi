package com.example.learnapi.Activitys;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learnapi.Models.CommentResult;
import com.example.learnapi.Models.Comments;
import com.example.learnapi.R;
import com.example.learnapi.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentsItemActivity extends AppCompatActivity {
    String kpostId, kid, name, email, body;
    Button btnDelete;
    TextView txtPostId, txtId, txtName, txtEmail, txtBody;
    List<CommentResult> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments_item);

        txtPostId = findViewById(R.id.txt_post_id);
        txtId = findViewById(R.id.txt_id);
        txtName =findViewById(R.id.txt_name);
        txtEmail = findViewById(R.id.txt_email);
        txtBody = findViewById(R.id.txt_body);
        btnDelete = findViewById(R.id.btn_item_delete);


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();

            }
        });

        itemShow();
        istek();


    }

    public void delete() {

        Toast.makeText(getApplicationContext(),"Delete",Toast.LENGTH_SHORT).show();


        Call<CommentResult> call = ManagerAll.getInstance().deleteComment(kid);
        call.enqueue(new Callback<CommentResult>() {
            @Override
            public void onResponse(Call<CommentResult> call, Response<CommentResult> response) {

                if (response.isSuccessful()){
                    Intent i = new Intent(getApplicationContext(),CommentsActivity.class);
                    startActivity(i);

                }
            }

            @Override
            public void onFailure(Call<CommentResult> call, Throwable t) {

            }
        });

    }


    public void itemShow() {

          Intent i = getIntent();
          Bundle extras = i.getExtras();
          kpostId = extras.getString("POST_ID");
          kid = extras.getString("ID");
          //  name = bundle.getString("st_name");
           // email = bundle.getString("st_email");
           // body = bundle.getString("body");
       // postId= "1";
        //id = "3";
        Log.i("degerler","id=" + kid + "  ,  " + "postid=" + kpostId); // null dönüyor
    }

    public  void  istek(){
        list = new ArrayList<>();
        Call<List<CommentResult>> call = ManagerAll.getInstance().mngGetcommentsGetir(kpostId,kid);
        call.enqueue(new Callback<List<CommentResult>>() {
            @Override
            public void onResponse(Call<List<CommentResult>> call, Response<List<CommentResult>> response) {
                if (response.isSuccessful()) {
                    list = response.body();
                    atama(list);
                    Log.i("başarı", response.body().get(0).getEmail()); // get(0)
                }
                }

            @Override
            public void onFailure(Call<List<CommentResult>> call, Throwable t) {

            }
        });
    }

    public void atama(List<CommentResult> commentResultList) {
        txtPostId.setText(""+commentResultList.get(0).getPostId());
        txtId.setText(""+commentResultList.get(0).getId());
        txtName.setText(""+commentResultList.get(0).getName());
        txtEmail.setText(""+commentResultList.get(0).getEmail());
        txtBody.setText(""+commentResultList.get(0).getBody());
    }
}
