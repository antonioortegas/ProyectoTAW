package es.taw.proyectotaw.controller;


import es.taw.proyectotaw.dao.EmpresaRepository;
import es.taw.proyectotaw.dao.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpresaController {



    @Autowired
    protected EmpresaRepository empresaRepository;
    protected UsuarioRepository usuarioRepository;


    @GetMapping("/Empresa/crearNuevaEmpresa")
    public String crearNuevaEmpresa(){
        return "Empresa/crearNuevaEmpresa";
    }


    @GetMapping("/Empresa/crearUsuarioEmpresa")
    public String crearNuevoSocio() {
        return "Empresa/crearUsuarioEmpresa";
    }


    @GetMapping("/Empresa/loginSocio")

    public String iniciarSesionEmpresa() {
        return "Empresa/login";
    }



    public String iniciarSesionEmpleadp() {
        return "";
    }

}
