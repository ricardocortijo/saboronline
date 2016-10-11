/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.saboronline.servicios;

import edu.upc.saboronline.entidades.Pedido;
import edu.upc.saboronline.negocio.PedidoClienteNegocio;

public class PedidoClienteService {
  
  private PedidoClienteNegocio pedidoClienteNegocio = new PedidoClienteNegocio();
  
  public void registrar(Pedido pedido) {
    pedidoClienteNegocio.registrar(pedido);
  }
  
}
