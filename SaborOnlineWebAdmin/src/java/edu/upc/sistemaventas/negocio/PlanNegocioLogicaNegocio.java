/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.negocio;

import edu.upc.sistemaventas.dominio.*;
import edu.upc.sistemaventas.persistencia.*;
import edu.upc.sistemaventas.utils.Parametros;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ricardocortijo
 */
public class PlanNegocioLogicaNegocio {

  /**
   *
   * Registrar un nuevo Plan de Negocio.
   *
   * @param planNegocio El objeto del Plan de Negocio llenado.
   *
   * @return El ID generado del registro.
   */
  public int registrarPlanNegocio(PlanNegocioDomain planNegocio) {
    try {
      PlanNegocioDAO planNegocioDao = new MySqlPlanNegocioDAO();
      int idPlanNegocio = planNegocioDao.registrarPlanNegocio(planNegocio);
      return idPlanNegocio;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return -1;
  }

  /**
   *
   * Si el plan de negocios es viable y cubre los requerimientos, se acepta el plan de negocio para su publicación,
   * caso contrario, se rechaza, indicando un mensaje del porque fue rechazado.
   *
   * @param idPlanNegocio ID del Plan de Negocio llenado.
   * @param esAprobado    true, define que el Plan esta aprobado, false que esta desaprobado.
   * @param mensajeFinal  El mensaje final.
   *
   * @return Valor true/false, dependiendo si el Plan de Negocio ha sido aprobado/rechazado para su publicación.
   */
  public boolean validarPublicacionPlanNegocio(int idPlanNegocio, boolean esAprobado, String mensajeFinal) {
    boolean esValido = false;
    try {
      PlanNegocioDAO planNegocioDao = new MySqlPlanNegocioDAO();
      PlanNegocioDomain planNegocio = planNegocioDao.getPlanNegocio(idPlanNegocio);
      planNegocio.setEstadoPlanNegocio(esAprobado ? Parametros.PLAN_PROYECTO_PUBLICADO : Parametros.PLAN_PROYECTO_RECHAZADO);
      planNegocio.setMensajeFinal(mensajeFinal);
      planNegocioDao.actualizarPlanNegocio(planNegocio);
      esValido = true;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return esValido;
  }

  /**
   * Obtener un determinado Plan de Negocio por ID.
   *
   * @param idPlanNegocio  El ID del plan de negocio a buscar.
   *
   * @return  El Plan de Negocio encontrado.
   */
  public PlanNegocioDomain getPlanNegocio(int idPlanNegocio) {
    try {
      PlanNegocioDomain planNegocio = null;
      PlanNegocioDAO planNegocioDao = new MySqlPlanNegocioDAO();
      planNegocio = planNegocioDao.getPlanNegocio(idPlanNegocio);
      return planNegocio;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }  
  
  /**
   * Buscar planes de negocio, en base a un criterio de búsqueda que busque por:
   * título, categoría, visión del negocio, razonamientos que conducen a la bondad de la propuesta.
   *
   * @param criterioBusqueda  El criterio de búsqueda a efectuar.
   *
   * @return  La lista de los Planes de Negocio encontrados.
   */
  public List<PlanNegocioDomain> buscarPlanesNegocio(String criterioBusqueda) {
    try {
      List<PlanNegocioDomain> listaPlanesNegocio = null;
      PlanNegocioDAO planNegocioDao = new MySqlPlanNegocioDAO();
      listaPlanesNegocio = planNegocioDao.buscarPlanesNegocio(criterioBusqueda);
      return listaPlanesNegocio;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  /**
   * Buscar planes de negocio, en base al criterio de búsqueda por Tiempo de Ejecución.
   *
   * @param tiempoEjecucionDesde  El tiempo de ejecución (desde).
   * @param tiempoEjecucionHasta  El tiempo de ejecución (hasta).
   *
   * @return  La lista de los Planes de Negocio encontrados.
   */
  public List<PlanNegocioDomain> buscarPlanesNegocioPorTiempoEjecucion(float tiempoEjecucionDesde, float tiempoEjecucionHasta) {
    try {
      List<PlanNegocioDomain> listaPlanesNegocio = null;
      PlanNegocioDAO planNegocioDao = new MySqlPlanNegocioDAO();
      listaPlanesNegocio = planNegocioDao.buscarPlanesNegocioPorTiempoEjecucion(tiempoEjecucionDesde, tiempoEjecucionHasta);
      return listaPlanesNegocio;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  /**
   * Buscar planes de negocio, en base al criterio de búsqueda por Inversión Total.
   *
   * @param tiempoEjecucionDesde  La inversión total (desde).
   * @param tiempoEjecucionHasta  La inversión total (hasta).
   *
   * @return  La lista de los Planes de Negocio encontrados.
   */
  public List<PlanNegocioDomain> buscarPlanesNegocioPorInversionTotal(BigDecimal inversionTotalDesde, BigDecimal inversionTotalHasta) {
    try {
      List<PlanNegocioDomain> listaPlanesNegocio = null;
      PlanNegocioDAO planNegocioDao = new MySqlPlanNegocioDAO();
      listaPlanesNegocio = planNegocioDao.buscarPlanesNegocioPorInversionTotal(inversionTotalDesde, inversionTotalHasta);
      return listaPlanesNegocio;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  /**
   * Buscar planes de negocio, en base al criterio de búsqueda por Margen Neto.
   *
   * @param tiempoEjecucionDesde  El margen neto (desde).
   * @param tiempoEjecucionHasta  El margen neto (hasta).
   *
   * @return  La lista de los Planes de Negocio encontrados.
   */
  public List<PlanNegocioDomain> buscarPlanesNegocioPorMargenNeto(BigDecimal margenNetoDesde, BigDecimal margenNetoHasta) {
    try {
      List<PlanNegocioDomain> listaPlanesNegocio = null;
      PlanNegocioDAO planNegocioDao = new MySqlPlanNegocioDAO();
      listaPlanesNegocio = planNegocioDao.buscarPlanesNegocioPorMargenNeto(margenNetoDesde, margenNetoHasta);
      return listaPlanesNegocio;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  /**
   * Buscar planes de negocio, en base al criterio de búsqueda por ROI.
   *
   * @param tiempoEjecucionDesde  El ROI (desde).
   * @param tiempoEjecucionHasta  El ROI (hasta).
   *
   * @return  La lista de los Planes de Negocio encontrados.
   */
  public List<PlanNegocioDomain> buscarPlanesNegocioPorROI(BigDecimal roiDesde, BigDecimal roiHasta) {
    try {
      List<PlanNegocioDomain> listaPlanesNegocio = null;
      PlanNegocioDAO planNegocioDao = new MySqlPlanNegocioDAO();
      listaPlanesNegocio = planNegocioDao.buscarPlanesNegocioPorROI(roiDesde, roiHasta);
      return listaPlanesNegocio;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  /**
   * Registrar alguna pregunta sobre un determinado Plan de Negocio.
   *
   * @param idPlanNegocio ID del Plan de Negocio.
   * @param pregunta      Pregunta a ser realizada y registrada.
   *
   * @return  El ID de la pregunta registrada.
   */
  public int registrarPreguntaPlanNegocio(int idPlanNegocio, PreguntaDomain pregunta) {
    try {
      PreguntaDAO preguntaDao = new MySqlPreguntaDAO();
      int idPregunta = preguntaDao.registrarPregunta(idPlanNegocio, pregunta);
      return idPregunta;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return -1;
  }

  /**
   * Actualizar la respuesta del sabio a una pregunta determinada de un Plan de Negocio.
   *
   * @param idPlanNegocio ID del Plan de Negocio.
   * @param idPregunta    ID de la Pregunta.
   * @param respuesta     El contenido de la respuesta (formato cadena).
   */
  public void actualizarRespuestaPreguntaPlanNegocio(int idPlanNegocio, int idPregunta, String respuesta) {
    try {
      PreguntaDAO preguntaDao = new MySqlPreguntaDAO();
      preguntaDao.actualizarRespuesta(idPlanNegocio, idPregunta, respuesta);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Realizar la compra de un Plan de Negocio, mediante el uso de tarjeta de crédito
   *
   * @param idPlanNegocio ID del Plan de Negocio.
   * @param idEmprendedor ID del Emprendedor.
   * @param infoTarjeta   Información de la Tarjeta de Crédito a ser utilizada.
   * @param direccion     Direccion de Entrega.
   *
   * @return El documento completo a ser descargado.
   */
  public DocumentoDomain comprarPlanNegocioPorTarjetaCredito(int idPlanNegocio, int idEmprendedor, TarjetaCreditoDomain infoTarjeta, String direccion) {
    try {
      DocumentoDomain documento = null;
      //** DAOs
      EmprendedorDAO emprendedorDao = new MySqlEmprendedorDAO();
      PlanNegocioDAO planNegocioDao = new MySqlPlanNegocioDAO();
      TarjetaCreditoDAO tarjetaCreditoDao = new MySqlTarjetaCreditoDAO();
      TransaccionPagoDAO transaccionDao = new MySqlTransaccionPagoDAO();
      DocumentoDAO documentoDao = new MySqlDocumentoDAO();
      //** Creando la instancia transaccion
      TransaccionPagoDomain transaccion = new TransaccionPagoDomain();
      transaccion.setPlanNegocio(planNegocioDao.getPlanNegocio(idPlanNegocio));
      transaccion.setEmprendedor(emprendedorDao.getEmprendedor(idEmprendedor));
      transaccion.setFechaTransaccion(new Date());
      transaccion.setTarjetaCredito(infoTarjeta);
      transaccion.setDireccionFacturacion(direccion);
      //** Registrando la Tarjeta de Credito (en caso no exista)
      TarjetaCreditoDomain tarjetaCreditoBuscada = tarjetaCreditoDao.getTarjetaCreditoByNumero(infoTarjeta.getNumeroTarjeta());
      if (tarjetaCreditoBuscada == null) {
        int idNuevaTarjetaCredito = tarjetaCreditoDao.registrarTarjetaCredito(infoTarjeta);
        infoTarjeta.setId(idNuevaTarjetaCredito);
      } else {
        infoTarjeta = tarjetaCreditoBuscada;
        transaccion.setTarjetaCredito(infoTarjeta);
      }
      //** Registrando la transaccion
      boolean estadoOperacion = transaccionDao.registrarTransaccionPago(transaccion);
      //** Actualizando el estado del Plan de Negocio ("C" --> Comprado)
      planNegocioDao.actualizarEstadoPlanNegocio(idPlanNegocio, Parametros.PLAN_PROYECTO_COMPRADO);
      //** Recuperando el documento
      if (estadoOperacion) {
        PlanNegocioDomain planNegocio = planNegocioDao.getPlanNegocio(idPlanNegocio);
        if (planNegocio.getDocumento() != null) {
          documento = documentoDao.getDocumento(planNegocio.getDocumento().getId());
        }
      }
      return documento;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }
  
}
