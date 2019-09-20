package com.example.souravroy.med4u;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RateUs extends AppCompatActivity {

    RatingBar ratingbar1;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ratingbar1=(RatingBar)findViewById(R.id.ratingBar);
        button=(Button)findViewById(R.id.button11);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {

                String rating=String.valueOf(ratingbar1.getRating());
                Toast.makeText(getApplicationContext(),"Thank You for giving us " + rating + " stars!", Toast.LENGTH_LONG).show();
                button.setEnabled(false);
            }

        });
    }

}
