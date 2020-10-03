package com.example.canvasdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.jar.Attributes;

import javax.xml.transform.sax.TemplatesHandler;

public class Myview extends View {
    Paint p;
    int x = 0;

    public Myview(Context context) {
        super(context);
        init();
    }

    public Myview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    void init() {
        p = new Paint();
    }

    protected void onDraw(Canvas canvas) {


        canvas.drawColor(Color.RED);
        p.setColor(Color.YELLOW);
        p.setStrokeWidth(30);
    }
}
