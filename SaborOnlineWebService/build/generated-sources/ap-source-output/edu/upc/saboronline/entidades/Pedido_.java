package edu.upc.saboronline.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-10T20:41:03")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, Date> fecha;
    public static volatile SingularAttribute<Pedido, Date> fechaHoraLlegada;
    public static volatile SingularAttribute<Pedido, String> distrito;
    public static volatile SingularAttribute<Pedido, String> direccionEntrega;
    public static volatile SingularAttribute<Pedido, Date> fechaHoraEstimada;
    public static volatile SingularAttribute<Pedido, String> usuario;
    public static volatile SingularAttribute<Pedido, Integer> id;
    public static volatile SingularAttribute<Pedido, String> modoPago;

}