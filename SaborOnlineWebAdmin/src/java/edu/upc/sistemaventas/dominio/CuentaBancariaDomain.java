/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.dominio;

/**
 *
 * @author ricardocortijo
 */
public class CuentaBancariaDomain {
  
  private BancoDomain banco;
  private String numeroCuenta;

  public BancoDomain getBanco() {
    return banco;
  }

  public void setBanco(BancoDomain banco) {
    this.banco = banco;
  }

  public String getNumeroCuenta() {
    return numeroCuenta;
  }

  public void setNumeroCuenta(String numeroCuenta) {
    this.numeroCuenta = numeroCuenta;
  }
  
}
