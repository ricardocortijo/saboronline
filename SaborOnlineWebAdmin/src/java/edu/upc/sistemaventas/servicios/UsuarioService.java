/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.servicios;

import edu.upc.sistemaventas.dominio.UsuarioDomain;
import edu.upc.sistemaventas.negocio.UsuarioLogicaNegocio;

public class UsuarioService {
  
  private static UsuarioLogicaNegocio usuarioLogicaNegocio = new UsuarioLogicaNegocio();
  
  public UsuarioDomain obtenerUsuario(String codigoUsuario) {
    return usuarioLogicaNegocio.buscarUsuarioByCodigo(codigoUsuario);
  }
  
}
