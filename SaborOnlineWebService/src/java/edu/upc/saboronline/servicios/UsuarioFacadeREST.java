/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.saboronline.servicios;

import edu.upc.saboronline.entidades.Rol;
import edu.upc.saboronline.entidades.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author milan
 */
@Stateless
@Path("usuario")
public class UsuarioFacadeREST extends AbstractFacade<Usuario> {

  @PersistenceContext(unitName = "SaborOnlineDBPU")
  private EntityManager em;

  public UsuarioFacadeREST() {
    super(Usuario.class);
  }

  @GET
  @Path("buscar/{id}")
  @Produces({"application/xml", "application/json"})
  public Usuario buscar(@PathParam("id") Integer id) {
    return super.buscar(id);
  }

  @GET
  @Path("validarUsuarioClaveUser/{usuario}/{clave}")
  @Produces({"application/xml", "application/json"})
  public boolean validarUsuarioClaveUser(@PathParam("usuario") String usuario,
          @PathParam("clave") String clave) {
    TypedQuery<Usuario> qry = getEntityManager().createNamedQuery("Usuario.findByCodigoUsuario", Usuario.class);
    qry.setParameter("codigoUsuario", usuario);
    Usuario obj = qry.getSingleResult();
    if (!obj.getIdRol().getId().equals(Rol.ROL_SUPER_ADMIN) && !obj.getIdRol().getId().equals(Rol.ROL_ADMIN)) {
      if (clave != null && obj.getClave() != null) {
        return obj.getClave().equals(clave);
      }
    }
    return false;
  }

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

}
