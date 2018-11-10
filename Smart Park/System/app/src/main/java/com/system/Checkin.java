package com.system;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Checkin extends Activity implements View.OnClickListener {
    Button cin,cout,con;
    int op;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkin);
        cin=(Button)findViewById(R.id.checkin);
        cout=(Button)findViewById(R.id.checkout);
        con=(Button)findViewById(R.id.conf);
        cin.setOnClickListener(this);
        cout.setOnClickListener(this);
        con.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.checkin:
                op=1;
                Intent a=new Intent(Checkin.this,Scan.class);
                a.putExtra("flag",1);
                startActivity(a);

                break;

            case R.id.checkout:
                op=3;
                Intent b=new Intent(Checkin.this,Scan.class);
                b.putExtra("flag",3);
                startActivity(b);
                break;
            case R.id.conf:
                op=2;
                Intent c=new Intent(Checkin.this,Scan.class);
                c.putExtra("flag",2);
                startActivity(c);
                break;
        }
    }



}
