package com.example.laba6;

import android.os.Parcel;
import android.os.Parcelable;

public class Vickend implements Parcelable {
    private String Name;
    private String Type;
    private String Information;
    private int Imgresours;
    private String unit;
    private int count;
    private boolean deleted;

    public Vickend(String Name, String Type, String Information, int Imgresours) {
        this.Name = Name;
        this.Type = Type;
        this.Information = Information;
        this.Imgresours = Imgresours;
        this.count = 0;
        this.unit = unit;
    }

    protected Vickend(Parcel in) {
        Name = in.readString();
        Type = in.readString();
        Information = in.readString();
        Imgresours = in.readInt();
        unit = in.readString();
        count = in.readInt();
        deleted = in.readByte() != 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Vickend> CREATOR = new Creator<Vickend>() {
        @Override
        public Vickend createFromParcel(Parcel in) {
            return new Vickend(in);
        }

        @Override
        public Vickend[] newArray(int size) {
            return new Vickend[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(Name);
        parcel.writeString(Type);
        parcel.writeString(Information);
        parcel.writeInt(Imgresours);
        parcel.writeString(unit);
        parcel.writeInt(count);
        parcel.writeByte((byte) (deleted ? 1 : 0));
    }


    public String Getunit() { return this.unit; }
    public boolean GetDeleted() { return this.deleted; }
    public void SetDeleted() { this.deleted = !this.deleted; }
    public Integer Getcount() { return this.count; }
    public void SetCount(int count) { this.count = count; }
    public String GetName() { return this.Information; }
    public String GetCompany() { return this.Name; }
    public String GetModel() { return this.Type; }
    public Integer GetImageResourse() { return this.Imgresours; }
    public void SetName(String Name) { this.Name = Name; }
    public void SetCompany(String Information) { this.Information = Information; }
    public void SetModel(String Type) { this.Type = Type; }
    public void SetImageResourse(int Imgresours) { this.Imgresours = Imgresours; }
}
