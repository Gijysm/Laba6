package com.example.laba6;

import android.media.Image;

public class Printers {
    private String Name;
    private String Model;
    private String Company;
    private int Imgresours;
    private String unit;
    private int count;

    public Printers(String Name,String Model, String Company, int Imgresours)
    {
        this.Name = Name;
        this.Model = Model;
        this.Company = Company;
        this.Imgresours = Imgresours;
        this.count = 0;
        this.unit = unit;
    }
    public String Getunit()
    {
        return this.unit;
    }
    public Integer Getcount()
    {
        return this.count;
    }
    public void SetCount(int count)
    {
        this.count = count;
    }
    public String GetName()
    {
        return this.Company;
    }
    public String GetCompany()
    {
        return this.Name;
    }
    public String GetModel()
    {
        return this.Model;
    }
    public Integer GetImageResourse()
    {
        return this.Imgresours;
    }
    public void SetName(String Name)
    {
        this.Name = Name;
    }
    public void SetCompany(String Company)
    {
        this.Company = Company;
    }
    public void SetModel(String Model)
    {
       this.Model = Model;
    }
    public void SetImageResourse(int Imgresours)
    {
        this.Imgresours = Imgresours;
    }
}
