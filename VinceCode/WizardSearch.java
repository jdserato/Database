package com.example.danielle98.hogwartsdata;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class WizardSearch extends AppCompatActivity {

    ListView lv;
    SearchView sv;
    CustomAdapter adapter;
    ArrayList<Wizard> wizards = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wizard_search);

        lv = (ListView) findViewById(R.id.lv);
        sv = (SearchView) findViewById(R.id.sv);

        adapter = new CustomAdapter(this, wizards);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        DBHelper db=new DBHelper(this);
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
