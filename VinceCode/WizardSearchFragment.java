package com.example.danielle98.hogwartsdata;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Danielle98 on 4/9/2017.
 */

public class WizardSearchFragment extends Fragment {

    View v;
    SearchView sv;
    ListView lv;
    CustomAdapter adapter;
    ArrayList<Wizard> wizards = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v  = inflater.inflate(R.layout.fragment_wizard_search,container,false);
        sv = (SearchView) v.findViewById(R.id.sv);
        lv = (ListView) v.findViewById(R.id.lv);
        return v;
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /*Button wizardSearch = (Button) v.findViewById(R.id.wizSearch);

        wizardSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), WizardSearch.class));
            }
        });*/

        adapter = new CustomAdapter(this.getContext(), wizards);

        sv.setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.length() > 0) {
                    getWizards(newText);
                } else {
                    getWizards("awqwpdw123dnawod");
                }
                return false;
            }
        });
    }

    private void getWizards(String searchTerm)
    {
        wizards.clear();
        DBHelper db=new DBHelper(this.getContext());
        db.openDB();
        Wizard p=null;

        Cursor c=db.retrieveUser(searchTerm);
        while (c.moveToNext())
        {
            int id=c.getInt(0);
            String name=c.getString(1);
            p=new Wizard();
            p.setId(id + "");
            p.setName(name);
            wizards.add(p);
        }
        db.close();
        lv.setAdapter(adapter);
    }
}
