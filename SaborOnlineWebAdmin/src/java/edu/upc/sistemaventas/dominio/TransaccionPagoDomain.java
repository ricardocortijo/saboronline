/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.dominio;

import java.util.Date;

/**
 *
 * @author ricardocortijo
 */
public class TransaccionPagoDomain {

  private int numeroTransaccion;
  private Date fechaTransaccion;
  private String direccionFacturacion;

  private EmprendedorDomain emprendedor;
  private PlanNegocioDomain planNegocio;
  private TarjetaCreditoDomain tarjetaCredito;

  public int getNumeroTransaccion() {
    return numeroTransaccion;
  }

  public void setNumeroTransaccion(int numeroTransaccion) {
    this.numeroTransaccion = numeroTransaccion;
  }

  public Date getFechaTransaccion() {
    return fechaTransaccion;
  }

  public void setFechaTransaccion(Date fechaTransaccion) {
    this.fechaTransaccion = fechaTransaccion;
  }

  public String getDireccionFacturacion() {
    return direccionFacturacion;
  }

  public void setDireccionFacturacion(String direccionFacturacion) {
    this.direccionFacturacion = direccionFacturacion;
  }
  
  public EmprendedorDomain getEmprendedor() {
    return emprendedor;
  }

  public void setEmprendedor(EmprendedorDomain emprendedor) {
    this.emprendedor = emprendedor;
  }

  public PlanNegocioDomain getPlanNegocio() {
    return planNegocio;
  }

  public void setPlanNegocio(PlanNegocioDomain planNegocio) {
    this.planNegocio = planNegocio;
  }

  public TarjetaCreditoDomain getTarjetaCredito() {
    return tarjetaCredito;
  }

  public void setTarjetaCredito(TarjetaCreditoDomain tarjetaCredito) {
    this.tarjetaCredito = tarjetaCredito;
  }

}
