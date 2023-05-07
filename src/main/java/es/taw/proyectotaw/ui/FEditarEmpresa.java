/*
AUTOR : Sergio Morejón Pérez - 100%
 */

package es.taw.proyectotaw.ui;

public class FEditarEmpresa {
    String nombre;

    public FEditarEmpresa(String nombre, String cif, Integer idEmpresa, Integer direccionByDireccionIdDireccion, Integer cuentabancoByCuentaEmpresaIdCuentaBanco, Integer idSocio) {
        this.nombre = nombre;
        this.cif = cif;
        this.idEmpresa = idEmpresa;
        this.direccionByDireccionIdDireccion = direccionByDireccionIdDireccion;
        this.cuentabancoByCuentaEmpresaIdCuentaBanco = cuentabancoByCuentaEmpresaIdCuentaBanco;
        this.idSocio = idSocio;
    }

    public FEditarEmpresa() {
        this.nombre = "";
        this.cif = "";
        this.idEmpresa = 0;
        this.direccionByDireccionIdDireccion = 0;
        this.cuentabancoByCuentaEmpresaIdCuentaBanco = 0;
        this.idSocio = 0;
    }

    String cif;
    Integer idEmpresa;
    Integer direccionByDireccionIdDireccion;
    Integer cuentabancoByCuentaEmpresaIdCuentaBanco;
    Integer idSocio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getDireccionByDireccionIdDireccion() {
        return direccionByDireccionIdDireccion;
    }

    public void setDireccionByDireccionIdDireccion(Integer direccionByDireccionIdDireccion) {
        this.direccionByDireccionIdDireccion = direccionByDireccionIdDireccion;
    }

    public Integer getCuentabancoByCuentaEmpresaIdCuentaBanco() {
        return cuentabancoByCuentaEmpresaIdCuentaBanco;
    }

    public void setCuentabancoByCuentaEmpresaIdCuentaBanco(Integer cuentabancoByCuentaEmpresaIdCuentaBanco) {
        this.cuentabancoByCuentaEmpresaIdCuentaBanco = cuentabancoByCuentaEmpresaIdCuentaBanco;
    }

    public Integer getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Integer idSocio) {
        this.idSocio = idSocio;
    }
}
