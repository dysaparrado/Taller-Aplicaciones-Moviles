package com.example.dss22.firebaseapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button btnInicio,btnRegistro;
    EditText Email,Password;

    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInicio = (Button) findViewById(R.id.btnInicio);
        btnRegistro = (Button) findViewById(R.id.btnRegistro);
        Email = findViewById(R.id.txtEmail);
        Password = findViewById(R.id.txtPassword);

        btnInicio.setOnClickListener((view)->{
            String email=Email.getText().toString();
            String pass=Password.getText().toString();
            iniciarsesion(email,pass);
        });

        btnRegistro.setOnClickListener((view)->{
            String email=Email.getText().toString();
            String pass=Password.getText().toString();
            registrar(email,pass);
        });

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    Log.i("SESION","Logueado Exitosamente: "+ user.getEmail());

                }else{
                    Log.i("SESION","Loguot");
                }
            }
        };
    }

    private void iniciarsesion(String email,String pass){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.i("SESION","Sesion Iniciada");
                    Toast.makeText(MainActivity.this,"Logueado Exitosamente: "+ email,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),AgregarActivity.class);
                    intent.putExtra("Email",email);
                    startActivity(intent);
                    Email.setText("");
                    Password.setText("");
                }else{
                    Log.i("SESION",task.getException().getMessage()+"");
                    Toast.makeText(MainActivity.this,"No fue posible iniciar sesion",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void registrar(String email,String pass){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.i("SESION","Usuario Registrado Exitosamente");
                    Toast.makeText(MainActivity.this,"Usuario Registrado Exitosamente",Toast.LENGTH_SHORT).show();
                    Email.setText("");
                    Password.setText("");

                }else{
                    Log.i("SESION",task.getException().getMessage()+"");
                    Toast.makeText(MainActivity.this,"No fue posible registrar al usuario",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mAuthListener != null){
            FirebaseAuth.getInstance().removeAuthStateListener(mAuthListener);
        }
    }
}
