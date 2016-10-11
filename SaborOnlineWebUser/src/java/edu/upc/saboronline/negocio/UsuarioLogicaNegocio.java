/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.saboronline.negocio;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author ricardocortijo
 */
public class UsuarioLogicaNegocio extends BaseNegocio {
  
  public boolean validarUsuario(String codigoUsuario, String clave) {
    Client client = ClientBuilder.newClient();
    WebTarget wsUsuario = client.target(BASE_URI).path("usuario");
    Boolean resultado = wsUsuario.path(java.text.MessageFormat.format("validarUsuarioClaveUser/{0}/{1}", new Object[]{ codigoUsuario, clave }))
                                 .request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
                                 .get(Boolean.class);
                                 //.post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.TEXT_PLAIN), String.class);
    return resultado.booleanValue();
  }

}
