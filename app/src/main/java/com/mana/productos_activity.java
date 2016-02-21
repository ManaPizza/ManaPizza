package com.mana;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class productos_activity extends AppCompatActivity {

    Intent change;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_activity);
        listViewM();


    }

    void listViewM(){
        final ListView listview = (ListView) findViewById(R.id.productosL);
        String[] values = new String[] {"Hawaiana", "Peperoni","Mar y tierra", "Atun"};
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

                                list.remove(item);
                                adapter.notifyDataSetChanged();
                                view.setAlpha(1);
                                change = new Intent(productos_activity.this, OrdenActivity.class);
                                startActivity(change);
                            }
                        });
            }
        });
    }
}
