/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.persistencia;

import edu.upc.sistemaventas.dominio.DocumentoDomain;

/**
 *
 * @author ricardocortijo
 */
public interface DocumentoDAO {
  
  public DocumentoDomain getDocumento(int idDocumento);
  public int registrarDocumento(DocumentoDomain documento);
  
}
