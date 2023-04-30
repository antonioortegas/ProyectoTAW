package es.taw.proyectotaw.Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "cuentabanco", schema = "mydb", catalog = "")
public class CuentabancoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_cuenta_banco", nullable = false)
    private Integer idCuentaBanco;
    @Basic
    @Column(name = "numero_cuenta", nullable = false, length = 45)
    private String numeroCuenta;
    @Basic
    @Column(name = "saldo", nullable = false)
    private Integer saldo;
    @Basic
    @Column(name = "estado_cuenta", nullable = false)
    private Integer estadoCuenta;
    @Basic
    @Column(name = "fecha_apertura", nullable = false)
    private Date fechaApertura;
    @Basic
    @Column(name = "fecha_cierre", nullable = true)
    private Date fechaCierre;
    @Basic
    @Column(name = "tipo_moneda", nullable = false, length = 45)
    private String tipoMoneda;
    @Basic
    @Column(name = "iban", nullable = false, length = 45)
    private String iban;
    @Basic
    @Column(name = "pais", nullable = false, length = 45)
    private String pais;
    @Basic
    @Column(name = "sospechoso", nullable = false)
    private Integer sospechoso;
    @OneToMany(mappedBy = "cuentabancoByCuentaBancoIdCuentaBanco")
    private Collection<TransaccionEntity> transaccionsByIdCuentaBanco;
    @OneToMany(mappedBy = "cuentabancoByCuentaBancoIdCuentaBanco")
    private Collection<UsuarioEntity> usuariosByIdCuentaBanco;

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

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
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

    public Integer getSospechoso() {
        return sospechoso;
    }

    public void setSospechoso(Integer sospechoso) {
        this.sospechoso = sospechoso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuentabancoEntity that = (CuentabancoEntity) o;
        return Objects.equals(idCuentaBanco, that.idCuentaBanco) && Objects.equals(numeroCuenta, that.numeroCuenta) && Objects.equals(saldo, that.saldo) && Objects.equals(estadoCuenta, that.estadoCuenta) && Objects.equals(fechaApertura, that.fechaApertura) && Objects.equals(fechaCierre, that.fechaCierre) && Objects.equals(tipoMoneda, that.tipoMoneda) && Objects.equals(iban, that.iban) && Objects.equals(pais, that.pais) && Objects.equals(sospechoso, that.sospechoso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCuentaBanco, numeroCuenta, saldo, estadoCuenta, fechaApertura, fechaCierre, tipoMoneda, iban, pais, sospechoso);
    }

    public Collection<TransaccionEntity> getTransaccionsByIdCuentaBanco() {
        return transaccionsByIdCuentaBanco;
    }

    public void setTransaccionsByIdCuentaBanco(Collection<TransaccionEntity> transaccionsByIdCuentaBanco) {
        this.transaccionsByIdCuentaBanco = transaccionsByIdCuentaBanco;
    }

    public Collection<UsuarioEntity> getUsuariosByIdCuentaBanco() {
        return usuariosByIdCuentaBanco;
    }

    public void setUsuariosByIdCuentaBanco(Collection<UsuarioEntity> usuariosByIdCuentaBanco) {
        this.usuariosByIdCuentaBanco = usuariosByIdCuentaBanco;
    }
}
