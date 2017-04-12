package com.example.danielle98.hogwartsdata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Danielle98 on 4/9/2017.
 */

public class SearchFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.fragment_search,container,false);
        return v;
    }
}
