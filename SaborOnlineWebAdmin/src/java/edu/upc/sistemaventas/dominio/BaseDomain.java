/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.dominio;

public abstract class BaseDomain {

  private boolean tieneErrores = false;
  private boolean seleccionado;
  private String accion;

  public boolean isTieneErrores() {
    return tieneErrores;
  }

  public void setTieneErrores(boolean tieneErrores) {
    this.tieneErrores = tieneErrores;
  }

  public boolean isSeleccionado() {
    return seleccionado;
  }

  public void setSeleccionado(boolean seleccionado) {
    this.seleccionado = seleccionado;
  }

  public String getAccion() {
    return accion;
  }

  public void setAccion(String accion) {
    this.accion = accion;
  }
  
}
