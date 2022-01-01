package com.example.online12piece_game;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signin extends AppCompatActivity {
private EditText enteremail, enterpass;
 Button sibutton, sunow;
 TextView yet;
 ProgressDialog mLoadingBar;
 FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );

        enteremail = findViewById(R.id.enteremail);
        enterpass = findViewById(R.id.enterpass);
        sibutton = findViewById(R.id.sibutton);
        sunow = findViewById(R.id.sunow);
        yet = findViewById(R.id.yet);
        mLoadingBar = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();

        sunow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signin.this,signup.class);
                startActivity(intent);
            }
        });

        sibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Attemptlogin();
            }
        });
    }

    private void Attemptlogin() {

        String email = enteremail.getText().toString();
        String password = enterpass.getText().toString();


        if(email.isEmpty() || !email.contains("@gmail")){
            showError(enteremail, "email is invalid");
        }
        else
        if(password.isEmpty() || password.length()<5){
            showError(enterpass, "password must be greater than 5 letters");
        }

        else{
            mLoadingBar.setTitle("Login");
            mLoadingBar.setMessage("please wait... checking credentials");
            mLoadingBar.setCanceledOnTouchOutside(false);
            mLoadingBar.show();
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful()){
                       mLoadingBar.dismiss();
                       Toast.makeText(Signin.this, "Login is successful", Toast.LENGTH_SHORT).show();
                       Intent intent = new Intent(Signin.this,Welcome.class);
                       intent.putExtra("theme","");
                       intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                       startActivity(intent);
                       finish();
                   }
                   else{
                       mLoadingBar.dismiss();
                       Toast.makeText(Signin.this,task.getException().toString(), Toast.LENGTH_SHORT).show();
                   }
                }
            });
        }
    }

    private void showError(EditText field, String text) {
        field.setError(text);
        field.requestFocus();
    }
}