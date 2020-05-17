package com.colmena.login_beta_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtUser, txtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUser = findViewById(R.id.id_txtUser);
        txtPassword = findViewById(R.id.id_txtPassword);
        btnLogin = findViewById(R.id.id_btnLogin);

        acceso();
    }

    private void acceso(){

        if (txtUser.getText().toString() == "admin" && txtPassword.getText().toString() == "admin"){
            Toast.makeText(this, "entraste!!", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this, "usuario y/o contraseña incorrecta!", Toast.LENGTH_SHORT).show();
    }
}
