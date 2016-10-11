/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.persistencia;

import edu.upc.sistemaventas.dominio.PreguntaDomain;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ricardocortijo
 */
public class MySqlPreguntaDAO extends MySqlBaseDAO implements PreguntaDAO {

  public MySqlPreguntaDAO() throws Exception {
    super();
  }

  public int registrarPregunta(int idPlanNegocio, PreguntaDomain pregunta) {
    int idCorrelativo = -1;
    String sql = "insert into pregunta ( titulo, descripcion, estado_pregunta, respuesta, id_plan_negocio ) ";
    sql += " values ( ?, ?, ?, ?, ? ) ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql, true);
      pstmt.setString(1, pregunta.getTitulo());
      pstmt.setString(2, pregunta.getDescripcion());
      pstmt.setString(3, pregunta.getEstadoPregunta());
      pstmt.setString(4, pregunta.getRespuesta());
      pstmt.setInt(5, idPlanNegocio);
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

  public void actualizarRespuesta(int idPlanNegocio, int idPregunta, String respuesta) {
    String sql = "update pregunta ";
    sql += "         set respuesta = ? ";
    sql += "       where id_plan_negocio = ? ";
    sql += "         and id = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setString(1, respuesta);
      pstmt.setInt(2, idPlanNegocio);
      pstmt.setInt(3, idPregunta);
      pstmt.executeUpdate();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  
}
