/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.saboronline.servicios;

import edu.upc.saboronline.entidades.ReservaMesa;
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
@Path("reservaMesa")
public class ReservaMesaFacadeREST extends AbstractFacade<ReservaMesa> {

  @PersistenceContext(unitName = "SaborOnlineDBPU")
  private EntityManager em;

  public ReservaMesaFacadeREST() {
    super(ReservaMesa.class);
  }

  @POST
  @Override
  @Consumes({"application/xml", "application/json"})
  public void registrar(ReservaMesa reserva) {
    super.registrar(reserva);
  }

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

}
