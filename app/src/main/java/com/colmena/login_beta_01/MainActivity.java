package com.colmena.login_beta_01;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    @BindView(R.id.btn_LoginButton) Button _loginButton;
    @BindView(R.id.input_Email) EditText _emailText;
    @BindView(R.id.input_Password) EditText _passwordText;
    @BindView(R.id.link_signUp) TextView _signUpLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_LoginButton)
    public void onClickLogin(){
        login();
    }

    public void login(){
        Log.d(TAG, "Login");

        if(!validate()){
            onLoginFailed();
            return;
        }


        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this,
                R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Autenticando...");
        progressDialog.show();

        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        onLoginSuccess();
                        progressDialog.dismiss();
                    }
                }, 3000
        );
    }

    public boolean validate(){

        boolean valid = true;
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            _emailText.setError("Error al ingresar email");
            valid = false;
        }else{
            _emailText.setError(null);
        }

        if(password.isEmpty() || password.length() < 4 || password.length() > 10){
            _passwordText.setError("La contraseña debe tener en 4 - 10 caracteres");
            valid = false;
        }else{
            _passwordText.setError(null);
        }
        return valid;
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        finish();
    }

    public void onLoginFailed(){
        Toast.makeText(this, "Login Error", Toast.LENGTH_LONG).show();
        _loginButton.setEnabled(true);
    }
}

