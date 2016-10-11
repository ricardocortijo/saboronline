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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ricardocortijo
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
  @NamedQuery(name = "Pedido.findById", query = "SELECT p FROM Pedido p WHERE p.id = :id"),
  @NamedQuery(name = "Pedido.findByFecha", query = "SELECT p FROM Pedido p WHERE p.fecha = :fecha"),
  @NamedQuery(name = "Pedido.findByUsuario", query = "SELECT p FROM Pedido p WHERE p.usuario = :usuario"),
  @NamedQuery(name = "Pedido.findByDireccionEntrega", query = "SELECT p FROM Pedido p WHERE p.direccionEntrega = :direccionEntrega"),
  @NamedQuery(name = "Pedido.findByFechaHoraLlegada", query = "SELECT p FROM Pedido p WHERE p.fechaHoraLlegada = :fechaHoraLlegada"),
  @NamedQuery(name = "Pedido.findByFechaHoraEstimada", query = "SELECT p FROM Pedido p WHERE p.fechaHoraEstimada = :fechaHoraEstimada"),
  @NamedQuery(name = "Pedido.findByDistrito", query = "SELECT p FROM Pedido p WHERE p.distrito = :distrito"),
  @NamedQuery(name = "Pedido.findByModoPago", query = "SELECT p FROM Pedido p WHERE p.modoPago = :modoPago")})
public class Pedido implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;
  @Column(name = "fecha")
  @Temporal(TemporalType.TIMESTAMP)
  private Date fecha;
  @Size(max = 45)
  @Column(name = "usuario")
  private String usuario;
  @Size(max = 1000)
  @Column(name = "direccion_entrega")
  private String direccionEntrega;
  @Column(name = "fecha_hora_llegada")
  @Temporal(TemporalType.TIMESTAMP)
  private Date fechaHoraLlegada;
  @Column(name = "fecha_hora_estimada")
  @Temporal(TemporalType.TIMESTAMP)
  private Date fechaHoraEstimada;
  @Size(max = 145)
  @Column(name = "distrito")
  private String distrito;
  @Size(max = 2)
  @Column(name = "modo_pago")
  private String modoPago;

  public Pedido() {
  }

  public Pedido(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getDireccionEntrega() {
    return direccionEntrega;
  }

  public void setDireccionEntrega(String direccionEntrega) {
    this.direccionEntrega = direccionEntrega;
  }

  public Date getFechaHoraLlegada() {
    return fechaHoraLlegada;
  }

  public void setFechaHoraLlegada(Date fechaHoraLlegada) {
    this.fechaHoraLlegada = fechaHoraLlegada;
  }

  public Date getFechaHoraEstimada() {
    return fechaHoraEstimada;
  }

  public void setFechaHoraEstimada(Date fechaHoraEstimada) {
    this.fechaHoraEstimada = fechaHoraEstimada;
  }

  public String getDistrito() {
    return distrito;
  }

  public void setDistrito(String distrito) {
    this.distrito = distrito;
  }

  public String getModoPago() {
    return modoPago;
  }

  public void setModoPago(String modoPago) {
    this.modoPago = modoPago;
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
    if (!(object instanceof Pedido)) {
      return false;
    }
    Pedido other = (Pedido) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "edu.upc.saboronline.entidades.Pedido[ id=" + id + " ]";
  }
  
}
