package es.taw.proyectotaw.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tipoestadocuenta", schema = "mydb", catalog = "")
public class TipoestadocuentaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idTipoEstadoCuenta", nullable = false)
    private Integer idTipoEstadoCuenta;
    @Basic
    @Column(name = "estado", nullable = false, length = 45)
    private String estado;
    @OneToMany(mappedBy = "tipoestadocuentaByEstado")
    private Collection<CuentabancoEntity> cuentabancosByIdTipoEstadoCuenta;

    public Integer getIdTipoEstadoCuenta() {
        return idTipoEstadoCuenta;
    }

    public void setIdTipoEstadoCuenta(Integer idTipoEstadoCuenta) {
        this.idTipoEstadoCuenta = idTipoEstadoCuenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoestadocuentaEntity that = (TipoestadocuentaEntity) o;
        return Objects.equals(idTipoEstadoCuenta, that.idTipoEstadoCuenta) && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTipoEstadoCuenta, estado);
    }

    public Collection<CuentabancoEntity> getCuentabancosByIdTipoEstadoCuenta() {
        return cuentabancosByIdTipoEstadoCuenta;
    }

    public void setCuentabancosByIdTipoEstadoCuenta(Collection<CuentabancoEntity> cuentabancosByIdTipoEstadoCuenta) {
        this.cuentabancosByIdTipoEstadoCuenta = cuentabancosByIdTipoEstadoCuenta;
    }
}
