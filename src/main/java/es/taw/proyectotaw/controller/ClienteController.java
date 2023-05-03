package es.taw.proyectotaw.controller;

import es.taw.proyectotaw.Entity.*;
import es.taw.proyectotaw.dao.*;
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
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import static java.lang.System.*;

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

    @Autowired
    protected CuentabancoRepository cuentabancoRepository;

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

    @GetMapping("/volverIndex")
    public String volverIndexCliente (Integer id, Model model, HttpSession session) {
        UsuarioEntity cliente = this.usuarioRepository.getReferenceById(id);
        model.addAttribute("cliente", cliente);
        return "Cliente/indexCliente";
    }

    @GetMapping("/cambioDeDivisaCliente")
    public String cambioDivisa (Integer id, Model model, HttpSession session) {
        UsuarioEntity cliente = this.usuarioRepository.getReferenceById(id);
        model.addAttribute("cliente", cliente);
        List<CambiodivisaEntity> cambioDivisa = this.cambiodivisaRepository.listaCambioDivisa(cliente.getCuentabancoByCuentaBancoIdCuentaBanco().getTipoMoneda());
        model.addAttribute("cambioDivisa", cambioDivisa);

        return "Cliente/cambioDivisaCliente";
    }

    @GetMapping("/nuevaPeticionAlta")
    public String pedirAlta (Integer id,  Model model, HttpSession session) {
        UsuarioEntity cliente = this.usuarioRepository.getReferenceById(id);
        model.addAttribute("cliente", cliente);
        PeticionEntity peticion = new PeticionEntity();
        peticion.setTipoPeticion("alta");
        peticion.setEstadoPeticion("noprocesada");
        peticion.setFechaPeticion(new Timestamp(currentTimeMillis()));
        peticion.setUsuarioByUsuarioIdUsuario(cliente);
        this.peticionRepository.save(peticion);
        return "Cliente/indexCliente";
    }

    @GetMapping("/nuevaPeticionInactivo")
    public String pedirActivo (Integer id, Model model, HttpSession session) {
        UsuarioEntity cliente = this.usuarioRepository.getReferenceById(id);
        model.addAttribute("cliente", cliente);
        PeticionEntity peticion = new PeticionEntity();
        peticion.setTipoPeticion("activar");
        peticion.setEstadoPeticion("noprocesada");
        peticion.setFechaPeticion(new Timestamp(currentTimeMillis()));
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
        peticion.setFechaPeticion(new Timestamp(currentTimeMillis()));
        peticion.setUsuarioByUsuarioIdUsuario(cliente);
        this.peticionRepository.save(peticion);
        return "Cliente/indexCliente";
    }

    @PostMapping("/guardarCliente")
    public String doGuardar (@ModelAttribute("cliente") UsuarioEntity cliente) {
        this.usuarioRepository.save(cliente);
        return "Cliente/indexCliente";
    }

    @PostMapping("/verificarCambioDivisa")
    public String doVerificarCambioDivisa (@RequestParam("cambio") String cambio, Model model) {
        UsuarioEntity cliente = (UsuarioEntity) model.getAttribute("cliente");
        CambiodivisaEntity cd = this.cambiodivisaRepository.miCambioDivisa(cambio, cliente.getCuentabancoByCuentaBancoIdCuentaBanco().getTipoMoneda());
        model.addAttribute("cambioDivisa", cd);
        model.addAttribute("cliente", cliente);
        return "Cliente/verificarCambioDivisaCliente";
    }

    @GetMapping("/realizarCambio")
    public String realizarCambio (Integer id,Integer cambioDivisa, Model model, HttpSession session) {
        UsuarioEntity cliente = this.usuarioRepository.getReferenceById(id);
        CambiodivisaEntity cd = this.cambiodivisaRepository.getReferenceById(cambioDivisa);
        int pasta = (Integer.parseInt(cd.getCantidadVenta())/Integer.parseInt(cd.getCantidadCompra()))*cliente.getCuentabancoByCuentaBancoIdCuentaBanco().getSaldo();

        model.addAttribute("cliente", cliente);
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
