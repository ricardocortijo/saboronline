/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.persistencia;

import edu.upc.sistemaventas.dominio.CategoriaDomain;
import java.util.List;

/**
 *
 * @author ricardocortijo
 */
public interface CategoriaDAO {

  public CategoriaDomain getCategoria(int idCategoria);
  public CategoriaDomain getCategoriaByNombre(String nombreCategoria);
  public List<CategoriaDomain> getListaCategoriaHijas(int idCategoriaPadre);

  public int registrarCategoria(CategoriaDomain Categoria);
  public void actualizarCategoria(CategoriaDomain Categoria);
  public void eliminarCategoria(int idCategoria);
  public void eliminarCategoriaByNombre(String nombreCategoria);
  
}
