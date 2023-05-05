package es.taw.proyectotaw.controller;


import com.fasterxml.jackson.databind.annotation.JsonAppend;
import es.taw.proyectotaw.Entity.*;
import es.taw.proyectotaw.dao.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
public class EmpresaController {


    @Autowired
    protected EmpresaRepository empresaRepository;
    @Autowired
    protected UsuarioRepository usuarioRepository;

    @Autowired
    protected DireccionRepository direccionRepository;
    @Autowired
    protected CambiodivisaRepository cambiodivisaRepository;
    @Autowired
    protected CuentabancoRepository cuentabancoRepository;

    @Autowired
    protected PagoRepository pagoRepository;
    @Autowired
    protected TransaccionRepository transaccionRepository;

    @GetMapping("/goPrincipalEmpresa")
    public String goPrincipalEmpresa(Model model, HttpSession httpSession) {


        return "/Empresa/sesionIniciadaEmpresa";
    }


    @GetMapping("/Empresa/crearNuevaEmpresa")
    public String crearNuevaEmpresa(@ModelAttribute("empresa") EmpresaEntity empresa) {
        //this.empresaRepository.save(empresa);
        return "Empresa/crearNuevaEmpresa";
    }
    @GetMapping("/Empresa/SalirEmpresa")
    public String salirEmpresa(Model model) {

        return "../index";
    }


    @RequestMapping("/procesarFormularioEmpresa")
    public String procesarFormularioEmpresa(@ModelAttribute("empresa") EmpresaEntity empresa, @ModelAttribute("direccion") DireccionEntity direccion) {
        System.out.println("PETA 1");
        //DireccionEntity direccionEntity = new DireccionEntity(11,"CAlle pilar","33","aa","MALAGA","SPAIN","12341", (byte) 1);
        //DireccionEntity direccionEntity = new DireccionEntity("CAlle pilar", "33", "aa", "MALAGA", "SPAIN", "12341", (byte) 1);
        //EmpresaEntity empresa1 = new EmpresaEntity(11, "222", "empresaPruebas", direccionEntity);
        //this.direccionRepository.save(direccionEntity);
        //this.empresaRepository.save(empresa1);
        //this.empresaRepository.save(empresa);
        System.out.println(empresa.getNombre());
        System.out.println(empresa.getIdEmpresa());
        System.out.println(empresa.getCif());
        System.out.println(direccion.getCalle());
        System.out.println(direccion.getIdDireccion());
        System.out.println(direccion.getCp());
        System.out.println("PETA 2");
        return "/Empresa/crearUsuarioEmpresa";
    }

    @RequestMapping("/Empresa/crearNuevoSocio")
    public String crearNuevoSocio(@ModelAttribute("empresa") EmpresaEntity empresa, @ModelAttribute("direccion") DireccionEntity direccion, Model model) {
        List<UsuarioEntity> lu = (List<UsuarioEntity>) empresa.getUsuariosByIdEmpresa();
        model.addAttribute("lu", lu);
        return "Empresa/crearUsuarioEmpresa";
    }


    public String iniciarSesionEmpresa() {


        return "Empresa/login";
    }

    @PostMapping("/loginSocio")
    public String doAutenticar(@RequestParam("nif") String nif, @RequestParam("contrasena") String contrasena,
                               Model model, HttpSession session) {
        String urlTo = "/Empresa/sesionIniciadaEmpresa";
        UsuarioEntity socio = this.usuarioRepository.autenticarUsuarioEmpresa(nif, contrasena);
        if (socio == null) {
            model.addAttribute("error", "Credenciales incorrectas");
            urlTo = "loginSocio";
        } else {
            EmpresaEntity empresa = socio.getEmpresaByEmpresaIdEmpresa();
            model.addAttribute("socio", socio);
            session.setAttribute("socio", socio);
            model.addAttribute("empresa", empresa);
            session.setAttribute("empresa", empresa);
        }

        return urlTo;
    }

    @GetMapping("/Empresa/loginSocio")
    public String iniciarSesionEmpleadp() {
        return "Empresa/login";
    }

    @GetMapping("/Empresa/bloquearSocios")
    public String bloquarSocios(Integer id, Model model, HttpSession httpSession) {
        UsuarioEntity socio = (UsuarioEntity) httpSession.getAttribute("socio");
        System.out.println("Solicitamos lista de usuarios de una empresa");
        List<UsuarioEntity> listaUsuariosEmpresa = this.usuarioRepository.buscarUsuariosMismaEmpresa(id);
        //List<UsuarioEntity> listaUsuariosEmpresa = this.usuarioRepository.buscarUsuariosMismaEmpresa(1);
        System.out.println("Añadimos lista de usuarios");
        model.addAttribute("listaUsuriosEmpresa", listaUsuariosEmpresa);
        model.addAttribute("socio", socio);
        for (UsuarioEntity u :
                listaUsuariosEmpresa) {
            System.out.println(u.getNombre());
        }

        return "Empresa/bloquearSocios";
    }

