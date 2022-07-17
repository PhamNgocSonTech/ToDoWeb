package com.demo.connection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class ConnectionUtils {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        return MySqlConnection.getMySQLConnection();

    }

    public static Date getSqlDate(LocalDate date){
        return java.sql.Date.valueOf(date);
    }

    public static LocalDate getUtilDate(Date sqlDate){
        return sqlDate.toLocalDate();
    }


}
