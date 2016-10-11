/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.persistencia;

import edu.upc.sistemaventas.dominio.BancoDomain;
import edu.upc.sistemaventas.dominio.EmprendedorDomain;
import edu.upc.sistemaventas.dominio.TarjetaCreditoDomain;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ricardocortijo
 */
public class MySqlTarjetaCreditoDAO extends MySqlBaseDAO implements TarjetaCreditoDAO {

  public MySqlTarjetaCreditoDAO() throws Exception {
    super();
  }

  public TarjetaCreditoDomain getTarjetaCredito(int idTarjetaCredito) {
    String sql = "select tc.* ";
    sql += "        from tarjeta_credito tc ";
    sql += "       where tc.id = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setInt(1, idTarjetaCredito);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        TarjetaCreditoDomain tarjetaCredito = obtenerTarjetaCreditoLlena(rs);
        return tarjetaCredito;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public TarjetaCreditoDomain getTarjetaCreditoByNumero(String numeroTarjetaCredito) {
    String sql = "select tc.* ";
    sql += "        from tarjeta_credito tc ";
    sql += "       where tc.numero_tarjeta = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setString(1, numeroTarjetaCredito);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        TarjetaCreditoDomain tarjetaCredito = obtenerTarjetaCreditoLlena(rs);
        return tarjetaCredito;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }
  
  public int registrarTarjetaCredito(TarjetaCreditoDomain tarjetaCredito) {
    int idCorrelativo = -1;
    String sql = "insert into tarjeta_credito ( id_emprendedor, id_banco, numero_tarjeta, fecha_caducidad, codigo_verificacion ) ";
    sql += "  values ( ?, ?, ?, ?, ? ); ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql, true);
      if (tarjetaCredito.getEmprendedor() != null) {
        pstmt.setInt(1, tarjetaCredito.getEmprendedor().getId());
      } else {
        pstmt.setNull(1, java.sql.Types.INTEGER);
      }
      if (tarjetaCredito.getBanco() != null) {
        pstmt.setInt(2, tarjetaCredito.getBanco().getId());
      } else {
        pstmt.setNull(2, java.sql.Types.INTEGER);
      }
      pstmt.setString(3, tarjetaCredito.getNumeroTarjeta());
      pstmt.setString(4, tarjetaCredito.getFechaCaducidad());
      pstmt.setString(5, tarjetaCredito.getCodigoVerificacion());
      pstmt.executeUpdate();
      ResultSet rs = pstmt.getGeneratedKeys();
      if (rs.next()) {
        idCorrelativo = rs.getInt(1);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return idCorrelativo;
  }

  public void actualizarTarjetaCredito(TarjetaCreditoDomain tarjetaCredito) {
    String sql = "update tarjeta_credito ";
    sql += "         set id_banco = ?, numero_tarjeta = ?, fecha_caducidad = ?, codigo_verificacion = ? ";
    sql += "       where id_emprendedor = ? ";
    sql += "         and id = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      if (tarjetaCredito.getBanco() != null) {
        pstmt.setInt(1, tarjetaCredito.getBanco().getId());
      } else {
        pstmt.setNull(1, java.sql.Types.INTEGER);
      }
      pstmt.setString(2, tarjetaCredito.getNumeroTarjeta());
      pstmt.setString(3, tarjetaCredito.getFechaCaducidad());
      pstmt.setString(4, tarjetaCredito.getCodigoVerificacion());
      pstmt.setInt(5, tarjetaCredito.getEmprendedor().getId());
      pstmt.setInt(6, tarjetaCredito.getId());
      pstmt.executeUpdate();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void eliminarTarjetaCredito(int idTarjetaCredito) {
    String sql = "delete from tarjeta_credito ";
    sql += "       where id = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setInt(1, idTarjetaCredito);
      pstmt.executeUpdate();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private TarjetaCreditoDomain obtenerTarjetaCreditoLlena(ResultSet rs) throws Exception {
    TarjetaCreditoDomain tarjetaCredito = new TarjetaCreditoDomain();
    tarjetaCredito.setId(rs.getInt("id"));
    if (rs.getObject("id_emprendedor") != null) {
      EmprendedorDAO emprendedorDao = new MySqlEmprendedorDAO();
      EmprendedorDomain emprendedor = emprendedorDao.getEmprendedor(rs.getInt("id_emprendedor"));
      tarjetaCredito.setEmprendedor(emprendedor);
    }
    if (rs.getObject("id_banco") != null) {
      BancoDomain banco = new BancoDomain();
      banco.setId(rs.getInt("id_banco"));
      tarjetaCredito.setBanco(banco);
    }
    tarjetaCredito.setNumeroTarjeta(rs.getString("numero_tarjeta"));
    tarjetaCredito.setFechaCaducidad(rs.getString("fecha_caducidad"));
    tarjetaCredito.setCodigoVerificacion(rs.getString("codigo_verificacion"));
    return tarjetaCredito;
  }
  
}
