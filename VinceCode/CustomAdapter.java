package com.example.danielle98.hogwartsdata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Serato on 4/16/2017.
 */

public class CustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<Wizard> wizards;
    LayoutInflater inflater;

    public CustomAdapter(Context c, ArrayList<Wizard> wizards) {
        this.c = c;
        this.wizards = wizards;
    }

    @Override
    public int getCount() {
        return wizards.size();
    }

    @Override
    public Object getItem(int position) {
        return wizards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater==null)
        {
            inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.searchres,parent,false);
        }
        TextView nameTxt= (TextView) convertView.findViewById(R.id.editNameTxt);
        nameTxt.setText(wizards.get(position).getName());
        final int pos=position;
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c,wizards.get(pos).getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
