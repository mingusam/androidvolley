package com.example.myapplication;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Usersadapter extends BaseAdapter{
    private LayoutInflater inflater;
    private List<UserListResponse> userItems;
    private Context mctx;

    public Usersadapter(List<UserListResponse> userItems, Context mctx){
        this.userItems = userItems;
        this.mctx = mctx;
    }
    @Override
    public int getCount() {
        return userItems.size();
    }

    @Override
    public Object getItem(int location) {
        return userItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null)
            inflater = LayoutInflater.from(mctx);

        if(convertView == null)
            convertView = inflater.inflate(R.layout.users_list_items,null);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView email = (TextView) convertView.findViewById(R.id.email);

        // getting model data for the row
        UserListResponse u = (UserListResponse) userItems.get(position);
        name.setText("Name: "+String.valueOf(u.getName()));
        email.setText("Email: "+String.valueOf(u.getEmail()));
        return convertView;
    }
}
