package es.taw.proyectotaw.controller;


import es.taw.proyectotaw.Entity.*;
import es.taw.proyectotaw.dao.*;
import es.taw.proyectotaw.ui.CrearNuevaEmpresa;
import es.taw.proyectotaw.ui.CrearNuevoSocio;
import es.taw.proyectotaw.ui.FEditarEmpresa;
import es.taw.proyectotaw.ui.FiltroTransaccionEmpresa;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.currentTimeMillis;
//Codigo hecho por Sergio Morejon
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
    @Autowired
    protected PeticionRepository peticionRepository;


    //Metodo para cerrar la sesion
    @GetMapping("/Empresa/SalirEmpresa")
    public String salirEmpresa(Model model) {

        return "Empresa/empresaPrincipal";
    }

    //Metodo para ir a la pagina principal de la empresa
    @GetMapping("/goPrincipalEmpresa")
    public String goPrincipalEmpresa(Model model, HttpSession httpSession, @RequestParam("id") Integer id) {
        UsuarioEntity socio = this.usuarioRepository.findById(id).orElse(null);
        model.addAttribute("socio", socio);
        EmpresaEntity empresa = socio.getEmpresaByEmpresaIdEmpresa();
        model.addAttribute("empresa", empresa);
        return "/Empresa/sesionIniciadaEmpresa";
    }

    //Metodo para crear una nueva empresa
    @GetMapping("/Empresa/crearNuevaEmpresa")
    public String crearNuevaEmpresa(Model model) {
        CrearNuevaEmpresa crearNuevaEmpresa = new CrearNuevaEmpresa();
        model.addAttribute("crearNuevaEmpresa", crearNuevaEmpresa);
        return "Empresa/crearNuevaEmpresa";
    }

    //Metodo para procesar el formulario de crear una nueva empresa
    @PostMapping("/procesarFormularioEmpresa")
    public String procesarFormularioEmpresa(@ModelAttribute("crearNuevaEmpresa") CrearNuevaEmpresa crearNuevaEmpresa, Model model) {

        EmpresaEntity empresa = new EmpresaEntity();
        empresa.setCif(crearNuevaEmpresa.getCif());
        empresa.setNombre(crearNuevaEmpresa.getNombre());
        empresa.setEstadoEmpresa("pendiente");

        DireccionEntity direccion = new DireccionEntity();
        direccion.setCalle(crearNuevaEmpresa.getCalle());
        direccion.setNumero(crearNuevaEmpresa.getNumero());
        direccion.setPuerta(crearNuevaEmpresa.getPuerta());
        direccion.setCiudad(crearNuevaEmpresa.getCiudad());
        direccion.setPais(crearNuevaEmpresa.getPais());
        direccion.setCp(crearNuevaEmpresa.getCp());
        direccion.setValida((byte) 1);

        String urlTo = "";
        if (empresa != null) {

            direccionRepository.save(direccion);
            empresa.setDireccionByDireccionIdDireccion(direccion);
            empresaRepository.save(empresa);

            PeticionEntity peticion = new PeticionEntity();
            peticion.setTipoPeticion("alta");
            peticion.setEstadoPeticion("noprocesada");
            peticion.setFechaPeticion(new Timestamp(currentTimeMillis()));
            peticion.setEmpresaByEmpresaIdEmpresa(empresa);
            this.peticionRepository.save(peticion);
            CrearNuevoSocio crearNuevoSocio = new CrearNuevoSocio();

            model.addAttribute("crearNuevoSocio", crearNuevoSocio);
            model.addAttribute("empresa", empresa);

            urlTo = "Empresa/crearUsuarioEmpresa";
        } else {
            System.out.println("no se ha creado la empresa");
        }

        return urlTo;
    }


    @GetMapping("/Empresa/registrarNuevoSocio")
    public String registrarNuevoSocio(Integer id, Model model) {
        UsuarioEntity socio = this.usuarioRepository.getReferenceById(id);

        CrearNuevoSocio crearNuevoSocio = new CrearNuevoSocio(id);

        model.addAttribute("crearNuevoSocio", crearNuevoSocio);
        model.addAttribute("socio", socio);
        model.addAttribute("empresa", socio.getEmpresaByEmpresaIdEmpresa());


        return "Empresa/crearUsuarioEmpresa";
    }

    //Metodo para procesar el formulario de crear el primer socio o anadir uno mas
    @PostMapping("/procesarRegistrarNuevoSocio")
    public String procesarRegistrarNuevoSocio(@ModelAttribute("crearNuevoSocio") CrearNuevoSocio crearNuevoSocio, Model model, HttpSession session) {


        DireccionEntity nuevaDireccion = new DireccionEntity();
        UsuarioEntity nuevoSocio = new UsuarioEntity();
        EmpresaEntity empresa = new EmpresaEntity();
        UsuarioEntity socio = new UsuarioEntity();
        if (crearNuevoSocio.getId() != null) {
            socio = usuarioRepository.findById(crearNuevoSocio.getId()).orElse(null);
        }
        if (crearNuevoSocio.getIdEmpresa() == null) {
            empresa = socio.getEmpresaByEmpresaIdEmpresa();

        } else {
            empresa = empresaRepository.findById(crearNuevoSocio.getIdEmpresa()).orElse(null);
        }


        nuevoSocio.setNif(crearNuevoSocio.getNif());
        nuevoSocio.setNombre(crearNuevoSocio.getNombre());
        nuevoSocio.setSegundoNombre(crearNuevoSocio.getSegundoNombre());
        nuevoSocio.setPrimerApellido(crearNuevoSocio.getApellido1());
        nuevoSocio.setSegundoApellido(crearNuevoSocio.getApellido2());
        nuevoSocio.setFechaNacimiento(crearNuevoSocio.getFechaNacimiento());
        nuevoSocio.setContrasena(crearNuevoSocio.getContrasena());
        nuevoSocio.setTipoUsuario(crearNuevoSocio.getTipoUsuario());
        nuevoSocio.setEstadoUsuario("pendiente");
        nuevoSocio.setFechaInicio(Date.valueOf(LocalDate.now()));
        nuevoSocio.setEmpresaByEmpresaIdEmpresa(empresa);
        nuevoSocio.setTipoPersonaRelacionada("desbloqueada");
        nuevaDireccion.setCalle(crearNuevoSocio.getCalle());
        nuevaDireccion.setNumero(crearNuevoSocio.getNumeroVivienda());
        nuevaDireccion.setPuerta(crearNuevoSocio.getPlanta());
        nuevaDireccion.setCiudad(crearNuevoSocio.getCiudad());
        nuevaDireccion.setRegion(crearNuevoSocio.getRegion());
        nuevaDireccion.setPais(crearNuevoSocio.getPais());
        nuevaDireccion.setCp(crearNuevoSocio.getCp());
        nuevaDireccion.setValida((byte) 1);
        nuevoSocio.setDireccionByDireccionIdDireccion(nuevaDireccion);


        String urlTo = "Empresa/socioExistente";

        if (nuevoSocio != null) {

            direccionRepository.save(nuevaDireccion);
            usuarioRepository.save(nuevoSocio);
            PeticionEntity peticion = new PeticionEntity();
            peticion.setTipoPeticion("alta");
            peticion.setEstadoPeticion("noprocesada");
            peticion.setFechaPeticion(new Timestamp(currentTimeMillis()));
            peticion.setUsuarioByUsuarioIdUsuario(nuevoSocio);
            this.peticionRepository.save(peticion);
            if (socio != null) {
                model.addAttribute("socio", socio);
                model.addAttribute("empresa", socio.getEmpresaByEmpresaIdEmpresa());
                session.setAttribute("socio", socio);
                urlTo = "Empresa/sesionIniciadaEmpresa";
            } else {
                urlTo = "Empresa/empresaPrincipal";
            }


        } else {
            urlTo = "/Empresa/empresaPrincipal";
        }

        return urlTo;
    }

    //Metodo para procesar el formulario de crear el primer socio o anadir uno mas
    @PostMapping("/loginSocioP")
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

    //Metodo para hacer login en la empresa
    @GetMapping("/Empresa/loginSocio")
    public String iniciarSesionEmpleadp() {
        return "Empresa/login";
    }



    //Metodo para listar los socios de una empresa
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

    //Metodo para cambiar el estado de un socio
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

    //Filtro para mostrar solo los socios
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
    //Filtro para mostrar solo los autorizados

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

    //Filtro para mostrar todos los usuarios
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


    //Metodo para editar los datos de un socio
    @GetMapping("/Empresa/editarDatosSocio")
    public String editarSocio(Integer id, Model model, HttpSession session) {
        UsuarioEntity socio = this.usuarioRepository.getReferenceById(id);
        model.addAttribute("socio", socio);
        EmpresaEntity empresa = socio.getEmpresaByEmpresaIdEmpresa();
        model.addAttribute("empresa", empresa);
        return "Empresa/editarDatosSocio";
    }

    //Metodo para guardar los datos de un socio
    @PostMapping("/guardarSocio")
    public String guardarSocio(@ModelAttribute("socio") UsuarioEntity socio, Model model) {
        this.usuarioRepository.save(socio);
        EmpresaEntity empresa = socio.getEmpresaByEmpresaIdEmpresa();
        model.addAttribute("empresa", empresa);
        model.addAttribute("socio", socio);
        return "Empresa/sesionIniciadaEmpresa";
    }

    //Metodo para editar los datos de una empresa
    @GetMapping("/Empresa/editarDatosEmpresa")
    public String editarEmpresa(Integer id, Model model, HttpSession httpSession) {
        UsuarioEntity socio = this.usuarioRepository.getReferenceById(id);
        EmpresaEntity empresa = socio.getEmpresaByEmpresaIdEmpresa();

        FEditarEmpresa fEditarEmpresa = new FEditarEmpresa(empresa.getNombre(), empresa.getCif(), empresa.getIdEmpresa(), empresa.getDireccionByDireccionIdDireccion().getIdDireccion(), empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco().getIdCuentaBanco(), socio.getIdUsuario());
        model.addAttribute("empresa", empresa);
        model.addAttribute("socio", socio);
        model.addAttribute("fEditarEmpresa", fEditarEmpresa);


        return "Empresa/editarDatosEmpresa";
    }
    //Metodo para guardar los datos de una empresa
    @PostMapping("/guardarEmpresa")
    public String guardarEmpresa(@ModelAttribute("fEditarEmpresa") FEditarEmpresa fEditarEmpresa, Model model) {
        EmpresaEntity empresa = this.empresaRepository.getReferenceById(fEditarEmpresa.getIdEmpresa());
        empresa.setCif(fEditarEmpresa.getCif());
        empresa.setNombre(fEditarEmpresa.getNombre());
        this.empresaRepository.save(empresa);

        model.addAttribute("empresa", empresa);
        model.addAttribute("socio", this.usuarioRepository.getReferenceById(fEditarEmpresa.getIdSocio()));

        return "Empresa/sesionIniciadaEmpresa";
    }
    //Metodo para ver el historial de operaciones de una empresa
    @GetMapping("/historialOperacionesEmpresa")
    public String mostrarHistorial(Integer id, Model model, HttpSession session) {
        UsuarioEntity socio = this.usuarioRepository.getReferenceById(id);
        model.addAttribute("socio", socio);
        EmpresaEntity empresa = socio.getEmpresaByEmpresaIdEmpresa();
        model.addAttribute("empresa", empresa);

        List<UsuarioEntity> actores = new ArrayList<>();
        for (UsuarioEntity u : empresa.getUsuariosByIdEmpresa()) {
            actores.add(u);
        }
        model.addAttribute("actores", actores);

        if (model.containsAttribute("filtroTransaccionesEmpresa") && model.getAttribute("filtroTransaccionesEmpresa") != null) {
            return procesarFiltradoTransaccionesEmpresa(id, model, (FiltroTransaccionEmpresa) model.getAttribute("filtroTransaccionesEmpresa"));
        } else {
            return procesarFiltradoTransaccionesEmpresa(id, model, null);
        }
    }

    //Metodo para filtrar las transacciones de una empresa
    @PostMapping("/Empresa/filtrarTransaccionesEmpresa")
    public String filtrarTransaccionesEmpresa(Model model, @ModelAttribute("filtroTransaccionesEmpresa") FiltroTransaccionEmpresa filtroTransaccion) {
        return procesarFiltradoTransaccionesEmpresa(filtroTransaccion.getId_socio(), model, filtroTransaccion);
    }
    private String procesarFiltradoTransaccionesEmpresa(Integer id, Model model, FiltroTransaccionEmpresa filtro) {
        System.out.println(id);

        UsuarioEntity socio = this.usuarioRepository.findById(id).orElse(null);
        EmpresaEntity empresa = socio.getEmpresaByEmpresaIdEmpresa();
        List<UsuarioEntity> listaUsuarios = this.usuarioRepository.findAllByEmpresaByEmpresaIdEmpresa(empresa);

        model.addAttribute("listaUsuarios", listaUsuarios);
        model.addAttribute("socio", socio);

        model.addAttribute("empresa", empresa);
        System.out.println(socio.getNombre());
        System.out.println(empresa.getNombre());


        List<TransaccionEntity> listaTransacciones = null;
        List<UsuarioEntity> actores = new ArrayList<>();
        for (UsuarioEntity u : empresa.getUsuariosByIdEmpresa()) {
            actores.add(u);
        }
        model.addAttribute("actores", actores);

        if (filtro == null) {
            filtro = new FiltroTransaccionEmpresa();
            listaTransacciones = this.transaccionRepository.findAllByCuentabancoByCuentaBancoIdCuentaBanco(Sort.by(filtro.getOrden()), empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco());
        }
        if (filtro.getPropiedad().equals("")) {
            listaTransacciones = this.transaccionRepository.findAllByCuentabancoByCuentaBancoIdCuentaBanco(Sort.by(filtro.getOrden()), empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco());
        }
        if (filtro.getPropiedad().equals("Pago")) {
            listaTransacciones = this.transaccionRepository.findAllByCuentabancoByCuentaBancoIdCuentaBancoEqualsAndPagoByPagoIdPagoNotNull(empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco(), Sort.by(filtro.getOrden()));
        }
        if (filtro.getPropiedad().equals("Cambio de divisa")) {
            listaTransacciones = this.transaccionRepository.findAllByCuentabancoByCuentaBancoIdCuentaBancoEqualsAndCambiodivisaByCambioDivisaIdCambioDivisaNotNull(empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco(), Sort.by(filtro.getOrden()));
        }

        model.addAttribute("listaTransacciones", listaTransacciones);
        model.addAttribute("filtroTransaccionEmpresa", filtro);

        return "Empresa/historialOperacionesEmpresa";
    }

    //Metodo para realizar una transferencia
    @GetMapping("/pagoEmpresa")
    public String pagoCliente(Integer id, Model model, HttpSession session) {
        UsuarioEntity socio = this.usuarioRepository.getReferenceById(id);
        EmpresaEntity empresa = socio.getEmpresaByEmpresaIdEmpresa();
        model.addAttribute("socio", socio);
        model.addAttribute("empresa", empresa);
        List<CambiodivisaEntity> cambioDivisa = this.cambiodivisaRepository.listaCambioDivisa(empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco().getTipoMoneda());
        model.addAttribute("cambioDivisa", cambioDivisa);

        return "Empresa/pagoEmpresa";
    }

    //Metodo para procesar una transferencia
    @PostMapping("/verificarTransferenciaEmpresa")
    public String doVerificarPago(@RequestParam("id") Integer id, @RequestParam("cantidad") Integer cantidad, @RequestParam("iban") String iban, Model model) {
        String UrlTo = "Empresa/verificarPagoEmpresa";
        UsuarioEntity socio = this.usuarioRepository.findById(id).orElse(null);

        EmpresaEntity empresa = socio.getEmpresaByEmpresaIdEmpresa();
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
                transaccion.setIdUsuarioActor(socio.getIdUsuario());
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
        model.addAttribute("socio", socio);

        return UrlTo;
    }


    //Metodo para realizar un cambio de divisa
    @GetMapping("/cambioDeDivisaEmpresa")
    public String cambioDivisa(Integer id, Model model, HttpSession session) {
        UsuarioEntity socio = this.usuarioRepository.getReferenceById(id);

        EmpresaEntity empresa = socio.getEmpresaByEmpresaIdEmpresa();
        model.addAttribute("socio", socio);
        model.addAttribute("empresa", empresa);
        List<CambiodivisaEntity> cambioDivisa = this.cambiodivisaRepository.listaCambioDivisa(empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco().getTipoMoneda());
        model.addAttribute("cambioDivisa", cambioDivisa);

        return "Empresa/cambioDivisaEmpresa";
    }
    //Metodo para procesar un cambio de divisa

    @PostMapping("/verificarCambioDivisaEmpresa")
    public String doVerificarCambioDivisa(@RequestParam("id") Integer id, @RequestParam("cambio") Integer cambio, Model model) {
        UsuarioEntity socio = this.usuarioRepository.findById(id).orElse(null);
        EmpresaEntity empresa = socio.getEmpresaByEmpresaIdEmpresa();
        CambiodivisaEntity cd = this.cambiodivisaRepository.findById(cambio).orElse(null);
        model.addAttribute("cambioDivisa", cd);
        model.addAttribute("socio", socio);
        model.addAttribute("empresa", empresa);
        float f = Float.valueOf(cd.getCantidadVenta()).floatValue() / Float.valueOf(cd.getCantidadCompra()).floatValue() * empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco().getSaldo();
        int pasta = Float.valueOf(f).intValue();
        model.addAttribute("pasta", pasta);
        return "Empresa/verificarCambioDivisaEmpresa";
    }
    //Metodo para realizar cambio de divisa
    @GetMapping("/realizarCambioEmpresa")
    public String realizarCambio(Integer id, Integer cambioDivisa, Integer pasta, Model model, HttpSession session) {
        UsuarioEntity socio = this.usuarioRepository.findById(id).orElse(null);
        EmpresaEntity empresa = socio.getEmpresaByEmpresaIdEmpresa();
        CambiodivisaEntity cd = this.cambiodivisaRepository.findById(cambioDivisa).orElse(null);
        empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco().setSaldo(pasta);
        empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco().setTipoMoneda(cd.getMonedaCompra());
        this.empresaRepository.save(empresa);
        TransaccionEntity transaccion = new TransaccionEntity();
        transaccion.setFechaInstruccion(Date.valueOf(LocalDate.now()));
        transaccion.setCuentabancoByCuentaBancoIdCuentaBanco(empresa.getCuentabancoByCuentaEmpresaIdCuentaBanco());
        transaccion.setCambiodivisaByCambioDivisaIdCambioDivisa(cd);
        this.transaccionRepository.save(transaccion);
        model.addAttribute("empresa", empresa);
        model.addAttribute("socio", socio);
        return "/Empresa/sesionIniciadaEmpresa";
    }


    //Metodo para pedir una peticion de alta
    @GetMapping("/nuevaPeticionAltaEmpresa")
    public String pedirAlta(Integer id, Model model, HttpSession session) {
        EmpresaEntity empresa = this.empresaRepository.getReferenceById(id);
        model.addAttribute("empresa", empresa);
        PeticionEntity peticion = new PeticionEntity();
        peticion.setTipoPeticion("alta");
        peticion.setEstadoPeticion("noprocesada");
        peticion.setFechaPeticion(new Timestamp(currentTimeMillis()));
        peticion.setEmpresaByEmpresaIdEmpresa(empresa);
        this.peticionRepository.save(peticion);
        return "Empresa/PeticionEnviadaEmpresa";
    }

    //Metodo para pedir una peticion de baja
    @GetMapping("/nuevaPeticionBloqueadoEmpresa")
    public String pedirDesbloqueo(@RequestParam("idUsuario") Integer idUsuario, Model model, HttpSession session) {
        EmpresaEntity empresa = this.empresaRepository.getReferenceById(idUsuario);
        PeticionEntity peticion = new PeticionEntity();
        peticion.setTipoPeticion("desbloqueo");
        peticion.setEstadoPeticion("noprocesada");
        peticion.setFechaPeticion(new Timestamp(currentTimeMillis()));
        peticion.setEmpresaByEmpresaIdEmpresa(empresa);
        this.peticionRepository.save(peticion);
        return "Empresa/PeticionEnviadaEmpresa";
    }

    //Metodo para pedir una peticion de activacion
    @GetMapping("/nuevaPeticionActivacionEmpresa")
    public String pedirActivacion(@RequestParam("idUsuario") Integer idUsuario, Model model, HttpSession session) {
        EmpresaEntity empresa = this.empresaRepository.getReferenceById(idUsuario);
        PeticionEntity peticion = new PeticionEntity();
        peticion.setTipoPeticion("activar");
        peticion.setEstadoPeticion("noprocesada");
        peticion.setFechaPeticion(new Timestamp(currentTimeMillis()));
        peticion.setEmpresaByEmpresaIdEmpresa(empresa);
        this.peticionRepository.save(peticion);
        return "Empresa/PeticionEnviadaEmpresa";
    }


}
