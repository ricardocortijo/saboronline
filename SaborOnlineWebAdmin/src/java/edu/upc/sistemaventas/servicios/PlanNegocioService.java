/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.servicios;

import edu.upc.sistemaventas.dominio.PlanNegocioDomain;
import edu.upc.sistemaventas.negocio.PlanNegocioLogicaNegocio;
import java.util.List;

public class PlanNegocioService {
  
  private static PlanNegocioLogicaNegocio planNegocioLogicaNegocio = new PlanNegocioLogicaNegocio();
  
  public List<PlanNegocioDomain> buscarPlanesNegocio(String criterioBusqueda) {
    return planNegocioLogicaNegocio.buscarPlanesNegocio(criterioBusqueda);
  }
  
  public PlanNegocioDomain obtenerPlanNegocio(int idPlanNegocio) {
    return planNegocioLogicaNegocio.getPlanNegocio(idPlanNegocio);
  }
  
}
