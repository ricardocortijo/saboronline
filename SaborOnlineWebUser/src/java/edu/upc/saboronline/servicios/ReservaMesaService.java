/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.saboronline.servicios;

import edu.upc.saboronline.entidades.ReservaMesa;
import edu.upc.saboronline.negocio.ReservaMesaNegocio;

public class ReservaMesaService {
  
  private ReservaMesaNegocio reservaMesaNegocio = new ReservaMesaNegocio();
  
  public void registrar(ReservaMesa reserva) {
    reservaMesaNegocio.registrar(reserva);
  }
  
}
