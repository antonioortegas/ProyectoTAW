package es.taw.proyectotaw.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "usuario", schema = "mydb", catalog = "")
public class UsuarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;
    @Basic
    @Column(name = "nif", nullable = false, length = 45)
    private String nif;
    @Basic
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Basic
    @Column(name = "segundo_nombre", nullable = true, length = 45)
    private String segundoNombre;
    @Basic
    @Column(name = "primer_apellido", nullable = false, length = 45)
    private String primerApellido;
    @Basic
    @Column(name = "segundo_apellido", nullable = true, length = 45)
    private String segundoApellido;
    @Basic
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;
    @Basic
    @Column(name = "contrasena", nullable = false, length = 45)
    private String contrasena;
    @Basic
    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;
    @Basic
    @Column(name = "tipo_usuario", nullable = false, length = 45)
    private String tipoUsuario;
    @Basic
    @Column(name = "estado_usuario", nullable = false, length = 45)
    private String estadoUsuario;
    @Basic
    @Column(name = "tipo_persona_relacionada", nullable = true, length = 45)
    private String tipoPersonaRelacionada;
    @OneToMany(mappedBy = "usuarioByUsuarioIdUsuario")
    private Collection<PeticionEntity> peticionsByIdUsuario;
    @OneToMany(mappedBy = "usuarioByUsuarioIdUsuario")
    private Collection<ServiciochatEntity> serviciochatsByIdUsuario;
    @ManyToOne
    @JoinColumn(name = "cuenta_banco_id_cuenta_banco", referencedColumnName = "id_cuenta_banco", nullable = false)
    private CuentabancoEntity cuentabancoByCuentaBancoIdCuentaBanco;
    @ManyToOne
    @JoinColumn(name = "Empresa_id_empresa", referencedColumnName = "id_empresa", nullable = false)
    private EmpresaEntity empresaByEmpresaIdEmpresa;
    @ManyToOne
    @JoinColumn(name = "Direccion_id_direccion", referencedColumnName = "id_direccion", nullable = false)
    private DireccionEntity direccionByDireccionIdDireccion;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getTipoPersonaRelacionada() {
        return tipoPersonaRelacionada;
    }

    public void setTipoPersonaRelacionada(String tipoPersonaRelacionada) {
        this.tipoPersonaRelacionada = tipoPersonaRelacionada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return Objects.equals(idUsuario, that.idUsuario) && Objects.equals(nif, that.nif) && Objects.equals(nombre, that.nombre) && Objects.equals(segundoNombre, that.segundoNombre) && Objects.equals(primerApellido, that.primerApellido) && Objects.equals(segundoApellido, that.segundoApellido) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(contrasena, that.contrasena) && Objects.equals(fechaInicio, that.fechaInicio) && Objects.equals(tipoUsuario, that.tipoUsuario) && Objects.equals(estadoUsuario, that.estadoUsuario) && Objects.equals(tipoPersonaRelacionada, that.tipoPersonaRelacionada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nif, nombre, segundoNombre, primerApellido, segundoApellido, fechaNacimiento, contrasena, fechaInicio, tipoUsuario, estadoUsuario, tipoPersonaRelacionada);
    }

    public Collection<PeticionEntity> getPeticionsByIdUsuario() {
        return peticionsByIdUsuario;
    }

    public void setPeticionsByIdUsuario(Collection<PeticionEntity> peticionsByIdUsuario) {
        this.peticionsByIdUsuario = peticionsByIdUsuario;
    }

    public Collection<ServiciochatEntity> getServiciochatsByIdUsuario() {
        return serviciochatsByIdUsuario;
    }

    public void setServiciochatsByIdUsuario(Collection<ServiciochatEntity> serviciochatsByIdUsuario) {
        this.serviciochatsByIdUsuario = serviciochatsByIdUsuario;
    }

    public CuentabancoEntity getCuentabancoByCuentaBancoIdCuentaBanco() {
        return cuentabancoByCuentaBancoIdCuentaBanco;
    }

    public void setCuentabancoByCuentaBancoIdCuentaBanco(CuentabancoEntity cuentabancoByCuentaBancoIdCuentaBanco) {
        this.cuentabancoByCuentaBancoIdCuentaBanco = cuentabancoByCuentaBancoIdCuentaBanco;
    }

    public EmpresaEntity getEmpresaByEmpresaIdEmpresa() {
        return empresaByEmpresaIdEmpresa;
    }

    public void setEmpresaByEmpresaIdEmpresa(EmpresaEntity empresaByEmpresaIdEmpresa) {
        this.empresaByEmpresaIdEmpresa = empresaByEmpresaIdEmpresa;
    }

    public DireccionEntity getDireccionByDireccionIdDireccion() {
        return direccionByDireccionIdDireccion;
    }

    public void setDireccionByDireccionIdDireccion(DireccionEntity direccionByDireccionIdDireccion) {
        this.direccionByDireccionIdDireccion = direccionByDireccionIdDireccion;
    }
}
