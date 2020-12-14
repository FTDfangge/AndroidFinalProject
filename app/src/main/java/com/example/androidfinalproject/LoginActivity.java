package com.example.androidfinalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidfinalproject.Network.HttpUtil;

import org.w3c.dom.Text;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    TextView usernameTextView,passwordTextView;
    Button loginBtn;
    TextView linkToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameTextView = findViewById(R.id.input_email);
        passwordTextView = findViewById(R.id.input_password);

        loginBtn = findViewById(R.id.btn_login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread connectThread = new ConnectThread();
                connectThread.start();
            }
        });

        linkToRegister = findViewById(R.id.link_signup);
        linkToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

    }

    class ConnectThread extends Thread{
        @Override
        public void run(){
            Callback callback = new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e("Loginininininininin","Failed");
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    Log.e("Loginininininininin","Response");
                    Log.d("Loginininininininin",response.toString());
                }
            };
            HttpUtil.sendLogin(usernameTextView.getText().toString(),passwordTextView.getText().toString(),callback);
        }
    }
}