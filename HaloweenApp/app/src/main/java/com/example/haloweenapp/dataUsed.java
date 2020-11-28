//
//
//
//
//
//
//

package com.example.haloweenapp;

import android.graphics.Point;
import android.graphics.Rect;

public class dataUsed {

  private Point frameData;
  private int frameWidth;
  private int frameHeight;
  private Rect batRect;
  private int duckWidth;
  private int duckHeight;

  public dataUsed(int width, int height){
    setFrameWidth(width);
    setFrameHeight(width);
  }

  public void setFrameData(Point data) {
    frameData = data;
  }

  public void setFrameWidth(int width) {
    frameWidth = width;
  }

  public void setFrameHeight(int height) {
    frameHeight = height;
  }

  public int getFrameWidth() {
    return frameWidth;
  }

  public int getFrameHeight() {
    return frameHeight;
  }

  public void setbatRect( Rect newbatRect ) {
    if( newbatRect != null ) {
      duckWidth = newbatRect.right - newbatRect.left;
      duckHeight = newbatRect.bottom - newbatRect.top;
      batRect = newbatRect;
    }
  }

  public Rect getbatRect( ) {
    return batRect;
  }


}
