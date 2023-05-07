package es.taw.proyectotaw.Entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "pago", schema = "mydb", catalog = "")
public class PagoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_pago", nullable = false)
    private Integer idPago;
    @Basic
    @Column(name = "moneda", nullable = false, length = 45)
    private String moneda;
    @Basic
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    @Basic
    @Column(name = "iban_beneficiario", nullable = true, length = 45)
    private String ibanBeneficiario;
    @OneToMany(mappedBy = "pagoByPagoIdPago")
    private Collection<TransaccionEntity> transaccionsByIdPago;

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getIbanBeneficiario() {
        return ibanBeneficiario;
    }

    public void setIbanBeneficiario(String ibanBeneficiario) {
        this.ibanBeneficiario = ibanBeneficiario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagoEntity that = (PagoEntity) o;
        return Objects.equals(idPago, that.idPago) && Objects.equals(moneda, that.moneda) && Objects.equals(cantidad, that.cantidad) && Objects.equals(ibanBeneficiario, that.ibanBeneficiario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPago, moneda, cantidad, ibanBeneficiario);
    }

    public Collection<TransaccionEntity> getTransaccionsByIdPago() {
        return transaccionsByIdPago;
    }

    public void setTransaccionsByIdPago(Collection<TransaccionEntity> transaccionsByIdPago) {
        this.transaccionsByIdPago = transaccionsByIdPago;
    }
}
