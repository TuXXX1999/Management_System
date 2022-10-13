package com.tx.mydemo.domain;

//客户
public class Info {
    private int Info_Id;
    private String Info_Name;
    private String Info_Phone;
    private String Info_Type;
    private String Info_Cycle;
    private String Info_Address;
    private String Info_Others;

    public int getInfo_Id() {
        return Info_Id;
    }

    public void setInfo_Id(int info_Id) {
        Info_Id = info_Id;
    }

    public String getInfo_Name() {
        return Info_Name;
    }

    public void setInfo_Name(String info_Name) {
        Info_Name = info_Name;
    }

    public String getInfo_Phone() {
        return Info_Phone;
    }

    public void setInfo_Phone(String info_Phone) {
        Info_Phone = info_Phone;
    }

    public String getInfo_Type() {
        return Info_Type;
    }

    public void setInfo_Type(String info_Type) {
        Info_Type = info_Type;
    }

    public String getInfo_Cycle() {
        return Info_Cycle;
    }

    public void setInfo_Cycle(String info_Cycle) {
        Info_Cycle = info_Cycle;
    }

    public String getInfo_Address() {
        return Info_Address;
    }

    public void setInfo_Address(String info_Address) {
        Info_Address = info_Address;
    }

    public String getInfo_Others() {
        return Info_Others;
    }

    public void setInfo_Others(String info_Others) {
        Info_Others = info_Others;
    }

    @Override
    public String toString() {
        return "Info{" +
                "Info_Id=" + Info_Id +
                ", Info_Name='" + Info_Name + '\'' +
                ", Info_Phone='" + Info_Phone + '\'' +
                ", Info_Type='" + Info_Type + '\'' +
                ", Info_Cycle='" + Info_Cycle + '\'' +
                ", Info_Address='" + Info_Address + '\'' +
                ", Info_Others='" + Info_Others + '\'' +
                '}';
    }
}
