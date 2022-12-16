package com.example.spacetrivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper helper= new DBHelper(this);

        EditText username= (EditText) findViewById(R.id.username);
        EditText password= (EditText) findViewById(R.id.password);
        Button signupbutton = (Button) findViewById(R.id.signup);
        Button signinbutton = (Button) findViewById(R.id.signin);

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= username.getText().toString();
                String pwd= password.getText().toString();
                if (user.equals("") || pwd.equals("")){
                    Toast.makeText(MainActivity.this, "Please enter data", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean usernamecheck= helper.checkUsername(user);
                    // user is not in database
                    if (usernamecheck==false){
                        helper.insertData(user,pwd);
                        Toast.makeText(MainActivity.this, "inserted user "+user, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "User "+user+ " is already registered", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= username.getText().toString();
                String pwd= password.getText().toString();
                if (user.equals("") || pwd.equals("")){
                    Toast.makeText(MainActivity.this, "Please enter data", Toast.LENGTH_SHORT).show();
                }
                else{

                    Boolean usernamecheck= helper.checkUsername(user);
                    // user is not in database
                    if (usernamecheck==false){
                        Toast.makeText(MainActivity.this, "user  "+user+" isn't registered yet", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Boolean passwordcheck = helper.checkPwd(user, pwd);
                        if (passwordcheck==true){
                            Toast.makeText(MainActivity.this,"the credentials are true",Toast.LENGTH_SHORT).show();
//                            Intent i = new Intent(getApplicationContext(),)
                            //TODO: redirect logged in user to new activity (put extra)
                        }
                        else{
                            Toast.makeText(MainActivity.this,"the credentials are false",Toast.LENGTH_SHORT).show();
                        }
                        }
                }
            }
        });

    }
}