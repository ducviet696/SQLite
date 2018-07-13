package com.example.admin.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.admin.sqlite.model.Champion;

public class AddNewChampion extends AppCompatActivity {


    EditText etName;
    EditText etPrice;
    EditText etType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_champion);
        etName = findViewById(R.id.etName);
        etPrice = findViewById(R.id.etPrice);
        etType = findViewById(R.id.etType);
    }
    public void btnSave(View view) {
        Intent intent = new Intent();
        String name = etName.getText().toString();
        double price = Double.parseDouble(etPrice.getText().toString());
        String type = etType.getText().toString();
        Champion champion = new Champion(name, price, type);
        intent.putExtra("champion", champion);
        setResult(200, intent);
        finish();

    }
}
