/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.persistencia;

import edu.upc.sistemaventas.dominio.PlanNegocioDomain;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author ricardocortijo
 */
public interface PlanNegocioDAO {

  public PlanNegocioDomain getPlanNegocio(int idPlanNegocio);
  public int registrarPlanNegocio(PlanNegocioDomain pregunta);
  public void actualizarPlanNegocio(PlanNegocioDomain planNegocio);
  public void actualizarEstadoPlanNegocio(int idPlanNegocio, String estado);
  public void eliminarPlanNegocio(int idPlanNegocio);

  public List<PlanNegocioDomain> buscarPlanesNegocio(String criterioBusqueda);
  public List<PlanNegocioDomain> buscarPlanesNegocioPorTiempoEjecucion(float tiempoEjecucionInicio, float tiempoEjecucionFin);
  public List<PlanNegocioDomain> buscarPlanesNegocioPorInversionTotal(BigDecimal inversionTotalDesde, BigDecimal inversionTotalHasta);
  public List<PlanNegocioDomain> buscarPlanesNegocioPorMargenNeto(BigDecimal margenNetoDesde, BigDecimal margenNetoHasta);
  public List<PlanNegocioDomain> buscarPlanesNegocioPorROI(BigDecimal roiDesde, BigDecimal roiHasta);

  public List<PlanNegocioDomain> obtenerPlanesNegocioPorSabio(int idSabio);
  
}
