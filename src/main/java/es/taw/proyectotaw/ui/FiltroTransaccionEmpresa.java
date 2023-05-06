package es.taw.proyectotaw.ui;

public class FiltroTransaccionEmpresa {

    public FiltroTransaccionEmpresa() {
        this.propiedad = "";
        this.orden = "idTransaccion";
        this.id_empresa = null;
        this.id_socio = null;
    }

    public Integer getId_socio() {
        return id_socio;
    }

    public void setId_socio(Integer id_socio) {
        this.id_socio = id_socio;
    }

    private Integer id_empresa;
    private Integer id_socio;
    private String propiedad;
    private String orden;

    public Integer getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(Integer id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrdenU(String ordenU) {
        this.orden = orden;
    }
}
