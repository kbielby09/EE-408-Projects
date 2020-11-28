package com.jblearning.candystorev5;

import android.app.DatePickerDialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Context;

import java.util.ArrayList;

public class DeleteActivity extends AppCompatActivity {
  private DatabaseManager dbManager;
  private boolean deletionChoice = false;


  public void onCreate( Bundle savedInstanceState ) {
    super.onCreate( savedInstanceState );
    dbManager = new DatabaseManager( this );
    updateView( );
  }

  //////////////// Function that Displays Alert Dialog when of button is pressed ///////////////////
  public void displayAlertDialog() {
    final boolean Choice;
    AlertDialog.Builder builder = new AlertDialog.Builder( this );
    builder.setMessage("Do you want to delete the selected elements:");
    builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialogInterface, int i) {
        setDeletionChoice(false);
      }
    });
    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int id) {
        setDeletionChoice(true);
      }
    });
    AlertDialog alert = builder.create();
    alert.show();
  }
  //////////////////////////////////////////////////////////////////////////////////////////////////

  /////////////////////////// Function that Sets Deletion Choice from User /////////////////////////
  public void setDeletionChoice(boolean choice){
    deletionChoice = choice;
  }
  //////////////////////////////////////////////////////////////////////////////////////////////////

  // Build a View dynamically with all the candies
  public void updateView( ) {
    ArrayList<Candy> candies = dbManager.selectAll( );
    RelativeLayout layout = new RelativeLayout( this );
    ScrollView scrollView = new ScrollView( this );
    RadioGroup group = new RadioGroup( this );
    for ( Candy candy : candies ) {
      RadioButton rb = new RadioButton( this );
      rb.setId( candy.getId( ) );
      rb.setText( candy.toString( ) );
      group.addView( rb );
    }
    // set up event handling
    RadioButtonHandler rbh = new RadioButtonHandler( );
    group.setOnCheckedChangeListener(rbh);

    ///////////////////////////////////// Add an OK Button /////////////////////////////////////////
    Button okButton = new Button( this );
    okButton.setText( "OK" );

    //add event handler for button
    okButton.setOnClickListener( new View.OnClickListener() {
     public void onClick( View v) {
       // update screen
       DeleteActivity.this.finish();
     }
    });
    ////////////////////////////////////////////////////////////////////////////////////////////////

    // create a back button
    Button backButton = new Button( this );
    backButton.setText( R.string.button_back );

    backButton.setOnClickListener( new View.OnClickListener( ) {
      public void onClick(View v) {
        DeleteActivity.this.finish();
      }
    });

    scrollView.addView(group);
    layout.addView( scrollView );

    // add back button at bottom
    RelativeLayout.LayoutParams params
        = new RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT );
    params.addRule( RelativeLayout.ALIGN_PARENT_BOTTOM );
    params.addRule( RelativeLayout.CENTER_HORIZONTAL );
    params.setMargins( 0, 0, 0, 50 );
      layout.addView( backButton, params );

      layout.addView( okButton, params ); //add ok button to layout

    setContentView( layout );
  }

  private class RadioButtonHandler
    implements RadioGroup.OnCheckedChangeListener {
    public void onCheckedChanged(RadioGroup group, int checkedId) {
//      dbManager.deleteById(checkedId);
//      Toast.makeText(DeleteActivity.this, "Candy deleted checkedId=" + checkedId,
//              Toast.LENGTH_SHORT).show();
//      updateView();

      displayAlertDialog();

      if(deletionChoice) {
        dbManager.deleteById(checkedId);
        Toast.makeText(DeleteActivity.this, "Candy deleted checkedId=" + checkedId,
                Toast.LENGTH_SHORT).show();
        updateView();
      }
    }
  }
}
