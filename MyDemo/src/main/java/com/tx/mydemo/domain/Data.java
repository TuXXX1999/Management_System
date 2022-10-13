package com.tx.mydemo.domain;

import java.util.List;

public class Data {
    String Data_Time;
    int Data_Id;
    String Data_Info;
    int Data_User;
    String Data_Amount;
    private User users;



    public String getData_Time() {
        return Data_Time;
    }

    public void setData_Time(String data_Time) {
        Data_Time = data_Time;
    }

    public int getData_Id() {
        return Data_Id;
    }

    public void setData_Id(int data_Id) {
        Data_Id = data_Id;
    }

    public String getData_Info() {
        return Data_Info;
    }

    public void setData_Info(String data_Info) {
        Data_Info = data_Info;
    }

    public int getData_User() {
        return Data_User;
    }

    public void setData_User(int data_User) {
        Data_User = data_User;
    }

    public String getData_Amount() {
        return Data_Amount;
    }

    public void setData_Amount(String data_Amount) {
        Data_Amount = data_Amount;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }


    @Override
    public String toString() {
        return "Data{" +
                "Data_Time='" + Data_Time + '\'' +
                ", Data_Id=" + Data_Id +
                ", Data_Info='" + Data_Info + '\'' +
                ", Data_User=" + Data_User +
                ", Data_Amount='" + Data_Amount + '\'' +
                ", users=" + users +
                '}';
    }
}
