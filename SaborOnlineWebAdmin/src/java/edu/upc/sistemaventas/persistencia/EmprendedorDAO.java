/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.persistencia;

import edu.upc.sistemaventas.dominio.EmprendedorDomain;
import java.util.List;

/**
 *
 * @author ricardocortijo
 */
public interface EmprendedorDAO {

  public List<EmprendedorDomain> buscarListaEmprendedores(String nombresApellidos, String tipoDocumento, String numeroDocumento);
  
  public EmprendedorDomain getEmprendedor(int idEmprendedor);
  public EmprendedorDomain getEmprendedorByCorreo(String correo);
  public EmprendedorDomain getEmprendedorByTipoNumDoc(String tipoDocumento, String numeroDocumento);

  public int registrarEmprendedor(EmprendedorDomain emprendedor);
  public void actualizarEmprendedor(EmprendedorDomain emprendedor);
  public void eliminarEmprendedor(int idEmprendedor);
  public void eliminarEmprendedorByCorreo(String correo);
  public void eliminarEmprendedorByTipoNumeroDoc(String tipoDocumento, String numeroDocumento);
  
}
