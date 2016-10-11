/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.web.forms;

import edu.upc.sistemaventas.dominio.BusquedaBaseDomain;
import edu.upc.sistemaventas.dominio.EmprendedorDomain;
import java.util.List;

public class EmprendedorBusquedaForm extends BusquedaBaseDomain {

  private boolean existeResultados = false;
  
  private String nombresApellidos;
  private String tipoDocumento;
  private String numeroDocumento;
  private List<EmprendedorDomain> listaResultadosBusqueda;

  public boolean isExisteResultados() {
    return existeResultados;
  }

  public void setExisteResultados(boolean existeResultados) {
    this.existeResultados = existeResultados;
  }

  public String getNombresApellidos() {
    return nombresApellidos;
  }

  public void setNombresApellidos(String nombresApellidos) {
    this.nombresApellidos = nombresApellidos;
  }

  public String getTipoDocumento() {
    return tipoDocumento;
  }

  public void setTipoDocumento(String tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
  }

  public String getNumeroDocumento() {
    return numeroDocumento;
  }

  public void setNumeroDocumento(String numeroDocumento) {
    this.numeroDocumento = numeroDocumento;
  }

  public List<EmprendedorDomain> getListaResultadosBusqueda() {
    return listaResultadosBusqueda;
  }

  public void setListaResultadosBusqueda(List<EmprendedorDomain> listaResultadosBusqueda) {
    this.listaResultadosBusqueda = listaResultadosBusqueda;
  }
  
}
