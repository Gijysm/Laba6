package com.example.laba6;

import android.os.Parcel;
import android.os.Parcelable;

public class Camera implements Parcelable {
    private String model;
    private String type;
    private String company;
    private int imgResource;
    private String unit;
    private int count;
    private boolean deleted;

    public Camera(String model, String type, String company, int imgResource) {
        this.model = model;
        this.type = type;
        this.company = company;
        this.imgResource = imgResource;
        this.count = 0;
        this.unit = unit;
    }

    protected Camera(Parcel in) {
        model = in.readString();
        type = in.readString();
        company = in.readString();
        imgResource = in.readInt();
        unit = in.readString();
        count = in.readInt();
        deleted = in.readByte() != 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Camera> CREATOR = new Creator<Camera>() {
        @Override
        public Camera createFromParcel(Parcel in) {
            return new Camera(in);
        }

        @Override
        public Camera[] newArray(int size) {
            return new Camera[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(model);
        parcel.writeString(type);
        parcel.writeString(company);
        parcel.writeInt(imgResource);
        parcel.writeString(unit);
        parcel.writeInt(count);
        parcel.writeByte((byte) (deleted ? 1 : 0));
    }

    public String getUnit() { return this.unit; }
    public boolean isDeleted() { return this.deleted; }
    public void toggleDeleted() { this.deleted = !this.deleted; }
    public Integer getCount() { return this.count; }
    public void setCount(int count) { this.count = count; }
    public String getModel() { return this.model; }
    public String getCompany() { return this.company; }
    public String getType() { return this.type; }
    public Integer getImageResource() { return this.imgResource; }
    public void setModel(String model) { this.model = model; }
    public void setCompany(String company) { this.company = company; }
    public void setType(String type) { this.type = type; }
    public void setImageResource(int imgResource) { this.imgResource = imgResource; }
}
