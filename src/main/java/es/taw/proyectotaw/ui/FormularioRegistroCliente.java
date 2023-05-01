package es.taw.proyectotaw.ui;

import es.taw.proyectotaw.Entity.DireccionEntity;
import es.taw.proyectotaw.Entity.UsuarioEntity;

public class FormularioRegistroCliente {

    private UsuarioEntity usuario;
    private DireccionEntity direccion;

    public UsuarioEntity getUsuario(){return usuario;}

    public DireccionEntity getDireccion(){return direccion;}

    public void setUsuario(UsuarioEntity usuario){
        this.usuario = usuario;
    }

    public void setDireccion(DireccionEntity direccion){
        this.direccion = direccion;
    }
}
