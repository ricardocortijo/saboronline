/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.saboronline.web.forms;

import edu.upc.saboronline.entidades.Pedido;

public class PedidoForm extends BaseForm {
  
  private Pedido pedido;
  
  public PedidoForm() {
    pedido = new Pedido();
  }

  /**
   * @return the pedido
   */
  public Pedido getPedido() {
    return pedido;
  }

  /**
   * @param pedido the pedido to set
   */
  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }
  
}
