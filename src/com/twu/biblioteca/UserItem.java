package com.twu.biblioteca;


/**
 * Created by eric on 3/5/16.
 */
public class UserItem implements Comparable<UserItem>{

    private String number = "xxx-xxxx";
    private String pwd = "dddd";
    private String name = "erer";
    private String email = "ee@11.com";
    private String phone = "112";
    private boolean isLoggedIn = false;

    public UserItem(String number, String pwd, String name, String email, String phone) {
        this.setNumber(number);
        this.setPwd(pwd);
        this.setName(name);
        this.setEmail(email);
        this.setPhone(phone);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

//    public String getPwd() {
//        return pwd;
//    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean checkUserInfo(String name, String password) {
        if (name.equals(getName()) && password.equals(pwd)) {
            isLoggedIn=true;
            return true;
        }
        isLoggedIn=false;
        return false;
    }

    public String getUserInfo(){
        if(!isLoggedIn()){
            return null;
        }
        return "name:\t"+this.getName()
                +"email:\t"+this.getEmail()
                +"phone:\t"+this.getPhone();
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    @Override
    public int compareTo(UserItem userItem) {
        if(this.equals(userItem)){
            return 0;
        }
        return -1;
    }
}
