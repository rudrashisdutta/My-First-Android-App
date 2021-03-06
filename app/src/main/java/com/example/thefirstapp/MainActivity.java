package com.example.thefirstapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStart;
    private Button btnStartAgain;
    private Button btnExit;
    private TextView txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart= this.findViewById(R.id.btnStart);
        btnStartAgain= this.findViewById(R.id.btnStartAgain);
        btnExit= this.findViewById(R.id.btnExit);
        txtMessage= this.findViewById(R.id.txtMessage);

        //Action Bar Stuff
        ActionBar actionBar=getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(getColor(R.color.actionBar));
        assert actionBar != null;
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setTitle(String.format("%s","My First App"));
        //Action Bar Stuff

        btnStart.setOnClickListener(this);
        btnStartAgain.setOnClickListener(v -> {
            txtMessage.setVisibility(View.VISIBLE);
            btnStart.setVisibility(View.VISIBLE);
            btnExit.setVisibility(View.GONE);
            btnStartAgain.setVisibility(View.GONE);
        });
        btnExit.setOnClickListener(v -> finish());
        btnStartAgain.setVisibility(View.GONE);
        btnExit.setVisibility(View.GONE);
    }
    public void onClick(View v){
    final EditText input = new EditText( this);
    AlertDialog dialog=new AlertDialog.Builder( this)
                .setMessage("What would you like to talk about?")
                .setView(input)
                .setPositiveButton( "Conitnue", (dialog1, width) -> keepTalking(input.getText().toString()))
                .setNegativeButton( "Cancel", null)
                .show();
        startAgain();
    }
    public void keepTalking(final String t){
        AlertDialog secondDialog = new AlertDialog.Builder(this)
                .setMessage("Do you like "+t+"?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        likeTopic(t);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dislikeTopic(t);
                    }
                })
                .show();
    }
    public void likeTopic(String t){
        Context context = getApplicationContext();
        CharSequence message = "I am happy that you like "+t+"!!";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context,message,duration);
        toast.show();
    }
    public void dislikeTopic(String t){
        Context context = getApplicationContext();
        CharSequence message = "Are you serious?? You don't like "+t+"!! I can not believe it!!";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context,message,duration);
        toast.show();
    }
    public void startAgain(){
        btnStart.setVisibility(View.GONE);
        txtMessage.setVisibility(View.GONE);
        btnStartAgain.setVisibility(View.VISIBLE);
        btnExit.setVisibility(View.VISIBLE);
    }

}