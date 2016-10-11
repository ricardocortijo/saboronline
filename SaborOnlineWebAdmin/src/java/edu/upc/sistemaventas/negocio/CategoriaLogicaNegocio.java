/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.negocio;

import edu.upc.sistemaventas.dominio.CategoriaDomain;
import edu.upc.sistemaventas.persistencia.CategoriaDAO;
import edu.upc.sistemaventas.persistencia.MySqlCategoriaDAO;
import java.util.List;

/**
 *
 * @author ricardocortijo
 */
public class CategoriaLogicaNegocio {

  public CategoriaDomain buscarCategoria(int idCategoria) {
    try {
      CategoriaDAO CategoriaDao = new MySqlCategoriaDAO();
      return CategoriaDao.getCategoria(idCategoria);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }
  
  public CategoriaDomain buscarCategoriaPorNombre(String nombreCategoria) {
    try {
      CategoriaDAO categoriaDao = new MySqlCategoriaDAO();
      return categoriaDao.getCategoriaByNombre(nombreCategoria);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public List<CategoriaDomain> buscarCategoriasPorPadre(int idCategoriaPadre) {
    try {
      CategoriaDAO CategoriaDao = new MySqlCategoriaDAO();
      return CategoriaDao.getListaCategoriaHijas(idCategoriaPadre);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  /**
   * Registrar un nuevo Categoria.
   *
   * @param Categoria El objeto Categoria llenado.
   *
   * @return El ID generado del registro.
   */
  public int registrarCategoria(CategoriaDomain Categoria) {
    try {
      CategoriaDAO CategoriaDao = new MySqlCategoriaDAO();
      int idCategoria = CategoriaDao.registrarCategoria(Categoria);
      return idCategoria;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return -1;
  }

  /**
   * Actualizar un Categoria existente.
   *
   * @param Categoria El objeto Categoria llenado.
   */
  public void actualizarCategoria(CategoriaDomain Categoria) {
    try {
      CategoriaDAO CategoriaDao = new MySqlCategoriaDAO();
      CategoriaDao.actualizarCategoria(Categoria);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Eliminar un Categoria por ID.
   *
   * @param idCategoria ID del Categoria.
   */
  public void eliminarCategoria(int idCategoria) {
    try {
      CategoriaDAO CategoriaDao = new MySqlCategoriaDAO();
      CategoriaDao.eliminarCategoria(idCategoria);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  
  /**
   * Eliminar un Categoria por Nombre.
   *
   * @param nombreCategoria Nombre de la Categoria.
   */
  public void eliminarCategoriaByNombre(String nombreCategoria) {
    try {
      CategoriaDAO CategoriaDao = new MySqlCategoriaDAO();
      CategoriaDao.eliminarCategoriaByNombre(nombreCategoria);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

}
