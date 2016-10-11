/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.persistencia;

import edu.upc.sistemaventas.dominio.SabioDomain;
import edu.upc.sistemaventas.dominio.UsuarioDomain;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ricardocortijo
 */
public class MySqlSabioDAO extends MySqlBaseDAO implements SabioDAO {

  public MySqlSabioDAO() throws Exception {
    super();
  }

  public SabioDomain getSabio(int idSabio) {
    String sql = "select e.* ";
    sql += "        from sabio e ";
    sql += "       where e.id = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setInt(1, idSabio);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        SabioDomain sabio = obtenerSabioLleno(rs);
        return sabio;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public SabioDomain getSabioByCorreo(String correo) {
    String sql = "select s.* ";
    sql += "        from sabio s ";
    sql += "       where s.correo_electronico = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setString(1, correo);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        SabioDomain sabio = obtenerSabioLleno(rs);
        return sabio;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public SabioDomain getSabioByTipoNumDoc(String tipoDocumento, String numeroDocumento) {
    String sql = "select s.* ";
    sql += "        from sabio s ";
    sql += "       where s.tipo_doc_identidad = ? ";
    sql += "         and s.numero_doc_identidad = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setString(1, tipoDocumento);
      pstmt.setString(2, numeroDocumento);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        SabioDomain sabio = obtenerSabioLleno(rs);
        return sabio;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }
  
  public int registrarSabio(SabioDomain sabio) {
    int idCorrelativo = -1;
    String sql = "insert into sabio ( apellido_paterno, apellido_materno, nombres, sexo, tipo_doc_identidad, numero_doc_identidad, ";
    sql += "                          correo_electronico, celular, direccion, fecha_nacimiento, clave, id_usuario, ";
    sql += "                          apelativo, resumen_autobiografico, sitio_web, id_cuenta_bancaria ) ";
    sql += "  values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ); ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql, true);
      pstmt.setString(1, sabio.getApellidoPaterno());
      pstmt.setString(2, sabio.getApellidoMaterno());
      pstmt.setString(3, sabio.getNombres());
      pstmt.setString(4, sabio.getSexo());
      pstmt.setString(5, sabio.getTipoDocumentoIdentidad());
      pstmt.setString(6, sabio.getNumeroDocumentoIdentidad());
      pstmt.setString(7, sabio.getCorreo());
      pstmt.setString(8, sabio.getCelular());
      pstmt.setString(9, sabio.getDireccion());
      pstmt.setDate(10, new Date(sabio.getFechaNacimiento().getTime()));
      pstmt.setString(11, sabio.getClave());
      if (sabio.getUsuario() != null) {
        pstmt.setInt(12, sabio.getUsuario().getId());
      } else {
        pstmt.setNull(12, java.sql.Types.INTEGER);
      }
      pstmt.setString(13, sabio.getApelativo());
      pstmt.setString(14, sabio.getResumenAutobiografico());
      pstmt.setString(15, sabio.getSitioWeb());
      pstmt.setNull(16, java.sql.Types.INTEGER);
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

  public void actualizarSabio(SabioDomain sabio) {
    String sql = "update sabio ";
    sql += "         set apellido_paterno = ?, apellido_materno = ?, nombres = ?, sexo = ?, tipo_doc_identidad = ?, numero_doc_identidad = ?, ";
    sql += "             correo_electronico = ?, celular = ?, direccion = ?, fecha_nacimiento = ?, clave = ?, id_usuario = ?, ";
    sql += "             apelativo = ?, resumen_autobiografico = ?, sitio_web = ? ";
    sql += "       where id = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setString(1, sabio.getApellidoPaterno());
      pstmt.setString(2, sabio.getApellidoMaterno());
      pstmt.setString(3, sabio.getNombres());
      pstmt.setString(4, sabio.getSexo());
      pstmt.setString(5, sabio.getTipoDocumentoIdentidad());
      pstmt.setString(6, sabio.getNumeroDocumentoIdentidad());
      pstmt.setString(7, sabio.getCorreo());
      pstmt.setString(8, sabio.getCelular());
      pstmt.setString(9, sabio.getDireccion());
      pstmt.setDate(10, new Date(sabio.getFechaNacimiento().getTime()));
      pstmt.setString(11, sabio.getClave());
      if (sabio.getUsuario() != null) {
        pstmt.setInt(12, sabio.getUsuario().getId());
      } else {
        pstmt.setNull(12, java.sql.Types.INTEGER);
      }
      pstmt.setString(13, sabio.getApelativo());
      pstmt.setString(14, sabio.getResumenAutobiografico());
      pstmt.setString(15, sabio.getSitioWeb());
      pstmt.setInt(16, sabio.getId());
      pstmt.executeUpdate();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void eliminarSabio(int idSabio) {
    String sql = "delete from sabio ";
    sql += "       where id = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setInt(1, idSabio);
      pstmt.executeUpdate();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  
  public void eliminarSabioByCorreo(String correo) {
    String sql = "delete from sabio ";
    sql += "       where correo_electronico = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setString(1, correo);
      pstmt.executeUpdate();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void eliminarSabioByTipoNumeroDoc(String tipoDocumento, String numeroDocumento) {
    String sql = "delete from sabio ";
    sql += "       where tipo_doc_identidad = ? ";
    sql += "         and numero_doc_identidad = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setString(1, tipoDocumento);
      pstmt.setString(2, numeroDocumento);
      pstmt.executeUpdate();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private SabioDomain obtenerSabioLleno(ResultSet rs) throws Exception {
    SabioDomain sabio = new SabioDomain();
    sabio.setId(rs.getInt("id"));
    sabio.setApellidoPaterno(rs.getString("apellido_paterno"));
    sabio.setApellidoMaterno(rs.getString("apellido_materno"));
    sabio.setNombres(rs.getString("nombres"));
    sabio.setSexo(rs.getString("sexo"));
    sabio.setTipoDocumentoIdentidad(rs.getString("tipo_doc_identidad"));
    sabio.setNumeroDocumentoIdentidad(rs.getString("numero_doc_identidad"));
    sabio.setCorreo(rs.getString("correo_electronico"));
    sabio.setCelular(rs.getString("celular"));
    sabio.setDireccion(rs.getString("direccion"));
    sabio.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
    sabio.setClave(rs.getString("clave"));
    sabio.setApelativo(rs.getString("apelativo"));
    sabio.setResumenAutobiografico(rs.getString("resumen_autobiografico"));
    sabio.setSitioWeb(rs.getString("sitio_web"));
    if (rs.getObject("id_usuario") != null) {
      UsuarioDAO usuarioDao = new MySqlUsuarioDAO();
      UsuarioDomain usuario = usuarioDao.getUsuario(rs.getInt("id_usuario"));
      sabio.setUsuario(usuario);
    }
    return sabio;
  }
  
}
