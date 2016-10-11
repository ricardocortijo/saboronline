/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.sistemaventas.dominio;

/**
 *
 * @author ricardocortijo
 */
public class PreguntaDomain {

  private PlanNegocioDomain planNegocio;

  private int id;
  private String titulo;
  private String descripcion;
  private String estadoPregunta;
  private String respuesta;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getEstadoPregunta() {
    return estadoPregunta;
  }

  public void setEstadoPregunta(String estadoPregunta) {
    this.estadoPregunta = estadoPregunta;
  }

  public PlanNegocioDomain getPlanNegocio() {
    return planNegocio;
  }

  public void setPlanNegocio(PlanNegocioDomain planNegocio) {
    this.planNegocio = planNegocio;
  }

  public String getRespuesta() {
    return respuesta;
  }

  public void setRespuesta(String respuesta) {
    this.respuesta = respuesta;
  }
  
}
