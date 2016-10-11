/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.dominio;

/**
 *
 * @author ricardocortijo
 */
public class UsuarioDomain {

  private int id;
  private String codigoUsuario;
  private String clave;
  private String nombres;
  private String apellidos;
  private String correoElectronico;
  
  private RolDomain rol;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCodigoUsuario() {
    return codigoUsuario;
  }

  public void setCodigoUsuario(String codigoUsuario) {
    this.codigoUsuario = codigoUsuario;
  }

  public String getClave() {
    return clave;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }

  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getCorreoElectronico() {
    return correoElectronico;
  }

  public void setCorreoElectronico(String correoElectronico) {
    this.correoElectronico = correoElectronico;
  }
  
  public RolDomain getRol() {
    return rol;
  }

  public void setRol(RolDomain rol) {
    this.rol = rol;
  }
  
}
