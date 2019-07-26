package com.example.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView friendsListView = (ListView) findViewById(R.id.friendsListView);

        final ArrayList<String> myFriends = new ArrayList<String>(asList("John","Paul","George","Ringo"));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myFriends);

        friendsListView.setAdapter(arrayAdapter);

        friendsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),"Hello " + myFriends.get(position),Toast.LENGTH_LONG).show();
            }
        });
        /*ListView myListView = (ListView) findViewById(R.id.friendListView);

        ArrayList<String> myFamily = new ArrayList<String>();

        myFamily.add("Rob");
        myFamily.add("Kirsten");
        myFamily.add("Tommy");
        myFamily.add("Ralphie");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myFamily);

        myListView.setAdapter(arrayAdapter);*/

    }
}
