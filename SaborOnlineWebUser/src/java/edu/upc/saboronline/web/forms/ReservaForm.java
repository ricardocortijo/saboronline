/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.saboronline.web.forms;

import edu.upc.saboronline.entidades.ReservaMesa;

public class ReservaForm extends BaseForm {
  
  private ReservaMesa reserva;
  
  public ReservaForm() {
    reserva = new ReservaMesa();
  }

  /**
   * @return the reserva
   */
  public ReservaMesa getReserva() {
    return reserva;
  }

  /**
   * @param reserva the reserva to set
   */
  public void setReserva(ReservaMesa reserva) {
    this.reserva = reserva;
  }
  
}
