package modelo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "JUEGOS", schema = "EQDAW02", catalog = "")
public class Juego {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
    @SequenceGenerator(name = "seq_gen", sequenceName = "juegos_seq", allocationSize = 1)    @Id
    @Column(name = "ID_JUEGO", nullable = false, precision = 0)
    private int idJuego;
    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 50)
    private String nombre;
    @Basic
    @Column(name = "EMPRESA", nullable = true, length = 50)
    private String empresa;
    @Basic
    @Column(name = "FECHA_LANZAMIENTO", nullable = true)
    private Date fechaLanzamiento;
    @OneToMany(mappedBy = "juegosByIdJuego")
    private Collection<Competicion> competicionesByIdJuego;

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(byte idJuego) {
        this.idJuego = idJuego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

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

    public Collection<Competicion> getCompeticionesByIdJuego() {
        return competicionesByIdJuego;
    }

    public void setCompeticionesByIdJuego(Collection<Competicion> competicionesByIdJuego) {
        this.competicionesByIdJuego = competicionesByIdJuego;
    }
}
