package com.example.online12piece_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PlayerSelection extends AppCompatActivity {

    EditText name;
    TextView playerid;
    ImageView piece;
    Button n,p;
    String str="";
    ConstraintLayout rl;
    int[] Piece = { R.drawable.goti3d, R.drawable.piece1 };
    int count=0,pc=1;
    String Name1="",Goti1="",Name2="",Goti2="",Grid="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_selection);
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );

        rl = findViewById(R.id.llayout);
        Intent r = this.getIntent();
        str=r.getStringExtra("theme");
        Grid=r.getStringExtra("grid");
        Toast.makeText(this, Grid, Toast.LENGTH_SHORT).show();

        if(str.equals(""))
            rl.setBackgroundResource(R.drawable.theme_3bg);
        else if(str.equals("theme_1"))
            rl.setBackgroundResource(R.drawable.theme_1bg);
        else if(str.equals("theme_2"))
            rl.setBackgroundResource(R.drawable.theme_2bg);
        else if(str.equals("theme_3"))
            rl.setBackgroundResource(R.drawable.theme_3bg);

        piece=findViewById(R.id.PieceImg);
        playerid=findViewById(R.id.playerNumber);
        n=findViewById(R.id.nextbtn);
        p=findViewById(R.id.previousbtn);
    }
    public void backb(View view){
        Intent i = new Intent(this,grid_selection.class);
        this.startActivity(i);
    }
    public void Player1info (View view){
        name=findViewById(R.id.p1name);
        piece=findViewById(R.id.PieceImg);
        if(pc==1) {
            Name1 = name.getText().toString();
            if (Name1.equals("")) {
                Toast.makeText(this, "Enter name first", Toast.LENGTH_SHORT).show();
            } else {
                Goti1 = String.valueOf(count);
                playerid.setText("Enter Player 2 Name");
                pc++;
                name.setText(null);
            }
        }
        else{
            if (pc == 2) {
                Name2 = name.getText().toString();
                if (Name2.equals("")) {
                    Toast.makeText(this, "Enter name first", Toast.LENGTH_SHORT).show();
                } else {
                    Goti2 = String.valueOf(count);
                    if (Goti2.equals(Goti1)){
                        Toast.makeText(this, "Please select another piece", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if (Grid.equals("five")){
                            Intent i = new Intent(this,GameFive.class);
                            i.putExtra("p1name",Name1);
                            i.putExtra("p2name",Name2);
                            i.putExtra("p1goti",Goti1);
                            i.putExtra("p2goti",Goti2);
                            i.putExtra("grid",Grid);
                            i.putExtra("theme",str);
                            this.startActivity(i);
                        }
                        else if (Grid.equals("seven")){
                            Intent i = new Intent(this,GameSeven.class);
                            i.putExtra("p1name",Name1);
                            i.putExtra("p2name",Name2);
                            i.putExtra("p1goti",Goti1);
                            i.putExtra("p2goti",Goti2);
                            i.putExtra("grid",Grid);
                            i.putExtra("theme",str);
                            this.startActivity(i);
                        }
                    }
                }
            }
        }
    }
    public void Nextbtn (View view){

        p.setEnabled(true);
        if (count<=1){
            count++;
            piece.setImageResource(android.R.color.transparent);
            piece.setBackgroundResource(Piece[count]);
            if (count==1)
                n.setEnabled(false);
        }
    }
    public void Previousbtn (View view){

        n.setEnabled(true);
        if (count>=1){
            count--;
            piece.setImageResource(android.R.color.transparent);
            piece.setBackgroundResource(Piece[count]);
            if (count==0)
                p.setEnabled(false);
        }

    }
}