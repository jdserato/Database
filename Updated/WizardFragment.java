package com.example.danielle98.hogwartsdata;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Danielle98 on 4/9/2017.
 */

public class WizardFragment extends Fragment {

    private TextView mTextMessage;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.fragment_search,container,false);
        return v;
    }

}
