package modelo;

import jakarta.persistence.*;

import java.sql.Timestamp;


/**
 * Clase que representa un enfrentamiento entre dos equipos en una jornada.
 */
@Entity
@Table(name = "ENFRENTAMIENTOS", schema = "EQDAW02", catalog = "")
public class Enfrentamiento {
    /**
     * Identificador único del enfrentamiento.
     */
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
    @SequenceGenerator(name = "seq_gen", sequenceName = "enfrentamientos_seq", allocationSize = 1)
    @Id
    @Column(name = "ID_ENFRENTAMIENTO", nullable = false, precision = 0)
    private int idEnfrentamiento;
    /**
     * Hora programada para el enfrentamiento.
     */
    @Basic
    @Column(name = "HORA", nullable = true)
    private Timestamp hora;

    /**
     * Jornada a la que pertenece el enfrentamiento.
     */
    @ManyToOne
    @JoinColumn(name = "ID_JORNADA", referencedColumnName = "ID_JORNADA")
    private Jornada jornadasByIdJornada;
    /**
     * Equipo local que participa en el enfrentamiento.
     */
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO_LOCAL", referencedColumnName = "ID_EQUIPO")
    private Equipo equiposByIdEquipoLocal;
    /**
     * Equipo visitante que participa en el enfrentamiento.
     */
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO_VISITANTE", referencedColumnName = "ID_EQUIPO")
    private Equipo equiposByIdEquipoVisitante;
    /**
     * Equipo ganador del enfrentamiento.
     */
    @ManyToOne
    @JoinColumn(name = "ID_GANADOR", referencedColumnName = "ID_EQUIPO")
    private Equipo equiposByIdGanador;

    /**
     * Obtiene el identificador único del enfrentamiento.
     * @return Identificador único del enfrentamiento.
     */
    public int getIdEnfrentamiento() {
        return idEnfrentamiento;
    }

    /**
     * Establece el identificador único del enfrentamiento.
     * @param idEnfrentamiento Identificador único del enfrentamiento.
     */
    public void setIdEnfrentamiento(byte idEnfrentamiento) {
        this.idEnfrentamiento = idEnfrentamiento;
    }

    /**
     * Obtiene la hora programada para el enfrentamiento.
     * @return Hora programada para el enfrentamiento.
     */
    public Timestamp getHora() {
        return hora;
    }

    /**
     * Establece la hora programada para el enfrentamiento.
     * @param hora Hora programada para el enfrentamiento.
     */
    public void setHora(Timestamp hora) {
        this.hora = hora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enfrentamiento that = (Enfrentamiento) o;

        if (idEnfrentamiento != that.idEnfrentamiento) return false;
        if (hora != null ? !hora.equals(that.hora) : that.hora != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idEnfrentamiento;
        result = 31 * result + (hora != null ? hora.hashCode() : 0);
        return result;
    }

    /**
     * Obtiene la jornada a la que pertenece el enfrentamiento.
     * @return La jornada a la que pertenece el enfrentamiento.
     */
    public Jornada getJornadasByIdJornada() {
        return jornadasByIdJornada;
    }

    /**
     * Establece la jornada a la que pertenece el enfrentamiento.
     * @param jornadasByIdJornada La jornada a establecer.
     */
    public void setJornadasByIdJornada(Jornada jornadasByIdJornada) {
        this.jornadasByIdJornada = jornadasByIdJornada;
    }

    /**
     * Obtiene el equipo local que participa en el enfrentamiento.
     * @return El equipo local que participa en el enfrentamiento.
     */
    public Equipo getEquiposByIdEquipoLocal() {
        return equiposByIdEquipoLocal;
    }

    /**
     * Establece el equipo local que participa en el enfrentamiento.
     * @param equiposByIdEquipoLocal El equipo local a establecer.
     */
    public void setEquiposByIdEquipoLocal(Equipo equiposByIdEquipoLocal) {
        this.equiposByIdEquipoLocal = equiposByIdEquipoLocal;
    }

    /**
     * Obtiene el equipo visitante que participa en el enfrentamiento.
     * @return El equipo visitante que participa en el enfrentamiento.
     */
    public Equipo getEquiposByIdEquipoVisitante() {
        return equiposByIdEquipoVisitante;
    }

    /**
     * Establece el equipo visitante que participa en el enfrentamiento.
     * @param equiposByIdEquipoVisitante El equipo visitante a establecer.
     */
    public void setEquiposByIdEquipoVisitante(Equipo equiposByIdEquipoVisitante) {
        this.equiposByIdEquipoVisitante = equiposByIdEquipoVisitante;
    }

    /**
     * Obtiene el equipo ganador del enfrentamiento.
     * @return El equipo ganador del enfrentamiento.
     */
    public Equipo getEquiposByIdGanador() {
        return equiposByIdGanador;
    }

    /**
     * Establece el equipo ganador del enfrentamiento.
     * @param equiposByIdGanador El equipo ganador a establecer.
     */
    public void setEquiposByIdGanador(Equipo equiposByIdGanador) {
        this.equiposByIdGanador = equiposByIdGanador;
    }
}
