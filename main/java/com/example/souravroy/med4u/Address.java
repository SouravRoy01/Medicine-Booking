package com.example.souravroy.med4u;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Address extends AppCompatActivity {
    EditText name,flat,street,pin,city,state,phone;
    Button proceed;
    int n1=0,n2=0,n3=0,n4=0,n5=0,n6=0,n7=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        name=(EditText)findViewById(R.id.editText);
        flat=(EditText)findViewById(R.id.editText2);
        street=(EditText)findViewById(R.id.editText3);
        pin=(EditText)findViewById(R.id.editText4);
        city=(EditText)findViewById(R.id.editText5);
        state=(EditText)findViewById(R.id.editText6);
        phone=(EditText)findViewById(R.id.editText7);
        proceed=(Button)findViewById(R.id.button2);


        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                proceed.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().trim().length()==0){
                    n1=0;
                    proceed.setEnabled(false);
                }
                else {
                    n1=1;
                    if(n2==1 && n3==1 && n4==1 && n5==1 && n6==1 && n7==1)
                        proceed.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        flat.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                proceed.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().trim().length()==0){
                    n2=0;
                    proceed.setEnabled(false);
                }
                else {
                    n2=1;
                    if(n1==1 && n3==1 && n4==1 && n5==1 && n6==1 && n7==1)
                        proceed.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        street.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                proceed.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().trim().length()==0){
                    n3=0;
                    proceed.setEnabled(false);
                }
                else {
                    n3=1;
                    if(n1==1 && n2==1 && n4==1 && n5==1 && n6==1 && n7==1)
                        proceed.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        pin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                proceed.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().trim().length()==0){
                    n4=0;
                    proceed.setEnabled(false);
                }
                else {
                    n4=1;
                    if(n1==1 && n2==1 && n3==1 && n5==1 && n6==1 && n7==1)
                        proceed.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        city.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                proceed.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().trim().length()==0){
                    n5=0;
                    proceed.setEnabled(false);
                }
                else {
                    n5=1;
                    if(n1==1 && n2==1 && n3==1 && n4==1 && n6==1 && n7==1)
                        proceed.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        state.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                proceed.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().trim().length()==0){
                    n6=0;
                    proceed.setEnabled(false);
                }
                else {
                    n6=1;
                    if(n1==1 && n2==1 && n3==1 && n4==1 && n5==1 && n7==1)
                        proceed.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                proceed.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().trim().length()==0){
                    n7=0;
                    proceed.setEnabled(false);
                }
                else {
                    n7=1;
                    if(n1==1 && n2==1 && n3==1 && n4==1 && n5==1 && n6==1)
                        proceed.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }

    public void proceed(View view)
    {
        Intent txt = new Intent(Address.this, Order_Summary.class);
        Bundle extra = getIntent().getExtras();
        String am=extra.getString("amount");
        txt.putExtra("Amount",am);
        txt.putExtra("Name",name.getText().toString());
        txt.putExtra("Flat",flat.getText().toString());
        txt.putExtra("Street",street.getText().toString());
        txt.putExtra("Pin",pin.getText().toString());
        txt.putExtra("City",city.getText().toString());
        txt.putExtra("State",state.getText().toString());
        txt.putExtra("Phone",phone.getText().toString());
        startActivity(txt);
    }

}