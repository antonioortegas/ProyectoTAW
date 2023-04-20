package es.taw.proyectotaw.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PersonarelacionadaHasTipopersonarelacionadaEntityPK implements Serializable {
    @Column(name = "PersonaRelacionada_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personaRelacionadaId;
    @Column(name = "TipoPersonaRelacionada_tipoID", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tipoPersonaRelacionadaTipoId;

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
        PersonarelacionadaHasTipopersonarelacionadaEntityPK that = (PersonarelacionadaHasTipopersonarelacionadaEntityPK) o;
        return Objects.equals(personaRelacionadaId, that.personaRelacionadaId) && Objects.equals(tipoPersonaRelacionadaTipoId, that.tipoPersonaRelacionadaTipoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personaRelacionadaId, tipoPersonaRelacionadaTipoId);
    }
}
