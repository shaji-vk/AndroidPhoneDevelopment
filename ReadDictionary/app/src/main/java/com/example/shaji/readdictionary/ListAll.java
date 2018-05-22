package com.example.shaji.readdictionary;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListAll extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all);
        List<MembersInfo> members = getFamilyMembers();
        ListView lv = (ListView)findViewById(R.id.lstnames);
        ArrayAdapter<MembersInfo> membersInfoArrayAdapter = new MemberInfoArrayAdapter(this.getApplicationContext(),R.layout.members_list,(ArrayList<MembersInfo>)members);
        lv.setAdapter(membersInfoArrayAdapter);
    }
    private List<MembersInfo> getFamilyMembers()
    {
        List<MembersInfo> members= new ArrayList<MembersInfo>();
        //DbHelper DB=new DbHelper(this.getApplicationContext());
        DbHelper DB=new DbHelper(ListAll.this);
        SQLiteDatabase dataBase = DB.getWritableDatabase();
        Cursor cursor = dataBase.query(MembersInfo.TABLE,
                new String[]{MembersInfo.ID,MembersInfo.FIRST_NAME,MembersInfo.LAST_NAME,MembersInfo.DATE_OF_BIRTH},null,null,null,null,null);
        if(cursor != null){
            int nIdIndex = cursor.getColumnIndex(MembersInfo.ID);
            int nFirstNameIndex = cursor.getColumnIndex(MembersInfo.FIRST_NAME);
            int nlastNameIndex = cursor.getColumnIndex(MembersInfo.LAST_NAME);
            int nDobIndex = cursor.getColumnIndex(MembersInfo.DATE_OF_BIRTH);
            cursor.moveToFirst();
            while(!cursor.isAfterLast())
            {
                int nId = cursor.getInt(nIdIndex);
                String firstName = cursor.getString(nFirstNameIndex);
                String lastName = cursor.getColumnName(nlastNameIndex);
                String dob = cursor.getColumnName(nDobIndex);
                members.add(new MembersInfo(nId,firstName,lastName,dob));
                cursor.moveToNext();
            }
        }
        return members;
    }
}
