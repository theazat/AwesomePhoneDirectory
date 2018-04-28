package com.androideduio.awesomephonedirectory.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Lenovo-PC on 25.08.2017.
 */

public class User implements Parcelable {

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };


    public String Cinsiyet;
    private int ID;
    private String Ad;
    private String Soyad;
    private String Telefon;
    private String Mail;
    private String Adres;

    public User() {

    }

    public User(int id, String ad, String soyad, String telefon, String mail, String adres, String cinsiyet) {

        this.Cinsiyet = cinsiyet;
        this.ID = id;
        this.Ad = ad;
        this.Soyad = soyad;
        this.Telefon = telefon;
        this.Mail = mail;
        this.Adres = adres;

    }

    public User(String ad, String soyad, String telefon, String mail, String adres, String cinsiyet) {
        this.Ad = ad;
        this.Soyad = soyad;
        this.Telefon = telefon;
        this.Mail = mail;
        this.Adres = adres;
        this.Cinsiyet = cinsiyet;
    }

    protected User(Parcel in) {
        Cinsiyet = in.readString();
        ID = in.readInt();
        Ad = in.readString();
        Soyad = in.readString();
        Telefon = in.readString();
        Mail = in.readString();
        Adres = in.readString();
    }


    public String getCinsiyet() {
        return Cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        Cinsiyet = cinsiyet;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String ad) {
        Ad = ad;
    }

    public String getSoyad() {
        return Soyad;
    }

    public void setSoyad(String soyad) {
        Soyad = soyad;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getAdres() {
        return Adres;
    }

    public void setAdres(String adres) {
        Adres = adres;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Cinsiyet);
        dest.writeInt(ID);
        dest.writeString(Ad);
        dest.writeString(Soyad);

        dest.writeString(Telefon);
        dest.writeString(Mail);
        dest.writeString(Adres);
    }

}
