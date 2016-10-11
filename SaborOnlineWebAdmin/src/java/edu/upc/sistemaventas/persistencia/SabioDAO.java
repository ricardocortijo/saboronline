/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.persistencia;

import edu.upc.sistemaventas.dominio.SabioDomain;
import edu.upc.sistemaventas.dominio.SabioDomain;

/**
 *
 * @author ricardocortijo
 */
public interface SabioDAO {
  
  public SabioDomain getSabio(int idSabio);
  public SabioDomain getSabioByCorreo(String correo);
  public SabioDomain getSabioByTipoNumDoc(String tipoDocumento, String numeroDocumento);

  public int registrarSabio(SabioDomain sabio);
  public void actualizarSabio(SabioDomain sabio);
  public void eliminarSabio(int idSabio);
  public void eliminarSabioByCorreo(String correo);
  public void eliminarSabioByTipoNumeroDoc(String tipoDocumento, String numeroDocumento);
  
}
