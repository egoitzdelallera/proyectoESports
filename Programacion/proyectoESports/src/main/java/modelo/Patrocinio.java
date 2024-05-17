package modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "PATROCINIOS", schema = "EQDAW02", catalog = "")
public class Patrocinio {
    @Id
    @Column(name = "ID_PATROCINADOR", nullable = true, precision = 0)
    private Byte idPatrocinador;
    @Basic
    @Column(name = "ID_EQUIPO", nullable = true, precision = 0)
    private Byte idEquipo;
    @ManyToOne
    @JoinColumn(name = "ID_PATROCINADOR", referencedColumnName = "ID_PATROCINADOR", insertable = false, updatable = false)
    private Patrocinador patrocinadoresByIdPatrocinador;
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID_EQUIPO", insertable = false, updatable = false)
    private Equipo equiposByIdEquipo;

    public Byte getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(Byte idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public Byte getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Byte idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patrocinio that = (Patrocinio) o;

        if (idPatrocinador != null ? !idPatrocinador.equals(that.idPatrocinador) : that.idPatrocinador != null)
            return false;
        if (idEquipo != null ? !idEquipo.equals(that.idEquipo) : that.idEquipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPatrocinador != null ? idPatrocinador.hashCode() : 0;
        result = 31 * result + (idEquipo != null ? idEquipo.hashCode() : 0);
        return result;
    }

    public Patrocinador getPatrocinadoresByIdPatrocinador() {
        return patrocinadoresByIdPatrocinador;
    }

    public void setPatrocinadoresByIdPatrocinador(Patrocinador patrocinadoresByIdPatrocinador) {
        this.patrocinadoresByIdPatrocinador = patrocinadoresByIdPatrocinador;
    }

    public Equipo getEquiposByIdEquipo() {
        return equiposByIdEquipo;
    }

    public void setEquiposByIdEquipo(Equipo equiposByIdEquipo) {
        this.equiposByIdEquipo = equiposByIdEquipo;
    }
}
