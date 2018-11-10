package dan.naveen.myapplication1;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class parkprocess_act5 extends Activity {

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parkprocess_act5);
        next = (Button) findViewById(R.id.butQR);
        try {
            Intent intent = new Intent("com.google.zxing.client.android.SCAN");
            intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
            startActivityForResult(intent, 0);    //Barcode Scanner to scan for us
        } catch (ActivityNotFoundException ae) {
            Toast.makeText(getApplicationContext(), "Download a scanner...", Toast.LENGTH_SHORT).show();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {

            TextView tvResult = (TextView) findViewById(R.id.tvResult);
            if (resultCode == RESULT_OK) {
                tvResult.setText(intent.getStringExtra("SCAN_RESULT"));
            } else if (resultCode == RESULT_CANCELED) {
                tvResult.setText("Scan cancelled.");
            }
        }

    }







    public void buttonclicked(View view)
    {
        startActivity(new Intent(this,MainActivity.class));
    }
}