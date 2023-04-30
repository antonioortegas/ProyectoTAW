package es.taw.proyectotaw.Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "cuentabanco", schema = "mydb", catalog = "")
public class CuentabancoEntity
{
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
    private Byte sospechoso;
    @OneToMany(mappedBy = "cuentabancoByCuentaBancoIdCuentaBanco")
    private Collection<TransaccionEntity> transaccionsByIdCuentaBanco;
    @OneToMany(mappedBy = "cuentabancoByCuentaBancoIdCuentaBanco")
    private Collection<UsuarioEntity> usuariosByIdCuentaBanco;

    public Integer getIdCuentaBanco()
    {
        return idCuentaBanco;
    }

    public void setIdCuentaBanco(Integer idCuentaBanco)
    {
        this.idCuentaBanco = idCuentaBanco;
    }

    public String getNumeroCuenta()
    {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta)
    {
        this.numeroCuenta = numeroCuenta;
    }

    public Integer getSaldo()
    {
        return saldo;
    }

    public void setSaldo(Integer saldo)
    {
        this.saldo = saldo;
    }

    public Integer getEstadoCuenta()
    {
        return estadoCuenta;
    }

    public void setEstadoCuenta(Integer estadoCuenta)
    {
        this.estadoCuenta = estadoCuenta;
    }

    public Date getFechaApertura()
    {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura)
    {
        this.fechaApertura = fechaApertura;
    }

    public Date getFechaCierre()
    {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre)
    {
        this.fechaCierre = fechaCierre;
    }

    public String getTipoMoneda()
    {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda)
    {
        this.tipoMoneda = tipoMoneda;
    }

    public String getIban()
    {
        return iban;
    }

    public void setIban(String iban)
    {
        this.iban = iban;
    }

    public String getPais()
    {
        return pais;
    }

    public void setPais(String pais)
    {
        this.pais = pais;
    }

    public Byte getSospechoso()
    {
        return sospechoso;
    }

    public void setSospechoso(Byte sospechoso)
    {
        this.sospechoso = sospechoso;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CuentabancoEntity that = (CuentabancoEntity) o;

        if (idCuentaBanco != null ? !idCuentaBanco.equals(that.idCuentaBanco) : that.idCuentaBanco != null)
            return false;
        if (numeroCuenta != null ? !numeroCuenta.equals(that.numeroCuenta) : that.numeroCuenta != null) return false;
        if (saldo != null ? !saldo.equals(that.saldo) : that.saldo != null) return false;
        if (estadoCuenta != null ? !estadoCuenta.equals(that.estadoCuenta) : that.estadoCuenta != null) return false;
        if (fechaApertura != null ? !fechaApertura.equals(that.fechaApertura) : that.fechaApertura != null)
            return false;
        if (fechaCierre != null ? !fechaCierre.equals(that.fechaCierre) : that.fechaCierre != null) return false;
        if (tipoMoneda != null ? !tipoMoneda.equals(that.tipoMoneda) : that.tipoMoneda != null) return false;
        if (iban != null ? !iban.equals(that.iban) : that.iban != null) return false;
        if (pais != null ? !pais.equals(that.pais) : that.pais != null) return false;
        if (sospechoso != null ? !sospechoso.equals(that.sospechoso) : that.sospechoso != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = idCuentaBanco != null ? idCuentaBanco.hashCode() : 0;
        result = 31 * result + (numeroCuenta != null ? numeroCuenta.hashCode() : 0);
        result = 31 * result + (saldo != null ? saldo.hashCode() : 0);
        result = 31 * result + (estadoCuenta != null ? estadoCuenta.hashCode() : 0);
        result = 31 * result + (fechaApertura != null ? fechaApertura.hashCode() : 0);
        result = 31 * result + (fechaCierre != null ? fechaCierre.hashCode() : 0);
        result = 31 * result + (tipoMoneda != null ? tipoMoneda.hashCode() : 0);
        result = 31 * result + (iban != null ? iban.hashCode() : 0);
        result = 31 * result + (pais != null ? pais.hashCode() : 0);
        result = 31 * result + (sospechoso != null ? sospechoso.hashCode() : 0);
        return result;
    }

    public Collection<TransaccionEntity> getTransaccionsByIdCuentaBanco()
    {
        return transaccionsByIdCuentaBanco;
    }

    public void setTransaccionsByIdCuentaBanco(Collection<TransaccionEntity> transaccionsByIdCuentaBanco)
    {
        this.transaccionsByIdCuentaBanco = transaccionsByIdCuentaBanco;
    }

    public Collection<UsuarioEntity> getUsuariosByIdCuentaBanco()
    {
        return usuariosByIdCuentaBanco;
    }

    public void setUsuariosByIdCuentaBanco(Collection<UsuarioEntity> usuariosByIdCuentaBanco)
    {
        this.usuariosByIdCuentaBanco = usuariosByIdCuentaBanco;
    }
}
