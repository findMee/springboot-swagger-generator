package com.example.springbootswaggercrud.crud.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
    private String userId;
    private String userName;
    private String email;
    private String gender;
    private String phone;
    private String age;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @JsonProperty("id")
    @JsonIgnore
    private void unpackUserId(Map<String, String> id) {
        this.userId = id.get("value");
    }

    @JsonProperty("login")
    @JsonIgnore
    private void unpackUserName(Map<String, String> login) {
        this.userName = login.get("username");
    }

    @JsonProperty("dob")
    @JsonIgnore
    private void unpackUserAge(Map<String, String> dob) {
        this.age = dob.get("age");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                '}';
    }
}
