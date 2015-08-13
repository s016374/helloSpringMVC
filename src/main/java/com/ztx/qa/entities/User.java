package com.ztx.qa.entities;

/**
 * Created by s016374 on 15/8/11.
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String mail;
    private Address address;

    public User() {
    }

    public User(String username, String password, Integer age, String mail) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.mail = mail;
    }

    public User(String username, String password, Integer age, String mail, Address address) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.mail = mail;
        this.address = address;
    }

    public User(Integer id, String username, String password, Integer age, String mail) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.mail = mail;
    }

    public User(Integer id, String username, String password, Integer age, String mail, Address address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.mail = mail;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", mail='" + mail + '\'' +
                ", address=" + address +
                '}';
    }
}
