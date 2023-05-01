package es.taw.proyectotaw.controller;

import es.taw.proyectotaw.Entity.CambiodivisaEntity;
import es.taw.proyectotaw.Entity.DireccionEntity;
import es.taw.proyectotaw.Entity.PeticionEntity;
import es.taw.proyectotaw.Entity.UsuarioEntity;
import es.taw.proyectotaw.dao.CambiodivisaRepository;
import es.taw.proyectotaw.dao.DireccionRepository;
import es.taw.proyectotaw.dao.PeticionRepository;
import es.taw.proyectotaw.dao.UsuarioRepository;
import es.taw.proyectotaw.ui.FormularioRegistroCliente;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    protected UsuarioRepository usuarioRepository;

    @Autowired
    protected PeticionRepository peticionRepository;

    @Autowired
    protected DireccionRepository direccionRepository;

    @Autowired
    protected CambiodivisaRepository cambiodivisaRepository;

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

    @GetMapping("/historialOperaciones")
    public String mostrarHistorial (Integer id, Model model, HttpSession session) {
        UsuarioEntity cliente = this.usuarioRepository.getReferenceById(id);
        model.addAttribute("cliente", cliente);
        return "Cliente/historialOperaciones";
    }

    @GetMapping("/cambioDeDivisaCliente")
    public String cambioDivisa (Integer id, Model model, HttpSession session) {
        UsuarioEntity cliente = this.usuarioRepository.getReferenceById(id);
        model.addAttribute("cliente", cliente);
        List<CambiodivisaEntity> cambioDivisa = this.cambiodivisaRepository.findAll();
        model.addAttribute("cambioDivisa", cambioDivisa);


        return "Cliente/cambioDivisaCliente";
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

    @PostMapping("/registroCliente")
    public String registroCliente(@Valid @ModelAttribute("formularioRegistroCliente") FormularioRegistroCliente formularioRegistroCliente, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "formularioRegistroCliente";
        } else {
            UsuarioEntity cliente = formularioRegistroCliente.getUsuario();
            DireccionEntity direccion = formularioRegistroCliente.getDireccion();
            cliente.setDireccionByDireccionIdDireccion(direccion);
            this.usuarioRepository.save(cliente);
            this.direccionRepository.save(direccion);
            model.addAttribute("cliente", cliente);
            return "Cliente/indexCliente";
        }
    }



}
