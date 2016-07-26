package com.exampledomain.arrayandlistview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.exampledomain.arrayandlistview.R;

public class SimpleSingleItemListViewActivity extends AppCompatActivity {

    // membbuat listview menjadi variable global
    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Deklarasi list view dari activity_main.xml
        listView = (ListView) findViewById(R.id.listView);

        // Membuat array untuk listview
        String[] values = new String[] { "ListView Android",
                "Implementasi adapter",
                "Simple ListView Android",
                "Membuat Listview",
                "Contoh ListView Android",
                "Belajar Android",
                "Perkenalan Array",
                "Memasukan Array Kedalam ListView",
                "Android ListView",
                "Implementasi ListView",
                "Simple Single ListView",
                "Numazu Okeh",
                "Numazu Android",
                "Android Development"
        };

        // Deklarasi adapter dengan array
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        //set adapter ke listview
        listView.setAdapter(adapter);

        // menggunakan fungsi saat klik item listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // mengambil posisi item dan di + 1 karna array memulai perhitungan dari 0
                int posisiItem = position+1;

                // mengambil text berdasarkan posisi item
                String itemValue = (String) listView.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(), "Posisi item di "+posisiItem+" yang valuenya : " + itemValue, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
