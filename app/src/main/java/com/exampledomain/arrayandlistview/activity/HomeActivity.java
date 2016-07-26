package com.exampledomain.arrayandlistview.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.exampledomain.arrayandlistview.R;

public class HomeActivity extends AppCompatActivity {

    Button buttonSimpleListView, buttonCustomListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        buttonSimpleListView = (Button) findViewById(R.id.buttonSimpleSingeListView);
        buttonCustomListview = (Button) findViewById(R.id.buttonCustomListView);

        buttonSimpleListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SimpleSingleItemListViewActivity.class);
                startActivity(intent);
            }
        });

        buttonCustomListview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CustomListViewDenganAdapterActivity.class);
                startActivity(intent);
            }
        });
    }
}
