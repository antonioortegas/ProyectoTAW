package es.taw.proyectotaw.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "peticion", schema = "mydb", catalog = "")
public class PeticionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_peticion", nullable = false)
    private Integer idPeticion;
    @Basic
    @Column(name = "tipo_peticion", nullable = false, length = 45)
    private String tipoPeticion;
    @Basic
    @Column(name = "fecha_peticion", nullable = true)
    private Timestamp fechaPeticion;
    @Basic
    @Column(name = "estado_peticion", nullable = false, length = 45)
    private String estadoPeticion;
    @ManyToOne
    @JoinColumn(name = "Usuario_id_usuario", referencedColumnName = "id_usuario")
    private UsuarioEntity usuarioByUsuarioIdUsuario;
    @ManyToOne
    @JoinColumn(name = "Empresa_id_empresa", referencedColumnName = "id_empresa")
    private EmpresaEntity empresaByEmpresaIdEmpresa;

    public Integer getIdPeticion() {
        return idPeticion;
    }

    public void setIdPeticion(Integer idPeticion) {
        this.idPeticion = idPeticion;
    }

    public String getTipoPeticion() {
        return tipoPeticion;
    }

    public void setTipoPeticion(String tipoPeticion) {
        this.tipoPeticion = tipoPeticion;
    }

    public Timestamp getFechaPeticion() {
        return fechaPeticion;
    }

    public void setFechaPeticion(Timestamp fechaPeticion) {
        this.fechaPeticion = fechaPeticion;
    }

    public String getEstadoPeticion() {
        return estadoPeticion;
    }

    public void setEstadoPeticion(String estadoPeticion) {
        this.estadoPeticion = estadoPeticion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PeticionEntity that = (PeticionEntity) o;

        if (idPeticion != null ? !idPeticion.equals(that.idPeticion) : that.idPeticion != null) return false;
        if (tipoPeticion != null ? !tipoPeticion.equals(that.tipoPeticion) : that.tipoPeticion != null) return false;
        if (fechaPeticion != null ? !fechaPeticion.equals(that.fechaPeticion) : that.fechaPeticion != null)
            return false;
        if (estadoPeticion != null ? !estadoPeticion.equals(that.estadoPeticion) : that.estadoPeticion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPeticion != null ? idPeticion.hashCode() : 0;
        result = 31 * result + (tipoPeticion != null ? tipoPeticion.hashCode() : 0);
        result = 31 * result + (fechaPeticion != null ? fechaPeticion.hashCode() : 0);
        result = 31 * result + (estadoPeticion != null ? estadoPeticion.hashCode() : 0);
        return result;
    }

    public UsuarioEntity getUsuarioByUsuarioIdUsuario() {
        return usuarioByUsuarioIdUsuario;
    }

    public void setUsuarioByUsuarioIdUsuario(UsuarioEntity usuarioByUsuarioIdUsuario) {
        this.usuarioByUsuarioIdUsuario = usuarioByUsuarioIdUsuario;
    }

    public EmpresaEntity getEmpresaByEmpresaIdEmpresa() {
        return empresaByEmpresaIdEmpresa;
    }

    public void setEmpresaByEmpresaIdEmpresa(EmpresaEntity empresaByEmpresaIdEmpresa) {
        this.empresaByEmpresaIdEmpresa = empresaByEmpresaIdEmpresa;
    }
}
