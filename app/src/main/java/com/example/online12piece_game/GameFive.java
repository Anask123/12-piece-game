package com.example.online12piece_game;

import static java.lang.Math.round;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameFive extends AppCompatActivity {

    String Name1="",Goti1="",Name2="",Goti2="",Grid="";
    String str="";
    RelativeLayout rl;
    TextView P1NameTV,P2NameTV,P1ScoreTV,P2ScoreTV,P1,P2;
    TextView P1nameText,P2nameText;
    ImageView P1gotiImg,P2gotiImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_five);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );

        rl = findViewById(R.id.Layout);
        Intent i = this.getIntent();
        Name1=i.getStringExtra("p1name");
        Name2=i.getStringExtra("p2name");
        Goti1=i.getStringExtra("p1goti");
        Goti2=i.getStringExtra("p2goti");
        Grid=i.getStringExtra("grid");
        str=i.getStringExtra("theme");

        if(str.equals(""))
            rl.setBackgroundResource(R.drawable.theme3);
        else if(str.equals("theme_1"))
            rl.setBackgroundResource(R.drawable.theme1);
        else if(str.equals("theme_2"))
            rl.setBackgroundResource(R.drawable.theme2);
        else if(str.equals("theme_3"))
            rl.setBackgroundResource(R.drawable.theme3);

        P1 = new TextView(this);
        P1.setTextSize(27);
        P1.setText(Name1);
        P1.setTextColor(Color.RED);
        P1.setPadding(40,5,40,10);
        P1.setTypeface(null, Typeface.BOLD);
        RelativeLayout.LayoutParams layoutParamsP1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsP1.setMargins(round(40), round(1900), 0, 0);
        P1.setLayoutParams(layoutParamsP1);
        rl.addView(P1);

        P2 = new TextView(this);
        P2.setTextSize(round(27));
        P2.setText(Name2);
        P2.setTextColor(Color.RED);
        P2.setPadding(40,5,40,10);
        P1.setTypeface(null,Typeface.BOLD);
        RelativeLayout.LayoutParams layoutParamsP2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsP2.setMargins(round(550), round(55), 0, 0);
        P2.setLayoutParams(layoutParamsP2);
        rl.addView(P2);

        P1NameTV = new TextView(this);
        P1NameTV.setText("Score"+" : ");
        P1NameTV.setTextSize(round(24));
        P1NameTV.setTypeface(null, Typeface.BOLD);
        P1NameTV.setTextColor(Color.GREEN);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(round(40), round(1800), 0, 0);
        P1NameTV.setLayoutParams(layoutParams);
        rl.addView(P1NameTV);

        P1ScoreTV = new TextView(this);
        P1ScoreTV.setText("0");
        P1ScoreTV.setTextSize(round(27));
        P1ScoreTV.setTypeface(null, Typeface.BOLD);
        P1ScoreTV.setTextColor(Color.RED);
        RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams1.setMargins(round(350), round(1800), 0, 0);
        P1ScoreTV.setLayoutParams(layoutParams1);
        rl.addView(P1ScoreTV);

        P2NameTV = new TextView(this);
        P2NameTV.setText("Score"+" : ");
        P2NameTV.setTextSize(round(24));
        P2NameTV.setTypeface(null, Typeface.BOLD);
        P2NameTV.setTextColor(Color.GREEN);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams2.setMargins(round(650), round(170), 0, 0);
        P2NameTV.setLayoutParams(layoutParams2);
        rl.addView(P2NameTV);

        P2ScoreTV = new TextView(this);
        P2ScoreTV.setText("0");
        P2ScoreTV.setTextSize(round(27));
        P2ScoreTV.setTypeface(null, Typeface.BOLD);
        P2ScoreTV.setTextColor(Color.GREEN);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams3.setMargins(round(950), round(170), 0, 0);
        P2ScoreTV.setLayoutParams(layoutParams3);
        rl.addView(P2ScoreTV);


        /*
        P1gotiImg=findViewById(R.id.p1gotiIMG);
        P2gotiImg=findViewById(R.id.p2gotiIMG);
        P1nameText=findViewById(R.id.p1name);
        P2nameText=findViewById(R.id.p2nameTEXT);

        P1nameText.setText
        P2nameText.setText(Name2);
        if (Goti1.equals("1"))
             P1gotiImg.setBackgroundResource(R.drawable.piece1);
        else
            P1gotiImg.setBackgroundResource(R.drawable.goti3d);
        if (Goti2.equals("1"))
            P2gotiImg.setBackgroundResource(R.drawable.piece1);
        else
            P2gotiImg.setBackgroundResource(R.drawable.goti3d);*/

        //Toast.makeText(this, Name1+" // "+Goti1+"// "+Name2+"// "+Goti2+" // "+Grid, Toast.LENGTH_SHORT).show();
    }
}