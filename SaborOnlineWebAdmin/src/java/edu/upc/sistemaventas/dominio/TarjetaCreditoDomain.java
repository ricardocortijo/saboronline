/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.dominio;

/**
 *
 * @author ricardocortijo
 */
public class TarjetaCreditoDomain {

  private int id;

  private BancoDomain banco;
  private EmprendedorDomain emprendedor;

  private String numeroTarjeta;
  private String fechaCaducidad;
  private String codigoVerificacion;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public BancoDomain getBanco() {
    return banco;
  }

  public void setBanco(BancoDomain banco) {
    this.banco = banco;
  }

  public EmprendedorDomain getEmprendedor() {
    return emprendedor;
  }

  public void setEmprendedor(EmprendedorDomain emprendedor) {
    this.emprendedor = emprendedor;
  }

  public String getCodigoVerificacion() {
    return codigoVerificacion;
  }

  public void setCodigoVerificacion(String codigoVerificacion) {
    this.codigoVerificacion = codigoVerificacion;
  }

  public String getFechaCaducidad() {
    return fechaCaducidad;
  }

  public void setFechaCaducidad(String fechaCaducidad) {
    this.fechaCaducidad = fechaCaducidad;
  }

  public String getNumeroTarjeta() {
    return numeroTarjeta;
  }

  public void setNumeroTarjeta(String numeroTarjeta) {
    this.numeroTarjeta = numeroTarjeta;
  }

}
