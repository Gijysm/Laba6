package com.example.laba6;

import android.os.Parcel;
import android.os.Parcelable;

public class Vickend implements Parcelable {
    private String Name;
    private String Model;
    private String Company;
    private int Imgresours;
    private int Money = 0;
    private int count;
    private String unit;
    private boolean deleted;

    public Vickend(String Name, String Model, String Company, int Imgresours, int Money) {
        this.Name = Name;
        this.Model = Model;
        this.Company = Company;
        this.Imgresours = Imgresours;
        this.Money = Money;
        this.count = 0;
    }

    protected Vickend(Parcel in) {
        Name = in.readString();
        Model = in.readString();
        Company = in.readString();
        Imgresours = in.readInt();
        unit = in.readString();
        Money = in.readInt();
        count = in.readInt();
        deleted = in.readByte() != 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(Name);
        parcel.writeString(Model);
        parcel.writeString(Company);
        parcel.writeInt(Imgresours);
        parcel.writeString(unit);
        parcel.writeInt(Money);
        parcel.writeInt(count);
        parcel.writeByte((byte) (deleted ? 1 : 0));
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

    // Getters and Setters
    public String Getunit() { return this.unit; }
    public boolean GetDeleted() { return this.deleted; }
    public void SetDeleted() { this.deleted = !this.deleted; }
    public Integer Getcount() { return this.count; }
    public void SetCount(int count) { this.count = count; }
    public String GetName() { return this.Name; }
    public String GetCompany() { return this.Company; }
    public String GetModel() { return this.Model; }
    public Integer GetImageResourse() { return this.Imgresours; }
    public Integer GetMoney() { return this.Money; }
    public Integer GetAllBuyed() { return this.Money * this.count; }
    public void SetName(String Name) { this.Name = Name; }
    public void SetCompany(String Company) { this.Company = Company; }
    public void SetModel(String Model) { this.Model = Model; }
    public void SetImageResourse(int Imgresours) { this.Imgresours = Imgresours; }
}
