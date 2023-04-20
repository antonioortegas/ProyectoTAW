package es.taw.proyectotaw.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "peticion", schema = "mydb", catalog = "")
@IdClass(PeticionEntityPK.class)
public class PeticionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPeticion", nullable = false)
    private Integer idPeticion;
    @Basic
    @Column(name = "fechaPeticion", nullable = true)
    private Timestamp fechaPeticion;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "tipo", nullable = false)
    private Integer tipo;
    @OneToMany(mappedBy = "peticion")
    private Collection<UsuarioEntity> usuarioPeticion;
    @ManyToOne
    @JoinColumn(name = "tipo", referencedColumnName = "idTipoPeticion", nullable = false)
    private TipopeticionEntity tipopeticionByTipo;

    public Integer getIdPeticion() {
        return idPeticion;
    }

    public void setIdPeticion(Integer idPeticion) {
        this.idPeticion = idPeticion;
    }

    public Timestamp getFechaPeticion() {
        return fechaPeticion;
    }

    public void setFechaPeticion(Timestamp fechaPeticion) {
        this.fechaPeticion = fechaPeticion;
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
        PeticionEntity that = (PeticionEntity) o;
        return Objects.equals(idPeticion, that.idPeticion) && Objects.equals(fechaPeticion, that.fechaPeticion) && Objects.equals(tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPeticion, fechaPeticion, tipo);
    }

    public Collection<UsuarioEntity> getUsuarioPeticion() {
        return usuarioPeticion;
    }

    public void setUsuarioPeticion(Collection<UsuarioEntity> usuarioPeticion) {
        this.usuarioPeticion = usuarioPeticion;
    }

    public TipopeticionEntity getTipopeticionByTipo() {
        return tipopeticionByTipo;
    }

    public void setTipopeticionByTipo(TipopeticionEntity tipopeticionByTipo) {
        this.tipopeticionByTipo = tipopeticionByTipo;
    }
}
