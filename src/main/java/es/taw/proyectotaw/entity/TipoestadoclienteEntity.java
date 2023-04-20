package es.taw.proyectotaw.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tipoestadocliente", schema = "mydb", catalog = "")
public class TipoestadoclienteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEstado", nullable = false)
    private Integer idEstado;
    @Basic
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @OneToMany(mappedBy = "tipoestadoclienteByEstado")
    private Collection<UsuarioEntity> usuariosByIdEstado;

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoestadoclienteEntity that = (TipoestadoclienteEntity) o;
        return Objects.equals(idEstado, that.idEstado) && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstado, nombre);
    }

    public Collection<UsuarioEntity> getUsuariosByIdEstado() {
        return usuariosByIdEstado;
    }

    public void setUsuariosByIdEstado(Collection<UsuarioEntity> usuariosByIdEstado) {
        this.usuariosByIdEstado = usuariosByIdEstado;
    }
}
