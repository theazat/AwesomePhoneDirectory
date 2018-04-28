package com.androideduio.awesomephonedirectory.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.androideduio.awesomephonedirectory.model.User;

import java.util.ArrayList;

/**
 * Created by Lenovo-PC on 30.08.2017.
 */

public class DataBaseAdapter extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "CustomerManager";
    private static final String TABLE_CONTACTS = "customer";

    private static final String KEY_ID = "id";
    private static final String KEY_AD = "ad";
    private static final String KEY_SOYAD = "soyad";
    private static final String KEY_TELEFON = "telefon";
    private static final String KEY_MAIL = "mail";
    private static final String KEY_ADRES = "adres";
    private static final String KEY_CINSIYET = "cinsiyet";

    public DataBaseAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_AD + " TEXT,"
                + KEY_SOYAD + " TEXT," + KEY_TELEFON + " TEXT,"
                + KEY_MAIL + " TEXT," + KEY_ADRES + " TEXT," + KEY_CINSIYET + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        onCreate(sqLiteDatabase);
    }

    public void addContact(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_AD, user.getAd());
        values.put(KEY_SOYAD, user.getSoyad());
        values.put(KEY_TELEFON, user.getTelefon());
        values.put(KEY_MAIL, user.getMail());
        values.put(KEY_ADRES, user.getAdres());
        values.put(KEY_CINSIYET, user.getCinsiyet());

        db.insert(TABLE_CONTACTS, null, values);
        db.close();
    }

    public User getUser(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[]{KEY_ID, KEY_AD,
                        KEY_SOYAD, KEY_TELEFON, KEY_MAIL, KEY_ADRES, KEY_CINSIYET}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();


        User user = new User(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));

        cursor.close();
        db.close();

        return user;
    }

    public ArrayList<User> getAllUser() {

        ArrayList<User> contactList = new ArrayList<User>();

        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                User contact = new User();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setAd(cursor.getString(1));
                contact.setSoyad(cursor.getString(2));
                contact.setTelefon(cursor.getString(3));
                contact.setMail(cursor.getString(4));
                contact.setAdres(cursor.getString(5));
                contact.setCinsiyet(cursor.getString(6));

                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return contactList;
    }

    public int getUserCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        cursor.close();
        db.close();

        return cursor.getCount();
    }

    public int updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_AD, user.getAd());
        values.put(KEY_SOYAD, user.getSoyad());
        values.put(KEY_TELEFON, user.getTelefon());
        values.put(KEY_MAIL, user.getMail());
        values.put(KEY_ADRES, user.getAdres());
        values.put(KEY_CINSIYET, user.getCinsiyet());

        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(user.getID())});
    }

    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[]{String.valueOf(user.getID())});

        db.close();
    }
}