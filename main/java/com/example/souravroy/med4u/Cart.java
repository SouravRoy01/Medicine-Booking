package com.example.souravroy.med4u;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Cart extends AppCompatActivity {
    Info in=new Info();
    EditText et;
    Button apply, checkout;
    TextView product, price;
    TextView tv,tv1;
    StringBuilder text;
    float total=0.00f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        addListenerOnButtonClick();

        tv=(TextView)findViewById(R.id.textView30) ;
        tv1=(TextView)findViewById(R.id.textView31) ;
        tv.setMovementMethod(new ScrollingMovementMethod());


        String[] arr=Info.cart.split(",");

        text=new StringBuilder();

        for(String w:arr)
        {
            int p=Integer.parseInt(w);
            float price=(in.Price[p]*(1-(float)in.Discount[p]/100));
            DecimalFormat df = new DecimalFormat("#.00");
            price = Float.valueOf(df.format(price));
            total=Float.valueOf(df.format(total+price));
            text.append(in.Name[p]+ " Price: "+ price +"\n");
        }

        tv.setText(text);
        tv1.setText(String.valueOf(total));

    }

    public void addListenerOnButtonClick() {
        apply=(Button)findViewById(R.id.button);
        checkout=(Button)findViewById(R.id.button1);


        et=(EditText)findViewById(R.id.editText);




        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message=et.getText().toString();

                if(message.equals("D25"))
                {
                    total=total*0.90f;
                    DecimalFormat df = new DecimalFormat("#.00");
                    total = Float.valueOf(df.format(total));
                    Toast.makeText(getApplicationContext(),"COUPON CODE APPLIED SUCCESSFULLY",Toast.LENGTH_SHORT).show();
                    tv1.setText(String.valueOf(total));
                    apply.setEnabled(false);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"COUPON CODE INVALID",Toast.LENGTH_SHORT).show();
                }
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
            }
        });

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent txt = new Intent(Cart.this, Address.class);
                txt.putExtra("amount",String.valueOf(total));
                startActivity(txt);
            }
        });
    }
}
