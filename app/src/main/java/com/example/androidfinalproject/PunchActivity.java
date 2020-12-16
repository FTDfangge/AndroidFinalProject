package com.example.androidfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidfinalproject.Class.PunchRecord;
import com.example.androidfinalproject.Network.HttpUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

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
                PunchRecord punchRecord = new PunchRecord();
                punchRecord.setPunchText(descriptionTextView.getText().toString());
                punchRecord.setStudentNumber(localuser.getStudentNumber());
                SimpleDateFormat   formatter   =   new   SimpleDateFormat   ("HH:mm:ss");
                Date curDate =  new Date(System.currentTimeMillis());
                //获取当前时间
                String   str   =   formatter.format(curDate);
                punchRecord.setPunchTime(str);

                Callback callback = new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                    }
                };
                HttpUtil.sendPunch(punchRecord,callback);
                Intent intent = new Intent(PunchActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}