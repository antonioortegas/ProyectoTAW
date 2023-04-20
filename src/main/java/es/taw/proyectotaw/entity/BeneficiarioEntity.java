package es.taw.proyectotaw.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "beneficiario", schema = "mydb", catalog = "")
public class BeneficiarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ibanCuenta", nullable = false, length = 45)
    private String ibanCuenta;
    @Basic
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Basic
    @Column(name = "apellido", nullable = false, length = 45)
    private String apellido;
    @Basic
    @Column(name = "pais", nullable = false, length = 45)
    private String pais;
    @Basic
    @Column(name = "moneda", nullable = false, length = 45)
    private String moneda;
    @Basic
    @Column(name = "numeroCuenta", nullable = false, length = 45)
    private String numeroCuenta;
    @Basic
    @Column(name = "swift", nullable = false, length = 45)
    private String swift;
    @Basic
    @Column(name = "paisCuenta", nullable = false, length = 45)
    private String paisCuenta;
    @OneToMany(mappedBy = "beneficiarioByBeneficiario")
    private Collection<PagoEntity> pagosByIbanCuenta;

    public String getIbanCuenta() {
        return ibanCuenta;
    }

    public void setIbanCuenta(String ibanCuenta) {
        this.ibanCuenta = ibanCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public String getPaisCuenta() {
        return paisCuenta;
    }

    public void setPaisCuenta(String paisCuenta) {
        this.paisCuenta = paisCuenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeneficiarioEntity that = (BeneficiarioEntity) o;
        return Objects.equals(ibanCuenta, that.ibanCuenta) && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(pais, that.pais) && Objects.equals(moneda, that.moneda) && Objects.equals(numeroCuenta, that.numeroCuenta) && Objects.equals(swift, that.swift) && Objects.equals(paisCuenta, that.paisCuenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ibanCuenta, nombre, apellido, pais, moneda, numeroCuenta, swift, paisCuenta);
    }

    public Collection<PagoEntity> getPagosByIbanCuenta() {
        return pagosByIbanCuenta;
    }

    public void setPagosByIbanCuenta(Collection<PagoEntity> pagosByIbanCuenta) {
        this.pagosByIbanCuenta = pagosByIbanCuenta;
    }
}
