package com.example.androidfinalproject.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.androidfinalproject.MainActivity;
import com.example.androidfinalproject.PunchActivity;
import com.example.androidfinalproject.PunchRecordListActivity;
import com.example.androidfinalproject.R;
import com.example.androidfinalproject.Class.User;

import static com.example.androidfinalproject.Class.User.localuser;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private int numOfPunches;
    TextView numOfPunchesTextView,habitTextView;
    private int time;
    Button punchBtn,recordBtn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        numOfPunches = localuser.getNumOfPunches();
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText("您已经完成了打卡：");
            }
        });
        numOfPunchesTextView = root.findViewById(R.id.numberOfPunchTextView);
        MyTimer myTimer = new MyTimer();
        myTimer.start();

        habitTextView = root.findViewById(R.id.HabitTextView);
        habitTextView.append(localuser.getMyHabit().getHabitName());
        final Context context = this.getContext();
        punchBtn = root.findViewById(R.id.PunchButton);
        punchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PunchActivity.class);
                startActivity(intent);
            }
        });

        recordBtn = root.findViewById(R.id.RecordButton);
        recordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PunchRecordListActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }

    class MyTimer extends Thread{
        @Override
        public void run(){
            time = 0;
            while( time<numOfPunches ){
                time += 1;
                numOfPunchesTextView.setText(Integer.toString(time));
                try {
                    if (numOfPunches <=5 ){
                        Thread.currentThread().sleep(200);
                    }

                    else if (numOfPunches <= 20) {
                        if (time > numOfPunches / 2)
                            Thread.currentThread().sleep((time - numOfPunches / 2) * 16000 / (numOfPunches * numOfPunches));
                        else
                            Thread.currentThread().sleep(2000 / numOfPunches);
                    }
                    else
                        if (numOfPunches-time >10){
                            Thread.currentThread().sleep(1000/(numOfPunches-10));
                        }
                        else
                            Thread.currentThread().sleep((10-numOfPunches+time)*2500/55);
                } catch (InterruptedException e) {

                }
            }
        }
    }
}