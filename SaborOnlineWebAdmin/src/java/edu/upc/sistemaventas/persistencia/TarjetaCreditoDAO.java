/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.persistencia;

import edu.upc.sistemaventas.dominio.TarjetaCreditoDomain;

/**
 *
 * @author ricardocortijo
 */
public interface TarjetaCreditoDAO {

  public TarjetaCreditoDomain getTarjetaCredito(int idTarjetaCredito);
  public TarjetaCreditoDomain getTarjetaCreditoByNumero(String numeroTarjetaCredito);

  public int registrarTarjetaCredito(TarjetaCreditoDomain tarjeta);
  public void actualizarTarjetaCredito(TarjetaCreditoDomain tarjeta);
  public void eliminarTarjetaCredito(int idTarjetaCredito);
  
}
