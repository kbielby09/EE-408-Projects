package com.example.haloweenapp;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.media.MediaPlayer;


public class MainActivity extends Activity {

    private backgroundImage backgroundView;
    private dataUsed data;
    private MediaPlayer mp;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );

        // get status bar height
        Resources res = getResources( );
        int statusBarHeight = 0;
        int statusBarId =
                res.getIdentifier( "status_bar_height", "dimen", "android" );
        if( statusBarId > 0 )
            statusBarHeight = res.getDimensionPixelSize( statusBarId );

        Point size = new Point( );
        getWindowManager( ).getDefaultDisplay( ).getSize( size );
         backgroundView = new backgroundImage( this, size.x, size.y - statusBarHeight );
        setContentView( backgroundView );

        // starts the music
        String mp3File = "raw/TchaikovskyDance.mp3";
        mp = MediaPlayer.create(this, R.raw.spooky);
        mp.start();

      }
}
