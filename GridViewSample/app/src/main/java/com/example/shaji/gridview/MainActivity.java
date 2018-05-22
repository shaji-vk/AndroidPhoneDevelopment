package com.example.shaji.gridview;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
implements AdapterView.OnItemSelectedListener  {
    TextView selection;
    String[] items={"lorem", "ipsum", "dolor", "sit", "amet",
            "consectetuer", "adipiscing", "elit", "morbi", "vel",
            "ligula", "vitae", "arcu", "aliquet", "mollis",
            "etiam", "vel", "erat", "placerat", "ante",
            "porttitor", "sodales", "pellentesque", "augue", "purus"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selection=(TextView)findViewById(R.id.selection);
        GridView gv=(GridView)findViewById(R.id.gridview);
        gv.setAdapter(new FunnyLookingAdapter(this,android.R.layout.simple_list_item_1,items));
        gv.setOnItemSelectedListener(this);

    }

    public void onItemSelected(AdapterView<?> parent,View v,int position, long id)
    {
        selection.setText(items[position]);
    }
    public void onNothingSelected(AdapterView<?> parent)
    {
        selection.setText("");
    }
    private class FunnyLookingAdapter extends ArrayAdapter
    {
        Context ctx;
        public FunnyLookingAdapter(Context context,int resource,String[] items)
        {
            super(context,resource,items);
            this.ctx=context;
        }
        public View getView(int position, View convertView, ViewGroup parent)
        {
            TextView label=(TextView)convertView;
            if(convertView == null)
            {
                convertView=new TextView(this.ctx);
                label=(TextView)convertView;
            }
            label.setText(items[position]);
            return (convertView);
        }
    }
}
