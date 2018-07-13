package com.example.admin.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.admin.sqlite.model.Champion;

public class showDetail extends AppCompatActivity {

    TextView tvName;
    TextView tvPrice;
    TextView tvType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        tvName = findViewById(R.id.tvName);
        tvPrice = findViewById(R.id.tvPrice);
        tvType = findViewById(R.id.tvType);
        Intent  intent = getIntent();
        Champion champion = (Champion) intent.getSerializableExtra("cham");
        tvName.setText(champion.getName());
        tvPrice.setText(String.valueOf(champion.getPrice()));
        tvType.setText(champion.getType());
    }
    public void OK(View view)
    {
        finish();
    }
}
