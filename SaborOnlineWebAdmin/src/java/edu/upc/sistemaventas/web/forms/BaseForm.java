/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.web.forms;

/**
 *
 * @author Edgar Pajuelo
 */
public class BaseForm {

  protected boolean tieneErrores = false;

  public boolean isTieneErrores() {
    return tieneErrores;
  }

  public void setTieneErrores(boolean tieneErrores) {
    this.tieneErrores = tieneErrores;
  }

}
