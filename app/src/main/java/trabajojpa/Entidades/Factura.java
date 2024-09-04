package trabajojpa.Entidades;

import java.util.Set;
import java.util.HashSet;
import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "factura")
@Data
@NoArgsConstructor

public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fecha;

    @Column(unique = false)
    private int numero;

    @Column(unique = false)
    private int total;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cliente cliFactura;

    private Set<DetalleFactura> detalleFactura = new HashSet<>();

}
