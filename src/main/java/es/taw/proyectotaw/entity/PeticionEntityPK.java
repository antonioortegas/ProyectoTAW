package es.taw.proyectotaw.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PeticionEntityPK implements Serializable {
    @Column(name = "idPeticion", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPeticion;
    @Column(name = "tipo", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tipo;

    public Integer getIdPeticion() {
        return idPeticion;
    }

    public void setIdPeticion(Integer idPeticion) {
        this.idPeticion = idPeticion;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeticionEntityPK that = (PeticionEntityPK) o;
        return Objects.equals(idPeticion, that.idPeticion) && Objects.equals(tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPeticion, tipo);
    }
}
