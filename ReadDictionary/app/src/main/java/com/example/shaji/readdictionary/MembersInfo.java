package com.example.shaji.readdictionary;

public class MembersInfo {
    public static final String TAG=MembersInfo.class.getSimpleName();
    public static final String TABLE="MembersInfo";

    public static final String ID="id";
    public static final String FIRST_NAME="FirstName";
    public static final String LAST_NAME="LastName";
    public static final String DATE_OF_BIRTH="DateOfBirth";
    public static final String CREATE_TABLE_FAMILY="CREATE TABLE "
            + TABLE + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FIRST_NAME + " TEXT NOT NULL,"
            + LAST_NAME + " TEXT NOT NULL,"
            + DATE_OF_BIRTH + " TEXT );";
    private int _id;
    private String _firstName;
    private String _lastName;
    private String _dateOfBirth;
    public MembersInfo(){}
    public MembersInfo(int id, String firstName,String lastName,String dob)
    {
        this._id=id;
        this._firstName=firstName;
        this._lastName=lastName;
        this._dateOfBirth=dob;
    }
    public void setFirstName(String firstName)
    {
        this._firstName=firstName;
    }
    public String getFirstName()
    {
        return this._firstName;
    }
    public void setLastName(String lastName)
    {
        this._lastName=lastName;
    }
    public String getLastName()
    {
        return this._lastName;
    }
    public void setDateOfBirth(String dob){
        this._dateOfBirth=dob;
    }
    public String getDateOfBirth(){
        return this._dateOfBirth;
    }
}
