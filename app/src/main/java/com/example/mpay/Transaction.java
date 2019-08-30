package com.example.mpay;

public class Transaction {
    private int id;
    private  int customerid;
    private  int vat;
    private  int companyid;
    private  int amount;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }
    public int getvat() {
        return vat;
    }

    public void setvat(int vat) {
        this.vat = vat;
    }
    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
