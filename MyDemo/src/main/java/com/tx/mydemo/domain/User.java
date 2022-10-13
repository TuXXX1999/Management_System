package com.tx.mydemo.domain;

import java.util.List;

//员工
public class User {
    private int User_Id;
    private String User_Name;
    private String User_Pass;
    private String User_Role;
    private String User_Phone;
    private String User_Address;
    private Role roles;

    public int getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(int user_Id) {
        User_Id = user_Id;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getUser_Pass() {
        return User_Pass;
    }

    public void setUser_Pass(String user_Pass) {
        User_Pass = user_Pass;
    }

    public String getUser_Role() {
        return User_Role;
    }

    public void setUser_Role(String user_Role) {
        User_Role = user_Role;
    }

    public String getUser_Phone() {
        return User_Phone;
    }

    public void setUser_Phone(String user_Phone) {
        User_Phone = user_Phone;
    }

    public String getUser_Address() {
        return User_Address;
    }

    public void setUser_Address(String user_Address) {
        User_Address = user_Address;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "User_Id=" + User_Id +
                ", User_Name='" + User_Name + '\'' +
                ", User_Pass='" + User_Pass + '\'' +
                ", User_Role='" + User_Role + '\'' +
                ", User_Phone='" + User_Phone + '\'' +
                ", User_Address='" + User_Address + '\'' +
                ", roles=" + roles +
                '}';
    }
}
