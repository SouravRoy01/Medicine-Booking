package com.example.souravroy.med4u;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Info info=new Info();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner spin = (Spinner) findViewById(R.id.spinner3);
        spin.setOnItemSelectedListener(this);



        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,info.Name);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item:
                Intent intent1=new Intent(this,RateUs.class);
                startActivity(intent1);
                return true;
            case R.id.item2:
                Intent intent2=new Intent(this,AboutUs.class);
                startActivity(intent2);
                return true;
            case R.id.item3:
                Intent intent3=new Intent(this,TermsAndConditions.class);
                startActivity(intent3);
                return true;
            case R.id.item4:
                Intent intent4=new Intent(this,Fax.class);
                startActivity(intent4);
                return true;
            case R.id.item5:
                if(!Info.cart.equals("")) {
                    Intent intent5 = new Intent(this, Cart.class);
                        startActivity(intent5);
                }
                else
                Toast.makeText(getApplicationContext(),"Cart Is Empty", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position!=0){

        Intent intent=new Intent(this,AllSearch.class);
        intent.putExtra("Position",String.valueOf(position));

        startActivity(intent);}
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void General(View view)
    {
        Intent intent=new Intent(this,Medicine.class);
        intent.putExtra("Tab","1");
        startActivity(intent);
    }

    public void Prescribed(View view){
        Intent intent=new Intent(this,Medicine.class);
        intent.putExtra("Tab","2");
        startActivity(intent);
    }
    public void Personal(View view){
        Intent intent=new Intent(this,Medicine.class);
        intent.putExtra("Tab","3");
        startActivity(intent);
    }


}
