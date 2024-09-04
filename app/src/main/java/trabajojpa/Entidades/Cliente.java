package trabajojpa.Entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "cliente")
@Data
@RequiredArgsConstructor
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCliente;

    private String apellidoCliente;

    @Column(unique = false)
    private int dni;

    public Cliente(String nombreCliente, String apellidoCliente, int dni) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.dni = dni;
    }

}
