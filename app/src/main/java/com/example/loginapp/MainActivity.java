package com.example.loginapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private ListView lvContact;
    private List<ContactModel> listContacts = new ArrayList<>();

    @Override

    protected void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        lvContact =(ListView) findViewById(R.id.lvContact);
        ContactAdapter  adapter = new ContactAdapter(listContacts,this);
        lvContact.setAdapter(adapter);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id    ) {
                ContactModel model = listContacts.get(position);
                Toast.makeText(MainActivity.this,model.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        ContactModel contact = new ContactModel(" nguyen van A","919149198",R.drawable.ic_avatar1);
        listContacts.add(contact);
        contact = new ContactModel(" nguyen van B","124122141",R.drawable.ic_avatar2);
        listContacts.add(contact);
        contact = new ContactModel(" nguyen van c","124124124",R.drawable.ic_avatar3);
        listContacts.add(contact);

        contact = new ContactModel(" nguyen van d","134613136",R.drawable.ic_avatar4);
        listContacts.add(contact);
        contact = new ContactModel(" nguyen van B","385664644",R.drawable.ic_avatar2);
        listContacts.add(contact);
        contact = new ContactModel(" nguyen van c","532624774",R.drawable.ic_avatar3);
        listContacts.add(contact);

        contact = new ContactModel(" nguyen van d","548465353",R.drawable.ic_avatar4);
        listContacts.add(contact);
        contact = new ContactModel(" nguyen van B","525869432",R.drawable.ic_avatar2);
        listContacts.add(contact);
        contact = new ContactModel(" nguyen van c","346375611",R.drawable.ic_avatar3);
        listContacts.add(contact);

        contact = new ContactModel(" nguyen van d","322346464",R.drawable.ic_avatar4);
        listContacts.add(contact);
    }
}
