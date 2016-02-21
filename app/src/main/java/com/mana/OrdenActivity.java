package com.mana;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class OrdenActivity extends AppCompatActivity {
    Button addmore;
    Button aceptar;
    Intent change;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden);
        addmore = (Button) findViewById(R.id.agregarmasB);
        aceptar = (Button) findViewById(R.id.aceptarB);
        addmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change = new Intent(OrdenActivity.this, productos_activity.class);
                startActivity(change);
            }
        });
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change = new Intent(OrdenActivity.this, LocalizarPedido.class);
                startActivity(change);
            }
        });
        listViewM();

    }

    void listViewM(){
        final ListView listview = (ListView) findViewById(R.id.ordenL);
        String[] values = new String[] {"Hawaiana Grande", "Refresco Mediano"};
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }
        final StableArrayAdapter adapter = new StableArrayAdapter(this,android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                view.animate().setDuration(2000).alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                            }
                        });
            }
        });
    }
}
