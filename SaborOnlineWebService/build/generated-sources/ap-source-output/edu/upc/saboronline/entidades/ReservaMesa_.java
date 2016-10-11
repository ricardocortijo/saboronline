package edu.upc.saboronline.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-10T21:28:35")
@StaticMetamodel(ReservaMesa.class)
public class ReservaMesa_ { 

    public static volatile SingularAttribute<ReservaMesa, Integer> numeroSillas;
    public static volatile SingularAttribute<ReservaMesa, String> codigoUsuario;
    public static volatile SingularAttribute<ReservaMesa, Integer> numeroMesa;
    public static volatile SingularAttribute<ReservaMesa, Integer> id;
    public static volatile SingularAttribute<ReservaMesa, String> comentarios;
    public static volatile SingularAttribute<ReservaMesa, Date> fechaReserva;

}