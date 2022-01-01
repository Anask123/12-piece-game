package com.example.online12piece_game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Welcome extends AppCompatActivity {

    String str="";
    RelativeLayout rl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );

        rl = findViewById(R.id.layout);
        Intent r = this.getIntent();
        str=r.getStringExtra("theme");

        if(str.equals(""))
            rl.setBackgroundResource(R.drawable.theme_3bg);
        else if(str.equals("theme_1"))
            rl.setBackgroundResource(R.drawable.theme_1bg);
        else if(str.equals("theme_2"))
            rl.setBackgroundResource(R.drawable.theme_2bg);
        else if(str.equals("theme_3"))
            rl.setBackgroundResource(R.drawable.theme_3bg);
    }
    public void play (View view){
        Intent i = new Intent(this,grid_selection.class);
        i.putExtra("theme",str);
        this.startActivity(i);
    }
    public void theme (View view){
        Intent i = new Intent(this,theme.class);
        i.putExtra("theme",str);
        this.startActivity(i);
    }
    public void about (View view){
        Intent i = new Intent(this,about.class);
        i.putExtra("theme",str);
        this.startActivity(i);
    }
    public void exit (View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure to Exit game?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();
                        System.exit(0);
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }
    }
