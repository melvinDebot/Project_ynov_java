package com.example.back.config;

import java.sql.*;

public class DBConfig {

    private String connectionUrl = "Server=tcp:dbserveynovvl.database.windows.net,1433;Initial Catalog=flightJava;Persist Security Info=False;User ID=vincent;Password=46CF7@cb;MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;";

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        return DriverManager.getConnection(connectionUrl);
    }

    public void closeConnection(Connection con){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    }

    public void closePreparedStatement(PreparedStatement ps) {
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
            }
        }
    }

    public void closeResultSet(ResultSet rs) {
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }
    }
}
