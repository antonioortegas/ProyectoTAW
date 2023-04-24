package es.taw.proyectotaw.controller;


import com.fasterxml.jackson.databind.annotation.JsonAppend;
import es.taw.proyectotaw.Entity.UsuarioEntity;
import es.taw.proyectotaw.dao.EmpresaRepository;
import es.taw.proyectotaw.dao.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmpresaController {



    @Autowired
    protected EmpresaRepository empresaRepository;
    @Autowired
    protected UsuarioRepository usuarioRepository;


    @GetMapping("/Empresa/crearNuevaEmpresa")
    public String crearNuevaEmpresa(){
        return "Empresa/crearNuevaEmpresa";
    }


    @GetMapping("/Empresa/crearUsuarioEmpresa")
    public String crearNuevoSocio() {
        return "Empresa/crearUsuarioEmpresa";
    }


    public String iniciarSesionEmpresa() {


        return "Empresa/login";
    }

    @PostMapping("/loginSocio")
    public String doAutenticar (@RequestParam("nif") String nif,
                                @RequestParam("contrasena") String contrasena,
                                Model model, HttpSession session) {
        String urlTo = "/Empresa/sesionIniciadaEmpresa";
        UsuarioEntity admin = this.usuarioRepository.autenticarUsuarioEmpresa(nif, contrasena);
        if (admin == null) {
            model.addAttribute("error", "Credenciales incorrectas");
            urlTo = "loginSocio";
        } else {
            session.setAttribute("admin", admin);
        }

        return urlTo;
    }

    @GetMapping("/Empresa/loginSocio")
    public String iniciarSesionEmpleadp() {
        return "Empresa/login";
    }





}
