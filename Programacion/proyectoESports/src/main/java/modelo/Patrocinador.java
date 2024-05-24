package modelo;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "PATROCINADORES", schema = "EQDAW02", catalog = "")
public class Patrocinador {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
    @SequenceGenerator(name = "seq_gen", sequenceName = "patrocinadores_seq", allocationSize = 1)
    @Id
    @Column(name = "ID_PATROCINADOR", nullable = false, precision = 0)
    private int idPatrocinador;
    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 50)
    private String nombre;
    @OneToMany(mappedBy = "patrocinadoresByIdPatrocinador")
    private Collection<Patrocinio> patrociniosByIdPatrocinador;

    public int getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(byte idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patrocinador that = (Patrocinador) o;

        if (idPatrocinador != that.idPatrocinador) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idPatrocinador;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    public Collection<Patrocinio> getPatrociniosByIdPatrocinador() {
        return patrociniosByIdPatrocinador;
    }

    public void setPatrociniosByIdPatrocinador(Collection<Patrocinio> patrociniosByIdPatrocinador) {
        this.patrociniosByIdPatrocinador = patrociniosByIdPatrocinador;
    }
}
