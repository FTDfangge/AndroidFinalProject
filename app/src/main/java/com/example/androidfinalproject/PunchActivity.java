package com.example.androidfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.androidfinalproject.Class.User.localuser;

public class PunchActivity extends AppCompatActivity {
    TextView habitNameTextView,timeTextView,descriptionTextView;
    Button punchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punch);
        habitNameTextView = findViewById(R.id.habitTextView);
        timeTextView = findViewById(R.id.textView);
        descriptionTextView = findViewById(R.id.editTextTextPersonName4);
        String s = localuser.getMyHabit().getHabitName();
        habitNameTextView.setText(localuser.getMyHabit().getHabitName());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        timeTextView.setText(simpleDateFormat.format(date));

        descriptionTextView.setText(localuser.getMyHabit().getRequest());

        punchButton = findViewById(R.id.button6);
        punchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //向服务器发送打卡请求

                Intent intent = new Intent(PunchActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}