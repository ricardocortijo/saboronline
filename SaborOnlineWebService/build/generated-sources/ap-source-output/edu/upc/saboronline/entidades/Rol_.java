package edu.upc.saboronline.entidades;

import edu.upc.saboronline.entidades.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-10T21:28:35")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile SingularAttribute<Rol, Integer> id;
    public static volatile CollectionAttribute<Rol, Usuario> usuarioCollection;
    public static volatile SingularAttribute<Rol, String> nombre;

}