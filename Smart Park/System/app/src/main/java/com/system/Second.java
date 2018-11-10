package com.system;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Second extends Activity {

    Button ad;
    EditText etid,etun,etamt,etpc;
    Dbhandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ad=(Button)findViewById(R.id.add);
        etid = (EditText) findViewById(R.id.editid);
        etun = (EditText) findViewById(R.id.editun);
        etamt = (EditText) findViewById(R.id.editamt);
        etpc = (EditText) findViewById(R.id.editpc);
        dbHandler = new Dbhandler(this);
    }
    public void add(View view) {

        Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_LONG).show();


        Register register1 = new Register(etid.getText().toString(),
                etun.getText().toString(),
                etamt.getText().toString(),
                etpc.getText().toString());

        dbHandler.add(register1);
        etid.setText("");
        etun.setText("");
        etamt.setText("");
        etpc.setText("");
        startActivity(new Intent(this,MainActivity.class));
    }


}
