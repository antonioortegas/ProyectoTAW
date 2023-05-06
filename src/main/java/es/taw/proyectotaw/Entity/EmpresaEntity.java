package es.taw.proyectotaw.Entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "empresa", schema = "mydb", catalog = "")
public class EmpresaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_empresa", nullable = false)
    private Integer idEmpresa;
    @Basic
    @Column(name = "cif", nullable = false, length = 45)
    private String cif;
    @Basic
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Basic
    @Column(name = "estado_empresa", nullable = false, length = 45)
    private String estadoEmpresa;
    @ManyToOne
    @JoinColumn(name = "Direccion_id_direccion", referencedColumnName = "id_direccion", nullable = false)
    private DireccionEntity direccionByDireccionIdDireccion;
    @ManyToOne
    @JoinColumn(name = "cuenta_empresa_id_cuenta_banco", referencedColumnName = "id_cuenta_banco")
    private CuentabancoEntity cuentabancoByCuentaEmpresaIdCuentaBanco;
    @OneToMany(mappedBy = "empresaByEmpresaIdEmpresa")
    private Collection<PeticionEntity> peticionsByIdEmpresa;
    @OneToMany(mappedBy = "empresaByEmpresaIdEmpresa")
    private Collection<UsuarioEntity> usuariosByIdEmpresa;

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

    public String getEstadoEmpresa() {
        return estadoEmpresa;
    }

    public void setEstadoEmpresa(String estadoEmpresa) {
        this.estadoEmpresa = estadoEmpresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpresaEntity that = (EmpresaEntity) o;
        return Objects.equals(idEmpresa, that.idEmpresa) && Objects.equals(cif, that.cif) && Objects.equals(nombre, that.nombre) && Objects.equals(estadoEmpresa, that.estadoEmpresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmpresa, cif, nombre, estadoEmpresa);
    }

    public DireccionEntity getDireccionByDireccionIdDireccion() {
        return direccionByDireccionIdDireccion;
    }

    public void setDireccionByDireccionIdDireccion(DireccionEntity direccionByDireccionIdDireccion) {
        this.direccionByDireccionIdDireccion = direccionByDireccionIdDireccion;
    }

    public CuentabancoEntity getCuentabancoByCuentaEmpresaIdCuentaBanco() {
        return cuentabancoByCuentaEmpresaIdCuentaBanco;
    }

    public void setCuentabancoByCuentaEmpresaIdCuentaBanco(CuentabancoEntity cuentabancoByCuentaEmpresaIdCuentaBanco) {
        this.cuentabancoByCuentaEmpresaIdCuentaBanco = cuentabancoByCuentaEmpresaIdCuentaBanco;
    }

    public Collection<PeticionEntity> getPeticionsByIdEmpresa() {
        return peticionsByIdEmpresa;
    }

    public void setPeticionsByIdEmpresa(Collection<PeticionEntity> peticionsByIdEmpresa) {
        this.peticionsByIdEmpresa = peticionsByIdEmpresa;
    }

    public Collection<UsuarioEntity> getUsuariosByIdEmpresa() {
        return usuariosByIdEmpresa;
    }

    public void setUsuariosByIdEmpresa(Collection<UsuarioEntity> usuariosByIdEmpresa) {
        this.usuariosByIdEmpresa = usuariosByIdEmpresa;
    }
}
