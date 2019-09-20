package com.example.souravroy.med4u;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Order_Successful extends AppCompatActivity {
    TextView coddccc,card_details,card_number_format,card_holder_name;
    Button home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_successful);
        addListenerOnButtonClick();
    }
    public void addListenerOnButtonClick()
    {
        coddccc=(TextView)findViewById(R.id.textView26);
        card_details=(TextView)findViewById(R.id.textView27);
        card_number_format=(TextView)findViewById(R.id.textView28);
        card_holder_name=(TextView)findViewById(R.id.textView29);
        home=(Button)findViewById(R.id.button5);

        Bundle extras = getIntent().getExtras();
        Boolean cod = getIntent().getExtras().getBoolean("Cod");
        Boolean dc = getIntent().getExtras().getBoolean("Dc");

        if (cod)
        {
            coddccc.setText("CASH ON DELIVERY");
        }
        if (dc)
        {
            coddccc.setText("DEBIT/CREDIT CARD");
            card_details.setVisibility(View.VISIBLE);
            card_number_format.setText(extras.getString("Card Number"));
            card_number_format.setVisibility(View.VISIBLE);
            card_holder_name.setText(extras.getString("Card Holder"));
            card_holder_name.setVisibility(View.VISIBLE);
        }

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent txt = new Intent(Order_Successful.this, MainActivity.class);

                 startActivity(txt);

            }
        });
    }

    public  void onBackPressed(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do You Want to Close This Application ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        moveTaskToBack(true);
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent txt = new Intent(Order_Successful.this, MainActivity.class);
                        finish();
                        startActivity(txt);
                    }
                });
        AlertDialog alert = builder.create();
        alert.setTitle("Exit the Application !!");
        alert.show();
        setContentView(R.layout.order_successful);
    }
}
