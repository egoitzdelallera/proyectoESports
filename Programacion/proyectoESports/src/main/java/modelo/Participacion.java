package modelo;

import jakarta.persistence.*;

/**
 * Representa la participación de un equipo en una competición.
 */
@Entity
@Table(name = "PARTICIPACIONES", schema = "EQDAW02", catalog = "")
@IdClass(ParticipacionPK.class)
public class Participacion {
    /**
     * Identificador del equipo.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_EQUIPO", nullable = false, precision = 0)
    private int idEquipo;
    /**
     * Identificador de la competición.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_COMPETICION", nullable = false, precision = 0)
    private int idCompeticion;
    /**
     * Puntuación obtenida por el equipo en la competición.
     */
    @Basic
    @Column(name = "PUNTUACION", nullable = true, precision = 0)
    private Byte puntuacion;
    /**
     * Equipo asociado a la participación.
     */
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID_EQUIPO", nullable = false, insertable = false, updatable = false)
    private Equipo equiposByIdEquipo;
    /**
     * Competición asociada a la participación.
     */
    @ManyToOne
    @JoinColumn(name = "ID_COMPETICION", referencedColumnName = "ID_COMPETICION", nullable = false, insertable = false, updatable = false)
    private Competicion competicionesByIdCompeticion;

    /**
     * Retorna el identificador del equipo.
     * @return El identificador del equipo.
     */
    public int getIdEquipo() {
        return idEquipo;
    }

    /**
     * Establece el identificador del equipo.
     * @param idEquipo El nuevo identificador del equipo.
     */
    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    /**
     * Retorna el identificador de la competición.
     * @return El identificador de la competición.
     */
    public int getIdCompeticion() {
        return idCompeticion;
    }

    /**
     * Establece el identificador de la competición.
     * @param idCompeticion El nuevo identificador de la competición.
     */
    public void setIdCompeticion(int idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    /**
     * Retorna la puntuación obtenida por el equipo en la competición.
     * @return La puntuación obtenida por el equipo.
     */
    public Byte getPuntuacion() {
        return puntuacion;
    }

    /**
     * Establece la puntuación obtenida por el equipo en la competición.
     * @param puntuacion La nueva puntuación obtenida por el equipo.
     */
    public void setPuntuacion(Byte puntuacion) {
        this.puntuacion = puntuacion;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Participacion that = (Participacion) o;

        if (idEquipo != that.idEquipo) return false;
        if (idCompeticion != that.idCompeticion) return false;
        if (puntuacion != null ? !puntuacion.equals(that.puntuacion) : that.puntuacion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idEquipo;
        result = 31 * result + (int) idCompeticion;
        result = 31 * result + (puntuacion != null ? puntuacion.hashCode() : 0);
        return result;
    }


    /**
     * Retorna el equipo asociado a la participación.
     * @return El equipo asociado a la participación.
     */
    public Equipo getEquiposByIdEquipo() {
        return equiposByIdEquipo;
    }

    /**
     * Establece el equipo asociado a la participación.
     * @param equiposByIdEquipo El nuevo equipo asociado a la participación.
     */
    public void setEquiposByIdEquipo(Equipo equiposByIdEquipo) {
        this.equiposByIdEquipo = equiposByIdEquipo;
    }

    /**
     * Retorna la competición asociada a la participación.
     * @return La competición asociada a la participación.
     */
    public Competicion getCompeticionesByIdCompeticion() {
        return competicionesByIdCompeticion;
    }

    /**
     * Establece la competición asociada a la participación.
     * @param competicionesByIdCompeticion La nueva competición asociada a la participación.
     */
    public void setCompeticionesByIdCompeticion(Competicion competicionesByIdCompeticion) {
        this.competicionesByIdCompeticion = competicionesByIdCompeticion;
    }
}
