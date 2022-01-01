package com.example.online12piece_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class theme extends AppCompatActivity {

    String str="";
    RelativeLayout rl;
    float screenWidth,screenHeight,scale,scale1;
    int []a={R.drawable.theme1,R.drawable.theme2,R.drawable.theme3};
    int []b=new int[6];
    int counter=0;
    Button btn,btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

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
    public void imgeview (View view)
    {
        Intent i = new Intent(this, Welcome.class);
        switch (counter){
            case 0:
                str="theme_1";
                break;
            case 1:
                str="theme_2";
                break;
            case 2:
                str="theme_3";
                break;
        }
        i.putExtra("theme", str);
        this.startActivity(i);
    }

    public void backclick (View view)
    {
        Intent i = new Intent(this, Welcome.class);
        i.putExtra("theme", str);
        this.startActivity(i);
    }
    public void nclick (View view)
    {
        ImageView i =findViewById(R.id.imageView);
        btn=findViewById(R.id.btnnclick);
        btn1=findViewById(R.id.btnpclick);
        counter++;
        if (counter>=0&&counter<=2)
            switch (counter){
                case 0:
                    i.setImageResource(a[0]);
                    break;
                case 1:
                    i.setImageResource(a[1]);
                    break;
                case 2:
                    i.setImageResource(a[2]);
                    break;
            }
        if(counter==2){
            btn.setEnabled(false);
        }
        else
        {
            btn.setEnabled(true);
            btn1.setEnabled(true);
        }
    }
    public void pclick (View view)
    {
        ImageView i =findViewById(R.id.imageView);
        counter--;
        if (counter>=0&&counter<=2)
            switch (counter){
                case 0:
                    i.setImageResource(a[0]);
                    break;
                case 1:
                    i.setImageResource(a[1]);
                    break;
                case 2:
                    i.setImageResource(a[2]);
                    break;
            }
        if(counter==0){
            btn1.setEnabled(false);
        }
        else
        {
            btn.setEnabled(true);
            btn1.setEnabled(true);
        }
    }

}