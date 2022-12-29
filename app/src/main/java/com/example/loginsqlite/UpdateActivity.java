package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    private EditText username_U, password_U, repassword_U;
    private Button btnupdate_u;
    DBHelper DB;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        username_U = (EditText) findViewById(R.id.username_U);
        password_U = (EditText) findViewById(R.id.password_U);
        repassword_U = (EditText) findViewById(R.id.repassword_U);
        btnupdate_u = (Button) findViewById(R.id.btnupdate);
        DB = new DBHelper(this);

        btnupdate_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData();
            }
        });
    }

    private void updateData() {
        String user = username_U.getText().toString();
        String pass = password_U.getText().toString();
        String repass = repassword_U.getText().toString();
        if(user.equals("")||pass.equals("")||repass.equals(""))
            Toast.makeText(UpdateActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        else{
            if(pass.equals(repass)){
                Boolean checkuser = DB.checkusername(user);
                if(checkuser==false){
                    Boolean update = DB.updateData(user, pass);
                    if(update==true){
                        Toast.makeText(UpdateActivity.this, "Account Updated Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(UpdateActivity.this, "Account Updated Failed", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(UpdateActivity.this, "User not found", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(UpdateActivity.this, "Password not matching", Toast.LENGTH_SHORT).show();
            }
        }
    }


}