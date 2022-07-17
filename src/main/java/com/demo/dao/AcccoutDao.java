package com.demo.dao;

import com.demo.beans.Account;
import com.demo.connection.ConnectionUtils;
import com.demo.connection.MySqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AcccoutDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account login(String user, String pass) {
        try {
//            String query = " select a.username, a.password from Account a " +
//                    " where a.username = ? and a.password = ?";
            String query = "select * from account where username= ? and password = ?";
            conn = MySqlConnection.getMySQLConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getString(1), rs.getString(2), rs.getString(3));
//                String mail = rs.getString("mail");
//                Account acc = new Account();
//                acc.setUsername(user);
//                acc.setPassword(pass);
//                acc.setEmail(mail);
                return acc;
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

    public Account checkRegister(String user) {
        try {
            String query = " select * from account where username = ? ";
            conn = ConnectionUtils.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3));
                return acc;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void register(String user, String pass, String email) {
        try {
            String query = "insert into Account (username, password, email) values(?, ?, ?)";
            conn = ConnectionUtils.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,user);
            ps.setString(2,pass);
            ps.setString(3,email);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {

        }
    }
}
