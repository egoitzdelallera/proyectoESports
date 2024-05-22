package modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "PARTICIPACIONES", schema = "EQDAW02", catalog = "")
@IdClass(ParticipacionPK.class)
public class Participacion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_EQUIPO", nullable = false, precision = 0)
    private int idEquipo;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_COMPETICION", nullable = false, precision = 0)
    private int idCompeticion;
    @Basic
    @Column(name = "PUNTUACION", nullable = true, precision = 0)
    private Byte puntuacion;
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID_EQUIPO", nullable = false, insertable = false, updatable = false)
    private Equipo equiposByIdEquipo;
    @ManyToOne
    @JoinColumn(name = "ID_COMPETICION", referencedColumnName = "ID_COMPETICION", nullable = false, insertable = false, updatable = false)
    private Competicion competicionesByIdCompeticion;

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(byte idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(int idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    public Byte getPuntuacion() {
        return puntuacion;
    }

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

    public Equipo getEquiposByIdEquipo() {
        return equiposByIdEquipo;
    }

    public void setEquiposByIdEquipo(Equipo equiposByIdEquipo) {
        this.equiposByIdEquipo = equiposByIdEquipo;
    }

    public Competicion getCompeticionesByIdCompeticion() {
        return competicionesByIdCompeticion;
    }

    public void setCompeticionesByIdCompeticion(Competicion competicionesByIdCompeticion) {
        this.competicionesByIdCompeticion = competicionesByIdCompeticion;
    }
}
