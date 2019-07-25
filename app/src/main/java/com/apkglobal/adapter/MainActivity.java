package com.apkglobal.adapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Spinner listView;
String [] name={"pawan", "naman","chaman"};
int [] image={android.R.drawable.alert_dark_frame,
android.R.drawable.alert_dark_frame,
android.R.drawable.alert_dark_frame};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        //pass the data into collection class
        ArrayList<HashMap<String, String>> list =new ArrayList<>();
        for (int i=0; i< name.length; i++)
        {
            HashMap<String, String> hashMap=new HashMap<>();
            hashMap.put("name", name[i]);
            hashMap.put("image", image[i]+"");
            list.add(hashMap);
        }

        String [] from={"name", "image"};
        int [] to={R.id.tv, R.id.iv};
        SimpleAdapter simpleAdapter=new SimpleAdapter(this, list,
                R.layout.item, from, to );
        listView.setAdapter(simpleAdapter);

        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                {
                    Intent intent=new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });*/

        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, name[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
