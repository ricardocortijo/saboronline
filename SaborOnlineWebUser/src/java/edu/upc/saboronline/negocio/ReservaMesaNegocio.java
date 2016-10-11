/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.saboronline.negocio;

import edu.upc.saboronline.entidades.ReservaMesa;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ricardocortijo
 */
public class ReservaMesaNegocio extends BaseNegocio {

  public void registrar(ReservaMesa reserva) {
    Client client = ClientBuilder.newClient();
    WebTarget wsReserva = client.target(BASE_URI).path("reservaMesa");
    wsReserva.request(MediaType.APPLICATION_XML).post(Entity.entity(reserva, MediaType.APPLICATION_XML));
  }

}
