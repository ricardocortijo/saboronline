/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.persistencia;

import edu.upc.sistemaventas.dominio.CategoriaDomain;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ricardocortijo
 */
public class MySqlCategoriaDAO extends MySqlBaseDAO implements CategoriaDAO {

  public MySqlCategoriaDAO() throws Exception {
    super();
  }

  public CategoriaDomain getCategoria(int idCategoria) {
    String sql = "select c.* ";
    sql += "        from categoria c ";
    sql += "       where c.id = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setInt(1, idCategoria);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        CategoriaDomain categoria = obtenerCategoriaLlena(rs);
        return categoria;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }
  
  public CategoriaDomain getCategoriaByNombre(String nombreCategoria) {
    String sql = "select c.* ";
    sql += "        from categoria c ";
    sql += "       where c.nombre = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setString(1, nombreCategoria);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        CategoriaDomain categoria = obtenerCategoriaLlena(rs);
        return categoria;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public List<CategoriaDomain> getListaCategoriaHijas(int idCategoriaPadre) {
    List<CategoriaDomain> listaCategorias = null;
    String sql = "select c.* ";
    sql += "        from categoria c ";
    sql += "       where c.id_padre = ? ";
    try {
      listaCategorias = new ArrayList<CategoriaDomain>();
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setInt(1, idCategoriaPadre);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        CategoriaDomain categoria = obtenerCategoriaLlena(rs);
        listaCategorias.add(categoria);
      }
      return listaCategorias;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public int registrarCategoria(CategoriaDomain categoria) {
    int idCorrelativo = -1;
    String sql = "insert into categoria ( nombre, descripcion, id_padre ) ";
    sql += " values ( ?, ? , ? ) ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql, true);
      pstmt.setString(1, categoria.getNombreCategoria());
      pstmt.setString(2, categoria.getDescripcion());
      if (categoria.getCategoriaPadre() != null) {
        pstmt.setInt(3, categoria.getCategoriaPadre().getId());
      } else {
        pstmt.setNull(3, java.sql.Types.INTEGER);
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

  public void actualizarCategoria(CategoriaDomain categoria) {
    String sql = "update categoria ";
    sql += "         set nombre = ?, descripcion = ?, id_padre = ? ";
    sql += "       where id = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setString(1, categoria.getNombreCategoria());
      pstmt.setString(2, categoria.getDescripcion());
      if (categoria.getCategoriaPadre() != null) {
        pstmt.setInt(3, categoria.getCategoriaPadre().getId());
      } else {
        pstmt.setNull(3, java.sql.Types.INTEGER);
      }
      pstmt.setInt(4, categoria.getId());
      pstmt.executeUpdate();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void eliminarCategoria(int idCategoria) {
    String sql = "delete from categoria ";
    sql += "       where id = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setInt(1, idCategoria);
      pstmt.executeUpdate();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void eliminarCategoriaByNombre(String nombreCategoria) {
    String sql = "delete from categoria ";
    sql += "       where nombre = ? ";
    try {
      PreparedStatement pstmt = db.getPreparedStatement(sql);
      pstmt.setString(1, nombreCategoria);
      pstmt.executeUpdate();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  
  private CategoriaDomain obtenerCategoriaLlena(ResultSet rs) throws Exception {
    CategoriaDomain categoria = new CategoriaDomain();
    categoria.setId(rs.getInt("id"));
    categoria.setNombreCategoria(rs.getString("nombre"));
    categoria.setDescripcion(rs.getString("descripcion"));
    if (rs.getObject("id_padre") != null) {
      CategoriaDomain categoriaPadre = getCategoria(rs.getInt("id_padre"));
      categoria.setCategoriaPadre(categoriaPadre);
    }
    return categoria;
  }
  
}
