package model;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String bank;
    private  int account;
    private  int mobile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getBankname() {
        return bank;
    }

    public void setBankname(String bank) {
        this.bank = bank;
    }
    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
}
