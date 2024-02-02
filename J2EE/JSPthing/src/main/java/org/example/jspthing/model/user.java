package org.example.jspthing.model;

public class user {

    private int userID;
    private String userName;
    private String userCity;

    public user(int userID, String userName, String userCity) {
        this.userID = userID;
        this.userName = userName;
        this.userCity = userCity;
    }

    public user(String userName, String userCity) {
        this.userName = userName;
        this.userCity = userCity;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    @Override
    public String toString() {
        return "user{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", userCity='" + userCity + '\'' +
                '}';
    }
}
