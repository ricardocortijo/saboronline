/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.saboronline.negocio;

import edu.upc.saboronline.entidades.Pedido;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ricardocortijo
 */
public class PedidoClienteNegocio extends BaseNegocio {

  public void registrar(Pedido pedido) {
    Client client = ClientBuilder.newClient();
    WebTarget wsPedido = client.target(BASE_URI).path("pedidoCliente");
    wsPedido.request(MediaType.APPLICATION_XML).post(Entity.entity(pedido, MediaType.APPLICATION_XML));
  }

}
