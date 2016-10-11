package edu.upc.saboronline.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface DBConnection {

  public Connection getConnection();
  public PreparedStatement getPreparedStatement(String sql) throws Exception;
  public PreparedStatement getPreparedStatement(String sql, boolean isGeneratedKeys) throws Exception;
  public void close() throws Exception;

}
