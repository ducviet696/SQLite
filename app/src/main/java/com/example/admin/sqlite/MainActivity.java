package com.example.admin.sqlite;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.admin.sqlite.data.DBManager;
import com.example.admin.sqlite.model.Champion;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Champion> listChampion;
    ListView listView;
    ArrayAdapter adapter;
    DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        dbManager = new DBManager(this);
        listChampion = dbManager.getAllChampion();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listChampion);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, showDetail.class);
                Champion champion = listChampion.get(i);
                intent.putExtra("cham", champion);
                startActivity(intent);
                return true;
            }
        });
    }
    public void addNew (View view)
    {
        Intent intent = new Intent(this, AddNewChampion.class);
        startActivityForResult(intent, 100);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100  )
        {
            if (resultCode == 200)
            {
                Champion champion = (Champion)data.getSerializableExtra("champion");
                dbManager.addChampion(champion);
                listChampion = dbManager.getAllChampion();
                adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listChampion);
                listView.setAdapter(adapter);

            }
        }
    }
}
