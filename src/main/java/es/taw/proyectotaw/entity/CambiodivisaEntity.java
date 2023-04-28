package es.taw.proyectotaw.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

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
    @Column(name = "cantidad_compra", nullable = false, length = 45)
    private String cantidadCompra;
    @Basic
    @Column(name = "cantidad_venta", nullable = false, length = 45)
    private String cantidadVenta;
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

    public String getCantidadCompra() {
        return cantidadCompra;
    }

    public void setCantidadCompra(String cantidadCompra) {
        this.cantidadCompra = cantidadCompra;
    }

    public String getCantidadVenta() {
        return cantidadVenta;
    }

    public void setCantidadVenta(String cantidadVenta) {
        this.cantidadVenta = cantidadVenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CambiodivisaEntity that = (CambiodivisaEntity) o;
        return Objects.equals(idCambioDivisa, that.idCambioDivisa) && Objects.equals(monedaVenta, that.monedaVenta) && Objects.equals(monedaCompra, that.monedaCompra) && Objects.equals(cantidadCompra, that.cantidadCompra) && Objects.equals(cantidadVenta, that.cantidadVenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCambioDivisa, monedaVenta, monedaCompra, cantidadCompra, cantidadVenta);
    }

    public Collection<TransaccionEntity> getTransaccionsByIdCambioDivisa() {
        return transaccionsByIdCambioDivisa;
    }

    public void setTransaccionsByIdCambioDivisa(Collection<TransaccionEntity> transaccionsByIdCambioDivisa) {
        this.transaccionsByIdCambioDivisa = transaccionsByIdCambioDivisa;
    }
}
