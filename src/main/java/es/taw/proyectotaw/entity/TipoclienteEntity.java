package es.taw.proyectotaw.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tipocliente", schema = "mydb", catalog = "")
public class TipoclienteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @OneToMany(mappedBy = "tipoclienteByTipoCliente")
    private Collection<UsuarioEntity> usuariosById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoclienteEntity that = (TipoclienteEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Collection<UsuarioEntity> getUsuariosById() {
        return usuariosById;
    }

    public void setUsuariosById(Collection<UsuarioEntity> usuariosById) {
        this.usuariosById = usuariosById;
    }
}
