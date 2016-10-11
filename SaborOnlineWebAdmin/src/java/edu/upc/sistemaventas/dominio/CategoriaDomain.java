/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.dominio;

/**
 *
 * @author ricardocortijo
 */
public class CategoriaDomain {

  private int id;
  private String nombreCategoria;
  private String descripcion;

  private CategoriaDomain categoriaPadre;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombreCategoria() {
    return nombreCategoria;
  }

  public void setNombreCategoria(String nombreCategoria) {
    this.nombreCategoria = nombreCategoria;
  }

  public CategoriaDomain getCategoriaPadre() {
    return categoriaPadre;
  }

  public void setCategoriaPadre(CategoriaDomain categoriaPadre) {
    this.categoriaPadre = categoriaPadre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

}
