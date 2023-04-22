package es.taw.proyectotaw.Entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "cuenta", schema = "mydb", catalog = "")
public class CuentaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCuenta", nullable = false)
    private Integer idCuenta;
    @Basic
    @Column(name = "Saldo", nullable = false)
    private Integer saldo;
    @OneToMany(mappedBy = "cuentaByCuentaIdCuenta")
    private Collection<UsuarioEntity> usuariosByIdCuenta;

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuentaEntity that = (CuentaEntity) o;
        return Objects.equals(idCuenta, that.idCuenta) && Objects.equals(saldo, that.saldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCuenta, saldo);
    }

    public Collection<UsuarioEntity> getUsuariosByIdCuenta() {
        return usuariosByIdCuenta;
    }

    public void setUsuariosByIdCuenta(Collection<UsuarioEntity> usuariosByIdCuenta) {
        this.usuariosByIdCuenta = usuariosByIdCuenta;
    }
}
