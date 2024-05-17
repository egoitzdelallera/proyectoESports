package modelo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

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

    public int getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(byte idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Boolean getEstado() {
        return estado;
    }

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

    public Juego getJuegosByIdJuego() {
        return juegosByIdJuego;
    }

    public void setJuegosByIdJuego(Juego juegosByIdJuego) {
        this.juegosByIdJuego = juegosByIdJuego;
    }

    public Collection<Jornada> getJornadasByIdCompeticion() {
        return jornadasByIdCompeticion;
    }

    public void setJornadasByIdCompeticion(Collection<Jornada> jornadasByIdCompeticion) {
        this.jornadasByIdCompeticion = jornadasByIdCompeticion;
    }

    public Collection<Participacion> getParticipacionesByIdCompeticion() {
        return participacionesByIdCompeticion;
    }

    public void setParticipacionesByIdCompeticion(Collection<Participacion> participacionesByIdCompeticion) {
        this.participacionesByIdCompeticion = participacionesByIdCompeticion;
    }
}
