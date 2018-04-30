package com.example.dss22.a47animacion_objectanimator;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private RelativeLayout canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.faceIcon);
        canvas = (RelativeLayout) findViewById(R.id.animationCanvas);
    }

    public void onButtonClick(View v) {

        int screenHeight = canvas.getHeight();
        int targetY = screenHeight - imageView.getHeight();
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "y", 0, targetY)
                .setDuration(1000);
        animator.setInterpolator(new BounceInterpolator());
        animator.start();
    }


    public void onButtonClick2(View v) {

        int screenHeight = canvas.getHeight();
        int targetY = screenHeight - imageView.getHeight();
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "y", 0, targetY)
                .setDuration(4000);
        animator.setInterpolator(new CycleInterpolator(5));
        animator.start();
    }


    public void onButtonClick3(View v) {

        int screenW = canvas.getHeight();
        int targetX = screenW - imageView.getHeight();
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "y", 0, targetX)
                .setDuration(1000);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.start();
    }

    public void onButtonClick4(View v) {

        int screenHeight = canvas.getHeight();
        int targetY = screenHeight - imageView.getHeight();
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "y",0, targetY)
                .setDuration(1000);
        animator.setInterpolator(new BounceInterpolator());
        animator.reverse();
        animator.start();

        ReverseInterpolator reverseInterpolator = new ReverseInterpolator(new BounceInterpolator());
        animator.setInterpolator(reverseInterpolator);
    }

    public void onButtonClick5(View v) {

        int screenHeight = canvas.getHeight();
        int targetY = screenHeight - imageView.getHeight();
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "y", 0, targetY)
                .setDuration(900);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();
    }
}

class ReverseInterpolator implements Interpolator {
    private final Interpolator delegate;

    public ReverseInterpolator(Interpolator delegate){
        this.delegate = delegate;
    }

    public ReverseInterpolator(){
        this(new LinearInterpolator());
    }

    @Override
    public float getInterpolation(float input) {
        return 1 - delegate.getInterpolation(input);
    }
}
