/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upc.sistemaventas.dominio;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author ricardocortijo
 */
public class PlanNegocioDomain {

  private int id;
  private String titulo;
  private String visionNegocio;
  private String razonamientosPropuesta;
  private float tiempoEjecucion;
  private BigDecimal inversionTotal;
  private BigDecimal margenNeto;
  private BigDecimal roi;
  private String flagViable;
  private String estadoPlanNegocio;
  private String mensajeFinal;

  private SabioDomain sabio;
  private CategoriaDomain categoria;
  private DocumentoDomain documento;
  private List<PreguntaDomain> listaPreguntas;

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

  public String getVisionNegocio() {
    return visionNegocio;
  }

  public void setVisionNegocio(String visionNegocio) {
    this.visionNegocio = visionNegocio;
  }

  public BigDecimal getInversionTotal() {
    return inversionTotal;
  }

  public void setInversionTotal(BigDecimal inversionTotal) {
    this.inversionTotal = inversionTotal;
  }

  public BigDecimal getMargenNeto() {
    return margenNeto;
  }

  public void setMargenNeto(BigDecimal margenNeto) {
    this.margenNeto = margenNeto;
  }

  public String getRazonamientosPropuesta() {
    return razonamientosPropuesta;
  }

  public void setRazonamientosPropuesta(String razonamientosPropuesta) {
    this.razonamientosPropuesta = razonamientosPropuesta;
  }

  public BigDecimal getRoi() {
    return roi;
  }

  public void setRoi(BigDecimal roi) {
    this.roi = roi;
  }

  public String getFlagViable() {
    return flagViable;
  }

  public void setFlagViable(String flagViable) {
    this.flagViable = flagViable;
  }

  public String getEstadoPlanNegocio() {
    return estadoPlanNegocio;
  }

  public void setEstadoPlanNegocio(String estadoPlanNegocio) {
    this.estadoPlanNegocio = estadoPlanNegocio;
  }

  public String getMensajeFinal() {
    return mensajeFinal;
  }

  public void setMensajeFinal(String mensajeFinal) {
    this.mensajeFinal = mensajeFinal;
  }

  public float getTiempoEjecucion() {
    return tiempoEjecucion;
  }

  public void setTiempoEjecucion(float tiempoEjecucion) {
    this.tiempoEjecucion = tiempoEjecucion;
  }

  public CategoriaDomain getCategoria() {
    return categoria;
  }

  public void setCategoria(CategoriaDomain categoria) {
    this.categoria = categoria;
  }

  public DocumentoDomain getDocumento() {
    return documento;
  }

  public void setDocumento(DocumentoDomain documento) {
    this.documento = documento;
  }

  public List<PreguntaDomain> getListaPreguntas() {
    return listaPreguntas;
  }

  public void setListaPreguntas(List<PreguntaDomain> listaPreguntas) {
    this.listaPreguntas = listaPreguntas;
  }

  public SabioDomain getSabio() {
    return sabio;
  }

  public void setSabio(SabioDomain sabio) {
    this.sabio = sabio;
  }

}
