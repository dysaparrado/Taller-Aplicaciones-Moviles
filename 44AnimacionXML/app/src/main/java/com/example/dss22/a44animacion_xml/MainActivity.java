package com.example.dss22.a44animacion_xml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.faceIcon);
    }

    public void onButtonClick(View v) {
        Animation animation =
                AnimationUtils.loadAnimation(this, R.anim.desvanecer);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setScaleX(1);
                imageView.setScaleY(1);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });




        imageView.startAnimation(animation);
    }

    public void onButtonClick2(View v) {
        Animation animation =
                AnimationUtils.loadAnimation(this, R.anim.rotate);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setScaleX(1);
                imageView.setScaleY(1);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });




        imageView.startAnimation(animation);
    }

    public void onButtonClick3(View v) {
        Animation animation =
                AnimationUtils.loadAnimation(this, R.anim.moveriz);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setScaleX(1);
                imageView.setScaleY(1);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });




        imageView.startAnimation(animation);
    }

    public void onButtonClick4(View v) {
        Animation animation =
                AnimationUtils.loadAnimation(this, R.anim.moverder);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setScaleX(1);
                imageView.setScaleY(1);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });




        imageView.startAnimation(animation);
    }
}
