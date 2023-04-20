package es.taw.proyectotaw.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "transaccion", schema = "mydb", catalog = "")
public class TransaccionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idTransaccion", nullable = false)
    private Integer idTransaccion;
    @Basic
    @Column(name = "fechaInstruccion", nullable = false)
    private Timestamp fechaInstruccion;
    @Basic
    @Column(name = "fechaEjecucion", nullable = true)
    private Timestamp fechaEjecucion;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "CuentaBanco_idCuentaBanco", referencedColumnName = "idCuentaBanco", nullable = false), @JoinColumn(name = "CuentaBanco_estado", referencedColumnName = "estado", nullable = false)})
    private CuentabancoEntity cuentabanco;
    @OneToMany(mappedBy = "transaccionByIdPago")
    private Collection<PagoEntity> pagoTransaccionByIdPago;
    @ManyToOne
    @JoinColumn(name = "CambioDivisa_idCambioDivisa", referencedColumnName = "idCambioDivisa", nullable = false)
    private CambiodivisaEntity cambiodivisaByCambioDivisaIdCambioDivisa;

    public Integer getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Timestamp getFechaInstruccion() {
        return fechaInstruccion;
    }

    public void setFechaInstruccion(Timestamp fechaInstruccion) {
        this.fechaInstruccion = fechaInstruccion;
    }

    public Timestamp getFechaEjecucion() {
        return fechaEjecucion;
    }

    public void setFechaEjecucion(Timestamp fechaEjecucion) {
        this.fechaEjecucion = fechaEjecucion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransaccionEntity that = (TransaccionEntity) o;
        return Objects.equals(idTransaccion, that.idTransaccion) && Objects.equals(fechaInstruccion, that.fechaInstruccion) && Objects.equals(fechaEjecucion, that.fechaEjecucion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTransaccion, fechaInstruccion, fechaEjecucion);
    }

    public CuentabancoEntity getCuentabanco() {
        return cuentabanco;
    }

    public void setCuentabanco(CuentabancoEntity cuentabanco) {
        this.cuentabanco = cuentabanco;
    }

    public Collection<PagoEntity> getPagoTransaccionByIdPago() {
        return pagoTransaccionByIdPago;
    }

    public void setPagoTransaccionByIdPago(Collection<PagoEntity> pagoTransaccionByIdPago) {
        this.pagoTransaccionByIdPago = pagoTransaccionByIdPago;
    }

    public CambiodivisaEntity getCambiodivisaByCambioDivisaIdCambioDivisa() {
        return cambiodivisaByCambioDivisaIdCambioDivisa;
    }

    public void setCambiodivisaByCambioDivisaIdCambioDivisa(CambiodivisaEntity cambiodivisaByCambioDivisaIdCambioDivisa) {
        this.cambiodivisaByCambioDivisaIdCambioDivisa = cambiodivisaByCambioDivisaIdCambioDivisa;
    }
}
