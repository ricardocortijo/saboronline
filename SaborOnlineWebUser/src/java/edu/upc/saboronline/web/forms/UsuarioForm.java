/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.saboronline.web.forms;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.NotEmpty;

public class UsuarioForm extends BaseForm {
  
  @NotNull(message="Debe de ingresar un valor para el campo 'Usuario'")
  @NotEmpty(message="Debe de ingresar un valor para el campo 'Usuario'")
  private String usuario;
  
  @NotNull(message="Debe de ingresar un valor para el campo 'Clave'")
  @NotEmpty(message="Debe de ingresar un valor para el campo 'Clave'")
  private String clave;

  public String getUsuario() {
    return usuario;
  }
  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getClave() {
    return clave;
  }
  public void setClave(String clave) {
    this.clave = clave;
  }
  
}
