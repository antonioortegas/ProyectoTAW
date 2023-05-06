package es.taw.proyectotaw.ui;

public class FiltroTransaccion {

    public FiltroTransaccion() {
        this.propiedad = "";
        this.orden = "idTransaccion";
        this.id_usuario = null;
    }



    private Integer id_usuario;
    private String propiedad;
    private String orden;

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
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
