package com.example.tanvi.digitalsecurity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class UsersList extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference dbManager;
    DatabaseReference dbCEO;
    DatabaseReference dbClerk;
    DatabaseReference dbStaff;
    DatabaseReference dbDepart;
    private ListView listView;

    private ArrayList<String> sUser =new ArrayList<>();
    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent rcv = getIntent();
        String Employee = rcv.getStringExtra("keySong");
        listView = (ListView) findViewById(R.id.userList);
        firebaseDatabase = FirebaseDatabase.getInstance();
        dbCEO = FirebaseDatabase.getInstance().getReference("CEO");
        dbManager = FirebaseDatabase.getInstance().getReference("MD");
        dbDepart = FirebaseDatabase.getInstance().getReference("Department");
        dbStaff = FirebaseDatabase.getInstance().getReference("Staff");
        dbClerk = FirebaseDatabase.getInstance().getReference("Clerk");

        final ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,sUser);
        listView.setAdapter(mAdapter);
       // listView.setOnClickListener((View.OnClickListener) this);
        if (Employee.equals("CEO")) {
            dbCEO.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    DataSnapshot name=dataSnapshot.child("name");
                     user=name.getValue().toString().trim();
                    sUser.add(user);
                    mAdapter.notifyDataSetChanged();
                    getSupportActionBar().setTitle("CEO Visitors");

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
        } else if (Employee.equals("MD")) {
            dbManager.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    DataSnapshot name=dataSnapshot.child("name");
                     user=name.getValue().toString().trim();

                    sUser.add(user);
                    mAdapter.notifyDataSetChanged();
                    getSupportActionBar().setTitle("MD Visitors");


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

        } else if (Employee.equals("Department Head")) {
            dbDepart.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    DataSnapshot name=dataSnapshot.child("name");
                    user=name.getValue().toString().trim();

                    sUser.add(user);
                    mAdapter.notifyDataSetChanged();
                    getSupportActionBar().setTitle("Department Head Visitors");

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

        } else if (Employee.equals("Staff Member")) {
            dbStaff.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    DataSnapshot name=dataSnapshot.child("name");
                    user=name.getValue().toString().trim();

                    sUser.add(user);
                    mAdapter.notifyDataSetChanged();
                    getSupportActionBar().setTitle("Staff Visitors");

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

        } else if (Employee.equals("Clerk")) {
            dbClerk.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    DataSnapshot name=dataSnapshot.child("name");
                     user=name.getValue().toString().trim();

                    sUser.add(user);
                    mAdapter.notifyDataSetChanged();
                    getSupportActionBar().setTitle("Clerk Visitors");


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
    }


    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0,101,0,"Sign Out");
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {

            case 101:
                Intent intent = new Intent(UsersList.this,Ask.class);
                startActivity(intent);
                break;
            case android.R.id.home:
                finish();
                return true;
               // break;
        }
        return super.onOptionsItemSelected(item) ;
    }
}