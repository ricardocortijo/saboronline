/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.servicios;

import edu.upc.sistemaventas.dominio.EmprendedorDomain;
import edu.upc.sistemaventas.negocio.EmprendedorLogicaNegocio;
import edu.upc.sistemaventas.utils.BusinessException;
import java.util.List;

public class EmprendedorService {
  
  private static EmprendedorLogicaNegocio emprendedorLogicaNegocio = new EmprendedorLogicaNegocio();
  
  public List<EmprendedorDomain> buscarListaEmprendedores(String nombresApellidos, String tipoDocumento, String numeroDocumento) {
    return emprendedorLogicaNegocio.buscarListaEmprendedores(nombresApellidos, tipoDocumento, numeroDocumento);
  }
  
  public EmprendedorDomain buscarEmprendedor(int idEmprendedor) {
    return emprendedorLogicaNegocio.buscarEmprendedor(idEmprendedor);
  }
  
  public void eliminarEmprendedor(int idEmprendedor) {
    emprendedorLogicaNegocio.eliminarEmprendedor(idEmprendedor);
  }
  
  public int registrarEmprendedor(EmprendedorDomain emprendedor) throws BusinessException, Exception {
    return emprendedorLogicaNegocio.registrarEmprendedor(emprendedor);
  }
  
  public void actualizarEmprendedor(EmprendedorDomain emprendedor) throws BusinessException, Exception {
    emprendedorLogicaNegocio.actualizarEmprendedor(emprendedor);
  }
  
}
