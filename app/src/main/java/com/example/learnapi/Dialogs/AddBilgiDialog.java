package com.example.learnapi.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.learnapi.MainActivity;
import com.example.learnapi.Models.Bilgiler;
import com.example.learnapi.R;
import com.example.learnapi.RestApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

public class AddBilgiDialog extends AppCompatDialogFragment {

    EditText edtId, edtTitle, edtBody;
    TextView txtId;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater layoutInflater = getActivity().getLayoutInflater();

        View view = layoutInflater.inflate(R.layout.add_bilgi_layout, null);

        edtId = view.findViewById(R.id.edt_ıd);
        edtTitle = view.findViewById(R.id.edt_title);
        edtBody = view.findViewById(R.id.edt_body);
        txtId =view.findViewById(R.id.txt_id);
        builder.setView(view)
                .setTitle("Add Bilgi")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!edtId.getText().toString().equals("") && !edtTitle.getText().toString().equals("") && !edtBody.getText().toString().equals("")) {
                            int userId = Integer.parseInt(edtId.getText().toString());
                            istek(userId, edtTitle.getText().toString(), edtBody.getText().toString());
                            edtId.setText("");
                            edtTitle.setText("");
                            edtBody.setText("");
                        }else{
                            Toast.makeText(getActivity(),"Alanları doldurunuz", Toast.LENGTH_LONG).show();
                        }
                    }
                });


        return builder.create();
    }

    private void istek(final int userId, final String title, final String body) {

        Call<Bilgiler> call = ManagerAll.getInstance().createBilgi(userId, title, body);
        call.enqueue(new Callback<Bilgiler>() {
            @Override
            public void onResponse(Call<Bilgiler> call, Response<Bilgiler> response) {
                Log.i( "basarı","user:"+userId+"title:"+title+"body:"+body);

            }

            @Override
            public void onFailure(Call<Bilgiler> call, Throwable t) {

            }
        });


    }
}
