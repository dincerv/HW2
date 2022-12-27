package com.dincervelioglu.hw2;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class Gym implements Parcelable{
    private int id;
    private String name;
    private String equipment;
    private int imgID;

    public Gym(int id, String name, String equipment, int imgID) {
        this.id = id;
        this.name = name;
        this.equipment = equipment;
        this.imgID = imgID;
    }

    public Gym() {
    }

    public int getImgId() {
        return imgID;
    }

    public void setImgId(int imgID) {
        this.imgID = imgID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }


    @Override
    public String toString() {
        return "Gym{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", equipment='" + equipment + '\'' +
                ", imgID=" + imgID +
                '}';
    }

    /*****************************************/
    protected Gym(Parcel in) {
        name = in.readString();
        equipment = in.readString();
        imgID = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(equipment);
        dest.writeInt(imgID);
    }

    @Override
     public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Gym> CREATOR = new Parcelable.Creator<Gym>() {
        @Override
        public Gym createFromParcel(Parcel in) {
            return new Gym(in);
        }

        @Override
        public Gym[] newArray(int size) {
            return new Gym[size];
        }
    };
}