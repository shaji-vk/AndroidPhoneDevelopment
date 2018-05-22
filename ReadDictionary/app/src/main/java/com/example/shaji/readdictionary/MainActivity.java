package com.example.shaji.readdictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnDelete = (Button)findViewById(R.id.btndelete);
        Button btnUpdate = (Button)findViewById(R.id.btnUpdate);
        btnDelete.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                deleteData(view);
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                updateData(view);
            }
        });
    }
    public void deleteData(View view)
    {
        Intent deleteData=new Intent(this,DeleteData.class);
        startActivity(deleteData);
    }
    public void updateData(View view)
    {
        Intent updateData = new Intent(this,UpdateData.class);
        startActivity(updateData);
    }
    public void addData(View view)
    {
        Intent addData = new Intent(this,AddData.class);
        startActivity(addData);
    }
    public void listData(View view)
    {
        Intent listAll=new Intent(this,ListAll.class);
        startActivity(listAll);
    }
    public void searchData(View view)
    {
        Intent searchData = new Intent(this,SearchData.class);
        startActivity(searchData);

    }
}
