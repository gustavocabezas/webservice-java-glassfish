/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcx.services;

import com.gcx.models.Authentication;
import com.gcx.models.Items;
import com.gcx.models.Users;
import com.gcx.sql.ConnectionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Gustavo
 */
@WebService(serviceName = "JavaWebService")
public class JavaWebService {

    @WebMethod(operationName = "Authentication")
    public Authentication Authenticate(@WebParam(name = "Authentication") Authentication auth) {
        Authentication userAuth = auth;
        Authentication returnedUser = null;
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionSQL.getConnection();
            String query = "SELECT * FROM [Users] WHERE Username = ? AND Password = ?";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, userAuth.getUsername());
            stmt.setString(2, userAuth.getPassword());
            resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                returnedUser = new Authentication();
                returnedUser.setId(resultSet.getInt("Id"));
                returnedUser.setProfileId(resultSet.getInt("ProfileId"));
                returnedUser.setUsername(resultSet.getString("Username"));
                returnedUser.setPassword(resultSet.getString("Password"));
                returnedUser.setStatusId(resultSet.getInt("StatusId"));
            }
        } catch (SQLException ex) {
            returnedUser = null;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
            return returnedUser;
        }
    }

    @WebMethod(operationName = "CreateUser")
    public Users CreateUser(@WebParam(name = "CreateUser") Users user) {

        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = ConnectionSQL.getConnection();
            String query = "INSERT INTO [Users] (ProfileId, Username, Password, StatusId, DateCreated, CreatedBy, DateUpdated, UpdatedBy, LastLogin) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, 2);
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, 1);

            Timestamp currentDate = new Timestamp(System.currentTimeMillis());
            stmt.setTimestamp(5, currentDate);
            stmt.setInt(6, 0);
            stmt.setTimestamp(7, currentDate);
            stmt.setInt(8, 0);
            stmt.setTimestamp(9, currentDate);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                return user;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    @WebMethod(operationName = "CreateItem")
    public Items CreateItem(@WebParam(name = "CreateItem") Items item) {

        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = ConnectionSQL.getConnection();
            String query = "INSERT INTO [Items] (UserId, Name, Description, LabelsId, StatusId, DateCreated, CreatedBy, DateUpdated, UpdatedBy) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, item.getUserId());
            stmt.setString(2, item.getName());
            stmt.setString(3, item.getDescription());
            stmt.setString(4, item.getLabelsId());
            stmt.setInt(5, 1);

            Timestamp currentDate = new Timestamp(System.currentTimeMillis());
            stmt.setTimestamp(6, currentDate);
            stmt.setInt(7, item.getUserId());
            stmt.setTimestamp(8, currentDate);
            stmt.setInt(9, item.getUserId());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                return item;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    @WebMethod(operationName = "GetAllItems")
    public List<Items> GetAllItems() {
        List<Items> itemsList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionSQL.getConnection();
            String query = "SELECT * FROM [Items]";
            stmt = connection.prepareStatement(query);
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Items item = new Items();
                item.setId(resultSet.getInt("Id"));
                item.setUserId(resultSet.getInt("UserId"));
                item.setName(resultSet.getString("Name"));
                item.setDescription(resultSet.getString("Description"));
                item.setLabelsId(resultSet.getString("LabelsId"));
                item.setStatusId(resultSet.getInt("StatusId"));
                item.setDateCreated(resultSet.getTimestamp("DateCreated"));
                item.setCreatedBy(resultSet.getInt("CreatedBy"));
                item.setDateUpdated(resultSet.getTimestamp("DateUpdated"));
                item.setUpdatedBy(resultSet.getInt("UpdatedBy"));
                itemsList.add(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }

        return itemsList;
    }

    @WebMethod(operationName = "GetAll")
    public String GetAll() {
        String result = "";

        try {
            Statement sql = ConnectionSQL.getConnection().createStatement();
            String queryX = "SELECT * FROM [test].[sys].[tables]";
            ResultSet resultSet = sql.executeQuery(queryX);

            while (resultSet.next()) {
                result += resultSet.getString("name") + "\n";
                System.out.println(result);
            }
            sql.close();
            resultSet.close();
        } catch (SQLException ex) {
            result = ex.toString();
        }

        return result;
    }
}
