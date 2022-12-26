package com.example.nyampahv3.Pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nyampahv3.Apis.UserApi;
import com.example.nyampahv3.Models.ErrorMessage;
import com.example.nyampahv3.Models.User;
import com.example.nyampahv3.R;
import com.example.nyampahv3.Utils.App;
import com.example.nyampahv3.Utils.SystemUtil;
import com.google.gson.Gson;

import org.json.JSONObject;

public class RegisterPage extends AppCompatActivity {

    EditText fullname;
    EditText email;
    EditText password;
    EditText confirm_password;
    Button registerBtn;
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);
        App.setActivity(this);


        fullname = findViewById(R.id.textInput_fullname);
        email = findViewById(R.id.textInput_email);
        password = findViewById(R.id.textInput_password);
        confirm_password = findViewById(R.id.textInput_confirm_password);
        registerBtn = findViewById(R.id.button_submit);


        registerBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {

                    String fullname_ = fullname.getText().toString();
                    String email_ = email.getText().toString();
                    String password_ = password.getText().toString();
                    String confirm_password_ = confirm_password.getText().toString();

                    if(!password_.equals(confirm_password_)){
                        Toast.makeText(getApplicationContext(), "Confirm your password !", Toast.LENGTH_LONG);
                        return;
                    }


                    User newUser = new User(fullname_,email_,password_);

                    User register = UserApi.Register(newUser);

                    if(register.created_at == null){

                        var ermsg = new ErrorMessage(new JSONObject(gson.toJson(register)));

                        Toast.makeText(getApplicationContext(), ermsg.error_message, Toast.LENGTH_LONG);
                        return;
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Register success", Toast.LENGTH_LONG);

                        startActivity(new Intent(getApplicationContext(),LoginPage.class));
                        return;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}