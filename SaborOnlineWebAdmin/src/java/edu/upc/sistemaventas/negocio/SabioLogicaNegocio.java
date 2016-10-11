/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.negocio;

import edu.upc.sistemaventas.dominio.SabioDomain;
import edu.upc.sistemaventas.utils.BusinessException;
import edu.upc.sistemaventas.dominio.PlanNegocioDomain;
import edu.upc.sistemaventas.dominio.SabioDomain;
import edu.upc.sistemaventas.persistencia.*;
import java.util.List;

/**
 *
 * @author ricardocortijo
 */
public class SabioLogicaNegocio {

  public SabioDomain buscarSabio(int idSabio) {
    try {
      SabioDAO sabioDao = new MySqlSabioDAO();
      return sabioDao.getSabio(idSabio);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }
    
  /**
   * Registrar un nuevo Sabio.
   *
   * @param sabio El objeto Sabio llenado.
   *
   * @return El ID generado del registro.
   */
  public int registrarSabio(SabioDomain sabio) throws BusinessException, Exception {
    if (sabio == null) {
      throw new BusinessException("No se ha llenado los datos del sabio.");
    }
    SabioDAO sabioDao = new MySqlSabioDAO();
    SabioDomain sabioBuscado = sabioDao.getSabioByCorreo(sabio.getCorreo());
    if (sabioBuscado != null) {
      throw new BusinessException("El sabio registrado ya ha sido registrado con el mismo correo electrónico: [" + sabio.getCorreo() + "]");
    }
    sabioBuscado = sabioDao.getSabioByTipoNumDoc(sabio.getTipoDocumentoIdentidad(), sabio.getNumeroDocumentoIdentidad());
    if (sabioBuscado != null) {
      throw new BusinessException("El sabio registrado ya ha sido registrado con el mismo tipo/número de documento: [" + sabio.getTipoDocumentoIdentidad() + "-" + sabio.getNumeroDocumentoIdentidad() + "]");
    }
    int idSabio = sabioDao.registrarSabio(sabio);
    return idSabio;
  }

  /**
   * Obtener (monitorear) la lista de los Planes de Negocio por sabio.
   *
   * @param   idSabio ID del sabio.
   *
   * @return  Lista de los Planes de Negocio correspondientes al sabio.
   */
  public List<PlanNegocioDomain> obtenerPlanesNegocioPorSabio(int idSabio) {
    try {
      List<PlanNegocioDomain> listaPlanesNegocio = null;
      PlanNegocioDAO planNegocioDao = new MySqlPlanNegocioDAO();
      listaPlanesNegocio = planNegocioDao.obtenerPlanesNegocioPorSabio(idSabio);
      return listaPlanesNegocio;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }
  
  /**
   * Eliminar un sabio por Correo.
   *
   * @param idSabio ID del sabio.
   */
  public void eliminarSabioByCorreo(String correo) {
    try {
      SabioDAO sabioDao = new MySqlSabioDAO();
      sabioDao.eliminarSabioByCorreo(correo);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  
  /**
   * Eliminar un sabio por Tipo y Numero de Documento.
   *
   * @param idSabio ID del sabio.
   */
  public void eliminarSabioByTipoNumeroDoc(String tipoDocumento, String numeroDocumento) {
    try {
      SabioDAO sabioDao = new MySqlSabioDAO();
      sabioDao.eliminarSabioByTipoNumeroDoc(tipoDocumento, numeroDocumento);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  
}
