package com.muyunfan.mytaxil;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            AnimatedVectorDrawable anim = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.anim);
            ImageView img = (ImageView) findViewById(R.id.logo);
            img.setImageDrawable(anim);
            anim.start();
        }
    }
}
