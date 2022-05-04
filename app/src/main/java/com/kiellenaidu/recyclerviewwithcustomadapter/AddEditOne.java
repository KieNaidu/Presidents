package com.kiellenaidu.recyclerviewwithcustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddEditOne extends AppCompatActivity {

    Button btn_Ok;
    Button btn_Cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_one);

        btn_Ok = findViewById(R.id.btn_Ok);
        btn_Cancel = findViewById(R.id.btn_Cancel);

        btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddEditOne.this, MainActivity.class ); //Reference to MainActivity class
                startActivity(intent);
            }
        });

        btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddEditOne.this, MainActivity.class ); //Reference to MainActivity class
                startActivity(intent);
            }
        });
    }
}