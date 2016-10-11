/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.persistencia;

import edu.upc.sistemaventas.dominio.EmprendedorDomain;
import edu.upc.sistemaventas.dominio.UsuarioDomain;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ricardocortijo
 */
public class MySqlEmprendedorDAO extends MySqlBaseDAO implements EmprendedorDAO {

  public MySqlEmprendedorDAO() throws Exception {
    super();
  }
  
  public List<EmprendedorDomain> buscarListaEmprendedores(String nombresApellidos, String tipoDocumento, String numeroDocumento) {
    List<EmprendedorDomain> listaEmprendedores = new ArrayList<EmprendedorDomain>();
    String sql = "select e.* ";
    sql += "        from emprendedor e ";
    sql += "       where 1 = 1 ";
    if (nombresApellidos != null && !nombresApellidos.equals("")) {
      sql += "         and ( e.apellido_paterno like ? or e.apellido_materno like ? or e.nombres like ? ) ";
    }
    if (tipoDocumento != null && !tipoDocumento.equals("")) {
      sql += "         and e.tipo_doc_identidad = ? ";
    }
    if (numeroDocumento != null && !numeroDocumento.equals("")) {
      sql += "         and e.numero_doc_identidad = ? ";
    }
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      int i = 1;
      if (nombresApellidos != null && !nombresApellidos.equals("")) {
        pstmt.setString(i++, "%" + nombresApellidos + "%");
        pstmt.setString(i++, "%" + nombresApellidos + "%");
        pstmt.setString(i++, "%" + nombresApellidos + "%");
      }
      if (tipoDocumento != null && !tipoDocumento.equals("")) {
        pstmt.setString(i++, tipoDocumento);
      }
      if (numeroDocumento != null && !numeroDocumento.equals("")) {
        pstmt.setString(i++, numeroDocumento);
      }
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        EmprendedorDomain emprendedor = obtenerEmprendedorLleno(rs);
        listaEmprendedores.add(emprendedor);
      }
      return listaEmprendedores;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public EmprendedorDomain getEmprendedor(int idEmprendedor) {
    String sql = "select e.* ";
    sql += "        from emprendedor e ";
    sql += "       where e.id = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setInt(1, idEmprendedor);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        EmprendedorDomain emprendedor = obtenerEmprendedorLleno(rs);
        return emprendedor;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public EmprendedorDomain getEmprendedorByCorreo(String correo) {
    String sql = "select e.* ";
    sql += "        from emprendedor e ";
    sql += "       where e.correo_electronico = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setString(1, correo);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        EmprendedorDomain emprendedor = obtenerEmprendedorLleno(rs);
        return emprendedor;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public EmprendedorDomain getEmprendedorByTipoNumDoc(String tipoDocumento, String numeroDocumento) {
    String sql = "select e.* ";
    sql += "        from emprendedor e ";
    sql += "       where e.tipo_doc_identidad = ? ";
    sql += "         and e.numero_doc_identidad = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setString(1, tipoDocumento);
      pstmt.setString(2, numeroDocumento);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        EmprendedorDomain emprendedor = obtenerEmprendedorLleno(rs);
        return emprendedor;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public int registrarEmprendedor(EmprendedorDomain emprendedor) {
    int idCorrelativo = -1;
    String sql = "insert into emprendedor ( apellido_paterno, apellido_materno, nombres, sexo, tipo_doc_identidad, numero_doc_identidad, ";
    sql += "                                correo_electronico, celular, direccion, fecha_nacimiento, clave, id_usuario ) ";
    sql += "  values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ); ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql, true);
      pstmt.setString(1, emprendedor.getApellidoPaterno());
      pstmt.setString(2, emprendedor.getApellidoMaterno());
      pstmt.setString(3, emprendedor.getNombres());
      pstmt.setString(4, emprendedor.getSexo());
      pstmt.setString(5, emprendedor.getTipoDocumentoIdentidad());
      pstmt.setString(6, emprendedor.getNumeroDocumentoIdentidad());
      pstmt.setString(7, emprendedor.getCorreo());
      pstmt.setString(8, emprendedor.getCelular());
      pstmt.setString(9, emprendedor.getDireccion());
      pstmt.setDate(10, new Date(emprendedor.getFechaNacimiento().getTime()));
      pstmt.setString(11, emprendedor.getClave());
      if (emprendedor.getUsuario() != null) {
        pstmt.setInt(12, emprendedor.getUsuario().getId());
      } else {
        pstmt.setNull(12, java.sql.Types.INTEGER);
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

  public void actualizarEmprendedor(EmprendedorDomain emprendedor) {
    String sql = "update emprendedor ";
    sql += "         set apellido_paterno = ?, apellido_materno = ?, nombres = ?, sexo = ?, tipo_doc_identidad = ?, numero_doc_identidad = ?, ";
    sql += "             correo_electronico = ?, celular = ?, direccion = ?, fecha_nacimiento = ?, clave = ?, id_usuario = ? ";
    sql += "       where id = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setString(1, emprendedor.getApellidoPaterno());
      pstmt.setString(2, emprendedor.getApellidoMaterno());
      pstmt.setString(3, emprendedor.getNombres());
      pstmt.setString(4, emprendedor.getSexo());
      pstmt.setString(5, emprendedor.getTipoDocumentoIdentidad());
      pstmt.setString(6, emprendedor.getNumeroDocumentoIdentidad());
      pstmt.setString(7, emprendedor.getCorreo());
      pstmt.setString(8, emprendedor.getCelular());
      pstmt.setString(9, emprendedor.getDireccion());
      pstmt.setDate(10, new Date(emprendedor.getFechaNacimiento().getTime()));
      pstmt.setString(11, emprendedor.getClave());
      if (emprendedor.getUsuario() != null) {
        pstmt.setInt(12, emprendedor.getUsuario().getId());
      } else {
        pstmt.setNull(12, java.sql.Types.INTEGER);
      }
      pstmt.setInt(13, emprendedor.getId());
      pstmt.executeUpdate();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void eliminarEmprendedor(int idEmprendedor) {
    String sql = "delete from emprendedor ";
    sql += "       where id = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setInt(1, idEmprendedor);
      pstmt.executeUpdate();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void eliminarEmprendedorByCorreo(String correo) {
    String sql = "delete from emprendedor ";
    sql += "       where correo_electronico = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setString(1, correo);
      pstmt.executeUpdate();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void eliminarEmprendedorByTipoNumeroDoc(String tipoDocumento, String numeroDocumento) {
    String sql = "delete from emprendedor ";
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
  
  private EmprendedorDomain obtenerEmprendedorLleno(ResultSet rs) throws Exception {
    EmprendedorDomain emprendedor = new EmprendedorDomain();
    emprendedor.setId(rs.getInt("id"));
    emprendedor.setApellidoPaterno(rs.getString("apellido_paterno"));
    emprendedor.setApellidoMaterno(rs.getString("apellido_materno"));
    emprendedor.setNombres(rs.getString("nombres"));
    emprendedor.setSexo(rs.getString("sexo"));
    emprendedor.setTipoDocumentoIdentidad(rs.getString("tipo_doc_identidad"));
    emprendedor.setNumeroDocumentoIdentidad(rs.getString("numero_doc_identidad"));
    emprendedor.setCorreo(rs.getString("correo_electronico"));
    emprendedor.setCelular(rs.getString("celular"));
    emprendedor.setDireccion(rs.getString("direccion"));
    emprendedor.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
    emprendedor.setClave(rs.getString("clave"));
    if (rs.getObject("id_usuario") != null) {
      UsuarioDAO usuarioDao = new MySqlUsuarioDAO();
      UsuarioDomain usuario = usuarioDao.getUsuario(rs.getInt("id_usuario"));
      emprendedor.setUsuario(usuario);
    }
    return emprendedor;
  }
  
}
