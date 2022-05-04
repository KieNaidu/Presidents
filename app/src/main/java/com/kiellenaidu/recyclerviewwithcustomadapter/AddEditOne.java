package com.kiellenaidu.recyclerviewwithcustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class AddEditOne extends AppCompatActivity {

    Button btn_Ok;
    Button btn_Cancel;
    EditText et_PresidentName;
    EditText et_DateElection;
    EditText et_ImgURL;
    int id;
    TextView txt_presidentIDNo;

    List<President> presidentList;

    MyApplication myApplication = (MyApplication) this.getApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_one);


        presidentList = myApplication.getPresidentList();

        btn_Ok = findViewById(R.id.btn_Ok);
        btn_Cancel = findViewById(R.id.btn_Cancel);
        et_PresidentName = findViewById(R.id.et_PresidentName);
        et_DateElection = findViewById(R.id.et_DateElection);
        et_ImgURL = findViewById(R.id.et_ImgURL);
        txt_presidentIDNo = findViewById(R.id.txt_presidentIDNo);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        President president = null;

        if (id >= 0) {
            //Edit president
            for (President p : presidentList) {
                if (p.getId() == id) {
                    president = p;
                }
            }
            et_PresidentName.setText(president.getName());
            et_DateElection.setText(String.valueOf(president.getDateOfElection()));
            et_ImgURL.setText(president.getImageURL());
            txt_presidentIDNo.setText(String.valueOf(id));
        } else {
            //Create new president

        }


        btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id >= 0) {
                   //Update
                    President updatedPresident = new President(id, et_PresidentName.getText().toString(), Integer.parseInt(et_DateElection.getText().toString()), et_ImgURL.getText().toString());
                    presidentList.set(id, updatedPresident);
                } else {
                    //Add new president
                    //create president object
                    int nextId = myApplication.getNextId();
                    President newPresident = new President(nextId, et_PresidentName.getText().toString(), Integer.parseInt(et_DateElection.getText().toString()), et_ImgURL.getText().toString());

                    //add to global list
                    presidentList.add(newPresident);
                    myApplication.setNextId(nextId++);
                }



                //go back to main activity


                Intent intent = new Intent(AddEditOne.this, MainActivity.class); //Reference to MainActivity class
                startActivity(intent);
            }
        });

        btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddEditOne.this, MainActivity.class); //Reference to MainActivity class
                startActivity(intent);
            }
        });
    }
}
