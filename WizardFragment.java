package com.example.danielle98.hogwartsdata;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Danielle98 on 4/9/2017.
 */

public class WizardFragment extends Fragment {

    View v;
    String etname;
    String etHouse;



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v  = inflater.inflate(R.layout.fragment_wizard,container,false);
        return v;
    }

    public void storage(String name){
        etname = name;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DBHelper db = new DBHelper(getActivity());
        db.openDB();
        String temp;
        temp = db.getTextTemp();
        String temporary;

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String stringName = prefs.getString("name","");


        temporary = db.getDetails(stringName);
        TextView texti = (TextView) v.findViewById(R.id.textView7);
        texti.setText(temporary);
        TextView textName = (TextView) v.findViewById(R.id.textView9);
        textName.setText(stringName);

        //String [] text = db.getDetails();

        /*DBHelper db = new DBHelper(getActivity());
        db.openDB();

        String[] text = db.getDetails();
        TextView texti = (TextView) v.findViewById(R.id.textView7);
        texti.setText(text[0]);

        db.close();
        */
    }


}
