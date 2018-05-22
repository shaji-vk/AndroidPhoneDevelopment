package com.example.shaji.readdictionary;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.icu.util.Calendar;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class AddData extends AppCompatActivity {
    private DatePicker datePicker;
    private EditText dateField;
    int year,month,day;
    private Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        calendar=Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);


        EditText dateField = (EditText)findViewById(R.id.txtdob);


        dateField.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                showDateDialoge(v);
            }
        });
        //dateField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
        //    @Override
        //    public void onFocusChange(View v, boolean hasFocus) {
        //        if(!hasFocus){
        //            showDate(v,year,month,day);
        //        }
        //    }
        //});

        Button btnCancel=(Button)findViewById(R.id.btncancel);
        Button btnSave=(Button)findViewById(R.id.btnsave);
        btnCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                saveToDB();
            }
        });
        showDate(dateField,year,month,day);
    }
    @SuppressWarnings("deprecation")
    public void showDateDialoge(View view)
    {
        showDialog(999);
        Toast.makeText(this.getApplicationContext(), "in",
                Toast.LENGTH_SHORT)
                .show();
    }
    @SuppressWarnings("deprecation")
    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    month=arg2;
                    year=arg1;
                    day=arg3;
                    EditText dateFiles=(EditText)findViewById(R.id.txtdob);
                    showDate(dateFiles,arg1, arg2+1, arg3);
                }
            };
    private void showDate(View v,int year, int month, int day) {
        EditText txtDate=(EditText)v;
        txtDate.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }
    private void saveToDB()
    {
        //DbHelper DB = new DbHelper(this.getApplicationContext());
        DbHelper DB = new DbHelper(AddData.this);
        SQLiteDatabase dataBase = DB.getWritableDatabase();
        ContentValues values = new ContentValues();
        EditText txtFirstName = (EditText)findViewById(R.id.txtfirstname);
        EditText txtLastName = (EditText)findViewById(R.id.txtlastname);
        EditText txtDob = (EditText)findViewById(R.id.txtdob);
        values.put(MembersInfo.FIRST_NAME,txtFirstName.getText().toString());
        values.put(MembersInfo.LAST_NAME,txtLastName.getText().toString());
        values.put(MembersInfo.DATE_OF_BIRTH,txtDob.getText().toString());
        dataBase.insert(MembersInfo.TABLE,null,values);
        dataBase.close();
        Toast.makeText(this.getApplicationContext(),"Data Saved Successfully !",Toast.LENGTH_SHORT).show();
    }
}
