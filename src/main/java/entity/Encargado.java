package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "encargado")
public class Encargado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEncargado;

    @OneToOne
    @JoinColumn(name = "idProfesor", nullable = false, unique = true)
    private Profesor profesor;

    @OneToOne
    @JoinColumn(name = "idPlana", nullable = false, unique = true)
    private Plana plana;

    public Encargado() {
    }

    public Encargado(Integer idEncargado) {
        this.idEncargado = idEncargado;
    }

    public Integer getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(Integer idEncargado) {
        this.idEncargado = idEncargado;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Plana getPlana() {
        return plana;
    }

    public void setPlana(Plana plana) {
        this.plana = plana;
    }
}
