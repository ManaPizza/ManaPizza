package com.mana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button domicilio;
    Button sucursales;
    Intent change;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        domicilio = (Button) findViewById(R.id.domicilioB);
        sucursales = (Button) findViewById(R.id.sucursalesB);

        domicilio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change = new Intent(MainActivity.this, productos_activity.class);
                startActivity(change);
            }
        });
        sucursales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change = new Intent(MainActivity.this, SucursalesActivity.class);
                startActivity(change);
            }
        });
    }
}
