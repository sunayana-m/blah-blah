package com.example.a3_165;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,plus,minus,star,slash,equals,dot,clear;
    EditText res;
    String op="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);
        b0=findViewById(R.id.b0);
        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        star=findViewById(R.id.star);
        slash=findViewById(R.id.slash);
        equals=findViewById(R.id.equals);
        dot=findViewById(R.id.dot);
        clear=findViewById(R.id.clear);
        res=findViewById(R.id.res);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        star.setOnClickListener(this);
        slash.setOnClickListener(this);
        dot.setOnClickListener(this);
        equals.setOnClickListener(this);
        res.setOnClickListener(this);
        clear.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        double ans;
        switch (v.getId()){
            case R.id.b0:res.append("0");
                break;
            case R.id.b1:res.append("1");
                break;
            case R.id.b2:res.append("2");
                break;
            case R.id.b3:res.append("3");
                break;
            case R.id.b4:res.append("4");
                break;
            case R.id.b5:res.append("5");
                break;
            case R.id.b6:res.append("6");
                break;
            case R.id.b7:res.append("7");
                break;
            case R.id.b8:res.append("8");
                break;
            case R.id.b9:res.append("9");
                break;
            case R.id.plus:res.append("+");
                op="+";
                break;
            case R.id.minus:res.append("-");
                op="-";
                break;
            case R.id.star:res.append("*");
                op="*";
                break;
            case R.id.slash:res.append("/");
                op="/";
                break;
            case R.id.dot:res.append(".");
                break;
            case R.id.clear:res.setText("");
                break;
            case R.id.equals:ans=evaluate(res.getText().toString(),op);
                res.setText(String.valueOf(ans));
                break;
        }
    }

    private double evaluate(String str, String operator) {
        String[] op=str.split("[+\\-*/]");
        double op1=Double.parseDouble(op[0]);
        double op2=Double.parseDouble(op[1]);
        switch(operator){
            case "+":return (op1+op2);
            case "-":return (op1-op2);
            case "*":return (op1*op2);
            case "/":return (op1/op2);
            default:return 0;
        }
    }


}