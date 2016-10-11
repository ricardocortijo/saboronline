/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.dominio;

import java.util.List;

/**
 *
 * @author ricardocortijo
 */
public class SabioDomain extends EmprendedorDomain {

  private int id;
  private String apelativo;
  private String resumenAutobiografico;
  private String sitioWeb;

  private UsuarioDomain usuario;
  private List<CuentaBancariaDomain> listaCuentasBancarias;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getApelativo() {
    return apelativo;
  }

  public void setApelativo(String apelativo) {
    this.apelativo = apelativo;
  }

  public String getResumenAutobiografico() {
    return resumenAutobiografico;
  }

  public void setResumenAutobiografico(String resumenAutobiografico) {
    this.resumenAutobiografico = resumenAutobiografico;
  }

  public String getSitioWeb() {
    return sitioWeb;
  }

  public void setSitioWeb(String sitioWeb) {
    this.sitioWeb = sitioWeb;
  }

  public UsuarioDomain getUsuario() {
    return usuario;
  }

  public void setUsuario(UsuarioDomain usuario) {
    this.usuario = usuario;
  }

  public List<CuentaBancariaDomain> getListaCuentasBancarias() {
    return listaCuentasBancarias;
  }

  public void setListaCuentasBancarias(List<CuentaBancariaDomain> listaCuentasBancarias) {
    this.listaCuentasBancarias = listaCuentasBancarias;
  }

}
