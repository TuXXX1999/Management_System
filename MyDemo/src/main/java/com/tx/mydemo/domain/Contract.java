package com.tx.mydemo.domain;

public class Contract {
    private int Contract_Id;
    private String Contract_Info;
    private String Contract_Start;
    private String Contract_End;
    private String Contract_Describe;
    private String Contract_State;
    private String Contract_Amount;

    public int getContract_Id() {
        return Contract_Id;
    }

    public void setContract_Id(int contract_Id) {
        Contract_Id = contract_Id;
    }

    public String getContract_Info() {
        return Contract_Info;
    }

    public void setContract_Info(String contract_Info) {
        Contract_Info = contract_Info;
    }

    public String getContract_Start() {
        return Contract_Start;
    }

    public void setContract_Start(String contract_Start) {
        Contract_Start = contract_Start;
    }

    public String getContract_End() {
        return Contract_End;
    }

    public void setContract_End(String contract_End) {
        Contract_End = contract_End;
    }

    public String getContract_Describe() {
        return Contract_Describe;
    }

    public void setContract_Describe(String contract_Describe) {
        Contract_Describe = contract_Describe;
    }

    public String getContract_State() {
        return Contract_State;
    }

    public void setContract_State(String contract_State) {
        Contract_State = contract_State;
    }

    public String getContract_Amount() {
        return Contract_Amount;
    }

    public void setContract_Amount(String contract_Amount) {
        Contract_Amount = contract_Amount;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "Contract_Id=" + Contract_Id +
                ", Contract_Info='" + Contract_Info + '\'' +
                ", Contract_Start='" + Contract_Start + '\'' +
                ", Contract_End='" + Contract_End + '\'' +
                ", Contract_Describe='" + Contract_Describe + '\'' +
                ", Contract_State='" + Contract_State + '\'' +
                ", Contract_Amount='" + Contract_Amount + '\'' +
                '}';
    }
}
