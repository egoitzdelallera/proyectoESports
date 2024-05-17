package modelo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "EQUIPOS", schema = "EQDAW02", catalog = "")
public class Equipo {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
    @SequenceGenerator(name = "seq_gen", sequenceName = "equipos_seq", allocationSize = 1)
    @Id
    @Column(name = "ID_EQUIPO", nullable = false, precision = 0)
    private byte idEquipo;
    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 25)
    private String nombre;
    @Basic
    @Column(name = "FECHA_FUNDACION", nullable = true)
    private Date fechaFundacion;
    @OneToMany(mappedBy = "equiposByIdEquipoLocal")
    private Collection<Enfrentamiento> enfrentamientosByIdEquipo;
    @OneToMany(mappedBy = "equiposByIdEquipoVisitante")
    private Collection<Enfrentamiento> enfrentamientosByIdEquipo_0;
    @OneToMany(mappedBy = "equiposByIdGanador")
    private Collection<Enfrentamiento> enfrentamientosByIdEquipo_1;
    @OneToMany(mappedBy = "equiposByIdEquipo")
    private Collection<Jugador> jugadoresByIdEquipo;
    @OneToMany(mappedBy = "equiposByIdEquipo")
    private Collection<Participacion> participacionesByIdEquipo;
    @OneToMany(mappedBy = "equiposByIdEquipo")
    private Collection<Patrocinio> patrociniosByIdEquipo;
    @OneToMany(mappedBy = "equiposByIdEquipo")
    private Collection<Staff> staffByIdEquipo;

    public Equipo() {
    }

    public byte getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(byte idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(Date fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipo equipo = (Equipo) o;

        if (idEquipo != equipo.idEquipo) return false;
        if (nombre != null ? !nombre.equals(equipo.nombre) : equipo.nombre != null) return false;
        if (fechaFundacion != null ? !fechaFundacion.equals(equipo.fechaFundacion) : equipo.fechaFundacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idEquipo;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (fechaFundacion != null ? fechaFundacion.hashCode() : 0);
        return result;
    }

    public Collection<Enfrentamiento> getEnfrentamientosByIdEquipo() {
        return enfrentamientosByIdEquipo;
    }

    public void setEnfrentamientosByIdEquipo(Collection<Enfrentamiento> enfrentamientosByIdEquipo) {
        this.enfrentamientosByIdEquipo = enfrentamientosByIdEquipo;
    }

    public Collection<Enfrentamiento> getEnfrentamientosByIdEquipo_0() {
        return enfrentamientosByIdEquipo_0;
    }

    public void setEnfrentamientosByIdEquipo_0(Collection<Enfrentamiento> enfrentamientosByIdEquipo_0) {
        this.enfrentamientosByIdEquipo_0 = enfrentamientosByIdEquipo_0;
    }

    public Collection<Enfrentamiento> getEnfrentamientosByIdEquipo_1() {
        return enfrentamientosByIdEquipo_1;
    }

    public void setEnfrentamientosByIdEquipo_1(Collection<Enfrentamiento> enfrentamientosByIdEquipo_1) {
        this.enfrentamientosByIdEquipo_1 = enfrentamientosByIdEquipo_1;
    }

    public Collection<Jugador> getJugadoresByIdEquipo() {
        return jugadoresByIdEquipo;
    }

    public void setJugadoresByIdEquipo(Collection<Jugador> jugadoresByIdEquipo) {
        this.jugadoresByIdEquipo = jugadoresByIdEquipo;
    }

    public Collection<Participacion> getParticipacionesByIdEquipo() {
        return participacionesByIdEquipo;
    }

    public void setParticipacionesByIdEquipo(Collection<Participacion> participacionesByIdEquipo) {
        this.participacionesByIdEquipo = participacionesByIdEquipo;
    }

    public Collection<Patrocinio> getPatrociniosByIdEquipo() {
        return patrociniosByIdEquipo;
    }

    public void setPatrociniosByIdEquipo(Collection<Patrocinio> patrociniosByIdEquipo) {
        this.patrociniosByIdEquipo = patrociniosByIdEquipo;
    }

    public Collection<Staff> getStaffByIdEquipo() {
        return staffByIdEquipo;
    }

    public void setStaffByIdEquipo(Collection<Staff> staffByIdEquipo) {
        this.staffByIdEquipo = staffByIdEquipo;
    }
}
