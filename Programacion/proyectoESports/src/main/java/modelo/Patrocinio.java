package modelo;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "PATROCINIOS", schema = "EQDAW02", catalog = "")
public class Patrocinio {
    @Id
    @Column(name = "ID_PATROCINADOR", nullable = true, precision = 0)
    private int idPatrocinador;
    @Basic
    @Column(name = "ID_EQUIPO", nullable = true, precision = 0)
    private int idEquipo;
    @ManyToOne
    @JoinColumn(name = "ID_PATROCINADOR", referencedColumnName = "ID_PATROCINADOR", insertable = false, updatable = false)
    private Patrocinador patrocinadoresByIdPatrocinador;
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID_EQUIPO", insertable = false, updatable = false)
    private Equipo equiposByIdEquipo;

    public int getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(int idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patrocinio that = (Patrocinio) o;

        if (idPatrocinador != null ? !idPatrocinador.equals(that.idPatrocinador) : that.idPatrocinador != null)
            return false;
        if (idEquipo != null ? !idEquipo.equals(that.idEquipo) : that.idEquipo != null) return false;

        return true;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patrocinio that = (Patrocinio) o;
        return idPatrocinador == that.idPatrocinador && idEquipo == that.idEquipo && Objects.equals(patrocinadoresByIdPatrocinador, that.patrocinadoresByIdPatrocinador) && Objects.equals(equiposByIdEquipo, that.equiposByIdEquipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPatrocinador, idEquipo, patrocinadoresByIdPatrocinador, equiposByIdEquipo);
    }
    /*
    @Override
    public int hashCode() {
        int result = idPatrocinador != null ? idPatrocinador.hashCode() : 0;
        result = 31 * result + (idEquipo != null ? idEquipo.hashCode() : 0);
        return result;
    }*/

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
