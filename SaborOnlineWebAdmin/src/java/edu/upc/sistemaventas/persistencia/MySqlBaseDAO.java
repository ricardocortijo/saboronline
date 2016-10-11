/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upc.sistemaventas.persistencia;

import edu.upc.sistemaventas.utils.DBConnection;
import edu.upc.sistemaventas.utils.MySQLConnection;

/**
 *
 * @author ricardocortijo
 */
public class MySqlBaseDAO {

  protected DBConnection db = null;

  public MySqlBaseDAO() throws Exception {
    db = new MySQLConnection();
  }

  @Override
  protected void finalize() throws Throwable {
    try {
      if (db != null) {
        db.close();
      }
    } finally {
      super.finalize();
    }
  }

}
