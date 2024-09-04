package trabajojpa.Entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "articulo")
@Data
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private int cantidad;

    private String denominacion;

    private int precio;

    public Articulo(int cantidad, String denominacion, int precio) {
        this.cantidad = cantidad;
        this.denominacion = denominacion;
        this.precio = precio;
    }
}
