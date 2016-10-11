/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.web.forms;

import edu.upc.sistemaventas.dominio.PlanNegocioDomain;
import java.util.List;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.NotEmpty;

public class PlanNegocioBusquedaForm extends BaseForm {
  
  private boolean existeResultados = false;
  
  @NotEmpty(message="Debe de ingresar un valor de criterio de búsqueda")
  private String criterioBusqueda;
  
  private List<PlanNegocioDomain> listaResultadosBusqueda;

  public boolean isExisteResultados() {
    return existeResultados;
  }

  public void setExisteResultados(boolean existeResultados) {
    this.existeResultados = existeResultados;
  }
  
  public String getCriterioBusqueda() {
    return criterioBusqueda;
  }

  public void setCriterioBusqueda(String criterioBusqueda) {
    this.criterioBusqueda = criterioBusqueda;
  }

  public List<PlanNegocioDomain> getListaResultadosBusqueda() {
    return listaResultadosBusqueda;
  }

  public void setListaResultadosBusqueda(List<PlanNegocioDomain> listaResultadosBusqueda) {
    this.listaResultadosBusqueda = listaResultadosBusqueda;
  }
  
}
