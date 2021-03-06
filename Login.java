package com.example.danielle98.hogwartsdata;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




public class Login extends AppCompatActivity implements View.OnClickListener{
    private EditText etName,etPass;
    private String name;
    private Button login,register;
    private DBHelper db;
    private Session session;

    public Login() {
        //constructor

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DBHelper(this);
        session = new Session(this);
        login = (Button)findViewById(R.id.btnLogin);
        register = (Button)findViewById(R.id.btnReg);
        etName = (EditText)findViewById(R.id.etName);
        etPass = (EditText)findViewById(R.id.etPass);
        login.setOnClickListener(this);
        register.setOnClickListener(this);

        Typeface typeface=Typeface.createFromAsset(getAssets(), "fonts/times.ttf");
        etName.setTypeface(typeface);
        etPass.setTypeface(typeface);


        if(session.loggedin()){
            startActivity(new Intent(Login.this,tabbar.class));
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnLogin:
               login();
                break;
            case R.id.btnReg:
                startActivity(new Intent(Login.this,Register.class));
                break;
            default:
        }
    }

    private void login(){
        name = etName.getText().toString();
        WizardFragment wizardName = new WizardFragment();
        wizardName.storage(name);
        String pass = etPass.getText().toString();
        WizardFragment wiz = new WizardFragment();
        wiz.storage(name);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("name",name);
        edit.apply();

        if(db.getUser(name,pass)){
            session.setLoggedin(true);

            startActivity(new Intent(Login.this,tabbar.class));
            //finish();
        } else {
           Toast.makeText(getApplicationContext(),"Wrong Wizard Name/Password", Toast.LENGTH_LONG).show();
        }
    }

    public String getName(){

        return name;
    }

}
