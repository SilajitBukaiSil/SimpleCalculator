package com.example1.silajit.simplecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener { // Parent class is Activity

    //Declaration
    EditText etNum1; // EditText is a class= start with uppercase & etNum1 is a variable= start with lowercase & its not occupy any memory, because we are not initialize any value
    EditText etNum2;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;
    Button reset;

    TextView tvReult;

    String oper = "";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) { // public because its called "Activity" class, and void for null pointer
        super.onCreate(savedInstanceState);// Memory created for the activity/blank screen,'super' is help to called the parent class Activity
        setContentView(R.layout.activity_main);//Layout added to blank screen, because (R.layout.activity_main helps to plugin in between xml & Java

        // setContentView must be declare before findViewById() method call

        // find the elements & initialization
        etNum1 = (EditText) findViewById(R.id.etNum1); // findViewById is a method which search id from xml file
        etNum2 = (EditText) findViewById(R.id.etNum2);

        btnAdd = (Button) findViewById(R.id.btnAdd); // R is stand for resource
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        tvReult = (TextView) findViewById(R.id.tvResult);

        reset = (Button) findViewById(R.id.reset);

        reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                etNum1.setText(" ");
                etNum2.setText(" ");
                tvReult.setText(" ");

            }
        });

        // set a listener
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        // check if the fields are empty
        if (TextUtils.isEmpty(etNum1.getText().toString())//getText method is used for gettting the default value
                || TextUtils.isEmpty(etNum2.getText().toString())) {
            return;
        }

        // read EditText and fill variables with numbers
        // Take the value from EditText and convert into an Float
        num1 = Float.parseFloat(etNum1.getText().toString()); // parseFloat use for parsing
        num2 = Float.parseFloat(etNum2.getText().toString());

        // defines the button that has been clicked and performs the corresponding operation
        // write operation into oper, we will use it later for output
        switch (v.getId()) {
            case R.id.btnAdd:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.btnSub:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.btnMult:
                oper = "*";
                result = num1 * num2;
                break;
            case R.id.btnDiv:
                oper = "/";
                result = num1 / num2;
                break;
            default:
                break;
        }

        // form the output line & set the result to textview
        tvReult.setText(num1 + " " + oper + " " + num2 + " = " + result);// concatination

    }

}
