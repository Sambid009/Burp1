package com.earth.burp1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String TAG = MainActivity.class.getSimpleName();


    Spinner spinner;
    boolean isSpinnerInitial = true;
    RadioGroup genderGroup;
    RadioButton radioButtonMale, radioButtonFemale;

    Button btnOk;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        Log.d(TAG,"OnCreate");
        setContentView(R.layout.activity_main);


//----------------------------Radio Button----------------------------------------------------

        genderGroup = findViewById(R.id.Gender);
        radioButtonMale = findViewById(R.id.radioButton1);
        radioButtonFemale = findViewById(R.id.radioButton2);


        genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Check which radio button was clicked
                if (checkedId == R.id.radioButton1) {
                    // Male radio button clicked
                    Toast.makeText(MainActivity.this, "Male", Toast.LENGTH_SHORT).show();
                }
                if (checkedId == R.id.radioButton2) {
                    // Female radio button clicked
                    Toast.makeText(MainActivity.this, "Female", Toast.LENGTH_SHORT).show();
                }

            }
        });






//-----------------------------Spinner-------------------------------

        //Initialize Spinner..................................
       spinner =  findViewById(R.id.spinner);

       //Create Arraylist and add items on it...................
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Permanent");
        arrayList.add("Temporary");
        arrayList.add("Contract");
        arrayList.add("Freelancer");
        arrayList.add("BBA");

        //Create Array Adapter Using ArrayList...................
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList);


        //specify the layout to use when list of choice appears
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);

        //apply adapter to spinner
        spinner.setAdapter(adapter);


        // Set a listener for when an item is selected

       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               if (!isSpinnerInitial) {
                   String item = parent.getItemAtPosition(position).toString();
                   Toast.makeText(MainActivity.this, "Selected item: " + item, Toast.LENGTH_SHORT).show();
               }
               isSpinnerInitial = false;  // Set the flag to false after the initial selection
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });








    }//end of mathod OnCreate

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart:::");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause:::");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG,"onPauseResumed:::");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"OnStop:::");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"OnDestroy:::");
    }
}//end of class MainActivity