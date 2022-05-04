package com.kiellenaidu.recyclerviewwithcustomadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Presidents App";
    Button btn_AddOne;

    List<President> presidentList = new ArrayList<President>(); //List of presidents class

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillPresidentList();
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

    private void fillPresidentList() {
        //Creating a new president
        President p0 = new President(0, "George washington", 1788, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg/160px-Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg" );
        President p1 = new President(1, "John Adams", 1796, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/70/John_Adams%2C_Gilbert_Stuart%2C_c1800_1815.jpg/160px-John_Adams%2C_Gilbert_Stuart%2C_c1800_1815.jpg");
        President p2 = new President(2, "Thomas Jefferson", 1800, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1e/Thomas_Jefferson_by_Rembrandt_Peale%2C_1800.jpg/160px-Thomas_Jefferson_by_Rembrandt_Peale%2C_1800.jpg");
        President p3 = new President(3, "James Madison", 1808, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/James_Madison.jpg/160px-James_Madison.jpg");
        President p4 = new President(4, "James Monroe", 1816, "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/James_Monroe_White_House_portrait_1819.jpg/160px-James_Monroe_White_House_portrait_1819.jpg");
        President p5 = new President(5, "John Qunicy Adams", 1824, "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/John_Quincy_Adams_by_Charles_Osgood.jpg/160px-John_Quincy_Adams_by_Charles_Osgood.jpg");
        President p6 = new President(6, "Andrew Jackson", 1828, "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Andrew_jackson_head.jpg/160px-Andrew_jackson_head.jpg" );
        President p7 = new President(7, "Martin Van Buren", 1836, "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8b/Martin_Van_Buren_circa_1837_crop.jpg/160px-Martin_Van_Buren_circa_1837_crop.jpg");
        President p8 = new President(8, "William Henry Harrison", 1840, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/William_Henry_Harrison_by_James_Reid_Lambdin%2C_1835_crop.jpg/160px-William_Henry_Harrison_by_James_Reid_Lambdin%2C_1835_crop.jpg");
        President p9 = new President(1, "John Tyler", 1840, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/John_Tyler%2C_Jr.jpg/160px-John_Tyler%2C_Jr.jpg");

        //Making list of presidents into one list
        presidentList.addAll(Arrays.asList(new President [] {p0, p1, p2, p3, p4, p5, p6, p7, p8, p9}));
    }
}