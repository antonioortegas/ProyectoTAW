package es.taw.proyectotaw.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "cuentabanco", schema = "mydb", catalog = "")
@IdClass(CuentabancoEntityPK.class)
public class CuentabancoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCuentaBanco", nullable = false)
    private Integer idCuentaBanco;
    @Basic
    @Column(name = "numeroCuenta", nullable = false, length = 45)
    private String numeroCuenta;
    @Basic
    @Column(name = "estadoCuenta", nullable = false)
    private Integer estadoCuenta;
    @Basic
    @Column(name = "fechaApertura", nullable = false)
    private Date fechaApertura;
    @Basic
    @Column(name = "fechaCierre", nullable = true)
    private Date fechaCierre;
    @Basic
    @Column(name = "tipoMoneda", nullable = false, length = 45)
    private String tipoMoneda;
    @Basic
    @Column(name = "iban", nullable = false, length = 45)
    private String iban;
    @Basic
    @Column(name = "pais", nullable = false, length = 45)
    private String pais;
    @Basic
    @Column(name = "sospechoso", nullable = false)
    private Byte sospechoso;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "estado", nullable = false)
    private Integer estado;
    @ManyToOne
    @JoinColumn(name = "estado", referencedColumnName = "idTipoEstadoCuenta", nullable = false)
    private TipoestadocuentaEntity tipoestadocuentaByEstado;
    @OneToMany(mappedBy = "cuentabanco")
    private Collection<TransaccionEntity> transaccions;
    @ManyToOne
    @JoinColumn(name = "idCuentaBanco", referencedColumnName = "cuentaBanco", nullable = false)
    private UsuarioEntity usuarioByIdCuentaBanco;

    public Integer getIdCuentaBanco() {
        return idCuentaBanco;
    }

    public void setIdCuentaBanco(Integer idCuentaBanco) {
        this.idCuentaBanco = idCuentaBanco;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Integer getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(Integer estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Byte getSospechoso() {
        return sospechoso;
    }

    public void setSospechoso(Byte sospechoso) {
        this.sospechoso = sospechoso;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuentabancoEntity that = (CuentabancoEntity) o;
        return Objects.equals(idCuentaBanco, that.idCuentaBanco) && Objects.equals(numeroCuenta, that.numeroCuenta) && Objects.equals(estadoCuenta, that.estadoCuenta) && Objects.equals(fechaApertura, that.fechaApertura) && Objects.equals(fechaCierre, that.fechaCierre) && Objects.equals(tipoMoneda, that.tipoMoneda) && Objects.equals(iban, that.iban) && Objects.equals(pais, that.pais) && Objects.equals(sospechoso, that.sospechoso) && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCuentaBanco, numeroCuenta, estadoCuenta, fechaApertura, fechaCierre, tipoMoneda, iban, pais, sospechoso, estado);
    }

    public TipoestadocuentaEntity getTipoestadocuentaByEstado() {
        return tipoestadocuentaByEstado;
    }

    public void setTipoestadocuentaByEstado(TipoestadocuentaEntity tipoestadocuentaByEstado) {
        this.tipoestadocuentaByEstado = tipoestadocuentaByEstado;
    }

    public Collection<TransaccionEntity> getTransaccions() {
        return transaccions;
    }

    public void setTransaccions(Collection<TransaccionEntity> transaccions) {
        this.transaccions = transaccions;
    }

    public UsuarioEntity getUsuarioByIdCuentaBanco() {
        return usuarioByIdCuentaBanco;
    }

    public void setUsuarioByIdCuentaBanco(UsuarioEntity usuarioByIdCuentaBanco) {
        this.usuarioByIdCuentaBanco = usuarioByIdCuentaBanco;
    }
}
