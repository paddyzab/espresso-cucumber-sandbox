package com.paddy.cuespton.cuespton;

import android.os.Parcel;
import android.os.Parcelable;

public class FormData implements Parcelable {

    private String name;
    private String lastName;
    private String streetName;
    private int streetNumber;
    private String city;
    private int postalNumber;

    public FormData() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.lastName);
        dest.writeString(this.streetName);
        dest.writeInt(this.streetNumber);
        dest.writeString(this.city);
        dest.writeInt(this.postalNumber);
    }

    private FormData(Parcel in) {
        this.name = in.readString();
        this.lastName = in.readString();
        this.streetName = in.readString();
        this.streetNumber = in.readInt();
        this.city = in.readString();
        this.postalNumber = in.readInt();
    }

    public static final Parcelable.Creator<FormData> CREATOR = new Parcelable.Creator<FormData>() {
        public FormData createFromParcel(Parcel source) {
            return new FormData(source);
        }

        public FormData[] newArray(int size) {
            return new FormData[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalNumber() {
        return postalNumber;
    }


    public void setPostalNumber(int postalNumber) {
        this.postalNumber = postalNumber;
    }
}
