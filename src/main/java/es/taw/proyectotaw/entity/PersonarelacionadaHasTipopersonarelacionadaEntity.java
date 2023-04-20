package es.taw.proyectotaw.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "personarelacionada_has_tipopersonarelacionada", schema = "mydb", catalog = "")
@IdClass(PersonarelacionadaHasTipopersonarelacionadaEntityPK.class)
public class PersonarelacionadaHasTipopersonarelacionadaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PersonaRelacionada_id", nullable = false)
    private Integer personaRelacionadaId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TipoPersonaRelacionada_tipoID", nullable = false)
    private Integer tipoPersonaRelacionadaTipoId;
    @ManyToOne
    @JoinColumn(name = "TipoPersonaRelacionada_tipoID", referencedColumnName = "tipoID", nullable = false)
    private TipopersonarelacionadaEntity tipopersonarelacionadaByTipoPersonaRelacionadaTipoId;

    public Integer getPersonaRelacionadaId() {
        return personaRelacionadaId;
    }

    public void setPersonaRelacionadaId(Integer personaRelacionadaId) {
        this.personaRelacionadaId = personaRelacionadaId;
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
        PersonarelacionadaHasTipopersonarelacionadaEntity that = (PersonarelacionadaHasTipopersonarelacionadaEntity) o;
        return Objects.equals(personaRelacionadaId, that.personaRelacionadaId) && Objects.equals(tipoPersonaRelacionadaTipoId, that.tipoPersonaRelacionadaTipoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personaRelacionadaId, tipoPersonaRelacionadaTipoId);
    }

    public TipopersonarelacionadaEntity getTipopersonarelacionadaByTipoPersonaRelacionadaTipoId() {
        return tipopersonarelacionadaByTipoPersonaRelacionadaTipoId;
    }

    public void setTipopersonarelacionadaByTipoPersonaRelacionadaTipoId(TipopersonarelacionadaEntity tipopersonarelacionadaByTipoPersonaRelacionadaTipoId) {
        this.tipopersonarelacionadaByTipoPersonaRelacionadaTipoId = tipopersonarelacionadaByTipoPersonaRelacionadaTipoId;
    }
}