    @GetMapping("/Empresa/cambiarEstadoSocio")
    public String cambioEstadoSocio(Integer idCambio, Model model, HttpSession httpSession) {
        String desbloqueada = "desbloqueada";
        String bloqueada = "bloqueada";
        System.out.println("entro");

        UsuarioEntity socio = (UsuarioEntity) httpSession.getAttribute("socio");

        UsuarioEntity socioCambio = usuarioRepository.getById(idCambio);
        System.out.println(socioCambio.getNombre() + " " + socioCambio.getTipoPersonaRelacionada());

        if (socioCambio.getTipoPersonaRelacionada() == null) {
            socioCambio.setTipoPersonaRelacionada(desbloqueada.toLowerCase());
        } else {
            if (socioCambio.getTipoPersonaRelacionada().toString().toLowerCase().equals(bloqueada.toString().toLowerCase())) {
                socioCambio.setTipoPersonaRelacionada(desbloqueada.toLowerCase());
                System.out.println(2);
                System.out.println(socioCambio.getTipoPersonaRelacionada());
            } else if (socioCambio.getTipoPersonaRelacionada().toString().toLowerCase().equals(desbloqueada.toString().toLowerCase())) {
                socioCambio.setTipoPersonaRelacionada(bloqueada.toLowerCase());
                System.out.println(3);
                System.out.println(socioCambio.getTipoPersonaRelacionada());
            }

        }

        this.usuarioRepository.save(socioCambio);

        Integer id = socioCambio.getEmpresaByEmpresaIdEmpresa().getIdEmpresa();
        List<UsuarioEntity> listaUsuariosEmpresa = this.usuarioRepository.buscarUsuariosMismaEmpresa(id);
        for (
                UsuarioEntity u :
                listaUsuariosEmpresa) {
            System.out.println(u.getNombre() + " " + u.getTipoPersonaRelacionada());
        }
        model.addAttribute("listaUsuriosEmpresa", listaUsuariosEmpresa);

        model.addAttribute("socio", socio);

        return "Empresa/bloquearSocios";

    }

    @GetMapping("/Empresa/mostrarSoloSocios")
    public String mostrarSoloSocios(Integer idEmpresa, Model model, HttpSession httpSession) {
        UsuarioEntity socio = (UsuarioEntity) httpSession.getAttribute("socio");

        List<UsuarioEntity> listaSocios = this.empresaRepository.buscarSocios(idEmpresa);

        model.addAttribute("listaUsuriosEmpresa", listaSocios);
        model.addAttribute("socio", socio);
        httpSession.setAttribute("socio", socio);
        httpSession.setAttribute("listaUsuariosEmpresa", listaSocios);
        return "Empresa/bloquearSocios";

    }

    @GetMapping("/Empresa/mostrarSoloAutorizados")
    public String mostrarSoloAutorizados(Integer idEmpresa, Model model, HttpSession httpSession) {
        UsuarioEntity socio = (UsuarioEntity) httpSession.getAttribute("socio");
        List<UsuarioEntity> listaSocios = this.empresaRepository.buscarAutorizados(idEmpresa);
        model.addAttribute("listaUsuriosEmpresa", listaSocios);
        model.addAttribute("socio", socio);
        httpSession.setAttribute("socio", socio);
        httpSession.setAttribute("listaUsuariosEmpresa", listaSocios);
        return "Empresa/bloquearSocios";

    }

    @GetMapping("/Empresa/mostrarTodos")
    public String mostrarTodos(Integer idEmpresa, Model model, HttpSession httpSession) {
        UsuarioEntity socio = (UsuarioEntity) httpSession.getAttribute("socio");
        List<UsuarioEntity> listaSocios = this.usuarioRepository.buscarUsuariosMismaEmpresa(idEmpresa);
        model.addAttribute("listaUsuriosEmpresa", listaSocios);
        model.addAttribute("socio", socio);
        httpSession.setAttribute("socio", socio);
        httpSession.setAttribute("listaUsuariosEmpresa", listaSocios);
        return "Empresa/bloquearSocios";

    }


    @GetMapping("/Empresa/editarDatosSocio")
    public String editarSocio(Integer id, Model model, HttpSession session) {
        UsuarioEntity socio = this.usuarioRepository.getReferenceById(id);
        model.addAttribute("socio", socio);
        EmpresaEntity empresa = socio.getEmpresaByEmpresaIdEmpresa();
        model.addAttribute("empresa", empresa);
        return "Empresa/editarDatosSocio";
    }

    @PostMapping("/guardarSocio")
    public String guardarSocio(@ModelAttribute("socio") UsuarioEntity socio) {
        this.usuarioRepository.save(socio);
        return "Empresa/sesionIniciadaEmpresa";
    }


