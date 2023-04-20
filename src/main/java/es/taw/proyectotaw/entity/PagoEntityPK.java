package es.taw.proyectotaw.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PagoEntityPK implements Serializable {
    @Column(name = "idPago", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPago;
    @Column(name = "beneficiario", nullable = false, length = 45)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String beneficiario;

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
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
        PagoEntityPK that = (PagoEntityPK) o;
        return Objects.equals(idPago, that.idPago) && Objects.equals(beneficiario, that.beneficiario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPago, beneficiario);
    }
}
