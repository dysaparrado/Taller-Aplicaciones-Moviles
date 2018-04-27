package com.example.dss22.a43graficos2dreloj;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Reloj reloj = new Reloj(this);
        setContentView(reloj);
    }

    private class Reloj extends View {

        private int width,height;
        private int fontSize = 0;
        private int handTruncation,hourHandTruncation =0;
        private int radius = 0;
        private Paint paint;
        private boolean isInit;
        private int[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12};;
        private Rect rect = new Rect();
        public int hour,minute,second =0;
        private boolean started = false;


        public Reloj(Context context) {
            super(context);
        }

        public Reloj(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public Reloj(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        private void iniciar() {

            height = getHeight();
            width = getWidth();
            fontSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, getResources().getDisplayMetrics());
            int min = Math.min(height,width);
            radius =min/2 - 70;
            handTruncation = min/18;
            hourHandTruncation = min/8;
            paint = new Paint();
            isInit=true;

        }

        @Override
        protected void onDraw(Canvas canvas) {
            if(!isInit){
                iniciar();
            }

            canvas.drawColor(Color.WHITE);
            dBase(canvas);
            dNumeros(canvas);
            drawHands(canvas,hour,minute,second);
            //dManecillas(canvas);

            if(!started){
                started=true;
                new Thread() {
                    public void run() {
                        try{
                            for(hour=12;hour>=0;hour--){
                                for(minute=60;minute>=0;minute-=5){
                                    for(second=60;second>=0;second--){
                                        Thread.sleep(22);
                                    }
                                }
                                if(hour==0)hour=12;
                            }
                        }catch (Exception e){
                            System.out.println(e);
                        }
                    }
                }.start();
            }
            postInvalidateDelayed(10);


        }

        private void dBase(Canvas canvas) {
            paint.reset();
            paint.setColor(getResources().getColor(android.R.color.darker_gray));
            paint.setStrokeWidth(3);
            paint.setAntiAlias(true);
            canvas.drawCircle(width / 2, height / 2, radius + 30 , paint);
        }

        private void dNumeros(Canvas canvas) {
            paint.setTextSize(fontSize);
            paint.setColor(getResources().getColor(android.R.color.white));
            for (int number : numbers) {
                String tmp = String.valueOf(number);
                paint.getTextBounds(tmp, 0, tmp.length(), rect);
                double angle = Math.PI / 6 * (number - 3);
                int x = (int) (width / 2 + Math.cos(angle) * radius - rect.width() / 2);
                int y = (int) (height / 2 + Math.sin(angle) * radius + rect.height() / 2);
                canvas.drawText(tmp, x, y, paint);
            }
        }


        private void drawHands(Canvas canvas,int hour,int minute,int second) {
            paint.setStrokeWidth(7);
            paint.setColor(getResources().getColor(android.R.color.white));
            drawHand(canvas,hour*5 - (60-minute)/60,true);
            paint.setStrokeWidth(4);
            drawHand(canvas,minute,false);
            paint.setStrokeWidth(3);
            paint.setColor(getResources().getColor(android.R.color.holo_red_dark));
            drawHand(canvas,second,false,"");
        }

        private void drawHand(Canvas canvas,float num,boolean isHour){
            double angle = Math.PI*num /30-Math.PI/2;
            int handRadius = isHour ? radius - handTruncation - hourHandTruncation: radius-handTruncation;
            canvas.drawLine(width/2,height/2,
                    (float)(width/2 - Math.cos(angle)*handRadius),
                    (float)(height/2 + Math.sin(angle)*handRadius),
                    paint);
        }
        private void drawHand(Canvas canvas,float num,boolean isHour,String x){
            double angle = Math.PI*num /30-Math.PI/2;
            int handRadius = isHour ? radius - handTruncation - hourHandTruncation: radius-handTruncation;
            canvas.drawLine(width/2,height/2,
                    (float)(width/2 - Math.cos(angle)*handRadius),
                    (float)(height/2 + Math.sin(angle)*handRadius),
                    paint);
        }

        private void manecilla(Canvas canvas, double loc, boolean isHour) {
            double angle = Math.PI * loc / 30 - Math.PI / 2;
            int handRadius = isHour ? radius - handTruncation - hourHandTruncation: radius-handTruncation;
            canvas.drawLine(width / 2, height / 2,
                    (float) (width/ 2 + Math.cos(angle) * handRadius),
                    (float) (height / 2 + Math.sin(angle) * handRadius),
                    paint);
        }


        private void dManecillas(Canvas canvas) {
            Calendar cal = Calendar.getInstance();
            float hora = cal.get(Calendar.HOUR_OF_DAY);
            hora = hora > 12 ? hora - 12 : hora;
            paint.setStrokeWidth(7);
            paint.setColor(getResources().getColor(android.R.color.white));
            manecilla(canvas, (hora + cal.get(Calendar.MINUTE) / 60) * 5f, true);
            paint.setStrokeWidth(4);
            manecilla(canvas, cal.get(Calendar.MINUTE), false);
            paint.setStrokeWidth(3);
            paint.setColor(getResources().getColor(android.R.color.holo_red_dark));
            manecilla(canvas, cal.get(Calendar.SECOND), false);
        }


    }

}
