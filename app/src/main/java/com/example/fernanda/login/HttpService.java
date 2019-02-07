package com.example.fernanda.login;

import android.nfc.Tag;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

public class HttpService {
    private OkHttpClient client = new OkHttpClient();
    private Response response = null;
    private String result;

    public String loginStart(String email, String password) {

        RequestBody formRequestBody = new FormBody.Builder()
                .add("email", email)
                .add("password", password)
                .build();

        final Request request = new Request.Builder()
                .url("http://ag-ifpb-sgd-server.herokuapp.com/login")
                .post(formRequestBody)
                .build();

        //String result;
        new Thread(new Runnable() {
            @Override
            public void run() {
                response = null;
                try {
                    response = client.newCall(request).execute();
                    result = String.valueOf(response.code());
                    if (!response.isSuccessful()) throw new IOException("Unexpected code" + response);
                    System.out.println(String.valueOf(response.code()));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return result;
    }
}
