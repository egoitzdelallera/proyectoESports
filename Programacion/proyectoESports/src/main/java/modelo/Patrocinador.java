package modelo;

import jakarta.persistence.*;

import java.util.Collection;

/**
 * Clase que representa un patrocinador en el sistema.
 */
@Entity
@Table(name = "PATROCINADORES", schema = "EQDAW02", catalog = "")
public class Patrocinador {
    /**
     * Identificador único del patrocinador.
     */
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
    @SequenceGenerator(name = "seq_gen", sequenceName = "patrocinadores_seq", allocationSize = 1)
    @Id
    @Column(name = "ID_PATROCINADOR", nullable = false, precision = 0)
    private int idPatrocinador;

    /**
     * Nombre del patrocinador.
     */
    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 50)
    private String nombre;
    /**
     * Colección de patrocinios asociados a este patrocinador.
     */
    @OneToMany(mappedBy = "patrocinadoresByIdPatrocinador")
    private Collection<Patrocinio> patrociniosByIdPatrocinador;

    /**
     * Obtiene el identificador único del patrocinador.
     * @return El identificador único del patrocinador.
     */
    public int getIdPatrocinador() {
        return idPatrocinador;
    }

    /**
     * Establece el identificador único del patrocinador.
     * @param idPatrocinador El identificador único del patrocinador.
     */
    public void setIdPatrocinador(byte idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    /**
     * Obtiene el nombre del patrocinador.
     * @return El nombre del patrocinador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del patrocinador.
     * @param nombre El nombre del patrocinador.
     */
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

    /**
     * Obtiene la colección de patrocinios asociados a este patrocinador.
     * @return La colección de patrocinios asociados a este patrocinador.
     */
    public Collection<Patrocinio> getPatrociniosByIdPatrocinador() {
        return patrociniosByIdPatrocinador;
    }

    /**
     * Establece la colección de patrocinios asociados a este patrocinador.
     * @param patrociniosByIdPatrocinador La colección de patrocinios asociados a este patrocinador.
     */
    public void setPatrociniosByIdPatrocinador(Collection<Patrocinio> patrociniosByIdPatrocinador) {
        this.patrociniosByIdPatrocinador = patrociniosByIdPatrocinador;
    }
}
