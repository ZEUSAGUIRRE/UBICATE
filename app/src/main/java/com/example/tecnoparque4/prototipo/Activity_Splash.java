package com.example.tecnoparque4.prototipo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Activity_Splash extends Activity {

    public void onAttachedToWindow(){
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }
    Thread splashTread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__splash);
        Activity a = new Activity_Splash();
        RelativeLayout ven = (RelativeLayout)findViewById(R.id.ventana_splash);
        RelativeLayout ani = (RelativeLayout)findViewById(R.id.Layou_logo);
        ComenzarAnimacion(ven,ani);
    }
    public void ComenzarAnimacion(RelativeLayout ventana,RelativeLayout Anim){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.alp);
        animation.reset();

        RelativeLayout L =  ventana;//(RelativeLayout)findViewById(R.id.ventana_splash);
        L.clearAnimation();

        L.startAnimation(animation);

        animation = AnimationUtils.loadAnimation(this,R.anim.traslate);
        animation.reset();
        RelativeLayout Logotipo = Anim;//(RelativeLayout) findViewById(R.id.Layou_logo);
        Logotipo.clearAnimation();
        Logotipo.startAnimation(animation);

        splashTread = new Thread(){
          @Override
            public void run(){
              try {
                  int waited = 0 ;
                  while (waited < 3500){
                         sleep(100);
                         waited +=100;
                  }
                  Activity_Splash.this.finish();
                  Intent intent = new Intent(Activity_Splash.this,Activity_Login.class);
                  startActivity(intent);
              }catch (InterruptedException e){
              // no hacer nada
              } finally {

              }
          }
        };
        splashTread.start();

    }

}
