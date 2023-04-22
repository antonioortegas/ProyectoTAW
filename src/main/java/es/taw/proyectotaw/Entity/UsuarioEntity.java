package es.taw.proyectotaw.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "usuario", schema = "mydb", catalog = "")
public class UsuarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idUsuario", nullable = false)
    private Integer idUsuario;
    @Basic
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Basic
    @Column(name = "apellido", nullable = true, length = 45)
    private String apellido;
    @ManyToOne
    @JoinColumn(name = "Cuenta_idCuenta", referencedColumnName = "idCuenta", nullable = false)
    private CuentaEntity cuentaByCuentaIdCuenta;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return Objects.equals(idUsuario, that.idUsuario) && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nombre, apellido);
    }

    public CuentaEntity getCuentaByCuentaIdCuenta() {
        return cuentaByCuentaIdCuenta;
    }

    public void setCuentaByCuentaIdCuenta(CuentaEntity cuentaByCuentaIdCuenta) {
        this.cuentaByCuentaIdCuenta = cuentaByCuentaIdCuenta;
    }
}
