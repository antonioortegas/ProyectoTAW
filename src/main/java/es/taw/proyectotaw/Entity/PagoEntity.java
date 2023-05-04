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
    @Basic
    @Column(name = "iban_beneficiario", nullable = true, length = 45)
    private String ibanBeneficiario;
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

    public String getIbanBeneficiario()
    {
        return ibanBeneficiario;
    }

    public void setIbanBeneficiario(String ibanBeneficiario)
    {
        this.ibanBeneficiario = ibanBeneficiario;
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
        if (ibanBeneficiario != null ? !ibanBeneficiario.equals(that.ibanBeneficiario) : that.ibanBeneficiario != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = idPago != null ? idPago.hashCode() : 0;
        result = 31 * result + (moneda != null ? moneda.hashCode() : 0);
        result = 31 * result + (cantidad != null ? cantidad.hashCode() : 0);
        result = 31 * result + (ibanBeneficiario != null ? ibanBeneficiario.hashCode() : 0);
        return result;
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
