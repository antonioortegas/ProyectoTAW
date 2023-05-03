package es.taw.proyectotaw.controller;

import es.taw.proyectotaw.Entity.*;
import es.taw.proyectotaw.dao.*;
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
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
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
        } else if(usuario.getEstadoUsuario().equals("bloqueado")){
            model.addAttribute("cliente", usuario);
            urlTo = "Cliente/esperarDesbloqueo";
        }else if(usuario.getEstadoUsuario().equals("pendiente")){
            model.addAttribute("cliente", usuario);
            urlTo = "Cliente/esperarVerificado";
        }else {
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
        cliente.getCuentabancoByCuentaBancoIdCuentaBanco().setSaldo(pasta);
        cliente.getCuentabancoByCuentaBancoIdCuentaBanco().setTipoMoneda(cd.getMonedaCompra());
        this.usuarioRepository.save(cliente);
        model.addAttribute("cliente", cliente);
        return "Cliente/indexCliente";
    }


    @PostMapping("/registrarCliente")
    public String registrarCliente(@RequestParam String nif, @RequestParam String nombre,
                                   @RequestParam(required = false) String segundoNombre, @RequestParam String apellido1,
                                   @RequestParam(required = false) String apellido2, @RequestParam Date fechaNacimiento,
                                   @RequestParam String calle, @RequestParam String numeroVivienda, @RequestParam String planta,
                                   @RequestParam String ciudad, @RequestParam(required = false) String region,
                                   @RequestParam String pais, @RequestParam String cp, @RequestParam boolean valida,
                                   @RequestParam String contrasena, Model model) {
        UsuarioEntity us = this.usuarioRepository.usuarioByNIF(nif);
        String urlTo = "Cliente/usuarioExistente";
        if(us==null){
        Byte val = 0;
        if(valida){
            val=1;
        }
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setTipoUsuario("cliente");
        usuario.setContrasena(contrasena);
        usuario.setFechaNacimiento(fechaNacimiento);
        usuario.setNif(nif);
        usuario.setNombre(nombre);
        usuario.setSegundoNombre(segundoNombre);
        usuario.setPrimerApellido(apellido1);
        usuario.setSegundoApellido(apellido2);
        usuario.setEstadoUsuario("pendiente");
        usuario.setFechaInicio(Date.valueOf(LocalDate.now()));
        DireccionEntity direccion = new DireccionEntity();
        direccion.setCalle(calle);
        direccion.setCiudad(ciudad);
        direccion.setNumero(numeroVivienda);
        direccion.setCp(cp);
        direccion.setPais(pais);
        direccion.setRegion(region);
        direccion.setPuerta(planta);
        direccion.setValida(val);
        this.direccionRepository.save(direccion);
        usuario.setDireccionByDireccionIdDireccion(direccion);
        this.usuarioRepository.save(usuario);
        model.addAttribute("cliente", usuario);
        urlTo ="Cliente/esperarVerificado";
        }

        return urlTo;
    }

}
