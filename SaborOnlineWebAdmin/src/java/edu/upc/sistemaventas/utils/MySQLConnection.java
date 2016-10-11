package edu.upc.sistemaventas.utils;

public class MySQLConnection extends GeneralConnection implements DBConnection {

  private static final String URL = "jdbc:mysql://localhost:3306/db_sistemaventas_planes_neg";
  private static final String USERNAME = "root";
  private static final String PASSWORD = "mysql";

  static {
    //registerDriver("org.gjt.mm.mysql.Driver");
    registerDriver("com.mysql.jdbc.Driver");
  }

  public MySQLConnection() throws Exception {
    super(URL, USERNAME, PASSWORD);
  }

}
