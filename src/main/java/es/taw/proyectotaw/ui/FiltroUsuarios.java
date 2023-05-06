package es.taw.proyectotaw.ui;

public class FiltroUsuarios {

    public FiltroUsuarios() {
        this.propiedadU = "";
        this.ordenU = "idUsuario";
    }

    private String propiedadU;
    private String ordenU;


    public String getPropiedadU() {
        return propiedadU;
    }

    public void setPropiedadU(String propiedadU) {
        this.propiedadU = propiedadU;
    }

    public String getOrdenU() {
        return ordenU;
    }

    public void setOrdenU(String ordenU) {
        this.ordenU = ordenU;
    }


}
