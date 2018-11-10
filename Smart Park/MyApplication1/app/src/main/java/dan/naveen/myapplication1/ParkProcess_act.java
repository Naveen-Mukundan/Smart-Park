package dan.naveen.myapplication1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.ByteMatrix;
import com.google.zxing.qrcode.QRCodeWriter;


public class ParkProcess_act extends ActionBarActivity implements View.OnClickListener {

    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_process_act);
        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(this);
        Intent intent = getIntent();

     //   String dbString = intent.getStringExtra("un");
        String dbString1 = intent.getStringExtra("id");


     //   String content1 = " User_Name: " + dbString;
        String content2 = " " + dbString1;

        QRCodeWriter writer = new QRCodeWriter();
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        try {
            ByteMatrix bitMatrix = writer.encode("SP100", BarcodeFormat.QR_CODE, 512, 512);
            int width = 512;
            int height = 512;

            Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    if (bitMatrix.get(x, y) == 0)
                        bmp.setPixel(x, y, Color.BLACK);
                    else
                        bmp.setPixel(x, y, Color.WHITE);
                }
            }
            iv.setImageBitmap(bmp);
        } catch (WriterException e) {
            Toast.makeText(getApplicationContext(), "Error reported...", Toast.LENGTH_SHORT).show();

        }
    }

    @Override

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.next:
                startActivity(new Intent(this, parkprocess_act2.class));
                break;
        }
    }




}

