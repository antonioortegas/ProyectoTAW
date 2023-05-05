package es.taw.proyectotaw.controller;

import es.taw.proyectotaw.Entity.*;
import es.taw.proyectotaw.dao.CuentabancoRepository;
import es.taw.proyectotaw.dao.EmpresaRepository;
import es.taw.proyectotaw.dao.PeticionRepository;
import es.taw.proyectotaw.dao.UsuarioRepository;
import es.taw.proyectotaw.ui.FiltroEmpresas;
import es.taw.proyectotaw.ui.FiltroUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class GestorController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private CuentabancoRepository cuentabancoRepository;

    @Autowired
    private PeticionRepository peticionRepository;


    //LISTADO DE USUARIOS
    @GetMapping("/gestor/usuarios")
    public String listarUsuarios(Model model){
        if(model.containsAttribute("filtroUsuarios")&&model.containsAttribute("filtroEmpresas")) {
            if (model.getAttribute("filtroUsuarios") != null && model.getAttribute("filtroEmpresas") != null){
                return procesarFiltrado(model, (FiltroUsuarios) model.getAttribute("filtroUsuarios"), (FiltroEmpresas) model.getAttribute("filtroEmpresas"));
            }
            else {
                return procesarFiltrado(model, null, null);
            }
        }
        else {
            return procesarFiltrado(model, null, null);
        }
    }

    //FILTROS
    @PostMapping("/gestor/filtrar")
    public String filtrarUsuarios(Model model, @ModelAttribute("filtroUsuarios") FiltroUsuarios filtroUsuarios, @ModelAttribute("filtroEmpresas") FiltroEmpresas filtroEmpresas){
        return procesarFiltrado(model, filtroUsuarios, filtroEmpresas);
    }

    private String procesarFiltrado(Model model, FiltroUsuarios filtroUsuarios, FiltroEmpresas filtroEmpresas) {
        List<CuentabancoEntity> listaCuentasSospechosas = this.cuentabancoRepository.findAllBySospechosoEquals(1);
        model.addAttribute("listaCuentasSospechosas", listaCuentasSospechosas);

        List<UsuarioEntity> listaUsuarios = null;
        List<EmpresaEntity> listaEmpresas = null;
        if(filtroUsuarios == null){
            filtroUsuarios = new FiltroUsuarios();
            listaUsuarios = this.usuarioRepository.findAll();
        }
        if(filtroUsuarios.getPropiedadU().equals("")&&filtroUsuarios.getOrdenU().equals("nif")){
            listaUsuarios = this.usuarioRepository.findAll();
        }
        if(filtroUsuarios.getPropiedadU().equals("Pendiente de alta")&&filtroUsuarios.getOrdenU().equals("nif")){
            listaUsuarios = this.usuarioRepository.buscarUsuariosConSolicitudDeTipo("alta");
        }
        if(filtroUsuarios.getPropiedadU().equals("30d")&&filtroUsuarios.getOrdenU().equals("nif")){
            LocalDate date = LocalDate.now().minusDays(30);
            Date dateBefore30Days = java.sql.Date.valueOf(date);
            listaUsuarios = this.usuarioRepository.buscarUsuariosConInactividadDe30Dias(dateBefore30Days);
            System.out.println(listaUsuarios.size());
        }
        if(filtroUsuarios.getPropiedadU().equals("Actividad sospechosa")&&filtroUsuarios.getOrdenU().equals("nif")){
            List<UsuarioEntity> listaUsuariosCompleta = this.usuarioRepository.findAll();

        }


        if(filtroEmpresas == null){
            filtroEmpresas = new FiltroEmpresas();
            listaEmpresas = this.empresaRepository.findAll();
        }
        if(filtroEmpresas.getPropiedadE().equals("")&&filtroEmpresas.getOrdenE().equals("cif")){
            listaEmpresas = this.empresaRepository.findAll();
        }
        if(filtroEmpresas.getPropiedadE().equals("Pendiente de alta")&&filtroEmpresas.getOrdenE().equals("cif")){
            listaEmpresas = this.empresaRepository.buscarEmpresasConSolicitudDeTipo("alta");
        }
        if(filtroEmpresas.getPropiedadE().equals("30d")&&filtroEmpresas.getOrdenE().equals("cif")){
            LocalDate date = LocalDate.now().minusDays(30);
            Date dateBefore30Days = java.sql.Date.valueOf(date);
            listaEmpresas = this.empresaRepository.buscarEmpresasConInactividadDe30Dias(dateBefore30Days);
        }
        if(filtroEmpresas.getPropiedadE().equals("Actividad sospechosa")&&filtroEmpresas.getOrdenE().equals("cif")){
            listaEmpresas = this.empresaRepository.findAll();
        }

        model.addAttribute("listaUsuarios", listaUsuarios);
        model.addAttribute("listaEmpresas", listaEmpresas);



        model.addAttribute("filtroUsuarios", filtroUsuarios);
        model.addAttribute("filtroEmpresas", filtroEmpresas);
        return "gestor/listadoUsuarios";
    }

    //DETALLES DE UN CLIENTE
    @GetMapping("/gestor/cliente")
    public String verDetallesCliente(Model model, @RequestParam("id_usuario") Integer id){
        UsuarioEntity usuario = this.usuarioRepository.findById(id).orElse(null);
        model.addAttribute("usuario", usuario);
        return "gestor/cliente";
    }

    //DETALLES DE UNA EMPRESA
    @GetMapping("/gestor/empresa")
    public String verDetallesEmpresa(Model model, @RequestParam("id_empresa") Integer id){
        EmpresaEntity empresa = this.empresaRepository.findById(id).orElse(null);
        List<UsuarioEntity> listaUsuarios = this.usuarioRepository.findAllByEmpresaByEmpresaIdEmpresa(empresa);
        model.addAttribute("empresa", listaUsuarios);
        return "gestor/empresa";
    }

    //=====
    //ACCIONES DE GESTOR SOBRE USUARIOS
    //=====

    //ACEPTAR ALTA DE USUARIO
    @GetMapping("/gestor/aceptarAltaUsuario")
    public String aceptarUsuario(Model model, @RequestParam("id_usuario") Integer id){
        UsuarioEntity usuario = this.usuarioRepository.findById(id).orElse(null);
        List<PeticionEntity> listaPeticiones = buscarPeticionesUsuarioPorTipo(usuario, "noprocesada", "alta");
        if(this.cuentabancoRepository.findAllByUsuariosByIdCuentaBancoIsEmpty().size() > 0){
            CuentabancoEntity cuenta = null;
            if(usuario.getTipoUsuario().equals("cliente")){
                cuenta = this.cuentabancoRepository.findAllByUsuariosByIdCuentaBancoIsEmpty().get(0);
            } else if((usuario.getTipoUsuario().equals("socio") || usuario.getTipoUsuario().equals("autorizado"))&& usuario.getEmpresaByEmpresaIdEmpresa().getEstadoEmpresa().equals("activo")){
                cuenta = usuario.getEmpresaByEmpresaIdEmpresa().getCuentabancoByCuentaEmpresaIdCuentaBanco();
            } else{
                System.out.println("La empresa no está activa");
            }
            usuario.setCuentabancoByCuentaBancoIdCuentaBanco(cuenta);
            setEstadoUsuario(usuario, "activo");
            for(PeticionEntity peticion : listaPeticiones){
                aceptarPeticion(peticion);
            }
            this.usuarioRepository.save(usuario);
        } else{
            System.out.println("No hay cuentas disponibles");
        }
        return "redirect:/gestor/usuarios";
    }

    //DENEGAR ALTA DE USUARIO
    @GetMapping("/gestor/denegarAltaUsuario")
    public String denegarUsuario(Model model, @RequestParam("id_usuario") Integer id){
        UsuarioEntity usuario = this.usuarioRepository.findById(id).orElse(null);
        List<PeticionEntity> listaPeticiones = buscarPeticionesUsuarioPorTipo(usuario, "noprocesada", "alta");
        for (PeticionEntity peticion: listaPeticiones) {
            rechazarPeticion(peticion);
        }
        this.usuarioRepository.save(usuario);
        return "redirect:/gestor/usuarios";
    }

    //ACEPTAR ACTIVACION DE USUARIO
    @GetMapping("/gestor/aceptarActivarUsuario")
    public String activarUsuario(Model model, @RequestParam("id_usuario") Integer id){
        UsuarioEntity usuario = this.usuarioRepository.findById(id).orElse(null);
        List<PeticionEntity> listaPeticiones = buscarPeticionesUsuarioPorTipo(usuario, "noprocesada", "activar");
        for (PeticionEntity peticion: listaPeticiones) {
            aceptarPeticion(peticion);
        }
        setEstadoUsuario(usuario, "activo");
        this.usuarioRepository.save(usuario);
        return "redirect:/gestor/usuarios";
    }

    //DENEGAR ACTIVACION DE USUARIO
    @GetMapping("/gestor/denegarActivarUsuario")
    public String denegarActivacionUsuario(Model model, @RequestParam("id_usuario") Integer id){
        UsuarioEntity usuario = this.usuarioRepository.findById(id).orElse(null);
        List<PeticionEntity> listaPeticiones = buscarPeticionesUsuarioPorTipo(usuario, "noprocesada", "activar");
        for (PeticionEntity peticion: listaPeticiones) {
            rechazarPeticion(peticion);
        }
        this.usuarioRepository.save(usuario);
        return "redirect:/gestor/usuarios";
    }

    //ACEPTAR DESBLOQUEO DE USUARIO
    @GetMapping("/gestor/aceptarDesbloquearUsuario")
    public String desbloquearUsuario(Model model, @RequestParam("id_usuario") Integer id){
        UsuarioEntity usuario = this.usuarioRepository.findById(id).orElse(null);
        List<PeticionEntity> listaPeticiones = buscarPeticionesUsuarioPorTipo(usuario, "noprocesada", "desbloqueo");
        for (PeticionEntity peticion: listaPeticiones) {
            aceptarPeticion(peticion);
        }
        setEstadoUsuario(usuario, "activo");
        this.usuarioRepository.save(usuario);
        return "redirect:/gestor/usuarios";
    }

    //DENEGAR DESBLOQUEO DE USUARIO
    @GetMapping("/gestor/denegarDesbloquearUsuario")
    public String denegarDesbloqueoUsuario(Model model, @RequestParam("id_usuario") Integer id){
        UsuarioEntity usuario = this.usuarioRepository.findById(id).orElse(null);
        List<PeticionEntity> listaPeticiones = buscarPeticionesUsuarioPorTipo(usuario, "noprocesada", "desbloqueo");
        for (PeticionEntity peticion: listaPeticiones) {
            rechazarPeticion(peticion);
        }
        this.usuarioRepository.save(usuario);
        return "redirect:/gestor/usuarios";
    }

    //DESACTIVAR USUARIO POR INACTIVIDAD
    @GetMapping("/gestor/desactivarUsuario")
    public String desactivarUsuario(Model model, @RequestParam("id_usuario") Integer id){
        UsuarioEntity usuario = this.usuarioRepository.findById(id).orElse(null);
        rechazarPeticionesUsuario(usuario);
        setEstadoUsuario(usuario, "inactivo");
        this.usuarioRepository.save(usuario);
        return "redirect:/gestor/usuarios";
    }

    //BLOQUEAR USUARIO POR ACTIVIDAD SOSPECHOSA
    @GetMapping("/gestor/bloquearUsuario")
    public String bloquearUsuario(Model model, @RequestParam("id_usuario") Integer id){
        UsuarioEntity usuario = this.usuarioRepository.findById(id).orElse(null);
        rechazarPeticionesUsuario(usuario);
        setEstadoUsuario(usuario, "bloqueado");
        this.usuarioRepository.save(usuario);
        return "redirect:/gestor/usuarios";
    }

    //=====
    //ACCIONES DE GESTOR SOBRE EMPRESAS
    //=====

    //ACEPTAR ALTA DE EMPRESA
    @GetMapping("/gestor/aceptarAltaEmpresa")
    public String aceptarAltaEmpresa(Model model, @RequestParam("id_empresa") Integer id){
        EmpresaEntity empresa = this.empresaRepository.findById(id).orElse(null);
        List<PeticionEntity> listaPeticiones = buscarPeticionesEmpresaPorTipo(empresa, "noprocesada", "alta");
        for (PeticionEntity peticion: listaPeticiones) {
            aceptarPeticion(peticion);
        }
        setEstadoEmpresa(empresa, "activo");
        this.empresaRepository.save(empresa);
        return "redirect:/gestor/usuarios";
    }

    //DENEGAR ALTA DE EMPRESA
    @GetMapping("/gestor/denegarAltaEmpresa")
    public String denegarAltaEmpresa(Model model, @RequestParam("id_empresa") Integer id){
        EmpresaEntity empresa = this.empresaRepository.findById(id).orElse(null);
        List<PeticionEntity> listaPeticiones = buscarPeticionesEmpresaPorTipo(empresa, "noprocesada", "alta");
        for (PeticionEntity peticion: listaPeticiones) {
            rechazarPeticion(peticion);
        }
        this.empresaRepository.save(empresa);
        return "redirect:/gestor/usuarios";
    }

    //BLOQUEAR EMPRESA POR ACTIVIDAD SOSPECHOSA
    @GetMapping ("/gestor/bloquearEmpresa")
    public String bloquearEmpresa(Model model, @RequestParam("id_empresa") Integer id){
        EmpresaEntity empresa = this.empresaRepository.findById(id).orElse(null);
        rechazarPeticionesEmpresa(empresa);
        setEstadoEmpresa(empresa, "bloqueado");
        this.empresaRepository.save(empresa);
        return "redirect:/gestor/usuarios";
    }

    //DESACTIVAR EMPRESA POR INACTIVIDAD
    @GetMapping ("/gestor/desactivarEmpresa")
    public String desactivarEmpresa(Model model, @RequestParam("id_empresa") Integer id){
        EmpresaEntity empresa = this.empresaRepository.findById(id).orElse(null);
        rechazarPeticionesEmpresa(empresa);
        setEstadoEmpresa(empresa, "inactivo");
        this.empresaRepository.save(empresa);
        return "redirect:/gestor/usuarios";
    }

    private void aceptarPeticion(PeticionEntity peticion){
        peticion.setEstadoPeticion("aceptada");
        this.peticionRepository.save(peticion);
    }

    private void rechazarPeticion(PeticionEntity peticion){
        peticion.setEstadoPeticion("denegada");
        this.peticionRepository.save(peticion);
    }

    private void rechazarPeticionesUsuario(UsuarioEntity usuario){
        List<PeticionEntity> listaPeticiones = buscarPeticionesActivasUsuario(usuario, "noprocesada");
        for(PeticionEntity peticion : listaPeticiones){
            peticion.setEstadoPeticion("denegada");
            this.peticionRepository.save(peticion);
        }
    }

    private void rechazarPeticionesEmpresa(EmpresaEntity empresa){
        List<PeticionEntity> listaPeticiones = buscarPeticionesActivasEmpresa(empresa, "noprocesada");
        for(PeticionEntity peticion : listaPeticiones){
            peticion.setEstadoPeticion("denegada");
            this.peticionRepository.save(peticion);
        }
    }

    private List<PeticionEntity> buscarPeticionesUsuarioPorTipo(UsuarioEntity user, String estado, String tipo) {
        return this.peticionRepository.findAllByUsuarioByUsuarioIdUsuarioEqualsAndEstadoPeticionEqualsAndTipoPeticionEquals(user ,estado, tipo);
    }

    private List<PeticionEntity> buscarPeticionesEmpresaPorTipo(EmpresaEntity empresa, String estado, String tipo) {
        return this.peticionRepository.findAllByEmpresaByEmpresaIdEmpresaEqualsAndEstadoPeticionEqualsAndTipoPeticionEquals(empresa ,estado, tipo);
    }

    private List<PeticionEntity> buscarPeticionesActivasUsuario(UsuarioEntity user, String estado) {
        return this.peticionRepository.findAllByUsuarioByUsuarioIdUsuarioEqualsAndEstadoPeticionEquals(user ,estado);
    }

    private List<PeticionEntity> buscarPeticionesActivasEmpresa(EmpresaEntity empresa, String estado) {
        return this.peticionRepository.findAllByEmpresaByEmpresaIdEmpresaEqualsAndEstadoPeticionEquals(empresa ,estado);
    }

    public void setEstadoUsuario(UsuarioEntity usuario, String nuevoEstado){
        if(nuevoEstado.equals("activo")){
            usuario.setEstadoUsuario("activo");
        }else if (usuario.getEstadoUsuario().equals("activo")){
            if (nuevoEstado.equals("bloqueado")){
                usuario.setEstadoUsuario("bloqueado");
            }else if(nuevoEstado.equals("inactivo")){
                usuario.setEstadoUsuario("inactivo");
            }else if(nuevoEstado.equals("pendiente")){
                usuario.setEstadoUsuario("pendiente");
            }
        } else {
            System.out.println("El usuario " + usuario.getNif() + " ya no estaba activa");
        }
        this.usuarioRepository.save(usuario);
    }

    public void setEstadoEmpresa(EmpresaEntity empresa, String nuevoEstado){
        if(nuevoEstado.equals("activo")){
            empresa.setEstadoEmpresa("activo");
        }else if (empresa.getEstadoEmpresa().equals("activo")){
            if (nuevoEstado.equals("bloqueado")){
                empresa.setEstadoEmpresa("bloqueado");
            }else if(nuevoEstado.equals("inactivo")){
                empresa.setEstadoEmpresa("inactivo");
            }else if(nuevoEstado.equals("pendiente")){
                empresa.setEstadoEmpresa("pendiente");
            }
        } else {
            System.out.println("La empresa " + empresa.getNombre() + " ya no estaba activa");
        }
        this.empresaRepository.save(empresa);
    }

}
