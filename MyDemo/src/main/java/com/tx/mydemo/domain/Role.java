package com.tx.mydemo.domain;

public class Role {
    int Role_Id;
    String Role_Name;

    public int getRole_Id() {
        return Role_Id;
    }

    public void setRole_Id(int role_Id) {
        Role_Id = role_Id;
    }

    public String getRole_Name() {
        return Role_Name;
    }

    public void setRole_Name(String role_Name) {
        Role_Name = role_Name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "Role_Id=" + Role_Id +
                ", Role_Name='" + Role_Name + '\'' +
                '}';
    }
}
