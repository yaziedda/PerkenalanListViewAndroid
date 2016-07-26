package com.exampledomain.arrayandlistview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.exampledomain.arrayandlistview.R;
import com.exampledomain.arrayandlistview.adapter.ListViewCustomAdapter;
import com.exampledomain.arrayandlistview.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewDenganAdapterActivity extends AppCompatActivity {

    // deklrasi listview dan listItem menjadi variable global
    ListView listView;
    List<ItemModel> listItem = new ArrayList<>();
    ListViewCustomAdapter listViewCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Deklarasi list view dari activity_main.xml
        listView = (ListView) findViewById(R.id.listView);

        // memanggil model ItemModel
        ItemModel itemModel1 = new ItemModel();
        // set Judul yang ada di dalam model
        itemModel1.setJudul("Judul Pertama");
        // set Deskripsi yang ada di dalam model
        itemModel1.setDeskripsi("Deskripsi Pertama");

        ItemModel itemModel2 = new ItemModel();
        itemModel2.setJudul("Judul Kedua");
        itemModel2.setDeskripsi("Deskripsi kedua");

        ItemModel itemModel3 = new ItemModel();
        itemModel3.setJudul("Judul Ketiga");
        itemModel3.setDeskripsi("Deskripsi Ketiga");

        // dan seterustnya

        // Model yang sudah di set ke dalam listItem
        listItem.add(itemModel1);
        listItem.add(itemModel2);
        listItem.add(itemModel3);

        // dan seterusnya sesuai jumlah model yang di panggil dan di set

        // Implementasi ListViewCustomAdapter untuk mengcustom ListView
        listViewCustomAdapter = new ListViewCustomAdapter(getApplicationContext(), listItem);

        // set list view dengan adapter yang sudah di implementasi di atas
        listView.setAdapter(listViewCustomAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // mengambil posisi item di + 1 karna array memulai perhitungan dari 0
                int posisiItem = position+1;

                // mengambil model berdasarkan posisi item nya
                ItemModel itemModel = listItem.get(position);

                // Membuat toast Posisi item di : posisi item Dengan judul : judulnya dan dengan Deskiprsi : deskripsinya berdasarkan posisi item
                Toast.makeText(getApplicationContext(), "Posisi item di : "+posisiItem+" Dengan judul : "+itemModel.getJudul()+" dan dengan deskripsi : "+itemModel.getDeskripsi(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
