/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.persistencia;

import edu.upc.sistemaventas.dominio.UsuarioDomain;

/**
 *
 * @author ricardocortijo
 */
public interface UsuarioDAO {
  
  public UsuarioDomain getUsuario(int idUsuario);
  public UsuarioDomain getUsuarioByCodigo(String codigoUsuario);
  public int registrarUsuario(UsuarioDomain usuario);
  public void actualizarUsuario(UsuarioDomain Usuario);
  public void eliminarUsuario(int idUsuario);
  
}
