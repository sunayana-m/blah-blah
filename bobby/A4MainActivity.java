package com.example.a4_165;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button register,update,delete,display;
    EditText uname,pswd;
    TextView show;
    private static final String dbname="studentdb";
    private static final String tname="student";
    private static final int dbversion=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname=findViewById(R.id.uname);
        pswd=findViewById(R.id.upasswod);

        show=findViewById(R.id.displayView);

        register=findViewById(R.id.regbtn);
        update=findViewById(R.id.updbtn);
        delete=findViewById(R.id.delbtn);
        display=findViewById(R.id.disbtn);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbhel = new DBHelper(MainActivity.this, dbname, null, dbversion);
                long ans = dbhel.add(uname.getText().toString(), pswd.getText().toString());
                if (ans == -1)
                    Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbhel=new DBHelper(MainActivity.this,dbname,null,dbversion);
                dbhel.update(uname.getText().toString(),pswd.getText().toString());
                Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_SHORT).show();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbhel=new DBHelper(MainActivity.this,dbname,null,dbversion);
                dbhel.delete(uname.getText().toString(),pswd.getText().toString());
                Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbhel=new DBHelper(MainActivity.this,dbname,null,dbversion);
                String dis=dbhel.display();
                show.setText(dis);
            }
        });
    }
}