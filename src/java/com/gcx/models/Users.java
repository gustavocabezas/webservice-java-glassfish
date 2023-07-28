/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcx.models;

import java.time.LocalDateTime;

/**
 *
 * @author Gustavo
 */
public class Users {

    private int Id;
    private int ProfileId = 2;
    private String Username = "";
    private String Password = "";
    private String TempPassword = "";
    private int StatusId;
    private LocalDateTime LastLogin = LocalDateTime.now();
    private LocalDateTime DateCreated = LocalDateTime.now();
    private LocalDateTime DateUpdated = LocalDateTime.now();
    private int CreatedBy;
    private int UpdatedBy;

    // Getter and Setter for id
    public int getId() {
        return this.Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    // Getter and Setter for profileId
    public int getProfileId() {
        return this.ProfileId;
    }

    public void setProfileId(int ProfileId) {
        this.ProfileId = ProfileId;
    }

    // Getter and Setter for username
    public String getUsername() {
        return this.Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    // Getter and Setter for password
    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    // Getter and Setter for tempPassword
    public String getTempPassword() {
        return this.TempPassword;
    }

    public void setTempPassword(String TempPassword) {
        this.TempPassword = TempPassword;
    }

    // Getter and Setter for lastLogin
    public LocalDateTime getLastLogin() {
        return this.LastLogin;
    }

    public void setLastLogin(LocalDateTime LastLogin) {
        this.LastLogin = LastLogin;
    }

    // Getter and Setter for statusId
    public int getStatusId() {
        return this.StatusId;
    }

    public void setStatusId(int StatusId) {
        this.StatusId = StatusId;
    }

    // Getter and Setter for dateCreated
    public LocalDateTime getDateCreated() {
        return this.DateCreated;
    }

    public void setDateCreated(LocalDateTime DateCreated) {
        this.DateCreated = DateCreated;
    }

    // Getter and Setter for dateUpdated
    public LocalDateTime getDateUpdated() {
        return this.DateUpdated;
    }

    public void setDateUpdated(LocalDateTime DateUpdated) {
        this.DateUpdated = DateUpdated;
    }

    // Getter and Setter for createdBy
    public int getCreatedBy() {
        return this.CreatedBy;
    }

    public void setCreatedBy(int CreatedBy) {
        this.CreatedBy = CreatedBy;
    }

    // Getter and Setter for updatedBy
    public int getUpdatedBy() {
        return this.UpdatedBy;
    }

    public void setUpdatedBy(int UpdatedBy) {
        this.UpdatedBy = UpdatedBy;
    }
}
