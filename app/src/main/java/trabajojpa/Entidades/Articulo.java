package trabajojpa.Entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "articulo")
@Data
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cantidad;

    private String denominacion;

    private int precio;

    @OneToMany(mappedBy = "articulo", cascade = CascadeType.PERSIST)
    private Set<DetalleFactura> detalleFactura = new HashSet<DetalleFactura>();

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "articuloCategoria", joinColumns = @JoinColumn(name = "idArticulo"), inverseJoinColumns = @JoinColumn(name = "idColumna"))
    private Set<Categoria> categoria = new HashSet<>();

    public Articulo(int cantidad, String denominacion, int precio) {
        this.cantidad = cantidad;
        this.denominacion = denominacion;
        this.precio = precio;
    }
}
