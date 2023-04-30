package es.taw.proyectotaw.Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "usuario", schema = "mydb", catalog = "")
public class UsuarioEntity
{
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
    @JoinColumn(name = "cuenta_banco_id_cuenta_banco", referencedColumnName = "id_cuenta_banco", nullable = false)
    private CuentabancoEntity cuentabancoByCuentaBancoIdCuentaBanco;
    @ManyToOne
    @JoinColumn(name = "Empresa_id_empresa", referencedColumnName = "id_empresa", nullable = false)
    private EmpresaEntity empresaByEmpresaIdEmpresa;
    @ManyToOne
    @JoinColumn(name = "Direccion_id_direccion", referencedColumnName = "id_direccion", nullable = false)
    private DireccionEntity direccionByDireccionIdDireccion;

    public Integer getIdUsuario()
    {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario)
    {
        this.idUsuario = idUsuario;
    }

    public String getNif()
    {
        return nif;
    }

    public void setNif(String nif)
    {
        this.nif = nif;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getSegundoNombre()
    {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre)
    {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido()
    {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido)
    {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido()
    {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido)
    {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimiento()
    {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento)
    {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getContrasena()
    {
        return contrasena;
    }

    public void setContrasena(String contrasena)
    {
        this.contrasena = contrasena;
    }

    public Date getFechaInicio()
    {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio)
    {
        this.fechaInicio = fechaInicio;
    }

    public String getTipoUsuario()
    {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario)
    {
        this.tipoUsuario = tipoUsuario;
    }

    public String getEstadoUsuario()
    {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario)
    {
        this.estadoUsuario = estadoUsuario;
    }

    public String getTipoPersonaRelacionada()
    {
        return tipoPersonaRelacionada;
    }

    public void setTipoPersonaRelacionada(String tipoPersonaRelacionada)
    {
        this.tipoPersonaRelacionada = tipoPersonaRelacionada;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioEntity that = (UsuarioEntity) o;

        if (idUsuario != null ? !idUsuario.equals(that.idUsuario) : that.idUsuario != null) return false;
        if (nif != null ? !nif.equals(that.nif) : that.nif != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (segundoNombre != null ? !segundoNombre.equals(that.segundoNombre) : that.segundoNombre != null)
            return false;
        if (primerApellido != null ? !primerApellido.equals(that.primerApellido) : that.primerApellido != null)
            return false;
        if (segundoApellido != null ? !segundoApellido.equals(that.segundoApellido) : that.segundoApellido != null)
            return false;
        if (fechaNacimiento != null ? !fechaNacimiento.equals(that.fechaNacimiento) : that.fechaNacimiento != null)
            return false;
        if (contrasena != null ? !contrasena.equals(that.contrasena) : that.contrasena != null) return false;
        if (fechaInicio != null ? !fechaInicio.equals(that.fechaInicio) : that.fechaInicio != null) return false;
        if (tipoUsuario != null ? !tipoUsuario.equals(that.tipoUsuario) : that.tipoUsuario != null) return false;
        if (estadoUsuario != null ? !estadoUsuario.equals(that.estadoUsuario) : that.estadoUsuario != null)
            return false;
        if (tipoPersonaRelacionada != null ? !tipoPersonaRelacionada.equals(that.tipoPersonaRelacionada) : that.tipoPersonaRelacionada != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = idUsuario != null ? idUsuario.hashCode() : 0;
        result = 31 * result + (nif != null ? nif.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (segundoNombre != null ? segundoNombre.hashCode() : 0);
        result = 31 * result + (primerApellido != null ? primerApellido.hashCode() : 0);
        result = 31 * result + (segundoApellido != null ? segundoApellido.hashCode() : 0);
        result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
        result = 31 * result + (contrasena != null ? contrasena.hashCode() : 0);
        result = 31 * result + (fechaInicio != null ? fechaInicio.hashCode() : 0);
        result = 31 * result + (tipoUsuario != null ? tipoUsuario.hashCode() : 0);
        result = 31 * result + (estadoUsuario != null ? estadoUsuario.hashCode() : 0);
        result = 31 * result + (tipoPersonaRelacionada != null ? tipoPersonaRelacionada.hashCode() : 0);
        return result;
    }

    public Collection<MensajeEntity> getMensajesByIdUsuario()
    {
        return mensajesByIdUsuario;
    }

    public void setMensajesByIdUsuario(Collection<MensajeEntity> mensajesByIdUsuario)
    {
        this.mensajesByIdUsuario = mensajesByIdUsuario;
    }

    public Collection<MensajeEntity> getMensajesByIdUsuario_0()
    {
        return mensajesByIdUsuario_0;
    }

    public void setMensajesByIdUsuario_0(Collection<MensajeEntity> mensajesByIdUsuario_0)
    {
        this.mensajesByIdUsuario_0 = mensajesByIdUsuario_0;
    }

    public Collection<PeticionEntity> getPeticionsByIdUsuario()
    {
        return peticionsByIdUsuario;
    }

    public void setPeticionsByIdUsuario(Collection<PeticionEntity> peticionsByIdUsuario)
    {
        this.peticionsByIdUsuario = peticionsByIdUsuario;
    }

    public CuentabancoEntity getCuentabancoByCuentaBancoIdCuentaBanco()
    {
        return cuentabancoByCuentaBancoIdCuentaBanco;
    }

    public void setCuentabancoByCuentaBancoIdCuentaBanco(CuentabancoEntity cuentabancoByCuentaBancoIdCuentaBanco)
    {
        this.cuentabancoByCuentaBancoIdCuentaBanco = cuentabancoByCuentaBancoIdCuentaBanco;
    }

    public EmpresaEntity getEmpresaByEmpresaIdEmpresa()
    {
        return empresaByEmpresaIdEmpresa;
    }

    public void setEmpresaByEmpresaIdEmpresa(EmpresaEntity empresaByEmpresaIdEmpresa)
    {
        this.empresaByEmpresaIdEmpresa = empresaByEmpresaIdEmpresa;
    }

    public DireccionEntity getDireccionByDireccionIdDireccion()
    {
        return direccionByDireccionIdDireccion;
    }

    public void setDireccionByDireccionIdDireccion(DireccionEntity direccionByDireccionIdDireccion)
    {
        this.direccionByDireccionIdDireccion = direccionByDireccionIdDireccion;
    }
}
