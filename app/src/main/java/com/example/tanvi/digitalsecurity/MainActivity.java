package com.example.tanvi.digitalsecurity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText eName,ePass;
    Spinner spList;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference dbManager;
    DatabaseReference dbCEO;
    DatabaseReference dbClerk;
    DatabaseReference dbStaff;
    DatabaseReference dbDepart;
    Button btnNext;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(" ");

        eName=(EditText)findViewById(R.id.userName);
        ePass=(EditText)findViewById(R.id.userPswrd);
       spList=(Spinner)findViewById(R.id.spinnerList);
        btnNext=(Button)findViewById(R.id.userLogin);
        ArrayAdapter<String> adapter;
        List<String> list1;

        list1 = new ArrayList<String>();
        list1.add("--You want to meet--");
        list1.add("CEO");
        list1.add("MD");
        list1.add("Department Head");
        list1.add("Staff Member");
        list1.add("Clerk");
        adapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.activity_spinner_layout, list1);
        adapter.setDropDownViewResource( R.layout.activity_spinner_layout);
        spList.setAdapter(adapter);
        firebaseDatabase=FirebaseDatabase.getInstance();
        dbCEO = FirebaseDatabase.getInstance().getReference("CEO");
        dbManager = FirebaseDatabase.getInstance().getReference("MD");
        dbDepart = FirebaseDatabase.getInstance().getReference("Department");
        dbStaff = FirebaseDatabase.getInstance().getReference("Staff");
        dbClerk = FirebaseDatabase.getInstance().getReference("Clerk");

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String meet= spList.getSelectedItem().toString().trim();
                if(meet.equals("CEO")){
                    dbCEO.addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                            final String abc=eName.getText().toString().trim();
                            final String def=ePass.getText().toString().trim();
                            DataSnapshot area = dataSnapshot.child("name");
                            DataSnapshot a1 = dataSnapshot.child("pass");

                            String area_value = area.getValue().toString().trim();
                            String area_value1 = a1.getValue().toString().trim();

                            if((area_value.equals(abc))&&(area_value1.equals(def))){
                                SmsManager smsManager = SmsManager.getDefault();

                                msg="Hello Ms.Tanvi, " +
                                        "Mr./Mrs. "+abc+" is coming to meet you";
                                smsManager.sendTextMessage("8054240511", null, msg, null, null);
                                Intent intent=new Intent(getApplicationContext(),Thanks.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"Wrong Username or Password",Toast.LENGTH_LONG).show();

                            }

                        }

                        @Override
                        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onChildRemoved(DataSnapshot dataSnapshot) {

                        }

                        @Override
                        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if(meet.equals("Staff Member")){
                    dbStaff.addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                            final String abc=eName.getText().toString().trim();
                            final String def=ePass.getText().toString().trim();
                            DataSnapshot area = dataSnapshot.child("name");
                            DataSnapshot a1 = dataSnapshot.child("pass");

                            String area_value = area.getValue().toString().trim();
                            String area_value1 = a1.getValue().toString().trim();

                            if((area_value.equals(abc))&&(area_value1.equals(def))){
                                SmsManager smsManager = SmsManager.getDefault();
                                msg="Hello Ms.Simran," +
                                        "Mr./Mrs. "+abc+"  is coming to meet you";
                                smsManager.sendTextMessage("8968045855", null, msg, null, null);
                                Intent intent=new Intent(getApplicationContext(),Thanks.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"Wrong Username or Password",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onChildRemoved(DataSnapshot dataSnapshot) {

                        }

                        @Override
                        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if(meet.equals("MD")){
                    dbManager.addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                            final String abc=eName.getText().toString().trim();
                            final String def=ePass.getText().toString().trim();
                            DataSnapshot area = dataSnapshot.child("name");
                            DataSnapshot a1 = dataSnapshot.child("pass");

                            String area_value = area.getValue().toString().trim();
                            String area_value1 = a1.getValue().toString().trim();

                            if((area_value.equals(abc))&&(area_value1.equals(def))){
                                SmsManager smsManager = SmsManager.getDefault();
                                msg="Hello Ms.Nitya, " +
                                        "Mr./Mrs. "+abc+"  is coming to meet you";
                                smsManager.sendTextMessage("9464016791", null, msg, null, null);
                                Intent intent=new Intent(getApplicationContext(),Thanks.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"Wrong Username or Password",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onChildRemoved(DataSnapshot dataSnapshot) {

                        }

                        @Override
                        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if(meet.equals("Department Head")){
                    dbDepart.addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                            final String abc=eName.getText().toString().trim();
                            final String def=ePass.getText().toString().trim();
                            DataSnapshot area = dataSnapshot.child("name");
                            DataSnapshot a1 = dataSnapshot.child("pass");

                            String area_value = area.getValue().toString().trim();
                            String area_value1 = a1.getValue().toString().trim();

                            if((area_value.equals(abc))&&(area_value1.equals(def))){
                                SmsManager smsManager = SmsManager.getDefault();
                                msg="Hello Ms.Nikita, " +
                                        "Mr./Mrs. "+abc+"  is coming to meet you";
                                smsManager.sendTextMessage("89680998800", null, msg, null, null);
                                Intent intent=new Intent(getApplicationContext(),Thanks.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"Wrong Username or Password",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onChildRemoved(DataSnapshot dataSnapshot) {

                        }

                        @Override
                        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if(meet.equals("CLerk")){
                    dbClerk.addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                            final String abc=eName.getText().toString().trim();
                            final String def=ePass.getText().toString().trim();
                            DataSnapshot area = dataSnapshot.child("name");
                            DataSnapshot a1 = dataSnapshot.child("pass");

                            String area_value = area.getValue().toString().trim();
                            String area_value1 = a1.getValue().toString().trim();

                            if((area_value.equals(abc))&&(area_value1.equals(def))){
                                SmsManager smsManager = SmsManager.getDefault();
                                msg="Hello Ms.Kajal, " +
                                        "Mr./Mrs. "+abc+"  is coming to meet you";
                                smsManager.sendTextMessage("9878646944", null, msg, null, null);
                                Intent intent=new Intent(getApplicationContext(),Thanks.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"Wrong Username or Password",Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onChildRemoved(DataSnapshot dataSnapshot) {

                        }

                        @Override
                        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else{
                    Toast.makeText(getApplicationContext(),"Enter all data",Toast.LENGTH_LONG).show();

                }


            }
        });


    }

    public void click(View v) {
        switch (v.getId()) {
            case R.id.serve: // R.id.textView1
               Intent intent = new Intent(MainActivity.this, NewUserSign.class);
                startActivity(intent);
                break;
        }
    }
 /*   public void loginStudent(View view) {
        String name=eName.getText().toString().trim();
        String pswrd=ePass.getText().toString().trim();

        if((name.equals("tanvi"))&&(pswrd.equals("tanvi"))) {
            Intent intent = new Intent(MainActivity.this, Otp.class);
            startActivity(intent);
        } */

  //  }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item) ;
    }

    }
