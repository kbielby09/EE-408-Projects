package edu.clarkson.ee408;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.clarkson.ee408.R;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mp;
    private TextView display;
    private TextView statusBar;
    private Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, bPlus, bMinus, bMult, bDiv, bClear, bEq;

///////////////////////////////// Check Input String for Large Number //////////////////////////////
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void checkString(String newBuffer) throws Exception {
        for(int i = 0; i < newBuffer.length(); i++){

        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b0 = (Button)findViewById(R.id.button0);
        b1 = (Button)findViewById(R.id.button1);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);
        b5 = (Button)findViewById(R.id.button5);
        b6 = (Button)findViewById(R.id.button6);
        b7 = (Button)findViewById(R.id.button7);
        b8 = (Button)findViewById(R.id.button8);
        b9 = (Button)findViewById(R.id.button9);
        b10 = (Button)findViewById(R.id.buttonLeftPar);
        b11 = (Button)findViewById(R.id.buttonRightPar);
        bPlus = (Button)findViewById(R.id.buttonPlus);
        bMinus = (Button)findViewById(R.id.buttonMinus);
        bMult = (Button)findViewById(R.id.buttonMult);
        bDiv = (Button)findViewById(R.id.buttonDiv);
        bClear = (Button)findViewById(R.id.buttonClear);
        bEq = (Button)findViewById(R.id.buttonEq);

        display = (TextView) findViewById(R.id.display);

//////////////////////////////////// Create Status Bar /////////////////////////////////////////////
        statusBar = (TextView) findViewById(R.id.statusBar);
////////////////////////////////////////////////////////////////////////////////////////////////////



        View.OnClickListener lNum = new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {

                Button b = (Button)v;

                try{
                    display.setText(display.getText().toString()+b.getText().toString());
                    statusBar.setText("");
                }
                catch (Exception excep){
                    statusBar.setText(excep.getLocalizedMessage());
                    display.setText("");
                }
            }
        };

        View.OnClickListener lOp = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button)v;

                try{
                    display.setText(display.getText().toString() + b.getText().toString());
                    statusBar.setText("");
                }
                catch (Exception excep){
                    statusBar.setText(excep.getLocalizedMessage());
                    display.setText("");
                }

            }
        };

        View.OnClickListener lDo = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    display.setText(Integer.toString(ParserII.DO(display.getText().toString())));//Integer.toString(result));     // TODO implemented Parser
                    statusBar.setText("");
                }
                catch (Exception excep) {
                    statusBar.setText(excep.getLocalizedMessage());
                    display.setText("");
                }
            }
    };

    /////////////////////////////////// On Click Listener for Clear Button /////////////////////////////
    View.OnClickListener Clr = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            display.setText("");
        }
    };
////////////////////////////////////////////////////////////////////////////////////////////////////

        b0.setOnClickListener(lNum);
        b1.setOnClickListener(lNum);
        b2.setOnClickListener(lNum);
        b3.setOnClickListener(lNum);
        b4.setOnClickListener(lNum);
        b5.setOnClickListener(lNum);
        b6.setOnClickListener(lNum);
        b7.setOnClickListener(lNum);
        b8.setOnClickListener(lNum);
        b9.setOnClickListener(lNum);
        b10.setOnClickListener(lNum);
        b11.setOnClickListener(lNum);

        bPlus.setOnClickListener(lOp);
        bMinus.setOnClickListener(lOp);
        bMult.setOnClickListener(lOp);
        bDiv.setOnClickListener(lOp);
////////////////////////////////// Set Click Listener for Clear Button /////////////////////////////
        bClear.setOnClickListener(Clr);
////////////////////////////////////////////////////////////////////////////////////////////////////
        bEq.setOnClickListener(lDo);

    // starts the music
    //mp = MediaPlayer.create(this, R.raw.myhouse);
    //mp.start();

}
}
