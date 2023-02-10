package com.example.a1_165;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView l1;
    ImageView img;
    Button btn;
    int flag=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Activity created", Toast.LENGTH_SHORT).show();
        l1 = findViewById(R.id.list);
        String arr[];
        arr=getResources().getStringArray(R.array.choc);
        ArrayAdapter<String> aa=new ArrayAdapter<String>(this,R.layout.txt_layout,arr);
        l1.setAdapter(aa);
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You clicked: "+parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show(); 
            }
        });

        img = findViewById(R.id.img);
        btn = findViewById(R.id.btn1);
        img.setImageResource(R.drawable.i1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert1 = new AlertDialog.Builder(MainActivity.this);
                alert1.setIcon(R.drawable.ic_launcher_background);
                alert1.setTitle("Alert");
                alert1.setMessage("Do you want to change image?");
                alert1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "You selected yes", Toast.LENGTH_SHORT).show();
                        if (flag == 1) {
                            img.setImageResource(R.drawable.i2);
                            flag = 2;
                        } else {
                            img.setImageResource(R.drawable.i1);
                            flag = 1;
                        }
                    }
                });
                alert1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "You selected no", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog a = alert1.create();
                a.show();

            }
        });
    }

    public MainActivity(){
        super();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Activity started", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Activity stopped", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Activity destroyed", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Activity paused", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Activity resumed", Toast.LENGTH_SHORT).show();
    }


}