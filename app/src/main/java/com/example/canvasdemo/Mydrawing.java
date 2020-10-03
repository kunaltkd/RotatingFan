package com.example.canvasdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

public class Mydrawing extends View {
    Path mypath;
    Paint mpaint;
    Mydrawing mydrawing;

    public Mydrawing(Context context) {
        super(context);
        mpaint = new Paint();
        mypath = new Path();
        mpaint.setColor(Color.BLACK);
        mpaint.setColor(Color.RED);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.CYAN);
        canvas.drawPath(mypath,mpaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
            mypath.moveTo(event.getX(),event.getY());
            break;
            case MotionEvent.ACTION_MOVE:
                mypath.lineTo(event.getX(),event.getY());
        }
        invalidate();
        return  true;
    }
}


