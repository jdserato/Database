package com.example.danielle98.hogwartsdata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Danielle98 on 4/9/2017.
 */

public class SearchFragment extends Fragment {
    String[] items;
    ArrayList<String> listitems;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;
    View v;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v  = inflater.inflate(R.layout.fragment_search,container,false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = (ListView)v.findViewById(R.id.listview);
        editText = (EditText)v.findViewById(R.id.txtsearch);
        initList();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().equals("")){
                    initList();
                } else {
                    searchItem(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void searchItem(String texttoSearch){
        for(String item: items){
            if(!item.contains(texttoSearch)){
                listitems.remove(item);
            }
        }

        adapter.notifyDataSetChanged();
    }

    public  void initList(){
        items = new String[]{"Petrificus Totalus", "Lumos","Expelliarmus","Alohamora","Stupefy",
                "Impedimenta", "Imperio", "Accio", "Crucio","Avada Kadavra","Deprimo","Diffindo","Dissendium","Duro","Nox",
                "Obliviate","Obscuro","Orchideous","Reducto","Relashio","Rennervate","Reparo","Repello Muggletum","Rictusempra",
                "Riddikulus","Salvio Hexio","Sectumsempra","Serpensortio", "Silencio","Sonorus","Specialis Revelio",
                "Tarantallegra","Tergeo","Waddiwasi","Wingardium Leviosa"};

        listitems = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(getActivity(),R.layout.list_item,R.id.txtitem,listitems);
        listView.setAdapter(adapter);
    }
}
