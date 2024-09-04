package trabajojpa.Entidades;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "domicilio")
@RequiredArgsConstructor
@Data
@NoArgsConstructor
public class Domicilio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String nombreCalle;

    @Column(unique = false)
    @NonNull
    private int numero;
}
