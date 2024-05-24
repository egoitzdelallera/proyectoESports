package modelo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

/**
 * Clase que representa una jornada de competición en el sistema.
 */
@Entity
@Table(name = "JORNADAS", schema = "EQDAW02", catalog = "")
public class Jornada {
    /**
     * Identificador único de la jornada.
     */
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
    @SequenceGenerator(name = "seq_gen", sequenceName = "jornadas_seq", allocationSize = 1)    @Id
    @Column(name = "ID_JORNADA", nullable = false, precision = 0)
    private int idJornada;
    /**
     * Número de la jornada.
     */
    @Basic
    @Column(name = "N_JORNADA", nullable = true, precision = 0)
    private Byte nJornada;
    /**
     * Fecha de la jornada.
     */
    @Basic
    @Column(name = "FECHA_JORNADA", nullable = true)
    private Date fechaJornada;
    /**
     * Colección de enfrentamientos asociados a esta jornada.
     */
    @OneToMany(mappedBy = "jornadasByIdJornada")
    private Collection<Enfrentamiento> enfrentamientosByIdJornada;
    /**
     * Competición a la que pertenece esta jornada.
     */
    @ManyToOne
    @JoinColumn(name = "ID_COMPETICION", referencedColumnName = "ID_COMPETICION")
    private Competicion competicionesByIdCompeticion;

    /**
     * Retorna el identificador único de la jornada.
     * @return El identificador único de la jornada.
     */
    public int getIdJornada() {
        return idJornada;
    }


    /**
     * Establece el identificador único de la jornada.
     * @param idJornada El nuevo identificador único de la jornada.
     */
    public void setIdJornada(byte idJornada) {
        this.idJornada = idJornada;
    }

    /**
     * Retorna el número de la jornada.
     * @return El número de la jornada.
     */
    public Byte getnJornada() {
        return nJornada;
    }

    /**
     * Establece el número de la jornada.
     * @param nJornada El nuevo número de la jornada.
     */
    public void setnJornada(Byte nJornada) {
        this.nJornada = nJornada;
    }

    /**
     * Retorna la fecha de la jornada.
     * @return La fecha de la jornada.
     */
    public Date getFechaJornada() {
        return fechaJornada;
    }

    /**
     * Establece la fecha de la jornada.
     * @param fechaJornada La nueva fecha de la jornada.
     */
    public void setFechaJornada(Date fechaJornada) {
        this.fechaJornada = fechaJornada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jornada jornada = (Jornada) o;

        if (idJornada != jornada.idJornada) return false;
        if (nJornada != null ? !nJornada.equals(jornada.nJornada) : jornada.nJornada != null) return false;
        if (fechaJornada != null ? !fechaJornada.equals(jornada.fechaJornada) : jornada.fechaJornada != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idJornada;
        result = 31 * result + (nJornada != null ? nJornada.hashCode() : 0);
        result = 31 * result + (fechaJornada != null ? fechaJornada.hashCode() : 0);
        return result;
    }

    /**
     * Retorna la colección de enfrentamientos asociados a esta jornada.
     * @return La colección de enfrentamientos asociados a esta jornada.
     */
    public Collection<Enfrentamiento> getEnfrentamientosByIdJornada() {
        return enfrentamientosByIdJornada;
    }

    /**
     * Establece la colección de enfrentamientos asociados a esta jornada.
     * @param enfrentamientosByIdJornada La nueva colección de enfrentamientos asociados a esta jornada.
     */
    public void setEnfrentamientosByIdJornada(Collection<Enfrentamiento> enfrentamientosByIdJornada) {
        this.enfrentamientosByIdJornada = enfrentamientosByIdJornada;
    }

    /**
     * Retorna la competición a la que pertenece esta jornada.
     * @return La competición a la que pertenece esta jornada.
     */
    public Competicion getCompeticionesByIdCompeticion() {
        return competicionesByIdCompeticion;
    }

    /**
     * Establece la competición a la que pertenece esta jornada.
     * @param competicionesByIdCompeticion La nueva competición a la que pertenece esta jornada.
     */
    public void setCompeticionesByIdCompeticion(Competicion competicionesByIdCompeticion) {
        this.competicionesByIdCompeticion = competicionesByIdCompeticion;
    }
}
