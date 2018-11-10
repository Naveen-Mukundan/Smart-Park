package com.system;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.ByteMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Print extends Activity{
    int a;
    TextView tc;

    static int[] park_1 = new int[]{1, 2, 3, 4, 5};
    static int[] park_2 = new int[]{6, 7, 8, 9, 10};
    int park_allot = 0;
    String result, pl, m, n, e1,disp_msg,dr, disp_qr=" ", o,aa;
    int count = 0,flag=8;
    Dbhandler db = new Dbhandler(Print.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);
        Intent intent = getIntent();
        a=intent.getIntExtra("choice",0);


            tc= (TextView) findViewById(R.id.printtext);
            result=intent.getStringExtra("id");

        try {
            switch (a) {
                case 1:
                    pl = db.getamount(result);

                    int amt = Integer.valueOf(pl);
                    if (amt > 80) {
                        dr = db.getparkcount(result);
                        count = Integer.parseInt(dr);
                        if (count > 50) {
                            for (int i = 0; i < 5; i++) {
                                if (park_2[i] != 0) {
                                    park_allot = park_2[i];
                                    park_2[i] = 0;
                                    break;
                                }
                            }
                        } else {
                            for (int i = 0; i < 5; i++) {
                                if (park_1[i] != 0) {
                                    park_allot = park_1[i];
                                    park_1[i] = 0;
                                    break;
                                }
                            }
                        }
                        if (park_allot == 0) {
                            disp_msg = "Parking Full...";
                            flag=0;
                        }
                        //give the textview value as Parking full...
                        //enter the id,start time ,park_allot,status=0 into the db_table_2
                        else {
                            Calendar c = Calendar.getInstance();
                            SimpleDateFormat sdf = new SimpleDateFormat("HH");
                            String strDate = sdf.format(c.getTime());
                            SimpleDateFormat sdf1 = new SimpleDateFormat("mm");
                            String strDate1 = sdf1.format(c.getTime());
                            String pal = String.valueOf(park_allot);

                            String li = "1";
                            aa = db.update(result, strDate, strDate1, pal, li);

                            disp_qr = pal;
                            park_allot = 0;
                            disp_msg = "Please do park in the given slot";
                        }
                    } else {
                        disp_msg = "Minimum balance required.Please recharge!!!";
                        flag=1;
                    }

                    break;
                case 2:

                    pl = db.getallocation(result);
                    int palc = Integer.parseInt(pl);
                    if (palc == 1) {
                        Calendar c = Calendar.getInstance();
                        SimpleDateFormat sdf = new SimpleDateFormat("HH");
                        int e_h = Integer.parseInt(sdf.format(c.getTime()));
                        SimpleDateFormat sdf1 = new SimpleDateFormat("mm");
                        int e_m = Integer.parseInt(sdf1.format(c.getTime()));

                        m = db.getstarthr(result);
                        n = db.getstartmin(result);

                        int s_h = Integer.parseInt(m);
                        int s_m = Integer.parseInt(n);

                        int diff = (e_h - s_h) * 60;
                        if (e_m > s_m) {
                            diff += (e_m - s_m);
                        } else {
                            diff -= (e_m - s_m);
                        }

                        if (diff <= 2) {
                            db.updatestatus(result, "2");
                            disp_msg = "Thanks for the confirmation";
                            flag=2;
                        } else {
                            disp_msg = "You have been fined for delay in confirmation";
                            flag=3;
                        }
                    } else {
                        disp_msg = "Please do park in the slot allotted";
                        flag=4;
                    }

                    break;
                case 3:

                    m = db.getstarthr(result);
                    n = db.getstartmin(result);
                    o = db.getamount(result);
                    dr = db.getparkcount(result);
                    int pc = Integer.parseInt(dr);
                    int amt1 = Integer.parseInt(o);
                    int s_h = Integer.parseInt(m);
                    int s_m = Integer.parseInt(n);

                    pl = db.getallocation(result);
                    int plot = Integer.parseInt(pl);
                    e1 = db.getstatus(result);
                    int tot = 0;
                    tot += 20;
                    Calendar c = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("HH");
                    int e_h = Integer.parseInt(sdf.format(c.getTime()));
                    SimpleDateFormat sdf1 = new SimpleDateFormat("mm");
                    int e_m = Integer.parseInt(sdf1.format(c.getTime()));
                    int diff = (e_h - s_h) * 60;
                    if (e_m > s_m) {
                        diff += (e_m - s_m);
                    } else {
                        diff -= (e_m - s_m);
                    }

                    diff = diff / 60;
                    if (diff > 2) {
                        tot += (diff * 25);

                    }
                    amt1 -= tot;

                    disp_msg = "Scan here for your receipt.";
                    disp_qr = "Amount:Rs" + tot + "+Duration:" + diff + "hr(s)+Remaining Balance:Rs" + amt1;
                    if (e1.equals("1")) {
                        amt1 -= 50;
                        disp_msg+="You are fined!";
                    }
                    m = "0";
                    n = "0";
                    o = String.valueOf(amt1);
                    pl = "0";
                    e1 = "0";
                    pc++;
                    dr = String.valueOf(pc);
                    db.updatefinal(result, m, n, pl, e1, o, dr);
                    if (plot > 5) {
                        park_2[plot - 6] = plot;
                    } else {
                        park_1[plot - 1] = plot;
                    }
                    break;
            }
        }
        catch(Exception e)
        {
            disp_msg="Invalid ID.Please try again!!!";
            flag=5;
        }

        QRCodeWriter writer = new QRCodeWriter();
        ImageView iv = (ImageView) findViewById(R.id.printimage);
         tc.setText(disp_msg);
        try {
            ByteMatrix bitMatrix = writer.encode(disp_qr, BarcodeFormat.QR_CODE, 512, 512);
            int width = 512;
            int height = 512;

            Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    if (bitMatrix.get(x,y) == 0)
                        bmp.setPixel(x, y, Color.BLACK);
                    else
                        bmp.setPixel(x, y, Color.WHITE);
                }
            }
            iv.setImageBitmap(bmp);
        } catch (WriterException e) {}
        switch(flag) {
            case 0:
                iv.setImageResource(R.drawable.full);
                break;
            case 1:
                iv.setImageResource(R.drawable.recharge);
                break;
            case 2:
                iv.setImageResource(R.drawable.tick);
                break;
            case 3:
                iv.setImageResource(R.drawable.fined);
                break;
            case 4:
                iv.setImageResource(R.drawable.x);
                break;
            case 5:
                iv.setImageResource(R.drawable.invalid);
                break;
        }
    }



}
