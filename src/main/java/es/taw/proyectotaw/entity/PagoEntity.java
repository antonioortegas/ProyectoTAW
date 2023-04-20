package es.taw.proyectotaw.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pago", schema = "mydb", catalog = "")
@IdClass(PagoEntityPK.class)
public class PagoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPago", nullable = false)
    private Integer idPago;
    @Basic
    @Column(name = "moneda", nullable = false, length = 45)
    private String moneda;
    @Basic
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "beneficiario", nullable = false, length = 45)
    private String beneficiario;
    @ManyToOne
    @JoinColumn(name = "beneficiario", referencedColumnName = "ibanCuenta", nullable = false)
    private BeneficiarioEntity beneficiarioByBeneficiario;
    @ManyToOne
    @JoinColumn(name = "idPago", referencedColumnName = "Pago_idPago", nullable = false)
    private TransaccionEntity transaccionByIdPago;

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

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagoEntity that = (PagoEntity) o;
        return Objects.equals(idPago, that.idPago) && Objects.equals(moneda, that.moneda) && Objects.equals(cantidad, that.cantidad) && Objects.equals(beneficiario, that.beneficiario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPago, moneda, cantidad, beneficiario);
    }

    public BeneficiarioEntity getBeneficiarioByBeneficiario() {
        return beneficiarioByBeneficiario;
    }

    public void setBeneficiarioByBeneficiario(BeneficiarioEntity beneficiarioByBeneficiario) {
        this.beneficiarioByBeneficiario = beneficiarioByBeneficiario;
    }

    public TransaccionEntity getTransaccionByIdPago() {
        return transaccionByIdPago;
    }

    public void setTransaccionByIdPago(TransaccionEntity transaccionByIdPago) {
        this.transaccionByIdPago = transaccionByIdPago;
    }
}
