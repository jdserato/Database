package com.example.danielle98.hogwartsdata;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{
    private Button reg;
    private TextView tvLogin;
    private EditText etName, etPass,etconPass;
    private TextView errorReport;
    private String house = "";

    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DBHelper(this);
        reg = (Button)findViewById(R.id.btnReg);
        tvLogin = (TextView) findViewById(R.id.tvLogin);
        etName = (EditText) findViewById(R.id.etName);
        etPass = (EditText)findViewById(R.id.etPass);
        etconPass = (EditText)findViewById(R.id.etconPass);
        errorReport = (TextView) findViewById(R.id.error);
//        etHouse = (EditText)findViewById(R.id.etHouse);
        reg.setOnClickListener(this);
        tvLogin.setOnClickListener(this);

        Spinner spinner = (Spinner) findViewById(R.id.etHouse);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.house_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnReg:
                register();
                break;
            case R.id.tvLogin:
                startActivity(new Intent(Register.this,Login.class));
                finish();
                break;
            default:
        }
    }

    private void register(){
        errorReport.setVisibility(View.INVISIBLE);
        String name = etName.getText().toString();
        String pass = etPass.getText().toString();
        String conpass = etconPass.getText().toString();

        if(name.isEmpty() || pass.isEmpty()){
            displayToast("Wizard Name/Password field empty.");
            etName.setText("");
        } else if(!(conpass.equals(pass))){
            displayToast("Please re-confirm password.");
        } else if(pass.length() < 8) {
            errorReport.setText(R.string.passwordErr);
            errorReport.setVisibility(View.VISIBLE);
        }
        else {
            try {
                db.addUser(name, pass, house);
                displayToast("Wizard Registered");
                finish();
            } catch (SQLiteException e) {
                errorReport.setText(String.format("\"%s\" %s", name, getString(R.string.nameErr)));
                errorReport.setVisibility(View.VISIBLE);
                etName.setText("");
            }
        }

        etPass.setText("");
        etconPass.setText("");
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selected = parent.getItemAtPosition(position).toString();
        house = selected;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
