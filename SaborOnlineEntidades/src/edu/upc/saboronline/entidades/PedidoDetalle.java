/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.saboronline.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ricardocortijo
 */
@Entity
@Table(name = "pedido_detalle")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "PedidoDetalle.findAll", query = "SELECT p FROM PedidoDetalle p"),
  @NamedQuery(name = "PedidoDetalle.findByIdPedido", query = "SELECT p FROM PedidoDetalle p WHERE p.idPedido = :idPedido"),
  @NamedQuery(name = "PedidoDetalle.findByCorrelativo", query = "SELECT p FROM PedidoDetalle p WHERE p.correlativo = :correlativo"),
  @NamedQuery(name = "PedidoDetalle.findByIdMenuPlato", query = "SELECT p FROM PedidoDetalle p WHERE p.idMenuPlato = :idMenuPlato"),
  @NamedQuery(name = "PedidoDetalle.findByCantidadMenuPlato", query = "SELECT p FROM PedidoDetalle p WHERE p.cantidadMenuPlato = :cantidadMenuPlato"),
  @NamedQuery(name = "PedidoDetalle.findByTipoDetalle", query = "SELECT p FROM PedidoDetalle p WHERE p.tipoDetalle = :tipoDetalle")})
public class PedidoDetalle implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id_pedido")
  private Integer idPedido;
  @Size(max = 45)
  @Column(name = "correlativo")
  private String correlativo;
  @Column(name = "id_menu_plato")
  private Integer idMenuPlato;
  @Column(name = "cantidad_menu_plato")
  private Integer cantidadMenuPlato;
  @Size(max = 1)
  @Column(name = "tipo_detalle")
  private String tipoDetalle;

  public PedidoDetalle() {
  }

  public PedidoDetalle(Integer idPedido) {
    this.idPedido = idPedido;
  }

  public Integer getIdPedido() {
    return idPedido;
  }

  public void setIdPedido(Integer idPedido) {
    this.idPedido = idPedido;
  }

  public String getCorrelativo() {
    return correlativo;
  }

  public void setCorrelativo(String correlativo) {
    this.correlativo = correlativo;
  }

  public Integer getIdMenuPlato() {
    return idMenuPlato;
  }

  public void setIdMenuPlato(Integer idMenuPlato) {
    this.idMenuPlato = idMenuPlato;
  }

  public Integer getCantidadMenuPlato() {
    return cantidadMenuPlato;
  }

  public void setCantidadMenuPlato(Integer cantidadMenuPlato) {
    this.cantidadMenuPlato = cantidadMenuPlato;
  }

  public String getTipoDetalle() {
    return tipoDetalle;
  }

  public void setTipoDetalle(String tipoDetalle) {
    this.tipoDetalle = tipoDetalle;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idPedido != null ? idPedido.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof PedidoDetalle)) {
      return false;
    }
    PedidoDetalle other = (PedidoDetalle) object;
    if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "edu.upc.saboronline.entidades.PedidoDetalle[ idPedido=" + idPedido + " ]";
  }
  
}
