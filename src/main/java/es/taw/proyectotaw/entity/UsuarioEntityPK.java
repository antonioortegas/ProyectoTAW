package es.taw.proyectotaw.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UsuarioEntityPK implements Serializable {
    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "direccionCliente", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer direccionCliente;
    @Column(name = "estado", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer estado;
    @Column(name = "tipoCliente", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tipoCliente;
    @Column(name = "cuentaBanco", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cuentaBanco;
    @Column(name = "TipoPersonaRelacionada_tipoID", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tipoPersonaRelacionadaTipoId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(Integer direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(Integer tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Integer getCuentaBanco() {
        return cuentaBanco;
    }

    public void setCuentaBanco(Integer cuentaBanco) {
        this.cuentaBanco = cuentaBanco;
    }

    public Integer getTipoPersonaRelacionadaTipoId() {
        return tipoPersonaRelacionadaTipoId;
    }

    public void setTipoPersonaRelacionadaTipoId(Integer tipoPersonaRelacionadaTipoId) {
        this.tipoPersonaRelacionadaTipoId = tipoPersonaRelacionadaTipoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntityPK that = (UsuarioEntityPK) o;
        return Objects.equals(id, that.id) && Objects.equals(direccionCliente, that.direccionCliente) && Objects.equals(estado, that.estado) && Objects.equals(tipoCliente, that.tipoCliente) && Objects.equals(cuentaBanco, that.cuentaBanco) && Objects.equals(tipoPersonaRelacionadaTipoId, that.tipoPersonaRelacionadaTipoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, direccionCliente, estado, tipoCliente, cuentaBanco, tipoPersonaRelacionadaTipoId);
    }
}
