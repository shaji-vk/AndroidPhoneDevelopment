package com.example.shaji.readdictionary;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {
    private static final String TAG=DbHelper.class.getSimpleName().toString();
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="MyFamily.db";

    public DbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(MembersInfo.CREATE_TABLE_FAMILY);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {
        Log.w(TAG,"Upgrading database. Existing contents will be lost. [" + oldVersion + "] -> [" + newVersion + "]");
        db.execSQL("DROP TABLE IF EXISTS " + MembersInfo.TABLE);
        onCreate(db);
    }
}
