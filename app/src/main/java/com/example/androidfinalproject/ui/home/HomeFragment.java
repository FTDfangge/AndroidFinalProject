package com.example.androidfinalproject.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.androidfinalproject.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private int numOfPunches=30;
    TextView numOfPunchesTextView;
    private int time;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
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
                    Thread.currentThread().sleep(50);
                } catch (InterruptedException e) {

                }
            }
        }
    }
}