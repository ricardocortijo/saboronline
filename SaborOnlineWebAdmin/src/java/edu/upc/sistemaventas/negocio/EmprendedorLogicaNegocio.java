/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.negocio;

import edu.upc.sistemaventas.dominio.EmprendedorDomain;
import edu.upc.sistemaventas.persistencia.EmprendedorDAO;
import edu.upc.sistemaventas.persistencia.MySqlEmprendedorDAO;
import edu.upc.sistemaventas.utils.BusinessException;
import java.util.List;

/**
 *
 * @author ricardocortijo
 */
public class EmprendedorLogicaNegocio {

  public List<EmprendedorDomain> buscarListaEmprendedores(String nombresApellidos, String tipoDocumento, String numeroDocumento) {
    try {
      EmprendedorDAO emprendedorDao = new MySqlEmprendedorDAO();
      return emprendedorDao.buscarListaEmprendedores(nombresApellidos, tipoDocumento, numeroDocumento);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }
  
  public EmprendedorDomain buscarEmprendedor(int idEmprendedor) {
    try {
      EmprendedorDAO emprendedorDao = new MySqlEmprendedorDAO();
      return emprendedorDao.getEmprendedor(idEmprendedor);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  /**
   * Registrar un nuevo Emprendedor.
   *
   * @param emprendedor El objeto Emprendedor llenado.
   *
   * @return El ID generado del registro.
   */
  public int registrarEmprendedor(EmprendedorDomain emprendedor) throws BusinessException, Exception {
    if (emprendedor == null) {
      throw new BusinessException("No se ha llenado los datos del emprendedor.");
    }
    EmprendedorDAO emprendedorDao = new MySqlEmprendedorDAO();
    EmprendedorDomain emprendedorBuscado = emprendedorDao.getEmprendedorByCorreo(emprendedor.getCorreo());
    if (emprendedorBuscado != null) {
      throw new BusinessException("El emprendedor registrado ya ha sido registrado con el mismo correo electrónico: [" + emprendedor.getCorreo() + "]");
    }
    emprendedorBuscado = emprendedorDao.getEmprendedorByTipoNumDoc(emprendedor.getTipoDocumentoIdentidad(), emprendedor.getNumeroDocumentoIdentidad());
    if (emprendedorBuscado != null) {
      throw new BusinessException("El emprendedor registrado ya ha sido registrado con el mismo Tipo/N° de Documento: [" + emprendedor.getTipoNumeroDocumento() + "]");
    }
    int idEmprendedor = emprendedorDao.registrarEmprendedor(emprendedor);
    return idEmprendedor;
  }

  /**
   * Actualizar un emprendedor existente.
   *
   * @param emprendedor El objeto Emprendedor llenado.
   */
  public void actualizarEmprendedor(EmprendedorDomain emprendedor) {
    try {
      EmprendedorDAO emprendedorDao = new MySqlEmprendedorDAO();
      emprendedorDao.actualizarEmprendedor(emprendedor);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Eliminar un emprendedor por ID.
   *
   * @param idEmprendedor ID del emprendedor.
   */
  public void eliminarEmprendedor(int idEmprendedor) {
    try {
      EmprendedorDAO emprendedorDao = new MySqlEmprendedorDAO();
      emprendedorDao.eliminarEmprendedor(idEmprendedor);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  
  /**
   * Eliminar un emprendedor por Correo.
   *
   * @param idEmprendedor ID del emprendedor.
   */
  public void eliminarEmprendedorByCorreo(String correo) {
    try {
      EmprendedorDAO emprendedorDao = new MySqlEmprendedorDAO();
      emprendedorDao.eliminarEmprendedorByCorreo(correo);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  
  /**
   * Eliminar un emprendedor por Tipo y Numero de Documento.
   *
   * @param idEmprendedor ID del emprendedor.
   */
  public void eliminarEmprendedorByTipoNumeroDoc(String tipoDocumento, String numeroDocumento) {
    try {
      EmprendedorDAO emprendedorDao = new MySqlEmprendedorDAO();
      emprendedorDao.eliminarEmprendedorByTipoNumeroDoc(tipoDocumento, numeroDocumento);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  
}
