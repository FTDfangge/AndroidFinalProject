package com.example.androidfinalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.example.androidfinalproject.Class.Moment;
import com.example.androidfinalproject.Class.User;

import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends ArrayAdapter<Moment> {
    private int resourceID;


    public UsersAdapter(Context context, int resource, List<Moment> moments){
        super(context,resource,moments);
        resourceID = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view;
        Moment moment = getItem(position);
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceID, null);
        }
        else
            view = convertView;

        ImageView userImage = (ImageView)view.findViewById(R.id.it_image);
        TextView userName = (TextView)view.findViewById(R.id.it1);
        TextView userTime = (TextView)view.findViewById(R.id.it2);
        TextView userText = (TextView)view.findViewById(R.id.it3);
        userImage.setImageResource(moment.getUserIcon());
        userImage.setImageResource(moment.getPunchImage());
        userName.setText(moment.getNickName());
        userTime.setText(moment.getPunchTime());
        userText.setText(moment.getPunchDescription());
        return view;
    }

}
