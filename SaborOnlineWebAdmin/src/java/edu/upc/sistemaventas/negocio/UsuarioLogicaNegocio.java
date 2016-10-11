/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.negocio;

import edu.upc.sistemaventas.dominio.UsuarioDomain;
import edu.upc.sistemaventas.persistencia.UsuarioDAO;
import edu.upc.sistemaventas.persistencia.MySqlUsuarioDAO;

/**
 *
 * @author ricardocortijo
 */
public class UsuarioLogicaNegocio {

  public UsuarioDomain buscarUsuario(int idUsuario) {
    try {
      UsuarioDAO UsuarioDao = new MySqlUsuarioDAO();
      return UsuarioDao.getUsuario(idUsuario);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }
  
  public UsuarioDomain buscarUsuarioByCodigo(String codigoUsuario) {
    try {
      UsuarioDAO UsuarioDao = new MySqlUsuarioDAO();
      return UsuarioDao.getUsuarioByCodigo(codigoUsuario);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }
  
  /**
   * Registrar un nuevo Usuario.
   *
   * @param Usuario El objeto Usuario llenado.
   *
   * @return El ID generado del registro.
   */
  public int registrarUsuario(UsuarioDomain Usuario) {
    try {
      UsuarioDAO UsuarioDao = new MySqlUsuarioDAO();
      int idUsuario = UsuarioDao.registrarUsuario(Usuario);
      return idUsuario;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return -1;
  }

  /**
   * Actualizar un Usuario existente.
   *
   * @param Usuario El objeto Usuario llenado.
   */
  public void actualizarUsuario(UsuarioDomain Usuario) {
    try {
      UsuarioDAO UsuarioDao = new MySqlUsuarioDAO();
      UsuarioDao.actualizarUsuario(Usuario);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Eliminar un Usuario por ID.
   *
   * @param idUsuario ID del Usuario.
   */
  public void eliminarUsuario(int idUsuario) {
    try {
      UsuarioDAO UsuarioDao = new MySqlUsuarioDAO();
      UsuarioDao.eliminarUsuario(idUsuario);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

}
