package com.example.laba6;

import android.os.Parcel;
import android.os.Parcelable;

public class Printers implements Parcelable {
    private String Name;
    private String Model;
    private String Company;
    private int Imgresours;
    private String unit;
    private int count;
    private boolean deleted;

    public Printers(String Name, String Model, String Company, int Imgresours) {
        this.Name = Name;
        this.Model = Model;
        this.Company = Company;
        this.Imgresours = Imgresours;
        this.count = 0;
        this.unit = unit;
    }

    protected Printers(Parcel in) {
        Name = in.readString();
        Model = in.readString();
        Company = in.readString();
        Imgresours = in.readInt();
        unit = in.readString();
        count = in.readInt();
        deleted = in.readByte() != 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Printers> CREATOR = new Creator<Printers>() {
        @Override
        public Printers createFromParcel(Parcel in) {
            return new Printers(in);
        }

        @Override
        public Printers[] newArray(int size) {
            return new Printers[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(Name);
        parcel.writeString(Model);
        parcel.writeString(Company);
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
    public String GetName() { return this.Company; }
    public String GetCompany() { return this.Name; }
    public String GetModel() { return this.Model; }
    public Integer GetImageResourse() { return this.Imgresours; }
    public void SetName(String Name) { this.Name = Name; }
    public void SetCompany(String Company) { this.Company = Company; }
    public void SetModel(String Model) { this.Model = Model; }
    public void SetImageResourse(int Imgresours) { this.Imgresours = Imgresours; }
}
