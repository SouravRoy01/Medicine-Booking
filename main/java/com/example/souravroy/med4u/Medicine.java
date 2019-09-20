package com.example.souravroy.med4u;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DecimalFormat;

import java.util.*;

/**
 * Created by souravroy on 18-07-2017.
 */

public class Medicine extends Activity implements AdapterView.OnItemSelectedListener {
    Info info1=new Info();
    Spinner spinner;
    TextView tv,tv1;
    TextView tv6,tv7,tv8,tv9,tv10,tv11,tv12,tv13;
    String arr[]=new String[110];
    Button bt,btminus,btplus,bt10;
    ImageView iv;
    EditText et;
    int pos=0;
    String tab;
    float price=0.00f;
    private static final int CAMERA_REQUEST = 1888;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine);
        ;
        spinner=new Spinner(this);
        spinner = (Spinner) findViewById(R.id.spinner1);

        Bundle extras = getIntent().getExtras();
        tab = extras.getString("Tab");


        spinner.setOnItemSelectedListener(this);

        tv1=(TextView)findViewById(R.id.textView3);
        int k=1;
        if(tab.equals("1")) {
            tv1.setText("General Medicines");

            for (int i = 1; i <= 110; i++) {
                if ((info1.Prescription[i] == 0) && (info1.PersonalCare[i] == 0)) {
                    arr[k++] = info1.Name[i];
                }
            }
        }
        else if(tab.equals("2"))
        {
            tv1.setText("Prescribed Medicines");

            for (int i = 1; i <= 110; i++)
            {
                if( info1.Prescription[i]==1)
                    arr[k++]=info1.Name[i];

            }
        }
        else if(tab.equals("3"))
        {
            tv1.setText("Personal Care Products");

            for (int i = 1; i <= 110; i++)
            {
                if( info1.Prescription[i]==0 && info1.PersonalCare[i]==1)
                    arr[k++]=info1.Name[i];
            }
        }








        //Storing the array in a list
        List<String> list = new ArrayList<String>();
        list.add("");
        for(String s : arr) {
            if(s != null && s.length() > 0) {         //for removing null from array
                list.add(s);
            }
        }
        arr = list.toArray(new String[list.size()]);  //list to array conversion
        arr[0]=info1.Name[0];  // EDIT IF REQUIRED
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,arr);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);




    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        bt=(Button)findViewById(R.id.button5);
        if(position!=0)
        {

            String text;


            btplus=(Button)findViewById(R.id.button6) ;
            btminus=(Button)findViewById(R.id.button7) ;
            tv1=(TextView)findViewById(R.id.textView4);
            et=(EditText)findViewById(R.id.editText);

            for(int i=1;i<=110;i++)
            {
                if(arr[position]==info1.Name[i])
                    pos=i;
            }
            tv=(TextView)findViewById(R.id.textView2);

            tv6=(TextView)findViewById(R.id.textView6);
            tv7=(TextView)findViewById(R.id.textView7);
            tv8=(TextView)findViewById(R.id.textView8);
            tv9=(TextView)findViewById(R.id.textView9);

            tv10=(TextView)findViewById(R.id.textView10);
            tv11=(TextView)findViewById(R.id.textView11);
            tv12=(TextView)findViewById(R.id.textView12);
            tv13=(TextView)findViewById(R.id.textView13);



            if(info1.Quantity[pos]>0) {
                price = (info1.Price[pos] * (1 - (float) info1.Discount[pos] / 100));
                DecimalFormat df = new DecimalFormat("#.00");
                price = Float.valueOf(df.format(price));
                tv10.setText(String.valueOf(info1.Name[pos]));
                tv11.setText(String.valueOf(info1.Price[pos]));
                tv12.setText(String.valueOf(info1.Discount[pos]));
                tv13.setText(String.valueOf(price));

                bt.setEnabled(true);
                et.setVisibility(View.VISIBLE);
                btminus.setVisibility(View.VISIBLE);
                btplus.setVisibility(View.VISIBLE);
                tv1.setVisibility(View.VISIBLE);

                tv6.setVisibility(View.VISIBLE);
                tv7.setVisibility(View.VISIBLE);
                tv8.setVisibility(View.VISIBLE);
                tv9.setVisibility(View.VISIBLE);

                tv.setText("");

                bt10=(Button)this.findViewById(R.id.buttonpr);
                iv=(ImageView)this.findViewById(R.id.imageView);


                iv.setImageBitmap(null);

                if(tab.equals("2"))
                {
                    bt10.setVisibility(View.VISIBLE);
                    iv.setVisibility(View.VISIBLE);
                    bt.setEnabled(false);
                    bt10.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(cameraIntent, CAMERA_REQUEST);

                        }
                    });

                }
            }
            else
            {
                pos=0;
                tv.setText("Product out of stock !");
                bt.setEnabled(false);
                et.setVisibility(View.INVISIBLE);
                btminus.setVisibility(View.INVISIBLE);
                btplus.setVisibility(View.INVISIBLE);
                tv1.setVisibility(View.INVISIBLE);

                tv6.setVisibility(View.INVISIBLE);
                tv7.setVisibility(View.INVISIBLE);
                tv8.setVisibility(View.INVISIBLE);
                tv9.setVisibility(View.INVISIBLE);
                tv10.setText("");
                tv11.setText("");
                tv12.setText("");
                tv13.setText("");

                bt10.setVisibility(View.INVISIBLE);
                iv.setVisibility(View.INVISIBLE);
            }

        }
        else
        {
            bt.setEnabled(false);
        }


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == CAMERA_REQUEST) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            iv.setImageBitmap(photo);
            bt.setEnabled(true);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void addtocart(View view)
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

                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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

    public void plus(View view)
    {
        btminus=(Button)findViewById(R.id.button7) ;
        et=(EditText)findViewById(R.id.editText);
        int n=Integer.parseInt(et.getText().toString());
        n++;
        if(n>1)
            btminus.setEnabled(true);
        if(n==info1.Quantity[pos])
            btplus.setEnabled(false);
        et.setText(String.valueOf(n));
    }

    public void minus(View view)
    {

        btminus=(Button)findViewById(R.id.button7) ;
        et = (EditText) findViewById(R.id.editText);
        int n = Integer.parseInt(et.getText().toString());
            n--;
        if(n==1)
            btminus.setEnabled(false);
        if(n<info1.Quantity[pos])
            btplus.setEnabled(true);
        et.setText(String.valueOf(n));

    }
}
