package modelo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

/**
 * Representa un juego en el sistema.
 */
@Entity
@Table(name = "JUEGOS", schema = "EQDAW02", catalog = "")
public class Juego {
    /**
     * Identificador único del juego.
     */
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
    @SequenceGenerator(name = "seq_gen", sequenceName = "juegos_seq", allocationSize = 1)    @Id
    @Column(name = "ID_JUEGO", nullable = false, precision = 0)
    private int idJuego;
    /**
     * Nombre del juego.
     */
    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 50)
    private String nombre;
    /**
     * Empresa desarrolladora del juego.
     */
    @Basic
    @Column(name = "EMPRESA", nullable = true, length = 50)
    private String empresa;
    /**
     * Fecha de lanzamiento del juego.
     */
    @Basic
    @Column(name = "FECHA_LANZAMIENTO", nullable = true)
    private Date fechaLanzamiento;
    /**
     * Colección de competiciones asociadas a este juego.
     */
    @OneToMany(mappedBy = "juegosByIdJuego")
    private Collection<Competicion> competicionesByIdJuego;

    /**
     * Retorna el identificador único del juego.
     * @return El identificador único del juego.
     */
    public int getIdJuego() {
        return idJuego;
    }


    /**
     * Establece el identificador único del juego.
     * @param idJuego El nuevo identificador único del juego.
     */
    public void setIdJuego(byte idJuego) {
        this.idJuego = idJuego;
    }

    /**
     * Retorna el nombre del juego.
     * @return El nombre del juego.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del juego.
     * @param nombre El nuevo nombre del juego.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el nombre de la empresa desarrolladora del juego.
     * @return El nombre de la empresa desarrolladora del juego.
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Establece el nombre de la empresa desarrolladora del juego.
     * @param empresa El nuevo nombre de la empresa desarrolladora del juego.
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * Retorna la fecha de lanzamiento del juego.
     * @return La fecha de lanzamiento del juego.
     */
    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    /**
     * Establece la fecha de lanzamiento del juego.
     * @param fechaLanzamiento La nueva fecha de lanzamiento del juego.
     */
    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Juego juego = (Juego) o;

        if (idJuego != juego.idJuego) return false;
        if (nombre != null ? !nombre.equals(juego.nombre) : juego.nombre != null) return false;
        if (empresa != null ? !empresa.equals(juego.empresa) : juego.empresa != null) return false;
        if (fechaLanzamiento != null ? !fechaLanzamiento.equals(juego.fechaLanzamiento) : juego.fechaLanzamiento != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idJuego;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (empresa != null ? empresa.hashCode() : 0);
        result = 31 * result + (fechaLanzamiento != null ? fechaLanzamiento.hashCode() : 0);
        return result;
    }

    /**
     * Retorna la colección de competiciones asociadas a este juego.
     * @return La colección de competiciones asociadas a este juego.
     */
    public Collection<Competicion> getCompeticionesByIdJuego() {
        return competicionesByIdJuego;
    }

    /**
     * Establece la colección de competiciones asociadas a este juego.
     * @param competicionesByIdJuego La nueva colección de competiciones asociadas a este juego.
     */
    public void setCompeticionesByIdJuego(Collection<Competicion> competicionesByIdJuego) {
        this.competicionesByIdJuego = competicionesByIdJuego;
    }
}
