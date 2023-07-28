/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcx.models;

/**
 *
 * @author Gustavo
 */
public class Authentication {

    private int Id;
    private String Token = "";
    private String Username = "";
    private String Password = "";
    private int ProfileId;
    private int StatusId;

    public int getId() {
        return this.Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getToken() {
        return this.Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    public String getUsername() {
        return this.Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    public int getProfileId() {
        return this.ProfileId;
    }

    public void setProfileId(int ProfileId) {
        this.ProfileId = ProfileId;
    }

    public int getStatusId() {
        return this.StatusId;
    }

    public void setStatusId(int StatusId) {
        this.StatusId = StatusId;
    }
}
