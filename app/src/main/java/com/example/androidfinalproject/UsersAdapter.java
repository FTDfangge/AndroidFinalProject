package com.example.androidfinalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.example.androidfinalproject.Class.User;

import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends ArrayAdapter<User> {
    private int resourceID;


    public UsersAdapter(Context context, int resource, List<User> users){
        super(context,resource,users);
        resourceID = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view;
        User users = getItem(position);
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceID, null);
        }
        else
            view = convertView;

        ImageView userImage = (ImageView)view.findViewById(R.id.it_image);
        TextView userName = (TextView)view.findViewById(R.id.it1);
        TextView userTime = (TextView)view.findViewById(R.id.it2);
        TextView userText = (TextView)view.findViewById(R.id.it3);
        userImage.setImageResource(users.getImageID());
        userImage.setImageResource(users.getImageID2());
        userName.setText(users.getName());
        userTime.setText(users.getTime());
        userText.setText(users.getText());
        return view;
    }

}
