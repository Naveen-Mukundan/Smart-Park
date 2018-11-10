package com.system;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {


    Button add, sy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    add=(Button)findViewById(R.id.addu);
     sy=(Button)findViewById(R.id.sys);

    add.setOnClickListener(this);
    sy.setOnClickListener(this);
}
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addu:

                startActivity(new Intent(this,Second.class));
                break;

            case R.id.sys:
                startActivity(new Intent(this,Checkin.class));
                break;
        }
    }


}
