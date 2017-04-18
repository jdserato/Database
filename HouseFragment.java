package com.example.danielle98.hogwartsdata;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Danielle98 on 4/9/2017.
 */

public class HouseFragment extends Fragment{
    private DBHelper db;
    View v;
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       v  = inflater.inflate(R.layout.fragment_house,container,false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button bulletin = (Button)v.findViewById(R.id.button);
        Button sched = (Button)v.findViewById(R.id.button2);
        Button owls = (Button)v.findViewById(R.id.button3);

        bulletin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),assigns.class));
            }
        });
        sched.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),sched.class));
            }
        });
        owls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),owls.class));
            }
        });
    }

}
