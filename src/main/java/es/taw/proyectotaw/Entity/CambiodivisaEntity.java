package es.taw.proyectotaw.Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "cambiodivisa", schema = "mydb", catalog = "")
public class CambiodivisaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_cambio_divisa", nullable = false)
    private Integer idCambioDivisa;
    @Basic
    @Column(name = "moneda_venta", nullable = false, length = 45)
    private String monedaVenta;
    @Basic
    @Column(name = "moneda_compra", nullable = false, length = 45)
    private String monedaCompra;
    @Basic
    @Column(name = "cantidad_compra", nullable = false)
    private Integer cantidadCompra;
    @Basic
    @Column(name = "cantidad_venta", nullable = false)
    private Integer cantidadVenta;
    @OneToMany(mappedBy = "cambiodivisaByCambioDivisaIdCambioDivisa")
    private Collection<TransaccionEntity> transaccionsByIdCambioDivisa;

    public Integer getIdCambioDivisa() {
        return idCambioDivisa;
    }

    public void setIdCambioDivisa(Integer idCambioDivisa) {
        this.idCambioDivisa = idCambioDivisa;
    }

    public String getMonedaVenta() {
        return monedaVenta;
    }

    public void setMonedaVenta(String monedaVenta) {
        this.monedaVenta = monedaVenta;
    }

    public String getMonedaCompra() {
        return monedaCompra;
    }

    public void setMonedaCompra(String monedaCompra) {
        this.monedaCompra = monedaCompra;
    }

    public Integer getCantidadCompra() {
        return cantidadCompra;
    }

    public void setCantidadCompra(Integer cantidadCompra) {
        this.cantidadCompra = cantidadCompra;
    }

    public Integer getCantidadVenta() {
        return cantidadVenta;
    }

    public void setCantidadVenta(Integer cantidadVenta) {
        this.cantidadVenta = cantidadVenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CambiodivisaEntity that = (CambiodivisaEntity) o;

        if (idCambioDivisa != null ? !idCambioDivisa.equals(that.idCambioDivisa) : that.idCambioDivisa != null)
            return false;
        if (monedaVenta != null ? !monedaVenta.equals(that.monedaVenta) : that.monedaVenta != null) return false;
        if (monedaCompra != null ? !monedaCompra.equals(that.monedaCompra) : that.monedaCompra != null) return false;
        if (cantidadCompra != null ? !cantidadCompra.equals(that.cantidadCompra) : that.cantidadCompra != null)
            return false;
        if (cantidadVenta != null ? !cantidadVenta.equals(that.cantidadVenta) : that.cantidadVenta != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCambioDivisa != null ? idCambioDivisa.hashCode() : 0;
        result = 31 * result + (monedaVenta != null ? monedaVenta.hashCode() : 0);
        result = 31 * result + (monedaCompra != null ? monedaCompra.hashCode() : 0);
        result = 31 * result + (cantidadCompra != null ? cantidadCompra.hashCode() : 0);
        result = 31 * result + (cantidadVenta != null ? cantidadVenta.hashCode() : 0);
        return result;
    }

    public Collection<TransaccionEntity> getTransaccionsByIdCambioDivisa() {
        return transaccionsByIdCambioDivisa;
    }

    public void setTransaccionsByIdCambioDivisa(Collection<TransaccionEntity> transaccionsByIdCambioDivisa) {
        this.transaccionsByIdCambioDivisa = transaccionsByIdCambioDivisa;
    }
}
