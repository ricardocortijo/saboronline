/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.persistencia;

import edu.upc.sistemaventas.dominio.TransaccionPagoDomain;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ricardocortijo
 */
public class MySqlTransaccionPagoDAO extends MySqlBaseDAO implements TransaccionPagoDAO {

  public MySqlTransaccionPagoDAO() throws Exception {
    super();
  }

  public boolean registrarTransaccionPago(TransaccionPagoDomain transaccion) {
    String sql1 = "insert into transaccion_pago ( numero_transaccion, fecha_transaccion, direccion_facturacion, id_emprendedor, id_tarjeta_credito ) ";
    sql1 += "                  values ( ?, ?, ?, ?, ? ) ";
    try {
      //** Registrando la transacción
      PreparedStatement pstmt = db.getPreparedStatement(sql1);
      pstmt.setInt(1, transaccion.getNumeroTransaccion());
      pstmt.setDate(2, new Date(transaccion.getFechaTransaccion().getTime()));
      pstmt.setString(3, transaccion.getDireccionFacturacion());
      if (transaccion.getEmprendedor() != null) {
        pstmt.setInt(4, transaccion.getEmprendedor().getId());
      } else {
        pstmt.setNull(4, java.sql.Types.INTEGER);
      }
      if (transaccion.getTarjetaCredito() != null) {
        pstmt.setInt(5, transaccion.getTarjetaCredito().getId());
      } else {
        pstmt.setNull(5, java.sql.Types.INTEGER);
      }
      return (pstmt.executeUpdate() > 0);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return false;
  }
  
}
