package es.taw.proyectotaw.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "empresa", schema = "mydb", catalog = "")
public class EmpresaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEmpresa", nullable = false)
    private Integer idEmpresa;
    @Basic
    @Column(name = "CIF", nullable = true, length = 45)
    private String cif;
    @Basic
    @Column(name = "Nombre", nullable = true, length = 45)
    private String nombre;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "Usuario_id", referencedColumnName = "id", nullable = false), @JoinColumn(name = "Usuario_direccionCliente", referencedColumnName = "direccionCliente", nullable = false), @JoinColumn(name = "Usuario_estado", referencedColumnName = "estado", nullable = false), @JoinColumn(name = "Usuario_tipoCliente", referencedColumnName = "tipoCliente", nullable = false), @JoinColumn(name = "Usuario_cuentaBanco", referencedColumnName = "cuentaBanco", nullable = false), @JoinColumn(name = "Usuario_TipoPersonaRelacionada_tipoID", referencedColumnName = "TipoPersonaRelacionada_tipoID", nullable = false)})
    private UsuarioEntity usuario;

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
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
        EmpresaEntity that = (EmpresaEntity) o;
        return Objects.equals(idEmpresa, that.idEmpresa) && Objects.equals(cif, that.cif) && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmpresa, cif, nombre);
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
}
