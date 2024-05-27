package modelo;

import jakarta.persistence.*;

import java.util.Collection;

/**
 * La clase Patrocinador representa la entidad de patrocinador en la base de datos.
 * Está mapeada a la tabla "PATROCINADORES" en el esquema "EQDAW02".
 */
@Entity
@Table(name = "PATROCINADORES", schema = "EQDAW02", catalog = "")
public class Patrocinador {

    /**
     * Identificador del patrocinador.
     * Mapeado a la columna "ID_PATROCINADOR" en la base de datos.
     * Generado automáticamente mediante una secuencia.
     */
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
    @SequenceGenerator(name = "seq_gen", sequenceName = "patrocinadores_seq", allocationSize = 1)
    @Id
    @Column(name = "ID_PATROCINADOR", nullable = false, precision = 0)
    private int idPatrocinador;

    /**
     * Nombre del patrocinador.
     * Mapeado a la columna "NOMBRE" en la base de datos.
     */
    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 50)
    private String nombre;

    /**
     * Relación uno a muchos con la entidad Patrocinio.
     * Mapeada por la propiedad "patrocinadoresByIdPatrocinador" en la clase Patrocinio.
     */
    @OneToMany(mappedBy = "patrocinadoresByIdPatrocinador")
    private Collection<Patrocinio> patrociniosByIdPatrocinador;

    /**
     * Obtiene el identificador del patrocinador.
     * @return el identificador del patrocinador.
     */
    public int getIdPatrocinador() {
        return idPatrocinador;
    }

    /**
     * Establece el identificador del patrocinador.
     * @param idPatrocinador el identificador del patrocinador a establecer.
     */
    public void setIdPatrocinador(byte idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    /**
     * Obtiene el nombre del patrocinador.
     * @return el nombre del patrocinador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del patrocinador.
     * @param nombre el nombre del patrocinador a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Compara este patrocinador con otro objeto para determinar si son iguales.
     * @param o el objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patrocinador that = (Patrocinador) o;

        if (idPatrocinador != that.idPatrocinador) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    /**
     * Calcula el código hash para este patrocinador.
     * @return el código hash.
     */
    @Override
    public int hashCode() {
        int result = (int) idPatrocinador;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    /**
     * Obtiene la colección de patrocinios asociados a este patrocinador.
     * @return la colección de patrocinios.
     */
    public Collection<Patrocinio> getPatrociniosByIdPatrocinador() {
        return patrociniosByIdPatrocinador;
    }

    /**
     * Establece la colección de patrocinios asociados a este patrocinador.
     * @param patrociniosByIdPatrocinador la colección de patrocinios a establecer.
     */
    public void setPatrociniosByIdPatrocinador(Collection<Patrocinio> patrociniosByIdPatrocinador) {
        this.patrociniosByIdPatrocinador = patrociniosByIdPatrocinador;
    }
}
