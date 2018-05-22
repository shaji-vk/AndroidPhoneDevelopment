package com.example.shaji.readdictionary;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MemberInfoArrayAdapter extends ArrayAdapter<MembersInfo> {
    private Context context;
    private List<MembersInfo> members;
    public MemberInfoArrayAdapter(Context context, int resource, ArrayList<MembersInfo> objects)
    {
        super(context,resource,objects);
        this.context = context;
        this.members=objects;
    }
    public View getView(int position,View convertView,ViewGroup parent){
        MembersInfo membersInfo = members.get(position);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.members_list,null);
        TextView lblNameValue=(TextView)view.findViewById(R.id.lblnamevalue);
        TextView lblDobValue = (TextView)view.findViewById(R.id.lbldobvalue);
        lblNameValue.setText(new StringBuilder().append(membersInfo.getFirstName()).append(", ").append(membersInfo.getLastName()).toString());
        lblDobValue.setText(membersInfo.getDateOfBirth());
        return view;
    }
}
