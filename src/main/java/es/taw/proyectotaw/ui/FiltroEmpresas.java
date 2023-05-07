/*
AUTOR : ANTONIO ORTEGA SANTAOLALLA - 100%
 */

package es.taw.proyectotaw.ui;

public class FiltroEmpresas {

    public FiltroEmpresas() {
        this.propiedadE = "";
        this.ordenE = "idEmpresa";
    }

    private String propiedadE;
    private String ordenE;


    public String getPropiedadE() {
        return propiedadE;
    }

    public void setPropiedadE(String propiedadE) {
        this.propiedadE = propiedadE;
    }

    public String getOrdenE() {
        return ordenE;
    }

    public void setOrdenE(String ordenE) {
        this.ordenE = ordenE;
    }
}
