/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.saboronline.servicios;

import edu.upc.saboronline.negocio.UsuarioLogicaNegocio;

public class UsuarioService {
  
  private UsuarioLogicaNegocio usuarioLogicaNegocio = new UsuarioLogicaNegocio();
  
  public boolean validarUsuario(String codigoUsuario, String clave) {
    return usuarioLogicaNegocio.validarUsuario(codigoUsuario, clave);
  }
  
}
