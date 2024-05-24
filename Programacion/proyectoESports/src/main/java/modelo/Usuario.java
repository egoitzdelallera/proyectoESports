package modelo;

import jakarta.persistence.*;

/**
 * Clase que representa a un usuario en el sistema.
 */
@Entity
@Table(name = "USUARIOS", schema = "EQDAW02", catalog = "")
public class Usuario {
    /**
     * Identificador único del usuario.
     */
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
    @SequenceGenerator(name = "seq_gen", sequenceName = "usuarios_seq", allocationSize = 1)
    @Id
    @Column(name = "ID_USUARIO", nullable = false, precision = 0)
    private int idUsuario;
    /**
     * Nombre del usuario.
     */
    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 50)
    private String nombre;

    /**
     * Contraseña del usuario.
     */
    @Basic
    @Column(name = "CONTRASENA", nullable = true, length = 50)
    private String contrasena;

    /**
     * Rol del usuario.
     */
    @Basic
    @Column(name = "ROL", nullable = true, length = 50)
    private String rol;

    /**
     * Obtiene el identificador único del usuario.
     * @return El identificador único del usuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el identificador único del usuario.
     * @param idUsuario El identificador único del usuario.
     */
    public void setIdUsuario(byte idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene el nombre del usuario.
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * @param nombre El nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return La contraseña del usuario.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario.
     * @param contrasena La contraseña del usuario.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el rol del usuario.
     * @return El rol del usuario.
     */
    public String getRol() {
        return rol;
    }

    /**
     * Establece el rol del usuario.
     * @param rol El rol del usuario.
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        if (idUsuario != usuario.idUsuario) return false;
        if (nombre != null ? !nombre.equals(usuario.nombre) : usuario.nombre != null) return false;
        if (contrasena != null ? !contrasena.equals(usuario.contrasena) : usuario.contrasena != null) return false;
        if (rol != null ? !rol.equals(usuario.rol) : usuario.rol != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idUsuario;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (contrasena != null ? contrasena.hashCode() : 0);
        result = 31 * result + (rol != null ? rol.hashCode() : 0);
        return result;
    }
}
