package com.example.tanvi.digitalsecurity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdministratorLogin extends AppCompatActivity {
    EditText eUser,ePswrd;
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(" ");
        eUser=(EditText)findViewById(R.id.adminUser);
        ePswrd=(EditText)findViewById(R.id.adminPwd);

    }

    public void loginTeacher(View view) {
        String user=eUser.getText().toString().trim();
        String pass=ePswrd.getText().toString().trim();
        if((user.equals("digital"))&&(pass.equals("security"))) {
            Intent intent = new Intent(this, Otp.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this,"Wrong Username or Password",Toast.LENGTH_LONG).show();
        }
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item) ;
    }
}