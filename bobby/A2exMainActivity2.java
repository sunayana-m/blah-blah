package com.example.a2ex_165;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity2 extends AppCompatActivity {
    TextView myName;
    String nameFromFirstActivity="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myName = findViewById(R.id.mytext) ;
        nameFromFirstActivity = getIntent().getStringExtra("name");
        myName.setText(nameFromFirstActivity);
    }
}
