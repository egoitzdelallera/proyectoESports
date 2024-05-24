package modelo;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "JUGADORES", schema = "EQDAW02", catalog = "")
public class Jugador {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
    @SequenceGenerator(name = "seq_gen", sequenceName = "jugadores_seq", allocationSize = 1)
    @Id
    @Column(name = "ID_JUGADOR", nullable = false, precision = 0)
    private int idJugador;
    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 50)
    private String nombre;
    @Basic
    @Column(name = "NACIONALIDAD", nullable = true, length = 50)
    private String nacionalidad;
    @Basic
    @Column(name = "FECHA_NACIMIENTO", nullable = true)
    private Date fechaNacimiento;
    @Basic
    @Column(name = "NICKNAME", nullable = true, length = 50)
    private String nickname;
    @Basic
    @Column(name = "ROL", nullable = true, length = 50)
    private String rol;
    @Basic
    @Column(name = "SUELDO", nullable = true, precision = 0)
    private Integer sueldo;
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID_EQUIPO")
    private Equipo equiposByIdEquipo;

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(byte idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getSueldo() {
        return sueldo;
    }

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

    public Equipo getEquiposByIdEquipo() {
        return equiposByIdEquipo;
    }

    public void setEquiposByIdEquipo(Equipo equiposByIdEquipo) {
        this.equiposByIdEquipo = equiposByIdEquipo;
    }
}
