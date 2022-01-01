package com.example.online12piece_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class about extends AppCompatActivity {

    String str="";
    ConstraintLayout rl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );


        rl = findViewById(R.id.layoutt);
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
    public void bbtn(View view){
        Intent i = new Intent(this,Welcome.class);
        this.startActivity(i);
    }
}