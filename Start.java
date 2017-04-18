//package com.example.danielle98.hogwartsdata;//package com.example.danielle98.hogwarts;
//
//import android.content.Intent;
//import android.os.Build;
//import android.os.Bundle;
//import android.support.annotation.IdRes;
//import android.support.annotation.RequiresApi;
//import android.support.v7.app.ActionBarActivity;
//import android.view.View;
//import android.widget.Button;
//
//import com.roughike.bottombar.BottomBar;
//import com.roughike.bottombar.OnMenuTabClickListener;
//import android.content.Intent;
//import android.support.annotation.IdRes;
//import android.support.v7.app.ActionBarActivity;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//import com.roughike.bottombar.BottomBar;
//import com.roughike.bottombar.BottomBarBadge;
//import com.roughike.bottombar.OnMenuTabClickListener;
//
//public class Start extends AppCompatActivity {
//    private Button btnLogout;
//    private Session session;
//    BottomBar botbar;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.bar);
//        botbar = BottomBar.attach(this,savedInstanceState);
//        botbar.setItemsFromMenu(R.menu.manu_file, new OnMenuTabClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
//            @Override
//            public void onMenuTabSelected(@IdRes int menuItemId) {
//                if(menuItemId == R.id.bottombarone) {
//                    WizardFragment w = new WizardFragment();
//                    getFragmentManager().beginTransaction().replace(R.id.frame, w).commit();
//                } else if(menuItemId == R.id.bottombartwo) {
//                    HouseFragment h = new HouseFragment();
//                    getFragmentManager().beginTransaction().replace(R.id.frame, h).commit();
//                } else if(menuItemId == R.id.bottombarthree) {
//                    SearchFragment s = new SearchFragment();
//                    getFragmentManager().beginTransaction().replace(R.id.frame, s).commit();
//                }
//            }
//
//            @Override
//            public void onMenuTabReSelected(@IdRes int menuItemId) {
//
//            }
//
//        });
//
//        botbar.mapColorForTab(0,"#8D6E63");
//        botbar.mapColorForTab(1,"#795548");
//        botbar.mapColorForTab(2,"#FFFFFF");
//
//
//        session = new Session(this);
//        if(!session.loggedin()){
//            logout();
//        }
//        btnLogout = (Button) findViewById(R.id.btnLogout); //CREATE BTNLOGOUT AGAIN LATER
//        btnLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                logout();
//            }
//        });
//
//    }
//
//    private void logout(){
//        session.setLoggedin(false);
//        finish();
//        startActivity(new Intent(Start.this,Login.class));
//    }
//}
//
