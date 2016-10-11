/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.persistencia;

import edu.upc.sistemaventas.dominio.RolDomain;
import edu.upc.sistemaventas.dominio.UsuarioDomain;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ricardocortijo
 */
public class MySqlUsuarioDAO extends MySqlBaseDAO implements UsuarioDAO {

  public MySqlUsuarioDAO() throws Exception {
    super();
  }

  public UsuarioDomain getUsuario(int idUsuario) {
    String sql = "select u.* ";
    sql += "        from usuario u ";
    sql += "       where u.id = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setInt(1, idUsuario);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        UsuarioDomain usuario = obtenerUsuarioLleno(rs);
        return usuario;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }
  
  public UsuarioDomain getUsuarioByCodigo(String codigoUsuario) {
    String sql = "select u.* ";
    sql += "        from usuario u ";
    sql += "       where u.codigo_usuario = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setString(1, codigoUsuario);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        UsuarioDomain usuario = obtenerUsuarioLleno(rs);
        return usuario;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public int registrarUsuario(UsuarioDomain usuario) {
    int idCorrelativo = -1;
    String sql = "insert into usuario ( id_rol ) ";
    sql += " values ( ? ) ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql, true);
      if (usuario.getRol() != null) {
        pstmt.setInt(1, usuario.getRol().getId());
      } else {
        pstmt.setNull(1, java.sql.Types.INTEGER);
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

  @Override
  public void actualizarUsuario(UsuarioDomain Usuario) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void eliminarUsuario(int idUsuario) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  private UsuarioDomain obtenerUsuarioLleno(ResultSet rs) throws Exception {
    UsuarioDomain usuario = new UsuarioDomain();
    usuario.setId(rs.getInt("id"));
    usuario.setCodigoUsuario(rs.getString("codigo_usuario"));
    usuario.setClave(rs.getString("clave"));
    usuario.setNombres(rs.getString("nombres"));
    usuario.setApellidos(rs.getString("apellidos"));
    usuario.setCorreoElectronico(rs.getString("correo_electronico"));
    if (rs.getObject("id_rol") != null) {
      RolDomain rol = new RolDomain();
      rol.setId(rs.getInt("id_rol"));
      usuario.setRol(rol);
    }
    return usuario;
  }
  
}
