package com.example.springbootswaggercrud.sampleData;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseData {
    private List<Employee> results;

    public List<Employee> getResults() {
        return results;
    }

    public void setResults(List<Employee> results) {
        this.results = results;
    }

}

@JsonIgnoreProperties(ignoreUnknown = true)
class Employee {
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
    private void unpackUserId(Map<String, String> id) {
        this.userId = id.get("value");
    }

    @JsonProperty("login")
    private void unpackUserName(Map<String, String> login) {
        this.userName = login.get("username");
    }

    @JsonProperty("dob")
    private void unpackUserAge(Map<String, String> dob) {
        this.age = dob.get("age");
    }
}
