package com.example.canvasdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Fanview extends SurfaceView implements Runnable {
    Canvas canvas;
    SurfaceHolder surfaceHolder;
    Paint paint;
    Thread t = null;
    boolean isRotating;
    int x = 0;

    public Fanview(Context context) {
        super(context);
        surfaceHolder = getHolder();
        paint = new Paint();
        isRotating = false;

        surfaceHolder.addCallback(new SurfaceHolder.Callback() {

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                startThread();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });

    }

    public void startThread() {
        isRotating = true;
        t = new Thread(this);
        t.start();
    }

    public void stopthread() {
        isRotating = false;
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (isRotating) {
            if (surfaceHolder.getSurface().isValid()) {
                canvas = surfaceHolder.lockCanvas();
                canvas.drawColor(Color.YELLOW);
                paint.setColor(Color.GREEN);
                canvas.drawArc(400, 400, 1000, 1000, x, 30, true, paint);

                canvas.drawArc(400, 400, 1000, 1000, x + 120, 30, true, paint);
                canvas.drawArc(400, 400, 1000, 1000, x + 240, 30, true, paint);
                x = x + 10;
                if (canvas != null)
                    surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }

    }
}

  //  @Override
   // public boolean onTouchEvent(MotionEvent event) {
    //    int x1 = (int) event.getX();
      //  int y1 = (int) event.getY();

        //if (r1.contains(x1, y1)) {

         //   switch (event.getAction())
     //   {
          //  case  MotionEvent.ACTION_DOWN:
           //  startThread();
              //  break;
          //  case  MotionEvent.ACTION_UP:
            //    stopthread();
        //        break;
      //  }
    //    return true;
  //  }
//}
