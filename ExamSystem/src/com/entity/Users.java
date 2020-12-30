package com.entity;

public class Users {
    private Integer id;//这样可以给id赋值为null
    private String userName;
    private String UserPswd;
    private String sex;
    private String email;

    public Users() {
    }

    public Users(Integer id, String userName, String userPswd, String sex, String email) {
        this.id = id;
        this.userName = userName;
        UserPswd = userPswd;
        this.sex = sex;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPswd() {
        return UserPswd;
    }

    public void setUserPswd(String userPswd) {
        UserPswd = userPswd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