    @GetMapping("/Empresa/editarDatosEmpresa")
    public String editarEmpresa(Integer id, Model model, HttpSession session) {
        UsuarioEntity socio = this.usuarioRepository.getReferenceById(id);
        EmpresaEntity empresa = socio.getEmpresaByEmpresaIdEmpresa();
        model.addAttribute("empresa", empresa);
        model.addAttribute("socio", socio);

        return "Empresa/editarDatosEmpresa";
    }

    @PostMapping("/guardarEmpresa")
    public String guardarEmpresa(@ModelAttribute("empresa") EmpresaEntity empresa) {
        this.empresaRepository.save(empresa);
        //Añadir socio al modelo??
        return "Empresa/sesionIniciadaEmpresa";
    }

    @GetMapping("/historialOperacionesEmpresa")
    public String mostrarHistorial(Integer id, Model model, HttpSession session) {
        UsuarioEntity socio = this.usuarioRepository.getReferenceById(id);
        model.addAttribute("socio", socio);
        return "Empresa/historialOperacionesEmpresa";
    }


    @GetMapping("/pagoEmpresa")
    public String pagoCliente(Integer id, Model model, HttpSession session) {
        EmpresaEntity empresa = this.empresaRepository.getReferenceById(id);
        model.addAttribute("empresa", empresa);
        List<CambiodivisaEntity> cambioDivisa = this.cambiodivisaRepository.listaCambioDivisa(empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco().getTipoMoneda());
        model.addAttribute("cambioDivisa", cambioDivisa);

        return "Empresa/pagoEmpresa";
    }

    @PostMapping("/verificarTransferenciaEmpresa")
    public String doVerificarPago(@RequestParam("id") Integer id, @RequestParam("cantidad") Integer cantidad, @RequestParam("iban") String iban, Model model) {
        String UrlTo = "Empresa/verificarPagoEmpresa";
        // UsuarioEntity cliente = this.usuarioRepository.findById(id).orElse(null);
        EmpresaEntity empresa = this.empresaRepository.findById(id).orElse(null);
        CuentabancoEntity cb = this.cuentabancoRepository.cuentaDestinatario(iban);
        PagoEntity pago = new PagoEntity();
        pago.setCantidad(cantidad);
        pago.setMoneda(empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco().getTipoMoneda());
        pago.setIbanBeneficiario(iban);
        if (cb != null) {//si la cuenta es de nuestro banco le sumamos el dinero si posee el mismo tipo de moneda
            if (cb.getTipoMoneda().equals(empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco().getTipoMoneda())) {
                cb.setSaldo(cb.getSaldo() + cantidad);
                empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco().setSaldo(empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco().getSaldo() - cantidad);
                this.empresaRepository.save(empresa);
                TransaccionEntity transaccion = new TransaccionEntity();
                transaccion.setFechaInstruccion(Date.valueOf(LocalDate.now()));
                transaccion.setCuentabancoByCuentaBancoIdCuentaBanco(empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco());
                this.pagoRepository.save(pago);
                transaccion.setPagoByPagoIdPago(pago);
                this.transaccionRepository.save(transaccion);
            } else {
                UrlTo = "Empresa/errorMonedaDistintaEmpresa";
            }
        } else {

            empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco().setSaldo(empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco().getSaldo() - cantidad);
            this.empresaRepository.save(empresa);
            TransaccionEntity transaccion = new TransaccionEntity();
            transaccion.setFechaInstruccion(Date.valueOf(LocalDate.now()));
            transaccion.setCuentabancoByCuentaBancoIdCuentaBanco(empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco());
            this.pagoRepository.save(pago);
            transaccion.setPagoByPagoIdPago(pago);
            this.transaccionRepository.save(transaccion);
        }
        model.addAttribute("empresa", empresa);

        return UrlTo;
    }



    @GetMapping("/cambioDeDivisaEmpresa")
    public String cambioDivisa (Integer id, Model model, HttpSession session) {
        EmpresaEntity empresa = this.empresaRepository.getReferenceById(id);
        model.addAttribute("empresa", empresa);
        List<CambiodivisaEntity> cambioDivisa = this.cambiodivisaRepository.listaCambioDivisa(empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco().getTipoMoneda());
        model.addAttribute("cambioDivisa", cambioDivisa);

        return "Empresa/cambioDivisaEmpresa";
    }
    @PostMapping("/verificarCambioDivisaEmpresa")
    public String doVerificarCambioDivisa (@RequestParam("id") Integer id, @RequestParam("cambio") Integer cambio, Model model) {
        EmpresaEntity empresa = this.empresaRepository.findById(id).orElse(null);
        CambiodivisaEntity cd = this.cambiodivisaRepository.findById(cambio).orElse(null);
        model.addAttribute("cambioDivisa", cd);
        model.addAttribute("empresa", empresa);
        float f = Float.valueOf(cd.getCantidadVenta()).floatValue()/Float.valueOf(cd.getCantidadCompra()).floatValue()*empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco().getSaldo();
        int pasta = Float.valueOf(f).intValue();
        model.addAttribute("pasta", pasta);
        return "Empresa/verificarCambioDivisaEmpresa";
    }
}
