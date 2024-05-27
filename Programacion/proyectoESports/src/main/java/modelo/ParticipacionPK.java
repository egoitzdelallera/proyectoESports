package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

/**
 * Clase que representa la clave primaria compuesta de la entidad Participacion.
 */
public class ParticipacionPK implements Serializable {
    /**
     * Identificador del equipo.
     */
    @Column(name = "ID_EQUIPO", nullable = false, precision = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte idEquipo;
    /**
     * Identificador de la competición.
     */
    @Column(name = "ID_COMPETICION", nullable = false, precision = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte idCompeticion;

    /**
     * Retorna el identificador del equipo.
     * @return El identificador del equipo.
     */
    public byte getIdEquipo() {
        return idEquipo;
    }

    /**
     * Establece el identificador del equipo.
     * @param idEquipo El nuevo identificador del equipo.
     */
    public void setIdEquipo(byte idEquipo) {
        this.idEquipo = idEquipo;
    }

    /**
     * Retorna el identificador de la competición.
     * @return El identificador de la competición.
     */
    public byte getIdCompeticion() {
        return idCompeticion;
    }

    /**
     * Establece el identificador de la competición.
     * @param idCompeticion El nuevo identificador de la competición.
     */
    public void setIdCompeticion(byte idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParticipacionPK that = (ParticipacionPK) o;

        if (idEquipo != that.idEquipo) return false;
        if (idCompeticion != that.idCompeticion) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idEquipo;
        result = 31 * result + (int) idCompeticion;
        return result;
    }
}
