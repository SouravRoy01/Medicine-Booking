package com.example.souravroy.med4u;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

public class Order_Summary extends AppCompatActivity {
    Button confirm;
    TextView name,flat_street,city_state_pin,number,product,price,quantity,amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_summary);
        addListenerOnButtonClick();
    }
    public void addListenerOnButtonClick() {
        confirm=(Button)findViewById(R.id.button3);
        name=(TextView)findViewById(R.id.textView9);
        flat_street=(TextView)findViewById(R.id.textView10);
        city_state_pin=(TextView)findViewById(R.id.textView11);
        number=(TextView)findViewById(R.id.textView13);

        amount=(TextView)findViewById(R.id.textView20);

        Bundle extras = getIntent().getExtras();

        amount.setText(extras.getString("Amount"));

        name.setText(extras.getString("Name"));
        flat_street.setText(extras.getString("Flat")+", "+extras.getString("Street"));
        city_state_pin.setText(extras.getString("City")+", "+extras.getString("State")+"- "+extras.getString("Pin")+".");
        number.setText(extras.getString("Phone"));

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Order_Summary.this, Payment_Details.class);
                finish();
                startActivity(intent);
            }
        });
    }
}
