package es.taw.proyectotaw.ui;

public class FiltroTransaccion {

    public FiltroTransaccion() {
        this.propiedad = "";
        this.orden = "idTransaccion";
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

    public void setOrdenU(String ordenU) {
        this.ordenU = ordenU;
    }
}
