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
                    Log.d("Loginininininininin",response.toString()+response.body().string());
                    String [] responseString = response.body().toString().split("\\s+");
                    if (responseString[0].equals("Y")){
                        HttpUtil.initUser(responseString[2],responseString[3],Integer.valueOf(responseString[4]),Integer.valueOf(responseString[1]));
                    }
                    else {
                        new AlertDialog.Builder(LoginActivity.this)
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .setTitle("警告")
                                .setMessage("用户名或密码错误")
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        usernameTextView.setText("");
                                        passwordTextView.setText("");
                                    }

                                }).create().show();
                    }
                }
            };
            HttpUtil.sendLogin(usernameTextView.getText().toString(),passwordTextView.getText().toString(),callback);
        }
    }
}