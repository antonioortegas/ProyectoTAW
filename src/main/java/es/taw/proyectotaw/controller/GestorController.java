package es.taw.proyectotaw.controller;

import es.taw.proyectotaw.Entity.CuentabancoEntity;
import es.taw.proyectotaw.Entity.EmpresaEntity;
import es.taw.proyectotaw.Entity.PeticionEntity;
import es.taw.proyectotaw.Entity.UsuarioEntity;
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



    @PostMapping("/gestor/filtrarUsuarios")
public String filtrarUsuarios(Model model, @ModelAttribute("filtroUsuarios") FiltroUsuarios filtroUsuarios, @ModelAttribute("filtroEmpresas") FiltroEmpresas filtroEmpresas){
        return procesarFiltrado(model, filtroUsuarios, filtroEmpresas);
    }

    @PostMapping("/gestor/filtrarEmpresas")
public String filtrarEmpresas(Model model, @ModelAttribute("filtroUsuarios") FiltroUsuarios filtroUsuarios, @ModelAttribute("filtroEmpresas") FiltroEmpresas filtroEmpresas){
        return procesarFiltrado(model, filtroUsuarios, filtroEmpresas);
    }

    private String procesarFiltrado(Model model, FiltroUsuarios filtroUsuarios, FiltroEmpresas filtroEmpresas) {
        List<UsuarioEntity> listaUsuarios = null;
        List<EmpresaEntity> listaEmpresas = null;
        if(filtroUsuarios == null){
            filtroUsuarios = new FiltroUsuarios();
            listaUsuarios = this.usuarioRepository.findAll();
        }
        if(filtroUsuarios.getPropiedad().equals("")&&filtroUsuarios.getOrden().equals("nif")){
            listaUsuarios = this.usuarioRepository.findAll();
        }
        if(filtroUsuarios.getPropiedad().equals("Pendiente de alta")&&filtroUsuarios.getOrden().equals("nif")){
            listaUsuarios = this.usuarioRepository.buscarUsuariosConSolicitudDeAlta();
        }
        if(filtroUsuarios.getPropiedad().equals("30d")&&filtroUsuarios.getOrden().equals("nif")){
            Date fecha = new Date();
            fecha.setDate(fecha.getDate()-30);
            listaUsuarios = this.usuarioRepository.buscarUsuariosConInactividadDe30Dias(fecha);
        }
        if(filtroUsuarios.getPropiedad().equals("Actividad sospechosa")&&filtroUsuarios.getOrden().equals("nif")){
            //ARREGLARlistaUsuarios = this.usuarioRepository.buscarUsuariosConActividadSospechosa();
        }


        if(filtroEmpresas == null){
            filtroEmpresas = new FiltroEmpresas();
            listaEmpresas = this.empresaRepository.findAll();
        }
        if(filtroEmpresas.getPropiedadE().equals("")&&filtroEmpresas.getOrdenE().equals("cif")){
            listaEmpresas = this.empresaRepository.findAll();
        }
        if(filtroEmpresas.getPropiedadE().equals("Pendiente de alta")&&filtroEmpresas.getOrdenE().equals("cif")){
            listaEmpresas = this.empresaRepository.buscarEmpresasConSolicitudDeAlta();
        }
        if(filtroEmpresas.getPropiedadE().equals("30d")&&filtroEmpresas.getOrdenE().equals("cif")){
            java.sql.Date fecha = new java.sql.Date(new Date().getTime()-30*24*60*60*1000);
            listaEmpresas = this.empresaRepository.buscarEmpresasConInactividadDe30Dias(fecha);
        }
        if(filtroEmpresas.getPropiedadE().equals("Actividad sospechosa")&&filtroEmpresas.getOrdenE().equals("cif")){
           //ARREGLAR listaEmpresas = this.empresaRepository.buscarEmpresasConActividadSospechosa();
        }


        if(listaUsuarios == null){
            listaUsuarios = this.usuarioRepository.findAll();
        }

        model.addAttribute("listaUsuarios", listaUsuarios);
        model.addAttribute("listaEmpresas", listaEmpresas);

        List<CuentabancoEntity> listaCuentasSospechosas = this.cuentabancoRepository.findAllBySospechosoEquals(1);
        model.addAttribute("listaCuentasSospechosas", listaCuentasSospechosas);

        model.addAttribute("filtroUsuarios", filtroUsuarios);
        model.addAttribute("filtroEmpresas", filtroEmpresas);
        return "gestor/listadoUsuarios";
    }

    @GetMapping("/gestor/cliente")
    public String verDetallesCliente(Model model, @RequestParam("id_usuario") Integer id){
        UsuarioEntity usuario = this.usuarioRepository.findById(id).orElse(null);
        model.addAttribute("usuario", usuario);
        return "gestor/cliente";
    }

    @GetMapping("/gestor/empresa")
    public String verDetallesEmpresa(Model model, @RequestParam("id_empresa") Integer id){
        EmpresaEntity empresa = this.empresaRepository.findById(id).orElse(null);
        List<UsuarioEntity> listaUsuarios = this.usuarioRepository.findAllByEmpresaByEmpresaIdEmpresa(empresa);
        model.addAttribute("empresa", listaUsuarios);
        return "gestor/empresa";
    }

    @GetMapping("/gestor/aceptarUsuario")
    public String aceptarUsuario(Model model, @RequestParam("id_usuario") Integer id){
        UsuarioEntity usuario = this.usuarioRepository.findById(id).orElse(null);
        List<PeticionEntity> listaPeticiones = buscarPeticiones(usuario, "noprocesada", "alta");
        //if persona fisica
        if(usuario.getTipoUsuario().equals("cliente")){
            if(this.cuentabancoRepository.findAllByUsuariosByIdCuentaBancoIsEmpty().size() > 0){
                CuentabancoEntity cuenta = this.cuentabancoRepository.findAllByUsuariosByIdCuentaBancoIsEmpty().get(0);
                usuario.setCuentabancoByCuentaBancoIdCuentaBanco(cuenta);
                setActivo(usuario);
                listaPeticiones.get(0).setEstadoPeticion("aceptada");
            } else{
                System.out.println("No hay cuentas disponibles");
            }
        }
        //if socio o autorizado
        if(usuario.getTipoUsuario().equals("socio")||usuario.getTipoUsuario().equals("autorizado")){
            //if first user of the company
            if(usuario.getEmpresaByEmpresaIdEmpresa().getUsuariosByIdEmpresa().size() == 1){
                if(this.cuentabancoRepository.findAllByUsuariosByIdCuentaBancoIsEmpty().size() > 0){
                    CuentabancoEntity cuenta = this.cuentabancoRepository.findAllByUsuariosByIdCuentaBancoIsEmpty().get(0);
                    usuario.setCuentabancoByCuentaBancoIdCuentaBanco(cuenta);
                    listaPeticiones.get(0).setEstadoPeticion("aceptada");
                } else{
                    System.out.println("No hay cuentas disponibles");
                }
            }
            //if not first user of the company
            else{
                List<UsuarioEntity> listaUsuarios = this.usuarioRepository.findByCuentabancoByCuentaBancoIdCuentaBancoIsNotNullAndEmpresaByEmpresaIdEmpresaEquals(usuario.getEmpresaByEmpresaIdEmpresa());
                usuario.setCuentabancoByCuentaBancoIdCuentaBanco(listaUsuarios.get(0).getCuentabancoByCuentaBancoIdCuentaBanco());
                listaPeticiones.get(0).setEstadoPeticion("aceptada");
            }
            setActivo(usuario);
        }

        //Terminar peticion
        this.peticionRepository.save(listaPeticiones.get(0));
        this.usuarioRepository.save(usuario);

        return "redirect:/gestor/usuarios";
    }

    @GetMapping("/gestor/denegarUsuario")
    public String denegarUsuario(Model model, @RequestParam("id_usuario") Integer id){
        UsuarioEntity usuario = this.usuarioRepository.findById(id).orElse(null);
        List<PeticionEntity> listaPeticiones = buscarPeticiones(usuario, "noprocesada", "alta");
        rechazarPeticion(listaPeticiones.get(0));
        usuario.setEstadoUsuario("pendiente");
        this.usuarioRepository.save(usuario);
        return "redirect:/gestor/usuarios";
    }

    @GetMapping("/gestor/bloquearUsuario")
    public String bloquearUsuario(Model model, @RequestParam("id_usuario") Integer id){
        UsuarioEntity usuario = this.usuarioRepository.findById(id).orElse(null);
        usuario.setEstadoUsuario("bloqueado");
        this.usuarioRepository.save(usuario);
        return "redirect:/gestor/usuarios";
    }

    @GetMapping("/gestor/activarUsuario")
    public String activarUsuario(Model model, @RequestParam("id_usuario") Integer id){
        UsuarioEntity usuario = this.usuarioRepository.findById(id).orElse(null);
        setActivo(usuario);
        List<PeticionEntity> listaPeticiones = buscarPeticiones(usuario, "noprocesada", "activar");
        aceptarPeticion(listaPeticiones.get(0));
        this.usuarioRepository.save(usuario);
        return "redirect:/gestor/usuarios";
    }

    @GetMapping("/gestor/denegarActivacionUsuario")
    public String denegarActivacionUsuario(Model model, @RequestParam("id_usuario") Integer id){
        UsuarioEntity usuario = this.usuarioRepository.findById(id).orElse(null);
        usuario.setEstadoUsuario("inactivo");
        List<PeticionEntity> listaPeticiones = buscarPeticiones(usuario, "noprocesada", "activar");
        rechazarPeticion(listaPeticiones.get(0));
        this.usuarioRepository.save(usuario);
        return "redirect:/gestor/usuarios";
    }

    @GetMapping("/gestor/desactivarUsuario")
    public String desactivarUsuario(Model model, @RequestParam("id_usuario") Integer id){
        UsuarioEntity usuario = this.usuarioRepository.findById(id).orElse(null);
        usuario.setEstadoUsuario("inactivo");
        this.usuarioRepository.save(usuario);
        return "redirect:/gestor/usuarios";
    }

    @GetMapping("/gestor/desbloquearUsuario")
    public String desbloquearUsuario(Model model, @RequestParam("id_usuario") Integer id){
        UsuarioEntity usuario = this.usuarioRepository.findById(id).orElse(null);
        usuario.setEstadoUsuario("activo");
        List<PeticionEntity> listaPeticiones = buscarPeticiones(usuario, "noprocesada", "desbloqueo");
        aceptarPeticion(listaPeticiones.get(0));
        this.usuarioRepository.save(usuario);
        return "redirect:/gestor/usuarios";
    }

    @GetMapping("/gestor/denegarDesbloqueoUsuario")
    public String denegarDesbloqueoUsuario(Model model, @RequestParam("id_usuario") Integer id){
        UsuarioEntity usuario = this.usuarioRepository.findById(id).orElse(null);
        List<PeticionEntity> listaPeticiones = buscarPeticiones(usuario, "noprocesada", "desbloqueo");
        rechazarPeticion(listaPeticiones.get(0));
        this.usuarioRepository.save(usuario);
        return "redirect:/gestor/usuarios";
    }

    @GetMapping ("/gestor/bloquearEmpresa")
    public String bloquearEmpresa(Model model, @RequestParam("id_empresa") Integer id){
        EmpresaEntity empresa = this.empresaRepository.findById(id).orElse(null);
        List<UsuarioEntity> listaUsuarios = (List<UsuarioEntity>) empresa.getUsuariosByIdEmpresa();
        for(UsuarioEntity usuario : listaUsuarios){
            usuario.setEstadoUsuario("bloqueado");
            this.usuarioRepository.save(usuario);
            List<PeticionEntity> listaPeticionesActivas = buscarPeticionesActivas(usuario, "noprocesada");
            for(PeticionEntity peticion : listaPeticionesActivas){
                peticion.setEstadoPeticion("denegada");
                this.peticionRepository.save(peticion);
            }
        }
        this.empresaRepository.save(empresa);
        return "redirect:/gestor/usuarios";
    }

    @GetMapping ("/gestor/desactivarEmpresa")
    public String desactivarEmpresa(Model model, @RequestParam("id_empresa") Integer id){
        EmpresaEntity empresa = this.empresaRepository.findById(id).orElse(null);
        List<UsuarioEntity> listaUsuarios = (List<UsuarioEntity>) empresa.getUsuariosByIdEmpresa();
        for(UsuarioEntity usuario : listaUsuarios){
            usuario.setEstadoUsuario("inactivo");
            this.usuarioRepository.save(usuario);
            List<PeticionEntity> listaPeticionesActivas = buscarPeticionesActivas(usuario, "noprocesada");
            for(PeticionEntity peticion : listaPeticionesActivas){
                peticion.setEstadoPeticion("denegada");
                this.peticionRepository.save(peticion);
            }
        }
        this.empresaRepository.save(empresa);
        return "redirect:/gestor/usuarios";
    }

    private List<PeticionEntity> buscarPeticiones(UsuarioEntity user, String estado, String tipo) {
        return this.peticionRepository.findAllByUsuarioByUsuarioIdUsuarioEqualsAndEstadoPeticionEqualsAndTipoPeticionEquals(user ,estado, tipo);
    }

    private List<PeticionEntity> buscarPeticionesActivas(UsuarioEntity user, String estado) {
        return this.peticionRepository.findAllByUsuarioByUsuarioIdUsuarioEqualsAndEstadoPeticionEquals(user ,estado);
    }

    private void aceptarPeticion(PeticionEntity peticion){
        peticion.setEstadoPeticion("aceptada");
        this.peticionRepository.save(peticion);
    }

    private void rechazarPeticion(PeticionEntity peticion){
        peticion.setEstadoPeticion("denegada");
        this.peticionRepository.save(peticion);
    }

    public void setActivo(UsuarioEntity usuario){
        usuario.setEstadoUsuario("activo");
    }


}
