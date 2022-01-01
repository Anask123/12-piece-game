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

public class signup extends AppCompatActivity {
private EditText entername, enterpass, confirmpass, enteremail;
private Button subutton;
private TextView sutextview, haveaccount;
ProgressDialog mLoadingBar;
FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );

entername = findViewById(R.id.entername);
enterpass = findViewById(R.id.enterpass);
enteremail = findViewById(R.id.enteremail);
confirmpass = findViewById(R.id.confirmpass);
subutton = findViewById(R.id.sibutton);
sutextview = findViewById(R.id.sutextview);
haveaccount = findViewById(R.id.haveaccount);
mAuth = FirebaseAuth.getInstance();
mLoadingBar = new ProgressDialog(this);

subutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
AttemptRegisteration();
    }
});

haveaccount.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(signup.this,Signin.class);
        startActivity(intent);




    }
});





    }

    private void AttemptRegisteration() {
        String name = entername.getText().toString();
        String email = enteremail.getText().toString();
        String password = enterpass.getText().toString();
        String confirm = confirmpass.getText().toString();

        if(email.isEmpty() || !email.contains("@gmail")){
            showError(enteremail, "email is invalid");
        }
        else
            if(password.isEmpty() || password.length()<5){
                showError(enterpass, "password must be greater than 5 letters");
            }
            else
                if(!confirm.equals(password)){
            showError(confirmpass, "password didn't match");
        }
                else{
        mLoadingBar.setTitle("Registration");
        mLoadingBar.setMessage("please wait... checking credentials");
        mLoadingBar.setCanceledOnTouchOutside(false);
        mLoadingBar.show();
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    mLoadingBar.dismiss();
                    Toast.makeText(signup.this, "Registration is successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(signup.this,Welcome.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("theme","");
                    startActivity(intent);
                    finish();

                }
                else{
                    mLoadingBar.dismiss();
                    Toast.makeText(signup.this, "Registration failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
                }

    }

    private void showError(EditText field, String text) {
    field.setError(text);
    field.requestFocus();
    }

    private void showError() {
    }
}