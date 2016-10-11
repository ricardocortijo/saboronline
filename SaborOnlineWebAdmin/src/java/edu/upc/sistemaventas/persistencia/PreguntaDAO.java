/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.persistencia;

import edu.upc.sistemaventas.dominio.PreguntaDomain;

/**
 *
 * @author ricardocortijo
 */
public interface PreguntaDAO {
  
  public int registrarPregunta(int idPlanNegocio, PreguntaDomain pregunta);

  public void actualizarRespuesta(int idPlanNegocio, int idPregunta, String respuesta);
  
}
