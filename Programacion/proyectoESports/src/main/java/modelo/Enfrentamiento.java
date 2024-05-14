package modelo;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "ENFRENTAMIENTOS", schema = "EQDAW02", catalog = "")
public class Enfrentamiento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ENFRENTAMIENTO", nullable = false, precision = 0)
    private byte idEnfrentamiento;
    @Basic
    @Column(name = "HORA", nullable = true)
    private Timestamp hora;
    @ManyToOne
    @JoinColumn(name = "ID_JORNADA", referencedColumnName = "ID_JORNADA")
    private Jornada jornadasByIdJornada;
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO_LOCAL", referencedColumnName = "ID_EQUIPO")
    private Equipo equiposByIdEquipoLocal;
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO_VISITANTE", referencedColumnName = "ID_EQUIPO")
    private Equipo equiposByIdEquipoVisitante;
    @ManyToOne
    @JoinColumn(name = "ID_GANADOR", referencedColumnName = "ID_EQUIPO")
    private Equipo equiposByIdGanador;

    public byte getIdEnfrentamiento() {
        return idEnfrentamiento;
    }

    public void setIdEnfrentamiento(byte idEnfrentamiento) {
        this.idEnfrentamiento = idEnfrentamiento;
    }

    public Timestamp getHora() {
        return hora;
    }

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

    public Jornada getJornadasByIdJornada() {
        return jornadasByIdJornada;
    }

    public void setJornadasByIdJornada(Jornada jornadasByIdJornada) {
        this.jornadasByIdJornada = jornadasByIdJornada;
    }

    public Equipo getEquiposByIdEquipoLocal() {
        return equiposByIdEquipoLocal;
    }

    public void setEquiposByIdEquipoLocal(Equipo equiposByIdEquipoLocal) {
        this.equiposByIdEquipoLocal = equiposByIdEquipoLocal;
    }

    public Equipo getEquiposByIdEquipoVisitante() {
        return equiposByIdEquipoVisitante;
    }

    public void setEquiposByIdEquipoVisitante(Equipo equiposByIdEquipoVisitante) {
        this.equiposByIdEquipoVisitante = equiposByIdEquipoVisitante;
    }

    public Equipo getEquiposByIdGanador() {
        return equiposByIdGanador;
    }

    public void setEquiposByIdGanador(Equipo equiposByIdGanador) {
        this.equiposByIdGanador = equiposByIdGanador;
    }
}
