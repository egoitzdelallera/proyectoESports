package modelo;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * La clase Patrocinio representa la entidad de patrocinio en la base de datos.
 * Está mapeada a la tabla "PATROCINIOS" en el esquema "EQDAW02".
 */
@Entity
@Table(name = "PATROCINIOS", schema = "EQDAW02", catalog = "")
public class Patrocinio {

    /**
     * Identificador del patrocinador.
     * Mapeado a la columna "ID_PATROCINADOR" en la base de datos.
     */
    @Id
    @Column(name = "ID_PATROCINADOR", nullable = true, precision = 0)
    private int idPatrocinador;

    /**
     * Identificador del equipo.
     * Mapeado a la columna "ID_EQUIPO" en la base de datos.
     */
    @Basic
    @Column(name = "ID_EQUIPO", nullable = true, precision = 0)
    private int idEquipo;

    /**
     * Relación muchos a uno con la entidad Patrocinador.
     * Se une a la columna "ID_PATROCINADOR" en la tabla Patrocinador.
     */
    @ManyToOne
    @JoinColumn(name = "ID_PATROCINADOR", referencedColumnName = "ID_PATROCINADOR", insertable = false, updatable = false)
    private Patrocinador patrocinadoresByIdPatrocinador;

    /**
     * Relación muchos a uno con la entidad Equipo.
     * Se une a la columna "ID_EQUIPO" en la tabla Equipo.
     */
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID_EQUIPO", insertable = false, updatable = false)
    private Equipo equiposByIdEquipo;

    /**
     * Obtiene el identificador del patrocinador.
     * @return el identificador del patrocinador.
     */
    public int getIdPatrocinador() {
        return idPatrocinador;
    }


    /**
     * Establece el identificador del patrocinador.
     * @param idPatrocinador el identificador del patrocinador a establecer.
     */
    public void setIdPatrocinador(int idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    /**
     * Obtiene el identificador del equipo.
     * @return el identificador del equipo.
     */
    public int getIdEquipo() {
        return idEquipo;
    }

    /**
     * Establece el identificador del equipo.
     * @param idEquipo el identificador del equipo a establecer.
     */
    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patrocinio that = (Patrocinio) o;

        if (idPatrocinador != null ? !idPatrocinador.equals(that.idPatrocinador) : that.idPatrocinador != null)
            return false;
        if (idEquipo != null ? !idEquipo.equals(that.idEquipo) : that.idEquipo != null) return false;

        return true;
    }*/

    /**
     * Compara este patrocinio con otro objeto para determinar si son iguales.
     * @param o el objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patrocinio that = (Patrocinio) o;
        return idPatrocinador == that.idPatrocinador && idEquipo == that.idEquipo && Objects.equals(patrocinadoresByIdPatrocinador, that.patrocinadoresByIdPatrocinador) && Objects.equals(equiposByIdEquipo, that.equiposByIdEquipo);
    }

    /**
     * Calcula el código hash para este patrocinio.
     * @return el código hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idPatrocinador, idEquipo, patrocinadoresByIdPatrocinador, equiposByIdEquipo);
    }
    /*
    @Override
    public int hashCode() {
        int result = idPatrocinador != null ? idPatrocinador.hashCode() : 0;
        result = 31 * result + (idEquipo != null ? idEquipo.hashCode() : 0);
        return result;
    }*/

    /**
     * Obtiene el patrocinador asociado a este patrocinio.
     * @return el patrocinador asociado.
     */
    public Patrocinador getPatrocinadoresByIdPatrocinador() {
        return patrocinadoresByIdPatrocinador;
    }

    /**
     * Establece el patrocinador asociado a este patrocinio.
     * @param patrocinadoresByIdPatrocinador el patrocinador a establecer.
     */
    public void setPatrocinadoresByIdPatrocinador(Patrocinador patrocinadoresByIdPatrocinador) {
        this.patrocinadoresByIdPatrocinador = patrocinadoresByIdPatrocinador;
    }

    /**
     * Obtiene el equipo asociado a este patrocinio.
     * @return el equipo asociado.
     */
    public Equipo getEquiposByIdEquipo() {
        return equiposByIdEquipo;
    }

    /**
     * Establece el equipo asociado a este patrocinio.
     * @param equiposByIdEquipo el equipo a establecer.
     */
    public void setEquiposByIdEquipo(Equipo equiposByIdEquipo) {
        this.equiposByIdEquipo = equiposByIdEquipo;
    }
}
