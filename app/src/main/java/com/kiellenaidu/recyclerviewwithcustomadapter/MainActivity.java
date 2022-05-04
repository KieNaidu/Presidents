package com.kiellenaidu.recyclerviewwithcustomadapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Presidents App";
    Button btn_AddOne;
    Menu menu;

    MyApplication myApplication = (MyApplication) this.getApplication();

    List<President> presidentList;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      presidentList = myApplication.getPresidentList(); //Fill the presidents with the value from the global variable


        Log.d(TAG, "onCreate: " + presidentList.toString()); //Log out all presidents after we fill them
        Toast.makeText(this, "Presidents count = " + presidentList.size() , Toast.LENGTH_SHORT).show();
        btn_AddOne = findViewById(R.id.btn_AddOne); //Referencing the "Add one" button

        //OnClick listener for "Add one" button - when user clicks this button the following actions will be executed
        btn_AddOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, AddEditOne.class); //Reference to AddEitOne class
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.lv_presidentList);

        recyclerView.setHasFixedSize(true);

        //Use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //specify an adapter
        mAdapter = new RecycleViewAdapter(presidentList, this);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()) {
            case R.id.menu_AToZ:
                //Sort from A to Z
                Collections.sort(presidentList, President.PresidentNameAZComparator);
                Toast.makeText(MainActivity.this, "Sort from A to Z", Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged(); //Notify adapter that the data has been changed
                return true;
            case R.id.menu_ZToA:
                //Sort from Z to A
                Collections.sort(presidentList, President.PresidentNameZAComparator);
                Toast.makeText(MainActivity.this, "Sort from Z to A", Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged(); //Notify adapter that the data has been changed
                return true;
            case R.id.menu_AscDate:
                //Sort from Z to A
                Collections.sort(presidentList, President.PresidentDateAscendingComparator);
                Toast.makeText(MainActivity.this, "Sort date ascending", Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged(); //Notify adapter that the data has been changed
                return true;
            case R.id.menu_DescDate:
                Collections.sort(presidentList, President.PresidentDateDescendingComparator);
                //Sort from Z to A
                Toast.makeText(MainActivity.this, "Sort date descending", Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged(); //Notify adapter that the data has been changed
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void closeOptionsMenu() {
        super.closeOptionsMenu();
    }
}
