package modelo;

import jakarta.persistence.*;

/**
 * Clase que representa el staff del equipo en el sistema.
 */
@Entity
@Table(name = "STAFF", schema = "EQDAW02", catalog = "")
public class Staff {
    /**
     * Identificador único del personal.
     */
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
    @SequenceGenerator(name = "seq_gen", sequenceName = "staff_seq", allocationSize = 1)
    @Id
    @Column(name = "ID_STAFF", nullable = false, precision = 0)
    private int idStaff;
    /**
     * Puesto del personal.
     */
    @Basic
    @Column(name = "PUESTO", nullable = true, length = 50)
    private String puesto;
    /**
     * Nombre del personal.
     */
    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 50)
    private String nombre;
    /**
     * Sueldo del personal.
     */
    @Basic
    @Column(name = "SUELDO", nullable = true, precision = 0)
    private Integer sueldo;

    /**
     * Equipo al que pertenece este personal.
     */
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID_EQUIPO")
    private Equipo equiposByIdEquipo;

    /**
     * Obtiene el identificador único del personal.
     * @return El identificador único del personal.
     */
    public int getIdStaff() {
        return idStaff;
    }

    /**
     * Establece el identificador único del personal.
     * @param idStaff El identificador único del personal.
     */
    public void setIdStaff(byte idStaff) {
        this.idStaff = idStaff;
    }

    /**
     * Obtiene el puesto del personal.
     * @return El puesto del personal.
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * Establece el puesto del personal.
     * @param puesto El puesto del personal.
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    /**
     * Obtiene el nombre del personal.
     * @return El nombre del personal.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del personal.
     * @param nombre El nombre del personal.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el sueldo del personal.
     * @return El sueldo del personal.
     */
    public Integer getSueldo() {
        return sueldo;
    }

    /**
     * Establece el sueldo del personal.
     * @param sueldo El sueldo del personal.
     */
    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff staff = (Staff) o;

        if (idStaff != staff.idStaff) return false;
        if (puesto != null ? !puesto.equals(staff.puesto) : staff.puesto != null) return false;
        if (nombre != null ? !nombre.equals(staff.nombre) : staff.nombre != null) return false;
        if (sueldo != null ? !sueldo.equals(staff.sueldo) : staff.sueldo != null) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idStaff;
        result = 31 * result + (puesto != null ? puesto.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (sueldo != null ? sueldo.hashCode() : 0);

        return result;
    }

    /**
     * Obtiene el equipo al que pertenece este personal.
     * @return El equipo al que pertenece este personal.
     */
    public Equipo getEquiposByIdEquipo() {
        return equiposByIdEquipo;
    }

    /**
     * Establece el equipo al que pertenece este personal.
     * @param equiposByIdEquipo El equipo al que pertenece este personal.
     */
    public void setEquiposByIdEquipo(Equipo equiposByIdEquipo) {
        this.equiposByIdEquipo = equiposByIdEquipo;
    }
}
