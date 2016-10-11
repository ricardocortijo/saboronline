package edu.upc.saboronline.utils;

import java.sql.*;

public class GeneralConnection {

  protected Connection connection = null;
  protected PreparedStatement pstmt = null;

  public GeneralConnection(String url, String username, String password) throws Exception {
    try {
      connection = DriverManager.getConnection(url, username, password);
    } catch (Exception ex) {
      System.out.println("Aplicacion: [" + Parametros.NOMBRE_APP + "]; Clase: " + getClass().getName() + "; Mensaje:" + ex);
      throw ex;
    }
  }

  protected static void registerDriver(String driverName) {
    try {
      Class.forName(driverName);
    } catch (Exception ex) {
      System.out.println("Aplicacion: [" + Parametros.NOMBRE_APP + "]; Clase: " + GeneralConnection.class.getName() + "; Mensaje:" + ex);
    }
  }

  public Connection getConnection() {
    return connection;
  }

  public PreparedStatement getPreparedStatement(String sql) throws Exception {
    pstmt = connection.prepareStatement(sql);
    return pstmt;
  }

  public PreparedStatement getPreparedStatement(String sql, boolean isGeneratedKeys) throws Exception {
    if (isGeneratedKeys) {
      pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    } else {
      pstmt = connection.prepareStatement(sql);
    }
    return pstmt;
  }

  public void close() throws Exception {
    if (pstmt != null) {
      pstmt.close();
    }
    if (connection != null) {
      connection.close();
    }
  }

  @Override
  protected void finalize() throws Throwable {
    try {
      if (pstmt != null) {
        pstmt.close();
      }
      if (connection != null) {
        connection.close();
      }
    } finally {
      super.finalize();
    }
  }

}
