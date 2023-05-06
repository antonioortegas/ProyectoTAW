package es.taw.proyectotaw.ui;


import java.sql.Date;

public class CrearNuevoSocio {

    String nif = "";
    String nombre = "";
    String segundoNombre = null;
    String apellido1 = "";
    String apellido2 = null;
    Date fechaNacimiento = null;
    String calle = "";
    String numeroVivienda = "";
    String planta = "";
    String ciudad = "";
    String region = null;
    String pais = "";
    String cp = "";
    Byte valida = 0;
    String contrasena = "";
    String repcontrasena = "";
    String tipoUsuario = "";
    Integer idEmpresa = null;
    Integer id = null;

    String tipoPersonaRelacionada = "";
    public CrearNuevoSocio(Integer id) {
        this.id = id;
    }

    public CrearNuevoSocio() {
        id=0;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getTipoPersonaRelacionada() {
        return tipoPersonaRelacionada;
    }

    public void setTipoPersonaRelacionada(String tipoPersonaRelacionada) {
        this.tipoPersonaRelacionada = tipoPersonaRelacionada;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroVivienda() {
        return numeroVivienda;
    }

    public void setNumeroVivienda(String numeroVivienda) {
        this.numeroVivienda = numeroVivienda;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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

    public Byte isValida() {
        return valida;
    }

    public void setValida(Byte valida) {
        this.valida = valida;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRepcontrasena() {
        return repcontrasena;
    }

    public void setRepcontrasena(String repcontrasena) {
        this.repcontrasena = repcontrasena;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
