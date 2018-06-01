package com.example.tanvi.digitalsecurity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Thanks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanks);
        getSupportActionBar().setTitle(" ");
        handler.sendEmptyMessageDelayed(101,5000);


    }
    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 101){
                if (11==11) { // A Logic Required
                    Intent intent = new Intent(Thanks.this, Ask.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(Thanks.this, Ask.class);
                    startActivity(intent);
                }

                finish();
            }
        }
    };
    }

