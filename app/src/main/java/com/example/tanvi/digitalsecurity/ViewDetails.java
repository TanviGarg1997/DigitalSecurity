package com.example.tanvi.digitalsecurity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ViewDetails extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
        getSupportActionBar().setTitle("Employees List ");

        listView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        adapter.add("CEO"); //0
        adapter.add("MD");
        adapter.add("Department Head");
        adapter.add("Staff Member");
        adapter.add("Clerk"); //n-1
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item) ;
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String Employee = adapter.getItem(i);
        Intent intent1 = new Intent(ViewDetails.this,UsersList.class);
        intent1.putExtra("keySong",Employee);
        startActivity(intent1);
    }
}
