package com.tx.mydemo.domain;

public class OverDate {
    int OverDate_Id;
    String OverDate_Name;
    String OverDate_Phone;
    String OverDate_Type;
    String OverDate_Time;

    public int getOverDate_Id() {
        return OverDate_Id;
    }

    public void setOverDate_Id(int overDate_Id) {
        OverDate_Id = overDate_Id;
    }

    public String getOverDate_Name() {
        return OverDate_Name;
    }

    public void setOverDate_Name(String overDate_Name) {
        OverDate_Name = overDate_Name;
    }

    public String getOverDate_Phone() {
        return OverDate_Phone;
    }

    public void setOverDate_Phone(String overDate_Phone) {
        OverDate_Phone = overDate_Phone;
    }

    public String getOverDate_Type() {
        return OverDate_Type;
    }

    public void setOverDate_Type(String overDate_Type) {
        OverDate_Type = overDate_Type;
    }

    public String getOverDate_Time() {
        return OverDate_Time;
    }

    public void setOverDate_Time(String overDate_Time) {
        OverDate_Time = overDate_Time;
    }

    @Override
    public String toString() {
        return "OverDate{" +
                "OverDate_Id=" + OverDate_Id +
                ", OverDate_Name='" + OverDate_Name + '\'' +
                ", OverDate_Phone='" + OverDate_Phone + '\'' +
                ", OverDate_Type='" + OverDate_Type + '\'' +
                ", OverDate_Time='" + OverDate_Time + '\'' +
                '}';
    }
}
