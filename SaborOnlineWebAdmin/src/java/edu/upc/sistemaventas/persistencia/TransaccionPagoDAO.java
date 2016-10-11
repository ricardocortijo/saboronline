/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.persistencia;

import edu.upc.sistemaventas.dominio.*;

/**
 *
 * @author ricardocortijo
 */
public interface TransaccionPagoDAO {
  
  public boolean registrarTransaccionPago(TransaccionPagoDomain transaccion);
  
}
