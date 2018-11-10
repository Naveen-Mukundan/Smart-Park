package dan.naveen.myapplication1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;

public class MainActivity extends Activity{


     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     /*   MediaPlayer mp=new MediaPlayer();
         mp=MediaPlayer.create(this,R.raw.mysound);
         mp.start();
       mp.setLooping(true);*/
         final Handler mHandler = new Handler();
         final Runnable mNextActivityCallback = new Runnable() {
             @Override
             public void run() {
                 Intent myIntent = new Intent(MainActivity.this, Login.class);
                 startActivity(myIntent);
                 finish();
             }
         };
         new Thread(){
             @Override
             public void run() {
                 SystemClock.sleep(2000);
                 mHandler.post(mNextActivityCallback);
             }

         }.start();
       }


}
