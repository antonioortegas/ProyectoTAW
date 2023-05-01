package es.taw.proyectotaw.ui;

public class FiltroUsuarios {

    public FiltroUsuarios() {
        this.propiedad = "";
        this.orden = "nif";
    }

    private String propiedad;
    private String orden;


    public String getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }


}
