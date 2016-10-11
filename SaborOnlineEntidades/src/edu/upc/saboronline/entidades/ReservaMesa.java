/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.saboronline.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jtovar
 */
@Entity
@Table(name = "reserva_mesa")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "ReservaMesa.findAll", query = "SELECT r FROM ReservaMesa r"),
  @NamedQuery(name = "ReservaMesa.findById", query = "SELECT r FROM ReservaMesa r WHERE r.id = :id"),
  @NamedQuery(name = "ReservaMesa.findByFechaReserva", query = "SELECT r FROM ReservaMesa r WHERE r.fechaReserva = :fechaReserva"),
  @NamedQuery(name = "ReservaMesa.findByNumeroMesa", query = "SELECT r FROM ReservaMesa r WHERE r.numeroMesa = :numeroMesa"),
  @NamedQuery(name = "ReservaMesa.findByCodigoUsuario", query = "SELECT r FROM ReservaMesa r WHERE r.codigoUsuario = :codigoUsuario"),
  @NamedQuery(name = "ReservaMesa.findByNumeroSillas", query = "SELECT r FROM ReservaMesa r WHERE r.numeroSillas = :numeroSillas")})
public class ReservaMesa implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Column(name = "fecha_reserva")
  @Temporal(TemporalType.TIMESTAMP)
  private Date fechaReserva;
  @Column(name = "numero_mesa")
  private Integer numeroMesa;
  @Size(max = 45)
  @Column(name = "codigo_usuario")
  private String codigoUsuario;
  @Column(name = "numero_sillas")
  private Integer numeroSillas;
  @Lob
  @Size(max = 65535)
  @Column(name = "comentarios")
  private String comentarios;

  public ReservaMesa() {
  }

  public ReservaMesa(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getFechaReserva() {
    return fechaReserva;
  }

  public void setFechaReserva(Date fechaReserva) {
    this.fechaReserva = fechaReserva;
  }

  public Integer getNumeroMesa() {
    return numeroMesa;
  }

  public void setNumeroMesa(Integer numeroMesa) {
    this.numeroMesa = numeroMesa;
  }

  public String getCodigoUsuario() {
    return codigoUsuario;
  }

  public void setCodigoUsuario(String codigoUsuario) {
    this.codigoUsuario = codigoUsuario;
  }

  public Integer getNumeroSillas() {
    return numeroSillas;
  }

  public void setNumeroSillas(Integer numeroSillas) {
    this.numeroSillas = numeroSillas;
  }

  public String getComentarios() {
    return comentarios;
  }

  public void setComentarios(String comentarios) {
    this.comentarios = comentarios;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ReservaMesa)) {
      return false;
    }
    ReservaMesa other = (ReservaMesa) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "edu.upc.saboronline.entidades.ReservaMesa[ id=" + id + " ]";
  }
  
}
