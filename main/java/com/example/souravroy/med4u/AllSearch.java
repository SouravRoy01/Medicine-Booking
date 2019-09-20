package com.example.souravroy.med4u;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

/**
 * Created by souravroy on 18-07-2017.
 */

public class AllSearch extends Activity
{
    Info info1=new Info();
    TextView tv,tv1;
    TextView tv14,tv15,tv16,tv17,tv18,tv19,tv20,tv21;
    float price=1.00f;
    String text;
    Button bt,btplusall,btminusall;
    EditText etall;
    int pos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_search);
       ;

        bt=(Button)findViewById(R.id.button4);
        btplusall=(Button)findViewById(R.id.button8);
        btminusall=(Button)findViewById(R.id.button9);
        etall=(EditText) findViewById(R.id.editText2);
        tv1=(TextView) findViewById(R.id.textView5);
        tv=new TextView(this);
        tv=(TextView)findViewById(R.id.textView);
        Bundle extras = getIntent().getExtras();  //used to share data b/w activities
        pos = Integer.parseInt(extras.getString("Position"));

        tv14=(TextView)findViewById(R.id.textView14);
        tv15=(TextView)findViewById(R.id.textView15);
        tv16=(TextView)findViewById(R.id.textView16);
        tv17=(TextView)findViewById(R.id.textView17);
        tv18=(TextView)findViewById(R.id.textView18);
        tv19=(TextView)findViewById(R.id.textView19);
        tv20=(TextView)findViewById(R.id.textView20);
        tv21=(TextView)findViewById(R.id.textView21);

       if(info1.Quantity[pos]>0)
       {
           price=(float)(info1.Price[pos]*(1-(float)info1.Discount[pos]/100));
           DecimalFormat df = new DecimalFormat("#.00");
           price = Float.valueOf(df.format(price));
           tv18.setText(String.valueOf(info1.Name[pos]));
           tv19.setText(String.valueOf(info1.Price[pos]));
           tv20.setText(String.valueOf(info1.Discount[pos]));
           tv21.setText(String.valueOf(price));

           bt.setEnabled(true);
           etall.setVisibility(View.VISIBLE);
           btminusall.setVisibility(View.VISIBLE);
           btplusall.setVisibility(View.VISIBLE);
           tv1.setVisibility(View.VISIBLE);

           tv14.setVisibility(View.VISIBLE);
           tv15.setVisibility(View.VISIBLE);
           tv16.setVisibility(View.VISIBLE);
           tv17.setVisibility(View.VISIBLE);

           tv.setText("");
       }
       else
       {
           tv.setText("Product out of stock !");
           bt.setVisibility(View.INVISIBLE);

           tv14.setVisibility(View.INVISIBLE);
           tv15.setVisibility(View.INVISIBLE);
           tv16.setVisibility(View.INVISIBLE);
           tv17.setVisibility(View.INVISIBLE);
           tv18.setText("");
           tv19.setText("");
           tv20.setText("");
           tv21.setText("");

       }



    }

    public void addtocartall(View view)
    {
        //FOR MULTUPLE ORDERS
        if(Info.cart=="")
            Info.cart=String.valueOf(pos);
        else
            Info.cart=Info.cart+","+pos;


        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        builder.setMessage("Do you want to Continue Shopping ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //finish();
                        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Go to Cart", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent=new Intent(getApplicationContext(),Cart.class);
                        startActivity(intent);
                    }
                });


        AlertDialog alert = builder.create();
        alert.setTitle("Product Added to Cart");
        alert.show();

    }

    public void plusall(View view)
    {
        btminusall=(Button)findViewById(R.id.button9) ;
        etall=(EditText)findViewById(R.id.editText2);
        int n=Integer.parseInt(etall.getText().toString());
        n++;
        if(n>1)
            btminusall.setEnabled(true);
        if(n== Info.Quantity[pos])
            btplusall.setEnabled(false);
        etall.setText(String.valueOf(n));
    }

    public void minusall(View view)
    {

        btminusall=(Button)findViewById(R.id.button9) ;
        etall = (EditText) findViewById(R.id.editText2);
        int n = Integer.parseInt(etall.getText().toString());
        n--;
        if(n==1)
            btminusall.setEnabled(false);
        if(n<info1.Quantity[pos])
            btplusall.setEnabled(true);
        etall.setText(String.valueOf(n));

    }

}
