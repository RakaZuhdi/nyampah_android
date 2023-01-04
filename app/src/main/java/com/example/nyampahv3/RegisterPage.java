package com.example.nyampahv3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nyampahv3.api.UserApi;
import com.example.nyampahv3.model.User;

public class RegisterPage extends AppCompatActivity {

    private Button buttonRequestAnotherPickup;
    private EditText fullname;
    private EditText email;
    private EditText password;
    private EditText confirmPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

        email = (EditText) findViewById(R.id.textInput_email_register);
        fullname = (EditText) findViewById(R.id.textInput_fullname_register);
        password = (EditText) findViewById(R.id.textInput_password_register);
        confirmPassword = (EditText) findViewById(R.id.textInput_confirmpassword_register);



        buttonRequestAnotherPickup = (Button) findViewById(R.id.button_submit_register);
        buttonRequestAnotherPickup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Register successful!",Toast.LENGTH_SHORT).show();
                Log.d("email", email.getText().toString());
                Log.d("fullname", fullname.getText().toString());
                Log.d("password", password.getText().toString());
                Log.d("confirmPassword", confirmPassword.getText().toString());

                User user = new User();

                user.email = email.getText().toString();
                user.fullname = fullname.getText().toString();
                user.password = password.getText().toString();

                try {
                    UserApi.Register(user);
                    Log.d("Register!", "successful!");
                    Toast.makeText(getApplicationContext(),"Register successful!",Toast.LENGTH_SHORT).show();
                    openLoginPage();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //openLoginPage();
            }
        });

    }

    public void openLoginPage(){
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }
}