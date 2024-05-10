package modelo;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@SuppressWarnings("JpaAttributeTypeInspection")
@Entity
@Table(name = "PATROCINADORES", schema = "EQDAW02", catalog = "")
public class Patrocinador {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PATROCINADOR", nullable = false, precision = 0)
    private byte idPatrocinador;
    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 50)
    private String nombre;

    private List<Equipo> listaEquipos;

    public byte getIdPatrocinador() {
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
}
