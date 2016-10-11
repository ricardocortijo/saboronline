/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.dominio;

import java.util.Date;
import java.util.List;

/**
 *
 * @author ricardocortijo
 */
public class EmprendedorDomain extends BaseDomain {

  private int id;
  private String nombres;
  private String apellidoPaterno;
  private String apellidoMaterno;
  private String sexo;
  private String tipoDocumentoIdentidad;
  private String numeroDocumentoIdentidad;
  private String correo;
  private String celular;
  private String direccion;
  private Date fechaNacimiento;
  private String clave;

  private UsuarioDomain usuario;
  private List<TarjetaCreditoDomain> listaTarjetasCreditos;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getApellidoMaterno() {
    return apellidoMaterno;
  }

  public void setApellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
  }

  public String getApellidoPaterno() {
    return apellidoPaterno;
  }

  public void setApellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
  }

  public String getCelular() {
    return celular;
  }

  public void setCelular(String celular) {
    this.celular = celular;
  }

  public String getClave() {
    return clave;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public Date getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public String getNumeroDocumentoIdentidad() {
    return numeroDocumentoIdentidad;
  }

  public void setNumeroDocumentoIdentidad(String numeroDocumentoIdentidad) {
    this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
  }

  public String getSexo() {
    return sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  public String getTipoDocumentoIdentidad() {
    return tipoDocumentoIdentidad;
  }

  public void setTipoDocumentoIdentidad(String tipoDocumentoIdentidad) {
    this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
  }

  public UsuarioDomain getUsuario() {
    return usuario;
  }

  public void setUsuario(UsuarioDomain usuario) {
    this.usuario = usuario;
  }

  public List<TarjetaCreditoDomain> getListaTarjetasCreditos() {
    return listaTarjetasCreditos;
  }

  public void setListaTarjetasCreditos(List<TarjetaCreditoDomain> listaTarjetasCreditos) {
    this.listaTarjetasCreditos = listaTarjetasCreditos;
  }

  public String getTipoNumeroDocumento() {
    String nomTipoDocumento = "[Desconocido]";
    if (tipoDocumentoIdentidad != null) {
      if (tipoDocumentoIdentidad.equals("1")) {
        nomTipoDocumento = "DNI";
      } else if (tipoDocumentoIdentidad.equals("2")) {
        nomTipoDocumento = "RUC";
      } else if (tipoDocumentoIdentidad.equals("3")) {
        nomTipoDocumento = "Carnet de Extranjeria";
      } else if (tipoDocumentoIdentidad.equals("4")) {
        nomTipoDocumento = "Brevete";
      }
    }
    return nomTipoDocumento + " - " + (numeroDocumentoIdentidad != null ? numeroDocumentoIdentidad : "[Sin Numero]");
  }
  
}
