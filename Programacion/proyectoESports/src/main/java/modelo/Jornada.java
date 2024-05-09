package modelo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "JORNADAS", schema = "EQDAW02", catalog = "")
public class Jornada {
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_JORNADA", nullable = false, precision = 0)
    private byte idJornada;
    @Basic
    @Column(name = "N_JORNADA", nullable = true, precision = 0)
    private Byte nJornada;
    @Basic
    @Column(name = "FECHA_JORNADA", nullable = true)
    private Date fechaJornada;
    @OneToMany(mappedBy = "jornadasByIdJornada")
    private Collection<Enfrentamiento> enfrentamientosByIdJornada;
    @ManyToOne
    @JoinColumn(name = "ID_COMPETICION", referencedColumnName = "ID_COMPETICION")
    private Competicion competicionesByIdCompeticion;

    public byte getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(byte idJornada) {
        this.idJornada = idJornada;
    }

    public Byte getnJornada() {
        return nJornada;
    }

    public void setnJornada(Byte nJornada) {
        this.nJornada = nJornada;
    }

    public Date getFechaJornada() {
        return fechaJornada;
    }

    public void setFechaJornada(Date fechaJornada) {
        this.fechaJornada = fechaJornada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jornada jornada = (Jornada) o;

        if (idJornada != jornada.idJornada) return false;
        if (nJornada != null ? !nJornada.equals(jornada.nJornada) : jornada.nJornada != null) return false;
        if (fechaJornada != null ? !fechaJornada.equals(jornada.fechaJornada) : jornada.fechaJornada != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idJornada;
        result = 31 * result + (nJornada != null ? nJornada.hashCode() : 0);
        result = 31 * result + (fechaJornada != null ? fechaJornada.hashCode() : 0);
        return result;
    }

    public Collection<Enfrentamiento> getEnfrentamientosByIdJornada() {
        return enfrentamientosByIdJornada;
    }

    public void setEnfrentamientosByIdJornada(Collection<Enfrentamiento> enfrentamientosByIdJornada) {
        this.enfrentamientosByIdJornada = enfrentamientosByIdJornada;
    }

    public Competicion getCompeticionesByIdCompeticion() {
        return competicionesByIdCompeticion;
    }

    public void setCompeticionesByIdCompeticion(Competicion competicionesByIdCompeticion) {
        this.competicionesByIdCompeticion = competicionesByIdCompeticion;
    }
}
