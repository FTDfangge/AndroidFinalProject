package com.example.androidfinalproject.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.androidfinalproject.Class.User;
import com.example.androidfinalproject.R;
import com.example.androidfinalproject.UsersAdapter;

import java.util.List;

public class DashboardFragment extends Fragment {
    List<User> userList = null;

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        UsersAdapter adapter = new UsersAdapter(getActivity().getApplicationContext(),R.layout.item,userList);
        ListView listView = root.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return root;
    }
}