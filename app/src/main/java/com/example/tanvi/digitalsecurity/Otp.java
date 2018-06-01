package com.example.tanvi.digitalsecurity;

import android.app.NotificationManager;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import java.util.concurrent.TimeUnit;

public class Otp extends AppCompatActivity {
   // EditText eMobile;
    Button btnSub;
    EditText eCode;
   // String name,pwd,meet,mobile,id,msg;
    private String phoneVerificationId;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks verificationCallbacks;
    private PhoneAuthProvider.ForceResendingToken resendingToken;
    private FirebaseAuth firebaseAuth;
 /*   FirebaseDatabase firebaseDatabase;
    DatabaseReference dbManager;
    DatabaseReference dbCEO;
    DatabaseReference dbClerk;
    DatabaseReference dbStaff;
    DatabaseReference dbDepart; */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        getSupportActionBar().setTitle(" ");

      //  eMobile=(EditText)findViewById(R.id.editTextMobile);
        eCode=(EditText)findViewById(R.id.editCode);
        btnSub=(Button)findViewById(R.id.buttonSub);

        firebaseAuth=FirebaseAuth.getInstance();
    /*    firebaseDatabase=FirebaseDatabase.getInstance();
        dbCEO = FirebaseDatabase.getInstance().getReference("CEO");
        dbManager = FirebaseDatabase.getInstance().getReference("MD");
        dbDepart = FirebaseDatabase.getInstance().getReference("Department");
        dbStaff = FirebaseDatabase.getInstance().getReference("Staff");
        dbClerk = FirebaseDatabase.getInstance().getReference("Clerk");

        Bundle bundle=getIntent().getExtras();
        name=bundle.getString("stuff");
        meet=bundle.getString("stuff1");
        pwd=bundle.getString("stuff2"); */
    }
    public void click(View view){
        switch (view.getId()){
            case R.id.textOTP:
                String mobile="8054240511";
                setUpVerificationCallbacks();
                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        mobile,        // Phone number to verify
                        60,                 // Timeout duration
                        TimeUnit.SECONDS,   // Unit of timeout
                        this,               // Activity (for callback binding)
                        verificationCallbacks);
                // OnVerificationStateChangedCallbacks}
        }
    }
    private void setUpVerificationCallbacks(){
        verificationCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                if(e instanceof FirebaseAuthInvalidCredentialsException){
                    Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_LONG).show();
                }
                else if(e instanceof FirebaseTooManyRequestsException){
                    Toast.makeText(getApplicationContext(),"SMS quota exceeded",Toast.LENGTH_LONG).show();
                }
            }
        };
    }
    public void onCodeSent(String verificationId,PhoneAuthProvider.ForceResendingToken token){
        phoneVerificationId=verificationId;
        resendingToken=token;
    }
    public void verifyCode(View view){

        String code=eCode.getText().toString().trim();
        PhoneAuthCredential credential=PhoneAuthProvider.getCredential(phoneVerificationId,code);
        signInWithPhoneAuthCredential(credential);}

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential){
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    FirebaseUser user=task.getResult().getUser();

                    Intent intent=new Intent(Otp.this,ViewDetails.class);
                    startActivity(intent);
                }
                else{
                    if(task.getException() instanceof FirebaseAuthInvalidCredentialsException){
                        Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_LONG).show();

                    }
                }

            }
        });
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
