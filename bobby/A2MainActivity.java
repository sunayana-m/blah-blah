package com.example.a2_165;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        call();
    }
    private void call(){
        EditText txt=findViewById(R.id.phn);
        Button btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p=txt.getText().toString();
                Toast.makeText(MainActivity.this, "Callling "+p, Toast.LENGTH_SHORT).show();
                Uri u=Uri.parse("tel:"+p);
                Intent i=new Intent(Intent.ACTION_DIAL,u);
                startActivity(i);
            }
        });
    }
}