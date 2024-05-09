package modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "PARTICIPACIONES", schema = "EQDAW02", catalog = "")
@IdClass(modelo.ParticipacionPK.class)
public class Participacion {
    @Basic
    @Column(name = "PUNTUACION", nullable = true, precision = 0)
    private Byte puntuacion;
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID_EQUIPO", nullable = false)
    private Equipo equiposByIdEquipo;
    @ManyToOne
    @JoinColumn(name = "ID_COMPETICION", referencedColumnName = "ID_COMPETICION", nullable = false)
    private Competicion competicionesByIdCompeticion;

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

        if (puntuacion != null ? !puntuacion.equals(that.puntuacion) : that.puntuacion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return puntuacion != null ? puntuacion.hashCode() : 0;
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

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_EQUIPO", nullable = false, precision = 0)
    private byte idEquipo;

    public byte getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(byte idEquipo) {
        this.idEquipo = idEquipo;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_COMPETICION", nullable = false, precision = 0)
    private byte idCompeticion;

    public byte getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(byte idCompeticion) {
        this.idCompeticion = idCompeticion;
    }
}
