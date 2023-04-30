package es.taw.proyectotaw.Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "beneficiario", schema = "mydb", catalog = "")
public class BeneficiarioEntity
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_beneficiario", nullable = false)
    private Integer idBeneficiario;
    @Basic
    @Column(name = "iban_beneficiario", nullable = false, length = 45)
    private String ibanBeneficiario;
    @Basic
    @Column(name = "nombre_beneficiario", nullable = false, length = 45)
    private String nombreBeneficiario;
    @Basic
    @Column(name = "apellido_beneficiario", nullable = false, length = 45)
    private String apellidoBeneficiario;
    @Basic
    @Column(name = "pais_cuenta_beneficiario", nullable = false, length = 45)
    private String paisCuentaBeneficiario;
    @Basic
    @Column(name = "moneda_beneficiario", nullable = false, length = 45)
    private String monedaBeneficiario;
    @Basic
    @Column(name = "numero_cuenta_beneficiario", nullable = false, length = 45)
    private String numeroCuentaBeneficiario;
    @Basic
    @Column(name = "swift", nullable = true, length = 45)
    private String swift;
    @OneToMany(mappedBy = "beneficiarioByBeneficiarioIdBeneficiario")
    private Collection<PagoEntity> pagosByIdBeneficiario;

    public Integer getIdBeneficiario()
    {
        return idBeneficiario;
    }

    public void setIdBeneficiario(Integer idBeneficiario)
    {
        this.idBeneficiario = idBeneficiario;
    }

    public String getIbanBeneficiario()
    {
        return ibanBeneficiario;
    }

    public void setIbanBeneficiario(String ibanBeneficiario)
    {
        this.ibanBeneficiario = ibanBeneficiario;
    }

    public String getNombreBeneficiario()
    {
        return nombreBeneficiario;
    }

    public void setNombreBeneficiario(String nombreBeneficiario)
    {
        this.nombreBeneficiario = nombreBeneficiario;
    }

    public String getApellidoBeneficiario()
    {
        return apellidoBeneficiario;
    }

    public void setApellidoBeneficiario(String apellidoBeneficiario)
    {
        this.apellidoBeneficiario = apellidoBeneficiario;
    }

    public String getPaisCuentaBeneficiario()
    {
        return paisCuentaBeneficiario;
    }

    public void setPaisCuentaBeneficiario(String paisCuentaBeneficiario)
    {
        this.paisCuentaBeneficiario = paisCuentaBeneficiario;
    }

    public String getMonedaBeneficiario()
    {
        return monedaBeneficiario;
    }

    public void setMonedaBeneficiario(String monedaBeneficiario)
    {
        this.monedaBeneficiario = monedaBeneficiario;
    }

    public String getNumeroCuentaBeneficiario()
    {
        return numeroCuentaBeneficiario;
    }

    public void setNumeroCuentaBeneficiario(String numeroCuentaBeneficiario)
    {
        this.numeroCuentaBeneficiario = numeroCuentaBeneficiario;
    }

    public String getSwift()
    {
        return swift;
    }

    public void setSwift(String swift)
    {
        this.swift = swift;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BeneficiarioEntity that = (BeneficiarioEntity) o;

        if (idBeneficiario != null ? !idBeneficiario.equals(that.idBeneficiario) : that.idBeneficiario != null)
            return false;
        if (ibanBeneficiario != null ? !ibanBeneficiario.equals(that.ibanBeneficiario) : that.ibanBeneficiario != null)
            return false;
        if (nombreBeneficiario != null ? !nombreBeneficiario.equals(that.nombreBeneficiario) : that.nombreBeneficiario != null)
            return false;
        if (apellidoBeneficiario != null ? !apellidoBeneficiario.equals(that.apellidoBeneficiario) : that.apellidoBeneficiario != null)
            return false;
        if (paisCuentaBeneficiario != null ? !paisCuentaBeneficiario.equals(that.paisCuentaBeneficiario) : that.paisCuentaBeneficiario != null)
            return false;
        if (monedaBeneficiario != null ? !monedaBeneficiario.equals(that.monedaBeneficiario) : that.monedaBeneficiario != null)
            return false;
        if (numeroCuentaBeneficiario != null ? !numeroCuentaBeneficiario.equals(that.numeroCuentaBeneficiario) : that.numeroCuentaBeneficiario != null)
            return false;
        if (swift != null ? !swift.equals(that.swift) : that.swift != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = idBeneficiario != null ? idBeneficiario.hashCode() : 0;
        result = 31 * result + (ibanBeneficiario != null ? ibanBeneficiario.hashCode() : 0);
        result = 31 * result + (nombreBeneficiario != null ? nombreBeneficiario.hashCode() : 0);
        result = 31 * result + (apellidoBeneficiario != null ? apellidoBeneficiario.hashCode() : 0);
        result = 31 * result + (paisCuentaBeneficiario != null ? paisCuentaBeneficiario.hashCode() : 0);
        result = 31 * result + (monedaBeneficiario != null ? monedaBeneficiario.hashCode() : 0);
        result = 31 * result + (numeroCuentaBeneficiario != null ? numeroCuentaBeneficiario.hashCode() : 0);
        result = 31 * result + (swift != null ? swift.hashCode() : 0);
        return result;
    }

    public Collection<PagoEntity> getPagosByIdBeneficiario()
    {
        return pagosByIdBeneficiario;
    }

    public void setPagosByIdBeneficiario(Collection<PagoEntity> pagosByIdBeneficiario)
    {
        this.pagosByIdBeneficiario = pagosByIdBeneficiario;
    }
}
