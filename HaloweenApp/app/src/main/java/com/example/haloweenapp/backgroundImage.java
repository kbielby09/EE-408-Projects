////////////////////////////////////////////////////////////////////////////////
//File:           backgroundImage.java
//Authors:        Kyle Bielby
//Date Created:   10/10/2020
//Description: This java file creates that background image that the bat is
//             to be animated with it will consist of a house
////////////////////////////////////////////////////////////////////////////////

package com.example.haloweenapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.graphics.Path;

public class backgroundImage extends View {
  private Paint paint;
  private int frameWidth;
  private int frameHeight;

  private dataUsed data;
  private Bitmap [] bat;

  public backgroundImage( Context context, int width, int height ) {
    super( context );



  }

  public void onDraw( Canvas canvas){
    super.onDraw( canvas );

    //draw background
    Paint paint = new Paint();
    paint.setColor(	Color.rgb(32,32,32) ); //0xA9A9A9 );
    paint.setStrokeWidth( 10 );
    canvas.drawRect(0, 0, 1100, 1200, paint);
    paint.setColor(Color.rgb(128,128,128));
    canvas.drawRect(0, 1200, 1100, 3000, paint);

    //draw left side of house
    paint.setColor(0xff3a3ab8);
    paint.setStyle(Paint.Style.FILL);
    Path lefthouseFront = new Path();
    lefthouseFront.moveTo((float) 500, (float) 1200);
    lefthouseFront.lineTo((float) 500, (float) 900);
    lefthouseFront.lineTo((float) 370, (float) 800);
    lefthouseFront.lineTo((float) 800, (float) 800);
    lefthouseFront.lineTo((float) 850, (float) 960);
    lefthouseFront.lineTo((float) 800, (float) 960);
    lefthouseFront.lineTo((float) 800, (float) 1200);
    lefthouseFront.lineTo((float) 500, (float) 1200);
    lefthouseFront.close();
    canvas.drawPath(lefthouseFront, paint);

    //set roof outline
    paint.setColor( 0xff242062 );
    paint.setStrokeWidth(30);
    paint.setStrokeCap(Paint.Cap.ROUND);
    canvas.drawLine((float) 500, (float) 960, (float) 850, (float) 960, paint);


    //draw front of House
    paint.setColor(0xff5151cd);
    paint.setStyle(Paint.Style.FILL);
    Path houseFront = new Path();
    houseFront.moveTo((float) 500, (float) 1200);
    houseFront.lineTo((float) 100, (float) 1200);
    houseFront.lineTo((float) 100, (float) 900);
    houseFront.lineTo((float) 500, (float) 900);
    houseFront.lineTo((float) 500, (float) 1200);
    houseFront.close();
    canvas.drawPath(houseFront, paint);

    Path topHouseFront = new Path();
    topHouseFront.moveTo((float) 100, (float) 900);
    topHouseFront.lineTo((float) 500, (float) 900);
    topHouseFront.lineTo((float) 290, (float) 700);
    topHouseFront.lineTo((float) 100, (float) 900);
    houseFront.close();
    canvas.drawPath(topHouseFront, paint);

    //set roof outline
    paint.setColor( 0xff242062 );
    paint.setStrokeWidth(30);
    paint.setStrokeCap(Paint.Cap.ROUND);
    canvas.drawLine((float) 100, (float) 900, (float) 290, (float) 700, paint);
    canvas.drawLine((float) 290, (float) 700, (float) 500, (float) 900, paint);

    // Draw moon
    paint.setColor( Color.WHITE );
    canvas.drawCircle( (float) 800, (float) 300, (float) 80, paint );
    paint.setColor( Color.rgb(32,32,32) );
    canvas.drawCircle( (float) 720, (float) 300, (float) 80, paint );



    // draw animated bat
    Bitmap [] bat = new Bitmap[1];
    bat[0] = BitmapFactory.decodeResource(getResources(), R.drawable.unnamed);

    Rect batRect = new Rect( 800, 400, 900, 500 );

    canvas.drawBitmap( bat[0], null, batRect, paint );

  }

}
