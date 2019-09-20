package com.example.souravroy.med4u;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class Payment_Details extends AppCompatActivity {
    CheckBox cod,dc;
    Button place_order;
    EditText card_number,card_holder,mm,yyyy;
    int n1=0,n2=0,n3=0,n4=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_details);

        place_order=(Button)findViewById(R.id.button4);
        cod=(CheckBox)findViewById(R.id.checkBox);
        dc=(CheckBox)findViewById(R.id.checkBox2);
        card_number=(EditText)findViewById(R.id.editText8);
        card_holder=(EditText)findViewById(R.id.editText9);
        mm=(EditText)findViewById(R.id.editText10);
        yyyy=(EditText)findViewById(R.id.editText11);


        card_number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                place_order.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().trim().length()==0){
                    n1=0;
                    place_order.setEnabled(false);
                }
                else {
                    n1=1;
                    if(n2==1 && n3==1 && n4==1)
                        place_order.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        card_holder.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                place_order.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().trim().length()==0){
                    n2=0;
                    place_order.setEnabled(false);
                }
                else {
                    n2=1;
                    if(n1==1 && n3==1 && n4==1)
                        place_order.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                place_order.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().trim().length()==0){
                    n3=0;
                    place_order.setEnabled(false);
                }
                else {
                    n3=1;
                    if(n1==1 && n2==1 && n4==1)
                        place_order.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        yyyy.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                place_order.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().trim().length()==0){
                    n4=0;
                    place_order.setEnabled(false);
                }
                else {
                    n4=1;
                    if(n1==1 && n2==1 && n3==1)
                        place_order.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        addListenerOnButtonClick();

    }
    public void addListenerOnButtonClick() {


        cod.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cod.isChecked())
                {
                    dc.setEnabled(false);
                    place_order.setEnabled(true);
                }
                else
                {
                    place_order.setEnabled(false);
                    dc.setEnabled(true);
                }
            }
        });

        dc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(dc.isChecked())
                {
                    cod.setEnabled(false);
                    card_number.setEnabled(true);
                    card_holder.setEnabled(true);
                    mm.setEnabled(true);
                    yyyy.setEnabled(true);
                }
                else
                {
                    place_order.setEnabled(false);
                    cod.setEnabled(true);
                    card_number.setEnabled(false);
                    card_holder.setEnabled(false);
                    mm.setEnabled(false);
                    yyyy.setEnabled(false);
                }
            }
        });

    }

    public void order(View view)
    {
        Info.cart="";
        Intent txt = new Intent(Payment_Details.this, Order_Successful.class);
        if(dc.isChecked())
        {
            txt.putExtra("Card Number",card_number.getText().toString());
            txt.putExtra("Card Holder",card_holder.getText().toString());
        }
        txt.putExtra("Cod", cod.isChecked());
        txt.putExtra("Dc", dc.isChecked());
        finish();
        startActivity(txt);
    }
}