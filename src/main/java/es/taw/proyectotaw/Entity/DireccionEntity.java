package es.taw.proyectotaw.Entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "direccion", schema = "mydb", catalog = "")
public class DireccionEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_direccion", nullable = false)
    private Integer idDireccion;
    @Basic
    @Column(name = "calle", nullable = false, length = 100)
    private String calle;
    @Basic
    @Column(name = "numero", nullable = false, length = 45)
    private String numero;
    @Basic
    @Column(name = "puerta", nullable = false, length = 45)
    private String puerta;
    @Basic
    @Column(name = "ciudad", nullable = false, length = 45)
    private String ciudad;
    @Basic
    @Column(name = "pais", nullable = false, length = 45)
    private String pais;
    @Basic
    @Column(name = "cp", nullable = false, length = 45)
    private String cp;
    @Basic
    @Column(name = "region", nullable = true, length = 45)
    private String region;
    @Basic
    @Column(name = "valida", nullable = false)
    private Byte valida;
    @OneToMany(mappedBy = "direccionByDireccionIdDireccion")
    private Collection<EmpresaEntity> empresasByIdDireccion;
    @OneToMany(mappedBy = "direccionByDireccionIdDireccion")
    private Collection<UsuarioEntity> usuariosByIdDireccion;
    public DireccionEntity() {
    }
    public DireccionEntity(String calle, String numero, String puerta, String ciudad, String pais, String cp, Byte valida) {
        this.calle = calle;
        this.numero = numero;
        this.puerta = puerta;
        this.ciudad = ciudad;
        this.pais = pais;
        this.cp = cp;
        this.region = region;
        this.valida = valida;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_direccion", nullable = false)
    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    @Basic
    @Column(name = "calle", nullable = false, length = 100)
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    @Basic
    @Column(name = "numero", nullable = false, length = 45)
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Basic
    @Column(name = "puerta", nullable = false, length = 45)
    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    @Basic
    @Column(name = "ciudad", nullable = false, length = 45)
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Basic
    @Column(name = "pais", nullable = false, length = 45)
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Basic
    @Column(name = "cp", nullable = false, length = 45)
    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    @Basic
    @Column(name = "region", nullable = true, length = 45)
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "valida", nullable = false)
    public Byte getValida() {
        return valida;
    }

    public void setValida(Byte valida) {
        this.valida = valida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DireccionEntity that = (DireccionEntity) o;
        return Objects.equals(idDireccion, that.idDireccion) && Objects.equals(calle, that.calle) && Objects.equals(numero, that.numero) && Objects.equals(puerta, that.puerta) && Objects.equals(ciudad, that.ciudad) && Objects.equals(pais, that.pais) && Objects.equals(cp, that.cp) && Objects.equals(region, that.region) && Objects.equals(valida, that.valida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDireccion, calle, numero, puerta, ciudad, pais, cp, region, valida);
    }

    @OneToMany(mappedBy = "direccionByDireccionIdDireccion")
    public Collection<EmpresaEntity> getEmpresasByIdDireccion() {
        return empresasByIdDireccion;
    }

    public void setEmpresasByIdDireccion(Collection<EmpresaEntity> empresasByIdDireccion) {
        this.empresasByIdDireccion = empresasByIdDireccion;
    }

    @OneToMany(mappedBy = "direccionByDireccionIdDireccion")
    public Collection<UsuarioEntity> getUsuariosByIdDireccion() {
        return usuariosByIdDireccion;
    }

    public void setUsuariosByIdDireccion(Collection<UsuarioEntity> usuariosByIdDireccion) {
        this.usuariosByIdDireccion = usuariosByIdDireccion;
    }
}
