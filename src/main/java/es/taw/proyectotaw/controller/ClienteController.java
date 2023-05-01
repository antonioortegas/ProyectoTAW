package es.taw.proyectotaw.controller;

import es.taw.proyectotaw.Entity.PeticionEntity;
import es.taw.proyectotaw.Entity.UsuarioEntity;
import es.taw.proyectotaw.dao.PeticionRepository;
import es.taw.proyectotaw.dao.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    protected UsuarioRepository usuarioRepository;

    @Autowired
    protected PeticionRepository peticionRepository;

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

    @GetMapping("/editarUsuario")
    public String editarCliente (Integer id, Model model, HttpSession session) {
        UsuarioEntity cliente = this.usuarioRepository.getReferenceById(id);
        model.addAttribute("cliente", cliente);
        return "Cliente/editarDatosCliente";
    }

    @GetMapping("/nuevaPeticionAlta")
    public String pedirAlta (Integer id,  Model model, HttpSession session) {
        UsuarioEntity cliente = this.usuarioRepository.getReferenceById(id);
        model.addAttribute("cliente", cliente);
        PeticionEntity peticion = null;
        peticion.setTipoPeticion("alta");
        peticion.setEstadoPeticion("noprocesada");
        peticion.setUsuarioByUsuarioIdUsuario(cliente);
        this.peticionRepository.save(peticion);
        return "Cliente/indexCliente";
    }

    @GetMapping("/nuevaPeticionInactivo")
    public String pedirActivo (Integer id, Model model, HttpSession session) {
        UsuarioEntity cliente = this.usuarioRepository.getReferenceById(id);
        model.addAttribute("cliente", cliente);
        PeticionEntity peticion = null;
        peticion.setTipoPeticion("activar");
        peticion.setEstadoPeticion("noprocesada");
        peticion.setUsuarioByUsuarioIdUsuario(cliente);
        this.peticionRepository.save(peticion);
        return "Cliente/indexCliente";
    }

    @GetMapping("/nuevaPeticionBloqueado")
    public String pedirDesbloqueo (@RequestParam("idUsuario") Integer id, Model model, HttpSession session) {
        UsuarioEntity cliente = this.usuarioRepository.getReferenceById(id);
        model.addAttribute("cliente", cliente);
        PeticionEntity peticion = new PeticionEntity();
        peticion.setTipoPeticion("desbloqueo");
        peticion.setEstadoPeticion("noprocesada");
        peticion.setUsuarioByUsuarioIdUsuario(cliente);
        this.peticionRepository.save(peticion);
        return "Cliente/indexCliente";
    }

    @PostMapping("/guardarCliente")
    public String doEditar (@ModelAttribute("cliente") UsuarioEntity cliente) {
        this.usuarioRepository.save(cliente);
        return "Cliente/indexCliente";
    }
}
