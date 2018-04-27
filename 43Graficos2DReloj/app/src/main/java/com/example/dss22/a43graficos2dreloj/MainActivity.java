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

     int height, width = 0;
     boolean inicio;
     int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Reloj reloj = new Reloj(this);
        setContentView(reloj);
    }

    private class Reloj extends View {

        int letra = 0;
        int manecillas, mHora = 0;
        int radio = 0;
        Paint paint;

        private Rect rect = new Rect();

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
            letra = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, getResources().getDisplayMetrics());
            radio = (Math.min(height, width)) / 2 - 70;
            manecillas = (Math.min(height, width)) / 18;
            mHora = (Math.min(height, width)) / 8;
            paint = new Paint();
            inicio = true;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            if (inicio==false) {
                iniciar();
            }

            canvas.drawColor(Color.WHITE);
            dBase(canvas);
            dNumeros(canvas);
            dManecillas(canvas);
            postInvalidateDelayed(1000);
            invalidate();

        }

        private void dBase(Canvas canvas) {
            paint.reset();
            paint.setColor(getResources().getColor(android.R.color.darker_gray));
            paint.setStrokeWidth(3);
            paint.setAntiAlias(true);
            canvas.drawCircle(width / 2, height / 2, radio + 30 , paint);
        }

        private void dNumeros(Canvas canvas) {
            paint.setTextSize(letra);
            paint.setColor(getResources().getColor(android.R.color.white));
            for (int number : numeros) {
                String tmp = String.valueOf(number);
                paint.getTextBounds(tmp, 0, tmp.length(), rect);
                double angle = Math.PI / 6 * (number - 3);
                int x = (int) (width / 2 + Math.cos(angle) * radio - rect.width() / 2);
                int y = (int) (height / 2 + Math.sin(angle) * radio + rect.height() / 2);
                canvas.drawText(tmp, x, y, paint);
            }
        }

        private void manecilla(Canvas canvas, double loc, boolean isHour) {
            double angle = Math.PI * loc / 30 - Math.PI / 2;
            int handRadius = isHour ? radio - manecillas - mHora : radio - manecillas;
            canvas.drawLine(width / 2, height / 2,
                    (float) (width/ 2 + Math.cos(angle) * handRadius),
                    (float) (height / 2 + Math.sin(angle) * handRadius),
                    paint);
            canvas.drawText( loc+"",(float) (width/ 2 + Math.cos(angle) * handRadius),
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
