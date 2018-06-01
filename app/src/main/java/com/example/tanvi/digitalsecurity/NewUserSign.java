package com.example.tanvi.digitalsecurity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static android.R.attr.phoneNumber;

public class NewUserSign extends AppCompatActivity {
    String id,msg;
    EditText eName,ePass,eRePass,eMobile,eAdhaar;
    RadioGroup rg;
    Button btnSub;
    Spinner spin;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference dbManager;
    DatabaseReference dbCEO;
    DatabaseReference dbClerk;
    DatabaseReference dbStaff;
    DatabaseReference dbDepart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_sign);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(" ");
        eAdhaar=(EditText)findViewById(R.id.editTextAdhaar);
        eName=(EditText)findViewById(R.id.editTextName);
        eMobile=(EditText)findViewById(R.id.editTextMobile);
        ePass=(EditText)findViewById(R.id.editTextPswd);
        eRePass=(EditText)findViewById(R.id.editTextRePswd);
        rg=(RadioGroup)findViewById(R.id.radioGroup);
        btnSub=(Button)findViewById(R.id.buttonSub);
        spin=(Spinner)findViewById(R.id.spinner);

        firebaseDatabase=FirebaseDatabase.getInstance();
        dbCEO = FirebaseDatabase.getInstance().getReference("CEO");
        dbManager = FirebaseDatabase.getInstance().getReference("MD");
        dbDepart = FirebaseDatabase.getInstance().getReference("Department");
        dbStaff = FirebaseDatabase.getInstance().getReference("Staff");
        dbClerk = FirebaseDatabase.getInstance().getReference("Clerk");
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
        spin.setAdapter(adapter);
    }
    public void Next(View view){
        String name=eName.getText().toString().trim();
        String pswrd=ePass.getText().toString().trim();
        String repwd=eRePass.getText().toString().trim();
        String meet= spin.getSelectedItem().toString().trim();
        String mobile=eMobile.getText().toString().trim();
        String adhaar=eAdhaar.getText().toString().trim();
        if((TextUtils.isEmpty(name))&&(TextUtils.isEmpty(pswrd))&&(TextUtils.isEmpty(adhaar))){
            Toast.makeText(this,"Enter all the data",Toast.LENGTH_LONG).show();
        }
        else if (!pswrd.equals(repwd)&&(!TextUtils.isEmpty(name))&&(!TextUtils.isEmpty(pswrd))){
            Toast.makeText(this,"Check password",Toast.LENGTH_LONG).show();
        }
        else if(pswrd.equals(repwd) && (!TextUtils.isEmpty(name)) && (!TextUtils.isEmpty(pswrd))) {
            SmsManager smsManager = SmsManager.getDefault();


            if(meet.equals("CEO")){
                id=dbCEO.push().getKey();
                Details details =new Details(id,name,pswrd,mobile,adhaar);
                dbCEO.child(id).setValue(details);
                msg="Hello Ms.Tanvi," +
                        "Mr./Mrs."+name+" is coming to meet you";
                smsManager.sendTextMessage("8054240511", null, msg, null, null);
            }
            else if(meet.equals("MD")){
                id=dbManager.push().getKey();
                Details details =new Details(id,name,pswrd,mobile,adhaar);
                dbManager.child(id).setValue(details);
                msg="Hello Ms.Simran," +
                        "Mr./Mrs."+name+"  is coming to meet you";
                smsManager.sendTextMessage("8968045855", null, msg, null, null);
            }
            else if(meet.equals("Department Head")){
                id=dbDepart.push().getKey();
                Details details =new Details(id,name,pswrd,mobile,adhaar);
                dbDepart.child(id).setValue(details);
                msg="Hello Ms.Kajal," +
                        "Mr./Mrs."+name+"  is coming to meet you";
                smsManager.sendTextMessage("9878646944", null, msg, null, null);
            }
            else if(meet.equals("Staff Member")){
                id=dbStaff.push().getKey();
                Details details =new Details(id,name,pswrd,mobile,adhaar);
                dbStaff.child(id).setValue(details);
                msg="Hello Ms.Nikita," +
                        "Mr./Mrs."+name+"  is coming to meet you";
                smsManager.sendTextMessage("8968998800", null, msg, null, null);
            }
            else if(meet.equals("Clerk")){
                id=dbClerk.push().getKey();
                Details details =new Details(id,name,pswrd,mobile,adhaar);
                dbClerk.child(id).setValue(details);
                msg="Hello Ms.Nitya," +
                        "Mr./Mrs."+name+"  is coming to meet you";
                smsManager.sendTextMessage("9464016791", null, msg, null, null);
            }
            Intent intent = new Intent(this, Thanks.class);
            startActivity(intent);
        }
            else {
                Toast.makeText(this, "Some fields are missing", Toast.LENGTH_LONG).show();
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
