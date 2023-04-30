package es.taw.proyectotaw.Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "pago", schema = "mydb", catalog = "")
public class PagoEntity
{
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
    @ManyToOne
    @JoinColumn(name = "Beneficiario_id_beneficiario", referencedColumnName = "id_beneficiario", nullable = false)
    private BeneficiarioEntity beneficiarioByBeneficiarioIdBeneficiario;
    @OneToMany(mappedBy = "pagoByPagoIdPago")
    private Collection<TransaccionEntity> transaccionsByIdPago;

    public Integer getIdPago()
    {
        return idPago;
    }

    public void setIdPago(Integer idPago)
    {
        this.idPago = idPago;
    }

    public String getMoneda()
    {
        return moneda;
    }

    public void setMoneda(String moneda)
    {
        this.moneda = moneda;
    }

    public Integer getCantidad()
    {
        return cantidad;
    }

    public void setCantidad(Integer cantidad)
    {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PagoEntity that = (PagoEntity) o;

        if (idPago != null ? !idPago.equals(that.idPago) : that.idPago != null) return false;
        if (moneda != null ? !moneda.equals(that.moneda) : that.moneda != null) return false;
        if (cantidad != null ? !cantidad.equals(that.cantidad) : that.cantidad != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = idPago != null ? idPago.hashCode() : 0;
        result = 31 * result + (moneda != null ? moneda.hashCode() : 0);
        result = 31 * result + (cantidad != null ? cantidad.hashCode() : 0);
        return result;
    }

    public BeneficiarioEntity getBeneficiarioByBeneficiarioIdBeneficiario()
    {
        return beneficiarioByBeneficiarioIdBeneficiario;
    }

    public void setBeneficiarioByBeneficiarioIdBeneficiario(BeneficiarioEntity beneficiarioByBeneficiarioIdBeneficiario)
    {
        this.beneficiarioByBeneficiarioIdBeneficiario = beneficiarioByBeneficiarioIdBeneficiario;
    }

    public Collection<TransaccionEntity> getTransaccionsByIdPago()
    {
        return transaccionsByIdPago;
    }

    public void setTransaccionsByIdPago(Collection<TransaccionEntity> transaccionsByIdPago)
    {
        this.transaccionsByIdPago = transaccionsByIdPago;
    }
}
