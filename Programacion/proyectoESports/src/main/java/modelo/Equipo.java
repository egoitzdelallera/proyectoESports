package modelo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

/**
 * Clase que representa un equipo en el sistema.
 */
@Entity
@Table(name = "EQUIPOS", schema = "EQDAW02", catalog = "")
public class Equipo {
    /**
     * Identificador único del equipo.
     */
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
    @SequenceGenerator(name = "seq_gen", sequenceName = "equipos_seq", allocationSize = 1)
    @Id
    @Column(name = "ID_EQUIPO", nullable = false, precision = 0)
    private int idEquipo;
    /**
     * Nombre del equipo.
     */
    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 25)
    private String nombre;
    /**
     * Fecha de fundación del equipo.
     */
    @Basic
    @Column(name = "FECHA_FUNDACION", nullable = true)
    private Date fechaFundacion;
    /**
     * Colección de enfrentamientos donde el equipo actúa como local.
     */
    @OneToMany(mappedBy = "equiposByIdEquipoLocal")
    private Collection<Enfrentamiento> enfrentamientosByIdEquipo;
    /**
     * Colección de enfrentamientos donde el equipo actúa como visitante.
     */
    @OneToMany(mappedBy = "equiposByIdEquipoVisitante")
    private Collection<Enfrentamiento> enfrentamientosByIdEquipo_0;
    /**
     * Colección de enfrentamientos donde el equipo es el ganador.
     */
    @OneToMany(mappedBy = "equiposByIdGanador")
    private Collection<Enfrentamiento> enfrentamientosByIdEquipo_1;
    /**
     * Colección de jugadores que pertenecen al equipo.
     */
    @OneToMany(mappedBy = "equiposByIdEquipo")
    private Collection<Jugador> jugadoresByIdEquipo;
    /**
     * Colección de participaciones del equipo en competiciones.
     */
    @OneToMany(mappedBy = "equiposByIdEquipo")
    private Collection<Participacion> participacionesByIdEquipo;
    /**
     * Colección de patrocinios del equipo.
     */
    @OneToMany(mappedBy = "equiposByIdEquipo")
    private Collection<Patrocinio> patrociniosByIdEquipo;
    /**
     * Colección de personal de staff asociado al equipo.
     */
    @OneToMany(mappedBy = "equiposByIdEquipo")
    private Collection<Staff> staffByIdEquipo;

    /**
     * Constructor por defecto de la clase Equipo.
     */
    public Equipo() {
    }

    /**
     * Retorna el identificador único del equipo.
     * @return El identificador único del equipo.
     */
    public int getIdEquipo() {
        return idEquipo;
    }

    /**
     * Establece el identificador único del equipo.
     * @param idEquipo El nuevo identificador único del equipo.
     */
    public void setIdEquipo(byte idEquipo) {
        this.idEquipo = idEquipo;
    }

    /**
     * Retorna el nombre del equipo.
     * @return El nombre del equipo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del equipo.
     * @param nombre El nuevo nombre del equipo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna la fecha de fundación del equipo.
     * @return La fecha de fundación del equipo.
     */
    public Date getFechaFundacion() {
        return fechaFundacion;
    }

    /**
     * Establece la fecha de fundación del equipo.
     * @param fechaFundacion La nueva fecha de fundación del equipo.
     */
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

    /**
     * Retorna la colección de enfrentamientos donde el equipo actúa como local.
     * @return La colección de enfrentamientos donde el equipo actúa como local.
     */
    public Collection<Enfrentamiento> getEnfrentamientosByIdEquipo() {
        return enfrentamientosByIdEquipo;
    }

    /**
     * Establece la colección de enfrentamientos donde el equipo actúa como local.
     * @param enfrentamientosByIdEquipo La nueva colección de enfrentamientos donde el equipo actúa como local.
     */
    public void setEnfrentamientosByIdEquipo(Collection<Enfrentamiento> enfrentamientosByIdEquipo) {
        this.enfrentamientosByIdEquipo = enfrentamientosByIdEquipo;
    }

    /**
     * Retorna la colección de enfrentamientos donde el equipo actúa como visitante.
     * @return La colección de enfrentamientos donde el equipo actúa como visitante.
     */
    public Collection<Enfrentamiento> getEnfrentamientosByIdEquipo_0() {
        return enfrentamientosByIdEquipo_0;
    }

    /**
     * Establece la colección de enfrentamientos donde el equipo actúa como visitante.
     * @param enfrentamientosByIdEquipo_0 La nueva colección de enfrentamientos donde el equipo actúa como visitante.
     */
    public void setEnfrentamientosByIdEquipo_0(Collection<Enfrentamiento> enfrentamientosByIdEquipo_0) {
        this.enfrentamientosByIdEquipo_0 = enfrentamientosByIdEquipo_0;
    }

    /**
     * Retorna la colección de enfrentamientos donde el equipo es el ganador.
     * @return La colección de enfrentamientos donde el equipo es el ganador.
     */
    public Collection<Enfrentamiento> getEnfrentamientosByIdEquipo_1() {
        return enfrentamientosByIdEquipo_1;
    }

    /**
     * Establece la colección de enfrentamientos donde el equipo es el ganador.
     * @param enfrentamientosByIdEquipo_1 La nueva colección de enfrentamientos donde el equipo es el ganador.
     */
    public void setEnfrentamientosByIdEquipo_1(Collection<Enfrentamiento> enfrentamientosByIdEquipo_1) {
        this.enfrentamientosByIdEquipo_1 = enfrentamientosByIdEquipo_1;
    }

    /**
     * Retorna la colección de jugadores que pertenecen al equipo.
     * @return La colección de jugadores que pertenecen al equipo.
     */
    public Collection<Jugador> getJugadoresByIdEquipo() {
        return jugadoresByIdEquipo;
    }

    /**
     * Establece la colección de jugadores que pertenecen al equipo.
     * @param jugadoresByIdEquipo La nueva colección de jugadores que pertenecen al equipo.
     */
    public void setJugadoresByIdEquipo(Collection<Jugador> jugadoresByIdEquipo) {
        this.jugadoresByIdEquipo = jugadoresByIdEquipo;
    }

    /**
     * Retorna la colección de participaciones del equipo en competiciones.
     * @return La colección de participaciones del equipo en competiciones.
     */
    public Collection<Participacion> getParticipacionesByIdEquipo() {
        return participacionesByIdEquipo;
    }

    /**
     * Establece la colección de participaciones del equipo en competiciones.
     * @param participacionesByIdEquipo La nueva colección de participaciones del equipo en competiciones.
     */
    public void setParticipacionesByIdEquipo(Collection<Participacion> participacionesByIdEquipo) {
        this.participacionesByIdEquipo = participacionesByIdEquipo;
    }

    /**
     * Retorna la colección de patrocinios del equipo.
     * @return La colección de patrocinios del equipo.
     */
    public Collection<Patrocinio> getPatrociniosByIdEquipo() {
        return patrociniosByIdEquipo;
    }

    /**
     * Establece la colección de patrocinios del equipo.
     * @param patrociniosByIdEquipo La nueva colección de patrocinios del equipo.
     */
    public void setPatrociniosByIdEquipo(Collection<Patrocinio> patrociniosByIdEquipo) {
        this.patrociniosByIdEquipo = patrociniosByIdEquipo;
    }

    /**
     * Retorna la colección de personal de staff asociado al equipo.
     * @return La colección de personal de staff asociado al equipo.
     */
    public Collection<Staff> getStaffByIdEquipo() {
        return staffByIdEquipo;
    }

    /**
     * Establece la colección de personal de staff asociado al equipo.
     * @param staffByIdEquipo La nueva colección de personal de staff asociado al equipo.
     */
    public void setStaffByIdEquipo(Collection<Staff> staffByIdEquipo) {
        this.staffByIdEquipo = staffByIdEquipo;
    }
}
