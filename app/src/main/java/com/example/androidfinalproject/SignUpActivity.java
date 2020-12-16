package com.example.androidfinalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.androidfinalproject.Class.Habit;
import com.example.androidfinalproject.Class.Student;
import com.example.androidfinalproject.Network.HttpUtil;

import java.io.BufferedReader;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SignUpActivity extends AppCompatActivity {
    TextView stuNameTextView, stuNumTextView, emailTextView, passwordTextView, confirmPasswordTextView;
    TextView yaoQiuText,jiezhiriqiText,zhouqiText,pingzhengText,cepingzhouqiText,cepingYaoQiuText,cepingcishuText;
    Button signUpBtn;
    Spinner choosingSpinner;
    Habit habit = new Habit();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        stuNameTextView = findViewById(R.id.input_name);
        stuNumTextView = findViewById(R.id.input_stu_num);
        emailTextView = findViewById(R.id.input_email);
        passwordTextView = findViewById(R.id.input_password);
        confirmPasswordTextView = findViewById(R.id.input_reEnterPassword);

        yaoQiuText=findViewById(R.id.autoCompleteTextView3);
        yaoQiuText.setText("Not Available");
        jiezhiriqiText=findViewById(R.id.autoCompleteTextView4);
        jiezhiriqiText.setText("Not Available");
        zhouqiText=findViewById(R.id.autoCompleteTextView5);
        zhouqiText.setText("Not Available");
        pingzhengText=findViewById(R.id.autoCompleteTextView6);
        pingzhengText.setText("Not Available");
        cepingzhouqiText=findViewById(R.id.autoCompleteTextView7);
        cepingzhouqiText.setText("Not Available");
        cepingYaoQiuText=findViewById(R.id.autoCompleteTextView8);
        cepingYaoQiuText.setText("Not Available");
        cepingcishuText=findViewById(R.id.autoCompleteTextView9);
        cepingcishuText.setText("Not Available");

        signUpBtn = findViewById(R.id.btn_signup);
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread regThread = new registerThread();
                regThread.start();
            }
        });

        choosingSpinner = (Spinner) findViewById(R.id.spinner);
        choosingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String habitName = parent.getSelectedItem().toString();
                Log.d("---------------------------------",habitName);
                habit.setHabit(habitName);
                fillTextview(habit);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void fillTextview(Habit habit){
        yaoQiuText.setText(habit.request);
        jiezhiriqiText.setText(habit.endingTime.toString());
        zhouqiText.setText(habit.cycle);
        pingzhengText.setText("暂不支持");
        cepingzhouqiText.setText(habit.testCycle);
        cepingYaoQiuText.setText(String.valueOf(habit.testTimeInCycle));
        cepingcishuText.setText(String.valueOf(habit.requiredNumberOfCycle));

    }

    class registerThread extends Thread{
        @Override
        public void run(){
            Callback callback = new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e("Failed","FFFFFFFFFFFFFFFF");
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (response.body().toString().equals("YRegister")){
                        Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }
                    Log.d("TTTTTTTTTTTTT",response.body().toString());
                }
            };
            Student student = new Student();
            student.setStudentNumber(stuNumTextView.getText().toString());
            student.setStudentName(stuNameTextView.getText().toString());
            student.setNickName(stuNameTextView.getText().toString());
            student.setMailAddress(emailTextView.getText().toString());
            student.setStudentSex(1);
            if (passwordTextView.getText().toString().equals(confirmPasswordTextView.getText().toString()))
                student.setStudentPassword(passwordTextView.getText().toString());
            else
                new AlertDialog.Builder(SignUpActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("警告")
                        .setMessage("两次密码不一致")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                confirmPasswordTextView.setText("");
                                passwordTextView.setText("");
                            }

                        }).create().show();
            student.setChoiceNum(habit.habitTag);
            HttpUtil.sendRegister(student,callback);
        }
    }
}