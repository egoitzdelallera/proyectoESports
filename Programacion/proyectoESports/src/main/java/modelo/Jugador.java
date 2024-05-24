package modelo;

import jakarta.persistence.*;

import java.sql.Date;

/**
 * Representa un jugador en el sistema.
 */
@Entity
@Table(name = "JUGADORES", schema = "EQDAW02", catalog = "")
public class Jugador {
    /**
     * Identificador único del jugador.
     */
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
    @SequenceGenerator(name = "seq_gen", sequenceName = "jugadores_seq", allocationSize = 1)
    @Id
    @Column(name = "ID_JUGADOR", nullable = false, precision = 0)
    private int idJugador;
    /**
     * Nombre del jugador.
     */
    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 50)
    private String nombre;
    /**
     * Nacionalidad del jugador.
     */
    @Basic
    @Column(name = "NACIONALIDAD", nullable = true, length = 50)
    private String nacionalidad;
    /**
     * Fecha de nacimiento del jugador.
     */
    @Basic
    @Column(name = "FECHA_NACIMIENTO", nullable = true)
    private Date fechaNacimiento;
    /**
     * Apodo (nickname) del jugador.
     */
    @Basic
    @Column(name = "NICKNAME", nullable = true, length = 50)
    private String nickname;
    /**
     * Rol del jugador en el equipo.
     */
    @Basic
    @Column(name = "ROL", nullable = true, length = 50)
    private String rol;
    /**
     * Sueldo del jugador.
     */
    @Basic
    @Column(name = "SUELDO", nullable = true, precision = 0)
    private Integer sueldo;

    /**
     * Equipo al que pertenece el jugador.
     */
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID_EQUIPO")
    private Equipo equiposByIdEquipo;

    /**
     * Retorna el identificador único del jugador.
     * @return El identificador único del jugador.
     */
    public int getIdJugador() {
        return idJugador;
    }

    /**
     * Establece el identificador único del jugador.
     * @param idJugador El nuevo identificador único del jugador.
     */
    public void setIdJugador(byte idJugador) {
        this.idJugador = idJugador;
    }

    /**
     * Retorna el nombre del jugador.
     * @return El nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del jugador.
     * @param nombre El nuevo nombre del jugador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna la nacionalidad del jugador.
     * @return La nacionalidad del jugador.
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Establece la nacionalidad del jugador.
     * @param nacionalidad La nueva nacionalidad del jugador.
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * Retorna la fecha de nacimiento del jugador.
     * @return La fecha de nacimiento del jugador.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del jugador.
     * @param fechaNacimiento La nueva fecha de nacimiento del jugador.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Retorna el apodo (nickname) del jugador.
     * @return El apodo (nickname) del jugador.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Establece el apodo (nickname) del jugador.
     * @param nickname El nuevo apodo (nickname) del jugador.
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Retorna el rol del jugador.
     * @return El rol del jugador.
     */
    public String getRol() {
        return rol;
    }

    /**
     * Establece el rol del jugador.
     * @param rol El nuevo rol del jugador.
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * Retorna el sueldo del jugador.
     * @return El sueldo del jugador.
     */
    public Integer getSueldo() {
        return sueldo;
    }

    /**
     * Establece el sueldo del jugador.
     * @param sueldo El nuevo sueldo del jugador.
     */
    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jugador jugador = (Jugador) o;

        if (idJugador != jugador.idJugador) return false;
        if (nombre != null ? !nombre.equals(jugador.nombre) : jugador.nombre != null) return false;
        if (nacionalidad != null ? !nacionalidad.equals(jugador.nacionalidad) : jugador.nacionalidad != null)
            return false;
        if (fechaNacimiento != null ? !fechaNacimiento.equals(jugador.fechaNacimiento) : jugador.fechaNacimiento != null)
            return false;
        if (nickname != null ? !nickname.equals(jugador.nickname) : jugador.nickname != null) return false;
        if (rol != null ? !rol.equals(jugador.rol) : jugador.rol != null) return false;
        if (sueldo != null ? !sueldo.equals(jugador.sueldo) : jugador.sueldo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idJugador;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (nacionalidad != null ? nacionalidad.hashCode() : 0);
        result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (rol != null ? rol.hashCode() : 0);
        result = 31 * result + (sueldo != null ? sueldo.hashCode() : 0);
        return result;
    }

    /**
     * Retorna el equipo al que pertenece el jugador.
     * @return El equipo al que pertenece el jugador.
     */
    public Equipo getEquiposByIdEquipo() {
        return equiposByIdEquipo;
    }

    /**
     * Establece el equipo al que pertenece el jugador.
     * @param equiposByIdEquipo El nuevo equipo al que pertenece el jugador.
     */
    public void setEquiposByIdEquipo(Equipo equiposByIdEquipo) {
        this.equiposByIdEquipo = equiposByIdEquipo;
    }
}
