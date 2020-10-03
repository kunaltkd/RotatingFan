package com.example.canvasdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    //Myview myview;
    ImageView b1;
    int cback,crect,ccircle;
    Canvas canvas=null;
    Paint p,pText;
    Bitmap bitmap;
    Rect r1;
    int Factor=100;
    int start= Factor;
    Fanview fanview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
       // myview = new Myview(this);
        //setContentView(myview);
        fanview= new Fanview(this);
        setContentView(fanview);
        b1=findViewById(R.id.b1);
        cback= ResourcesCompat.getColor(getResources(),R.color.c1,null);
        crect=ResourcesCompat.getColor(getResources(),R.color.c2,null);
        ccircle=ResourcesCompat.getColor(getResources(),R.color.c3,null);
        p= new Paint();
        pText =new Paint(Paint.UNDERLINE_TEXT_FLAG);
        pText.setTextSize(50);
        r1=new Rect();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    public void drawthis(View view) {
        int viewWidth= view.getWidth();
        int viewHeight= view.getHeight();
        int halfwidth =viewWidth/2;
        int halfheight = viewHeight/2;

         if(start  == Factor) {
             bitmap = Bitmap.createBitmap(viewWidth, viewHeight, Bitmap.Config.ARGB_8888);
             b1.setImageBitmap(bitmap);
             canvas = new Canvas(bitmap);
             canvas.drawColor(cback);
             pText.setColor(Color.WHITE);
             canvas.drawText("keep going",100,100,pText);
             start=start + Factor;
         }
         else {
             if (start < halfwidth && start < halfheight) {
                 p.setColor(crect - 200 * start);
                 canvas.drawRect(start, start, viewWidth - start, viewHeight - start, p);
                 start = start + Factor;

             }
             else {
                 p.setColor(ccircle);
                 canvas.drawCircle(halfwidth,halfheight,halfwidth/3,p);
                    canvas.drawText("Done",halfwidth,halfheight,pText);
             }
         }
         view.invalidate();

         }

    }
