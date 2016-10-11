package edu.upc.saboronline.entidades;

import edu.upc.saboronline.entidades.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-10T21:28:35")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> apellidos;
    public static volatile SingularAttribute<Usuario, String> clave;
    public static volatile SingularAttribute<Usuario, Rol> idRol;
    public static volatile SingularAttribute<Usuario, String> codigoUsuario;
    public static volatile SingularAttribute<Usuario, Integer> id;
    public static volatile SingularAttribute<Usuario, String> correoElectronico;
    public static volatile SingularAttribute<Usuario, String> nombres;

}