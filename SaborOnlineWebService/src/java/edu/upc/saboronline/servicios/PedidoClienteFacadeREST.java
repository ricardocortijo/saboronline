/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.saboronline.servicios;

import edu.upc.saboronline.entidades.Pedido;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author ricardocortijo
 */
@Stateless
@Path("pedidoCliente")
public class PedidoClienteFacadeREST extends AbstractFacade<Pedido> {

  @PersistenceContext(unitName = "SaborOnlineDBPU")
  private EntityManager em;

  public PedidoClienteFacadeREST() {
    super(Pedido.class);
  }

  @POST
  @Override
  @Consumes({"application/xml", "application/json"})
  public void registrar(Pedido pedido) {
    super.registrar(pedido);
  }

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

}
