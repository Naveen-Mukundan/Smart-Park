package com.system;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


public class Scan extends Activity {
    String result;
    int ch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        Intent intent = getIntent();
        ch = intent.getIntExtra("flag",0);

        try {
            Intent intent1 = new Intent("com.google.zxing.client.android.SCAN");
            intent1.putExtra("SCAN_MODE", "QR_CODE_MODE");
            startActivityForResult(intent1, 0);    //Barcode Scanner to scan for us
        } catch (ActivityNotFoundException ae) {
            Toast.makeText(getApplicationContext(), "Download a scanner...", Toast.LENGTH_SHORT).show();
        }

    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {

            if (resultCode == RESULT_OK) {
                result = intent.getStringExtra("SCAN_RESULT");

            } else if (resultCode == RESULT_CANCELED) {

                Toast.makeText(Scan.this, "Invalid Scanner.. ", Toast.LENGTH_LONG).show();
            }
        }
        Intent a=new Intent(Scan.this,Print.class);
        a.putExtra("choice",ch);
        a.putExtra("id",result);
        startActivity(a);
    }
}






