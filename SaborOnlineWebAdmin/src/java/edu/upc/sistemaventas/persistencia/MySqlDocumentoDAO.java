/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.persistencia;

import edu.upc.sistemaventas.dominio.DocumentoDomain;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ricardocortijo
 */
public class MySqlDocumentoDAO extends MySqlBaseDAO implements DocumentoDAO {

  public MySqlDocumentoDAO() throws Exception {
    super();
  }

  public DocumentoDomain getDocumento(int idDocumento) {
    String sql = "select d.* ";
    sql += "        from documento d ";
    sql += "       where d.id = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setInt(1, idDocumento);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        DocumentoDomain documento = obtenerDocumentoLleno(rs);
        return documento;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public int registrarDocumento(DocumentoDomain documento) {
    int idCorrelativo = -1;
    String sql = "insert into documento ( nombre, descripcion, contenido ) ";
    sql += " values ( ?, ? , ? ) ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql, true);
      pstmt.setString(1, documento.getNombreDocumento());
      pstmt.setString(2, documento.getDescripcion());
      if (documento.getContenido() != null) {
        pstmt.setBytes(3, documento.getContenido());
      } else {
        pstmt.setNull(3, java.sql.Types.BLOB);
      }
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

  private DocumentoDomain obtenerDocumentoLleno(ResultSet rs) throws Exception {
    DocumentoDomain documento = new DocumentoDomain();
    documento.setId(rs.getInt("id"));
    documento.setNombreDocumento(rs.getString("nombre"));
    documento.setDescripcion(rs.getString("descripcion"));
    documento.setContenido(rs.getBytes("contenido"));
    return documento;
  }
  
}
