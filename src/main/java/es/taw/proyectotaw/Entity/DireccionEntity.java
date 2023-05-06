package es.taw.proyectotaw.Entity;

import jakarta.persistence.*;

import java.util.Collection;

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

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

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

        DireccionEntity direccion = (DireccionEntity) o;

        if (idDireccion != null ? !idDireccion.equals(direccion.idDireccion) : direccion.idDireccion != null)
            return false;
        if (calle != null ? !calle.equals(direccion.calle) : direccion.calle != null) return false;
        if (numero != null ? !numero.equals(direccion.numero) : direccion.numero != null) return false;
        if (puerta != null ? !puerta.equals(direccion.puerta) : direccion.puerta != null) return false;
        if (ciudad != null ? !ciudad.equals(direccion.ciudad) : direccion.ciudad != null) return false;
        if (pais != null ? !pais.equals(direccion.pais) : direccion.pais != null) return false;
        if (cp != null ? !cp.equals(direccion.cp) : direccion.cp != null) return false;
        if (region != null ? !region.equals(direccion.region) : direccion.region != null) return false;
        if (valida != null ? !valida.equals(direccion.valida) : direccion.valida != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDireccion != null ? idDireccion.hashCode() : 0;
        result = 31 * result + (calle != null ? calle.hashCode() : 0);
        result = 31 * result + (numero != null ? numero.hashCode() : 0);
        result = 31 * result + (puerta != null ? puerta.hashCode() : 0);
        result = 31 * result + (ciudad != null ? ciudad.hashCode() : 0);
        result = 31 * result + (pais != null ? pais.hashCode() : 0);
        result = 31 * result + (cp != null ? cp.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (valida != null ? valida.hashCode() : 0);
        return result;
    }

    public Collection<EmpresaEntity> getEmpresasByIdDireccion() {
        return empresasByIdDireccion;
    }

    public void setEmpresasByIdDireccion(Collection<EmpresaEntity> empresasByIdDireccion) {
        this.empresasByIdDireccion = empresasByIdDireccion;
    }

    public Collection<UsuarioEntity> getUsuariosByIdDireccion() {
        return usuariosByIdDireccion;
    }

    public void setUsuariosByIdDireccion(Collection<UsuarioEntity> usuariosByIdDireccion) {
        this.usuariosByIdDireccion = usuariosByIdDireccion;
    }


}
