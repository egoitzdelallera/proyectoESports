package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PATROCINIOS", schema = "EQDAW02", catalog = "")
public class Patrocinio {
    @ManyToOne
    @JoinColumn(name = "ID_PATROCINADOR", referencedColumnName = "ID_PATROCINADOR")
    private Patrocinador patrocinadoresByIdPatrocinador;
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID_EQUIPO")
    private Equipo equiposByIdEquipo;

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
