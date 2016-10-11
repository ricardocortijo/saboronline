/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.dominio;

public class BusquedaBaseDomain extends BaseDomain {
  
  private String accion;
  private String elementoSeleccionado;

  public String getAccion() {
    return accion;
  }

  public void setAccion(String accion) {
    this.accion = accion;
  }
  
  public String getElementoSeleccionado() {
    return elementoSeleccionado;
  }

  public void setElementoSeleccionado(String elementoSeleccionado) {
    this.elementoSeleccionado = elementoSeleccionado;
  }

}
