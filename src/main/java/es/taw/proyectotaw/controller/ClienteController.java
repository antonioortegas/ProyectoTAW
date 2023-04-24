package es.taw.proyectotaw.controller;

import es.taw.proyectotaw.Entity.UsuarioEntity;
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
public class ClienteController {

    @Autowired
    protected UsuarioRepository usuarioRepository;

    @GetMapping("/Cliente/crearNuevoCliente")
    public String crearNuevoCliente(){
        return "/Cliente/crearNuevoCliente";
    }

    @GetMapping("/Cliente/loginCliente")
    public String iniciarSesionCliente(Model model) {
        List<UsuarioEntity> lista = this.usuarioRepository.findAll();
        model.addAttribute("listaUsuarios", lista);
        return "Cliente/loginCliente";
    }

    @PostMapping("/loginCliente")
    public String doComprobarCredenciales (@RequestParam("nif") String nif,
                                @RequestParam("contrasena") String contrasena,
                                Model model, HttpSession session) {
        String urlTo = "Cliente/loginCliente";
        UsuarioEntity usuario = this.usuarioRepository.usuarioByNIFyContrasena(nif, contrasena);

        if (usuario == null) {
            model.addAttribute("error", "Credenciales incorrectas");
        } else {
            model.addAttribute("cliente", usuario);
            urlTo = "Cliente/indexCliente";
        }

        return urlTo;
    }
}
