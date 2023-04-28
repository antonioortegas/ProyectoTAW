package es.taw.proyectotaw.controller;


import es.taw.proyectotaw.entity.UsuarioEntity;
import es.taw.proyectotaw.dao.EmpresaRepository;
import es.taw.proyectotaw.dao.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmpresaController {



    @Autowired
    protected EmpresaRepository empresaRepository;
    @Autowired
    protected UsuarioRepository usuarioRepository;


    @GetMapping("/Empresa/crearNuevaEmpresa")
    public String crearNuevaEmpresa(HttpSession httpSession){
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

    @GetMapping("/Empresa/bloquearSocios")
    public String bloquarSocios(Model model, HttpSession httpSession){
        UsuarioEntity usuario = (UsuarioEntity) httpSession.getAttribute("nif");

        //List<UsuarioEntity> listaUsuriosEmpresa = this.usuarioRepository.buscarUsuariosMismaEmpresa(usuario.getEmpresaByEmpresaIdEmpresa().getIdEmpresa());
        List<UsuarioEntity> listaUsuriosEmpresa = this.usuarioRepository.buscarUsuariosMismaEmpresa("1");
        model.addAttribute("listaUsuriosEmpresa", listaUsuriosEmpresa);

        for (UsuarioEntity u:
             listaUsuriosEmpresa) {
            System.out.println(u.getNombre());
        }

        return "Empresa/bloquearSocios";
    }





}
