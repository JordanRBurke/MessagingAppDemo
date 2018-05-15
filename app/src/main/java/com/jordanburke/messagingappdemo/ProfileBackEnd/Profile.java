package com.jordanburke.messagingappdemo.ProfileBackEnd;

public class Profile {

    private String userName;
    private String email;
    private String profileDescription;
    private String teams;

    public Profile(String userName, String email, String profileDescription, String teams) {
        this.userName = userName;
        this.email = email;
        this.profileDescription = profileDescription;
        this.teams = teams;
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

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }
}
