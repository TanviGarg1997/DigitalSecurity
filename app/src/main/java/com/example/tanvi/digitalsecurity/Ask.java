package com.example.tanvi.digitalsecurity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Ask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask);
        getSupportActionBar().setTitle("Civil Administration Reporting");

    }
    public void Administrator(View view){
        Intent intent=new Intent(this,AdministratorLogin.class);
        startActivity(intent);
    }
    public void User(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0,101,0,"About App");
        menu.add(0,102,0,"About Developers");
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==101){
            Intent intent = new Intent(Ask.this,AbtUs.class);
            startActivity(intent);
        }
        if(id==102){
            Intent intent = new Intent(Ask.this,AbtDevelopers.class);
            startActivity(intent);
        }
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item) ;
    }
}
