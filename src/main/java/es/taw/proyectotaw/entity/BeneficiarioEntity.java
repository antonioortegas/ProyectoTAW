package es.taw.proyectotaw.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "beneficiario", schema = "mydb", catalog = "")
public class BeneficiarioEntity {
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

    public Integer getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(Integer idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public String getIbanBeneficiario() {
        return ibanBeneficiario;
    }

    public void setIbanBeneficiario(String ibanBeneficiario) {
        this.ibanBeneficiario = ibanBeneficiario;
    }

    public String getNombreBeneficiario() {
        return nombreBeneficiario;
    }

    public void setNombreBeneficiario(String nombreBeneficiario) {
        this.nombreBeneficiario = nombreBeneficiario;
    }

    public String getApellidoBeneficiario() {
        return apellidoBeneficiario;
    }

    public void setApellidoBeneficiario(String apellidoBeneficiario) {
        this.apellidoBeneficiario = apellidoBeneficiario;
    }

    public String getPaisCuentaBeneficiario() {
        return paisCuentaBeneficiario;
    }

    public void setPaisCuentaBeneficiario(String paisCuentaBeneficiario) {
        this.paisCuentaBeneficiario = paisCuentaBeneficiario;
    }

    public String getMonedaBeneficiario() {
        return monedaBeneficiario;
    }

    public void setMonedaBeneficiario(String monedaBeneficiario) {
        this.monedaBeneficiario = monedaBeneficiario;
    }

    public String getNumeroCuentaBeneficiario() {
        return numeroCuentaBeneficiario;
    }

    public void setNumeroCuentaBeneficiario(String numeroCuentaBeneficiario) {
        this.numeroCuentaBeneficiario = numeroCuentaBeneficiario;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeneficiarioEntity that = (BeneficiarioEntity) o;
        return Objects.equals(idBeneficiario, that.idBeneficiario) && Objects.equals(ibanBeneficiario, that.ibanBeneficiario) && Objects.equals(nombreBeneficiario, that.nombreBeneficiario) && Objects.equals(apellidoBeneficiario, that.apellidoBeneficiario) && Objects.equals(paisCuentaBeneficiario, that.paisCuentaBeneficiario) && Objects.equals(monedaBeneficiario, that.monedaBeneficiario) && Objects.equals(numeroCuentaBeneficiario, that.numeroCuentaBeneficiario) && Objects.equals(swift, that.swift);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBeneficiario, ibanBeneficiario, nombreBeneficiario, apellidoBeneficiario, paisCuentaBeneficiario, monedaBeneficiario, numeroCuentaBeneficiario, swift);
    }

    public Collection<PagoEntity> getPagosByIdBeneficiario() {
        return pagosByIdBeneficiario;
    }

    public void setPagosByIdBeneficiario(Collection<PagoEntity> pagosByIdBeneficiario) {
        this.pagosByIdBeneficiario = pagosByIdBeneficiario;
    }
}
