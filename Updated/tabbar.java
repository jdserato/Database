package com.example.danielle98.hogwartsdata;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.danielle98.hogwartsdata.R.id.btnLogout;

public class tabbar extends AppCompatActivity {

    private TextView mTextMessage;
    Button btnLogout;
    Session session;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();

            // define your fragments here
            WizardFragment wizard = new WizardFragment();
            HouseFragment house = new HouseFragment();
            SearchFragment search = new SearchFragment();

            switch (item.getItemId()) {
                case R.id.navigation_wizard:
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.navigation_wizard, wizard).commit();
                    return true;
                case R.id.navigation_house:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.navigation_house, house).commit();
                    return true;
                case R.id.navigation_search:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.navigation_search, search).commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbar);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        session = new Session(this);
        if(!session.loggedin()){
            logout();
        }
        btnLogout = (Button) findViewById(R.id.btnLogout); //CREATE BTNLOGOUT AGAIN LATER
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });


    }

    private void logout(){
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(tabbar.this,Login.class));
    }

}
