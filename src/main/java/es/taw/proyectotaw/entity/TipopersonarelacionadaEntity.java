package es.taw.proyectotaw.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tipopersonarelacionada", schema = "mydb", catalog = "")
public class TipopersonarelacionadaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "tipoID", nullable = false)
    private Integer tipoId;
    @Basic
    @Column(name = "tipo", nullable = true, length = 45)
    private String tipo;
    @OneToMany(mappedBy = "tipopersonarelacionadaByTipoPersonaRelacionadaTipoId")
    private Collection<PersonarelacionadaHasTipopersonarelacionadaEntity> personarelacionadaHasTipopersonarelacionadasByTipoId;
    @OneToMany(mappedBy = "tipopersonarelacionadaByTipoPersonaRelacionadaTipoId")
    private Collection<UsuarioEntity> usuariosByTipoId;

    public Integer getTipoId() {
        return tipoId;
    }

    public void setTipoId(Integer tipoId) {
        this.tipoId = tipoId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipopersonarelacionadaEntity that = (TipopersonarelacionadaEntity) o;
        return Objects.equals(tipoId, that.tipoId) && Objects.equals(tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoId, tipo);
    }

    public Collection<PersonarelacionadaHasTipopersonarelacionadaEntity> getPersonarelacionadaHasTipopersonarelacionadasByTipoId() {
        return personarelacionadaHasTipopersonarelacionadasByTipoId;
    }

    public void setPersonarelacionadaHasTipopersonarelacionadasByTipoId(Collection<PersonarelacionadaHasTipopersonarelacionadaEntity> personarelacionadaHasTipopersonarelacionadasByTipoId) {
        this.personarelacionadaHasTipopersonarelacionadasByTipoId = personarelacionadaHasTipopersonarelacionadasByTipoId;
    }

    public Collection<UsuarioEntity> getUsuariosByTipoId() {
        return usuariosByTipoId;
    }

    public void setUsuariosByTipoId(Collection<UsuarioEntity> usuariosByTipoId) {
        this.usuariosByTipoId = usuariosByTipoId;
    }
}
