package JPA_Ejemplo_1.entidades;

import JPA_Ejemplo_1.entidades.Direccion;
import JPA_Ejemplo_1.entidades.Mascota;
import JPA_Ejemplo_1.enums.Rol;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-07-05T16:29:47")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, String> apellido;
    public static volatile SingularAttribute<Persona, Direccion> direccion;
    public static volatile ListAttribute<Persona, Mascota> mascotas;
    public static volatile SingularAttribute<Persona, String> id;
    public static volatile SingularAttribute<Persona, String> nombre;
    public static volatile SingularAttribute<Persona, String> dni;
    public static volatile SingularAttribute<Persona, Rol> rol;
    public static volatile SingularAttribute<Persona, Date> nacimiento;

}