package es.taw.proyectotaw.Entity;

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
    @OneToMany(mappedBy = "usuarioByUsuarioDestino")
    private Collection<MensajeEntity> mensajesByIdUsuario;
    @OneToMany(mappedBy = "usuarioByUsuarioOrigen")
    private Collection<MensajeEntity> mensajesByIdUsuario_0;
    @OneToMany(mappedBy = "usuarioByUsuarioIdUsuario")
    private Collection<PeticionEntity> peticionsByIdUsuario;
    @ManyToOne
    @JoinColumn(name = "cuenta_banco_id_cuenta_banco", referencedColumnName = "id_cuenta_banco")
    private CuentabancoEntity cuentabancoByCuentaBancoIdCuentaBanco;
    @ManyToOne
    @JoinColumn(name = "Empresa_id_empresa", referencedColumnName = "id_empresa")
    private EmpresaEntity empresaByEmpresaIdEmpresa;
    @ManyToOne
    @JoinColumn(name = "Direccion_id_direccion", referencedColumnName = "id_direccion", nullable = false)
    private DireccionEntity direccionByDireccionIdDireccion;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_usuario", nullable = false)
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Basic
    @Column(name = "nif", nullable = false, length = 45)
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Basic
    @Column(name = "nombre", nullable = false, length = 45)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "segundo_nombre", nullable = true, length = 45)
    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    @Basic
    @Column(name = "primer_apellido", nullable = false, length = 45)
    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    @Basic
    @Column(name = "segundo_apellido", nullable = true, length = 45)
    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    @Basic
    @Column(name = "fecha_nacimiento", nullable = false)
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Basic
    @Column(name = "contrasena", nullable = false, length = 45)
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Basic
    @Column(name = "fecha_inicio", nullable = false)
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Basic
    @Column(name = "tipo_usuario", nullable = false, length = 45)
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Basic
    @Column(name = "estado_usuario", nullable = false, length = 45)
    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    @Basic
    @Column(name = "tipo_persona_relacionada", nullable = true, length = 45)
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
        UsuarioEntity usuario = (UsuarioEntity) o;
        return Objects.equals(idUsuario, usuario.idUsuario) && Objects.equals(nif, usuario.nif) && Objects.equals(nombre, usuario.nombre) && Objects.equals(segundoNombre, usuario.segundoNombre) && Objects.equals(primerApellido, usuario.primerApellido) && Objects.equals(segundoApellido, usuario.segundoApellido) && Objects.equals(fechaNacimiento, usuario.fechaNacimiento) && Objects.equals(contrasena, usuario.contrasena) && Objects.equals(fechaInicio, usuario.fechaInicio) && Objects.equals(tipoUsuario, usuario.tipoUsuario) && Objects.equals(estadoUsuario, usuario.estadoUsuario) && Objects.equals(tipoPersonaRelacionada, usuario.tipoPersonaRelacionada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nif, nombre, segundoNombre, primerApellido, segundoApellido, fechaNacimiento, contrasena, fechaInicio, tipoUsuario, estadoUsuario, tipoPersonaRelacionada);
    }

    @OneToMany(mappedBy = "usuarioByUsuarioDestino")
    public Collection<MensajeEntity> getMensajesByIdUsuario() {
        return mensajesByIdUsuario;
    }

    public void setMensajesByIdUsuario(Collection<MensajeEntity> mensajesByIdUsuario) {
        this.mensajesByIdUsuario = mensajesByIdUsuario;
    }

    @OneToMany(mappedBy = "usuarioByUsuarioOrigen")
    public Collection<MensajeEntity> getMensajesByIdUsuario_0() {
        return mensajesByIdUsuario_0;
    }

    public void setMensajesByIdUsuario_0(Collection<MensajeEntity> mensajesByIdUsuario_0) {
        this.mensajesByIdUsuario_0 = mensajesByIdUsuario_0;
    }

    @OneToMany(mappedBy = "usuarioByUsuarioIdUsuario")
    public Collection<PeticionEntity> getPeticionsByIdUsuario() {
        return peticionsByIdUsuario;
    }

    public void setPeticionsByIdUsuario(Collection<PeticionEntity> peticionsByIdUsuario) {
        this.peticionsByIdUsuario = peticionsByIdUsuario;
    }

    @ManyToOne
    @JoinColumn(name = "cuenta_banco_id_cuenta_banco", referencedColumnName = "id_cuenta_banco")
    public CuentabancoEntity getCuentabancoByCuentaBancoIdCuentaBanco() {
        return cuentabancoByCuentaBancoIdCuentaBanco;
    }

    public void setCuentabancoByCuentaBancoIdCuentaBanco(CuentabancoEntity cuentabancoByCuentaBancoIdCuentaBanco) {
        this.cuentabancoByCuentaBancoIdCuentaBanco = cuentabancoByCuentaBancoIdCuentaBanco;
    }

    @ManyToOne
    @JoinColumn(name = "Empresa_id_empresa", referencedColumnName = "id_empresa")
    public EmpresaEntity getEmpresaByEmpresaIdEmpresa() {
        return empresaByEmpresaIdEmpresa;
    }

    public void setEmpresaByEmpresaIdEmpresa(EmpresaEntity empresaByEmpresaIdEmpresa) {
        this.empresaByEmpresaIdEmpresa = empresaByEmpresaIdEmpresa;
    }

    @ManyToOne
    @JoinColumn(name = "Direccion_id_direccion", referencedColumnName = "id_direccion", nullable = false)
    public DireccionEntity getDireccionByDireccionIdDireccion() {
        return direccionByDireccionIdDireccion;
    }

    public void setDireccionByDireccionIdDireccion(DireccionEntity direccionByDireccionIdDireccion) {
        this.direccionByDireccionIdDireccion = direccionByDireccionIdDireccion;
    }
}
