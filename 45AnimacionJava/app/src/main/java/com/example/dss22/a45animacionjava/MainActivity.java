package com.example.dss22.a45animacionjava;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
        imageView.animate().alpha(0).rotationY(360)
                .setDuration(3000)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        Log.i("Animation", "onAnimationStart");
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Log.i("Animation", "onAnimationEnd");
                        imageView.animate().alpha(1);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });

    }

    public void onButtonClick2(View v) {
        imageView.animate()
                .rotationX(360)
                .rotationY(180)
                .setDuration(3000)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        Log.i("Animation", "onAnimationStart");
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Log.i("Animation", "onAnimationEnd");
                        imageView.setX(192);
                        imageView.setY(164);


                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }

    public void onButtonClick3(View v) {
        imageView.animate()
                .translationY(800).rotation(360)
                .setDuration(3000)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        Log.i("Animation", "onAnimationStart");
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Log.i("Animation", "onAnimationEnd");
                        imageView.setScaleX(1);
                        imageView.setScaleY(1);
                        imageView.setX(192);
                        imageView.setY(164);

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }

    public void onButtonClick4(View v) {
        imageView.animate()
                .translationX(500).rotationY(180)
                .setDuration(3000)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        Log.i("Animation", "onAnimationStart");
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Log.i("Animation", "onAnimationEnd");
                        imageView.setScaleX(1);
                        imageView.setScaleY(1);
                        imageView.setX(192);
                        imageView.setY(164);

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }


}

