package dan.naveen.myapplication1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.ByteMatrix;
import com.google.zxing.qrcode.QRCodeWriter;


public class parkprocess_act3 extends Activity {

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parkprocess_act3);
        next = (Button) findViewById(R.id.next);

        String content2 = " ";

        QRCodeWriter writer = new QRCodeWriter();
        ImageView iv = (ImageView) findViewById(R.id.imageView1);
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


    public void buttonclicked(View view)
    {
        startActivity(new Intent(this,parkprocess_act4.class));
    }
}
