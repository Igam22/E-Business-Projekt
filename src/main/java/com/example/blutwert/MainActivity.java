package com.example.blutwert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //references to buttons amd otter controls on the layouts
    Button btn_add, btn_viewAll;
    EditText et_datum, et_eisengehalt, et_cholesteringehalt, et_blutzucker, et_triglyceride, et_blutdruck, et_vitamind, et_vitaminb12;
    ListView lv_customerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);
        btn_viewAll = findViewById(R.id.btn_viewAll);
        et_datum = findViewById(R.id.et_datum);
        et_eisengehalt = findViewById(R.id.et_eisengehalt);
        et_cholesteringehalt = findViewById(R.id.et_cholesteringehalt);
        et_blutzucker = findViewById(R.id.et_blutzucker);
        et_triglyceride = findViewById(R.id.et_triglyceride);
        et_blutdruck = findViewById(R.id.et_blutdruck);
        et_vitamind = findViewById(R.id.et_vitamind);
        et_vitaminb12 = findViewById(R.id.et_vitaminb12);
        lv_customerList = findViewById(R.id.lv_customerList);

        //button listerners for the add and view all buttons
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CustomerModel customerModel;

                try{
                     customerModel = new CustomerModel(
                            -1,
                            et_datum.getText().toString(),
                            Integer.parseInt(et_eisengehalt.getText().toString()),
                            Integer.parseInt(et_cholesteringehalt.getText().toString()),
                            Integer.parseInt(et_blutzucker.getText().toString()),
                            Integer.parseInt(et_triglyceride.getText().toString()),
                            Integer.parseInt(et_blutdruck.getText().toString()),
                            Integer.parseInt(et_vitamind.getText().toString()),
                            Integer.parseInt(et_vitaminb12.getText().toString())
                    );

                    Toast.makeText(MainActivity.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error Creating Customer", Toast.LENGTH_SHORT).show();
                    customerModel = new CustomerModel(-1, "error", 0, 0,0,0,0,0,0);
                }

                DataBaseHelper dataBaseHelper= new DataBaseHelper(MainActivity.this);
                boolean success = dataBaseHelper.addOne(customerModel);
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();


            }
        });

        btn_viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
                //List<CustomerModel> everyone = dataBaseHelper.getEveryone();
                Toast.makeText(MainActivity.this, "everyone.toString()", Toast.LENGTH_SHORT).show();

            }
        });


    }
}