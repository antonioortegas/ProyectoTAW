package es.taw.proyectotaw.Entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "transaccion", schema = "mydb", catalog = "")
public class TransaccionEntity
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_transaccion", nullable = false)
    private Integer idTransaccion;
    @Basic
    @Column(name = "fecha_instruccion", nullable = false)
    private Date fechaInstruccion;
    @Basic
    @Column(name = "fecha_ejecucion", nullable = true)
    private Date fechaEjecucion;
    @ManyToOne
    @JoinColumn(name = "cuenta_banco_id_cuenta_banco", referencedColumnName = "id_cuenta_banco", nullable = false)
    private CuentabancoEntity cuentabancoByCuentaBancoIdCuentaBanco;
    @ManyToOne
    @JoinColumn(name = "cambio_divisa_id_cambio_divisa", referencedColumnName = "id_cambio_divisa", nullable = false)
    private CambiodivisaEntity cambiodivisaByCambioDivisaIdCambioDivisa;
    @ManyToOne
    @JoinColumn(name = "Pago_id_pago", referencedColumnName = "id_pago", nullable = false)
    private PagoEntity pagoByPagoIdPago;

    public Integer getIdTransaccion()
    {
        return idTransaccion;
    }

    public void setIdTransaccion(Integer idTransaccion)
    {
        this.idTransaccion = idTransaccion;
    }

    public Date getFechaInstruccion()
    {
        return fechaInstruccion;
    }

    public void setFechaInstruccion(Date fechaInstruccion)
    {
        this.fechaInstruccion = fechaInstruccion;
    }

    public Date getFechaEjecucion()
    {
        return fechaEjecucion;
    }

    public void setFechaEjecucion(Date fechaEjecucion)
    {
        this.fechaEjecucion = fechaEjecucion;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransaccionEntity that = (TransaccionEntity) o;

        if (idTransaccion != null ? !idTransaccion.equals(that.idTransaccion) : that.idTransaccion != null)
            return false;
        if (fechaInstruccion != null ? !fechaInstruccion.equals(that.fechaInstruccion) : that.fechaInstruccion != null)
            return false;
        if (fechaEjecucion != null ? !fechaEjecucion.equals(that.fechaEjecucion) : that.fechaEjecucion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = idTransaccion != null ? idTransaccion.hashCode() : 0;
        result = 31 * result + (fechaInstruccion != null ? fechaInstruccion.hashCode() : 0);
        result = 31 * result + (fechaEjecucion != null ? fechaEjecucion.hashCode() : 0);
        return result;
    }

    public CuentabancoEntity getCuentabancoByCuentaBancoIdCuentaBanco()
    {
        return cuentabancoByCuentaBancoIdCuentaBanco;
    }

    public void setCuentabancoByCuentaBancoIdCuentaBanco(CuentabancoEntity cuentabancoByCuentaBancoIdCuentaBanco)
    {
        this.cuentabancoByCuentaBancoIdCuentaBanco = cuentabancoByCuentaBancoIdCuentaBanco;
    }

    public CambiodivisaEntity getCambiodivisaByCambioDivisaIdCambioDivisa()
    {
        return cambiodivisaByCambioDivisaIdCambioDivisa;
    }

    public void setCambiodivisaByCambioDivisaIdCambioDivisa(CambiodivisaEntity cambiodivisaByCambioDivisaIdCambioDivisa)
    {
        this.cambiodivisaByCambioDivisaIdCambioDivisa = cambiodivisaByCambioDivisaIdCambioDivisa;
    }

    public PagoEntity getPagoByPagoIdPago()
    {
        return pagoByPagoIdPago;
    }

    public void setPagoByPagoIdPago(PagoEntity pagoByPagoIdPago)
    {
        this.pagoByPagoIdPago = pagoByPagoIdPago;
    }
}
