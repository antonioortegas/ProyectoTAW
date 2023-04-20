package es.taw.proyectotaw.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "usuario", schema = "mydb", catalog = "")
@IdClass(UsuarioEntityPK.class)
public class UsuarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "NIF", nullable = false, length = 45)
    private String nif;
    @Basic
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Basic
    @Column(name = "segundoNombre", nullable = true, length = 45)
    private String segundoNombre;
    @Basic
    @Column(name = "primerApellido", nullable = false, length = 45)
    private String primerApellido;
    @Basic
    @Column(name = "segundoApellido", nullable = true, length = 45)
    private String segundoApellido;
    @Basic
    @Column(name = "fechaNacimiento", nullable = false)
    private Date fechaNacimiento;
    @Basic
    @Column(name = "contrasena", nullable = false, length = 45)
    private String contrasena;
    @Basic
    @Column(name = "fechaInicio", nullable = false)
    private Date fechaInicio;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "direccionCliente", nullable = false)
    private Integer direccionCliente;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "estado", nullable = false)
    private Integer estado;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "tipoCliente", nullable = false)
    private Integer tipoCliente;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cuentaBanco", nullable = false)
    private Integer cuentaBanco;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TipoPersonaRelacionada_tipoID", nullable = false)
    private Integer tipoPersonaRelacionadaTipoId;
    @OneToMany(mappedBy = "usuario")
    private Collection<EmpresaEntity> empresas;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "id", referencedColumnName = "Cliente_id", nullable = false), @JoinColumn(name = "direccionCliente", referencedColumnName = "Cliente_direccionCliente", nullable = false), @JoinColumn(name = "estado", referencedColumnName = "Cliente_estado", nullable = false), @JoinColumn(name = "tipoCliente", referencedColumnName = "Cliente_tipoCliente", nullable = false), @JoinColumn(name = "cuentaBanco", referencedColumnName = "Cliente_cuentaBanco", nullable = false)})
    private PeticionEntity peticion;
    @ManyToOne
    @JoinColumn(name = "direccionCliente", referencedColumnName = "id", nullable = false)
    private DireccionEntity direccionByDireccionCliente;
    @ManyToOne
    @JoinColumn(name = "estado", referencedColumnName = "idEstado", nullable = false)
    private TipoestadoclienteEntity tipoestadoclienteByEstado;
    @ManyToOne
    @JoinColumn(name = "tipoCliente", referencedColumnName = "id", nullable = false)
    private TipoclienteEntity tipoclienteByTipoCliente;
    @OneToMany(mappedBy = "usuarioByIdCuentaBanco")
    private Collection<CuentabancoEntity> cuentaBancoUsuarioByIdCuentaBanco;
    @ManyToOne
    @JoinColumn(name = "chatID", referencedColumnName = "idChat", nullable = false)
    private ChatEntity chatByChatId;
    @ManyToOne
    @JoinColumn(name = "TipoPersonaRelacionada_tipoID", referencedColumnName = "tipoID", nullable = false)
    private TipopersonarelacionadaEntity tipopersonarelacionadaByTipoPersonaRelacionadaTipoId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(Integer direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(Integer tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Integer getCuentaBanco() {
        return cuentaBanco;
    }

    public void setCuentaBanco(Integer cuentaBanco) {
        this.cuentaBanco = cuentaBanco;
    }

    public Integer getTipoPersonaRelacionadaTipoId() {
        return tipoPersonaRelacionadaTipoId;
    }

    public void setTipoPersonaRelacionadaTipoId(Integer tipoPersonaRelacionadaTipoId) {
        this.tipoPersonaRelacionadaTipoId = tipoPersonaRelacionadaTipoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nif, that.nif) && Objects.equals(nombre, that.nombre) && Objects.equals(segundoNombre, that.segundoNombre) && Objects.equals(primerApellido, that.primerApellido) && Objects.equals(segundoApellido, that.segundoApellido) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(contrasena, that.contrasena) && Objects.equals(fechaInicio, that.fechaInicio) && Objects.equals(direccionCliente, that.direccionCliente) && Objects.equals(estado, that.estado) && Objects.equals(tipoCliente, that.tipoCliente) && Objects.equals(cuentaBanco, that.cuentaBanco) && Objects.equals(tipoPersonaRelacionadaTipoId, that.tipoPersonaRelacionadaTipoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nif, nombre, segundoNombre, primerApellido, segundoApellido, fechaNacimiento, contrasena, fechaInicio, direccionCliente, estado, tipoCliente, cuentaBanco, tipoPersonaRelacionadaTipoId);
    }

    public Collection<EmpresaEntity> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Collection<EmpresaEntity> empresas) {
        this.empresas = empresas;
    }

    public PeticionEntity getPeticion() {
        return peticion;
    }

    public void setPeticion(PeticionEntity peticion) {
        this.peticion = peticion;
    }

    public DireccionEntity getDireccionByDireccionCliente() {
        return direccionByDireccionCliente;
    }

    public void setDireccionByDireccionCliente(DireccionEntity direccionByDireccionCliente) {
        this.direccionByDireccionCliente = direccionByDireccionCliente;
    }

    public TipoestadoclienteEntity getTipoestadoclienteByEstado() {
        return tipoestadoclienteByEstado;
    }

    public void setTipoestadoclienteByEstado(TipoestadoclienteEntity tipoestadoclienteByEstado) {
        this.tipoestadoclienteByEstado = tipoestadoclienteByEstado;
    }

    public TipoclienteEntity getTipoclienteByTipoCliente() {
        return tipoclienteByTipoCliente;
    }

    public void setTipoclienteByTipoCliente(TipoclienteEntity tipoclienteByTipoCliente) {
        this.tipoclienteByTipoCliente = tipoclienteByTipoCliente;
    }

    public Collection<CuentabancoEntity> getCuentaBancoUsuarioByIdCuentaBanco() {
        return cuentaBancoUsuarioByIdCuentaBanco;
    }

    public void setCuentaBancoUsuarioByIdCuentaBanco(Collection<CuentabancoEntity> cuentaBancoUsuarioByIdCuentaBanco) {
        this.cuentaBancoUsuarioByIdCuentaBanco = cuentaBancoUsuarioByIdCuentaBanco;
    }

    public ChatEntity getChatByChatId() {
        return chatByChatId;
    }

    public void setChatByChatId(ChatEntity chatByChatId) {
        this.chatByChatId = chatByChatId;
    }

    public TipopersonarelacionadaEntity getTipopersonarelacionadaByTipoPersonaRelacionadaTipoId() {
        return tipopersonarelacionadaByTipoPersonaRelacionadaTipoId;
    }

    public void setTipopersonarelacionadaByTipoPersonaRelacionadaTipoId(TipopersonarelacionadaEntity tipopersonarelacionadaByTipoPersonaRelacionadaTipoId) {
        this.tipopersonarelacionadaByTipoPersonaRelacionadaTipoId = tipopersonarelacionadaByTipoPersonaRelacionadaTipoId;
    }
}
