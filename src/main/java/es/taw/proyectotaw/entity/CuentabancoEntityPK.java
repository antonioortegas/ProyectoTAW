package es.taw.proyectotaw.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CuentabancoEntityPK implements Serializable {
    @Column(name = "idCuentaBanco", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCuentaBanco;
    @Column(name = "estado", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer estado;

    public Integer getIdCuentaBanco() {
        return idCuentaBanco;
    }

    public void setIdCuentaBanco(Integer idCuentaBanco) {
        this.idCuentaBanco = idCuentaBanco;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuentabancoEntityPK that = (CuentabancoEntityPK) o;
        return Objects.equals(idCuentaBanco, that.idCuentaBanco) && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCuentaBanco, estado);
    }
}
