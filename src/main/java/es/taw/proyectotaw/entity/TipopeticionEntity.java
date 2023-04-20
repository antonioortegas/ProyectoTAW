package es.taw.proyectotaw.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tipopeticion", schema = "mydb", catalog = "")
public class TipopeticionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idTipoPeticion", nullable = false)
    private Integer idTipoPeticion;
    @Basic
    @Column(name = "tipoPeticion", nullable = false, length = 80)
    private String tipoPeticion;
    @OneToMany(mappedBy = "tipopeticionByTipo")
    private Collection<PeticionEntity> peticionsByIdTipoPeticion;

    public Integer getIdTipoPeticion() {
        return idTipoPeticion;
    }

    public void setIdTipoPeticion(Integer idTipoPeticion) {
        this.idTipoPeticion = idTipoPeticion;
    }

    public String getTipoPeticion() {
        return tipoPeticion;
    }

    public void setTipoPeticion(String tipoPeticion) {
        this.tipoPeticion = tipoPeticion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipopeticionEntity that = (TipopeticionEntity) o;
        return Objects.equals(idTipoPeticion, that.idTipoPeticion) && Objects.equals(tipoPeticion, that.tipoPeticion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTipoPeticion, tipoPeticion);
    }

    public Collection<PeticionEntity> getPeticionsByIdTipoPeticion() {
        return peticionsByIdTipoPeticion;
    }

    public void setPeticionsByIdTipoPeticion(Collection<PeticionEntity> peticionsByIdTipoPeticion) {
        this.peticionsByIdTipoPeticion = peticionsByIdTipoPeticion;
    }
}
