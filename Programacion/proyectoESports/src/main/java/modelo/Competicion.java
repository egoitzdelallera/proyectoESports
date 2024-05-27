package modelo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

/**
 * Representa una competición en el sistema.
 */
@Entity
@Table(name = "COMPETICIONES", schema = "EQDAW02", catalog = "")
public class Competicion {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
    @SequenceGenerator(name = "seq_gen", sequenceName = "competiciones_seq", allocationSize = 1)
    @Id
    @Column(name = "ID_COMPETICION", nullable = false, precision = 0)
    private int idCompeticion;
    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 50)
    private String nombre;
    @Basic
    @Column(name = "FECHA_INICIO", nullable = true)
    private Date fechaInicio;
    @Basic
    @Column(name = "FECHA_FIN", nullable = true)
    private Date fechaFin;
    @Basic
    @Column(name = "ESTADO", nullable = true, precision = 0)
    private Boolean estado;
    @ManyToOne
    @JoinColumn(name = "ID_JUEGO", referencedColumnName = "ID_JUEGO")
    private Juego juegosByIdJuego;
    @OneToMany(mappedBy = "competicionesByIdCompeticion")
    private Collection<Jornada> jornadasByIdCompeticion;
    @OneToMany(mappedBy = "competicionesByIdCompeticion")
    private Collection<Participacion> participacionesByIdCompeticion;

    /**
     * Obtiene el ID de la competición.
     *
     * @return El ID de la competición.
     */
    public int getIdCompeticion() {
        return idCompeticion;
    }

    /**
     * Establece el ID de la competición.
     *
     * @param idCompeticion El ID de la competición.
     */
    public void setIdCompeticion(int idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    /**
     * Obtiene el nombre de la competición.
     *
     * @return El nombre de la competición.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la competición.
     *
     * @param nombre El nombre de la competición.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la fecha de inicio de la competición.
     *
     * @return La fecha de inicio de la competición.
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio de la competición.
     *
     * @param fechaInicio La fecha de inicio de la competición.
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }


    /**
     * Obtiene la fecha de fin de la competición.
     *
     * @return La fecha de fin de la competición.
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece la fecha de fin de la competición.
     *
     * @param fechaFin La fecha de fin de la competición.
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Obtiene el estado de la competición.
     *
     * @return El estado de la competición.
     */
    public Boolean getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la competición.
     *
     * @param estado El estado de la competición.
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Competicion that = (Competicion) o;

        if (idCompeticion != that.idCompeticion) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (fechaInicio != null ? !fechaInicio.equals(that.fechaInicio) : that.fechaInicio != null) return false;
        if (fechaFin != null ? !fechaFin.equals(that.fechaFin) : that.fechaFin != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idCompeticion;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (fechaInicio != null ? fechaInicio.hashCode() : 0);
        result = 31 * result + (fechaFin != null ? fechaFin.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    /**
     * Obtiene los juegos asociados a la competición.
     *
     * @return Los juegos asociados a la competición.
     */
    public Juego getJuegosByIdJuego() {
        return juegosByIdJuego;
    }

    /**
     * Establece los juegos asociados a la competición.
     *
     * @param juegosByIdJuego Los juegos asociados a la competición.
     */
    public void setJuegosByIdJuego(Juego juegosByIdJuego) {
        this.juegosByIdJuego = juegosByIdJuego;
    }

    /**
     * Obtiene las jornadas asociadas a la competición.
     *
     * @return Las jornadas asociadas a la competición.
     */
    public Collection<Jornada> getJornadasByIdCompeticion() {
        return jornadasByIdCompeticion;
    }

    /**
     * Establece las jornadas asociadas a la competición.
     *
     * @param jornadasByIdCompeticion Las jornadas asociadas a la competición.
     */
    public void setJornadasByIdCompeticion(Collection<Jornada> jornadasByIdCompeticion) {
        this.jornadasByIdCompeticion = jornadasByIdCompeticion;
    }

    /**
     * Obtiene las participaciones asociadas a la competición.
     *
     * @return Las participaciones asociadas a la competición.
     */
    public Collection<Participacion> getParticipacionesByIdCompeticion() {
        return participacionesByIdCompeticion;
    }

    /**
     * Establece las participaciones asociadas a la competición.
     *
     * @param participacionesByIdCompeticion Las participaciones asociadas a la competición.
     */
    public void setParticipacionesByIdCompeticion(Collection<Participacion> participacionesByIdCompeticion) {
        this.participacionesByIdCompeticion = participacionesByIdCompeticion;
    }
}
