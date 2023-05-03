package es.taw.proyectotaw.controller;


import com.fasterxml.jackson.databind.annotation.JsonAppend;
import es.taw.proyectotaw.Entity.DireccionEntity;
import es.taw.proyectotaw.Entity.EmpresaEntity;
import es.taw.proyectotaw.Entity.UsuarioEntity;
import es.taw.proyectotaw.dao.DireccionRepository;
import es.taw.proyectotaw.dao.EmpresaRepository;
import es.taw.proyectotaw.dao.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpresaController {


    @Autowired
    protected EmpresaRepository empresaRepository;
    @Autowired
    protected UsuarioRepository usuarioRepository;

    @Autowired
    protected DireccionRepository direccionRepository;


    @GetMapping("/goPrincipalEmpresa")
    public String goPrincipalEmpresa(Model model, HttpSession httpSession) {


        return "/Empresa/sesionIniciadaEmpresa";
    }


    @GetMapping("/Empresa/crearNuevaEmpresa")
    public String crearNuevaEmpresa(@ModelAttribute("empresa") EmpresaEntity empresa) {
        //this.empresaRepository.save(empresa);
        return "Empresa/crearNuevaEmpresa";
    }

    @RequestMapping("/procesarFormularioEmpresa")
    public String procesarFormularioEmpresa(@ModelAttribute("empresa") EmpresaEntity empresa, @ModelAttribute("direccion") DireccionEntity direccion) {
        System.out.println("PETA 1");
        //DireccionEntity direccionEntity = new DireccionEntity(11,"CAlle pilar","33","aa","MALAGA","SPAIN","12341", (byte) 1);
        DireccionEntity direccionEntity = new DireccionEntity("CAlle pilar", "33", "aa", "MALAGA", "SPAIN", "12341", (byte) 1);
        EmpresaEntity empresa1 = new EmpresaEntity(11, "222", "empresaPruebas", direccionEntity);
        this.direccionRepository.save(direccionEntity);
        this.empresaRepository.save(empresa1);
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
        model.addAttribute("socio",socio);
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


        UsuarioEntity socio = usuarioRepository.getById(idCambio);
        System.out.println(socio.getNombre() + " " + socio.getTipoPersonaRelacionada());

        if (socio.getTipoPersonaRelacionada() == null) {
            socio.setTipoPersonaRelacionada(desbloqueada.toLowerCase());
        } else {
            if (socio.getTipoPersonaRelacionada().toString().toLowerCase().equals(bloqueada.toString().toLowerCase())) {
                socio.setTipoPersonaRelacionada(desbloqueada.toLowerCase());
                System.out.println(2);
                System.out.println(socio.getTipoPersonaRelacionada());
            } else if (socio.getTipoPersonaRelacionada().toString().toLowerCase().equals(desbloqueada.toString().toLowerCase())) {
                socio.setTipoPersonaRelacionada(bloqueada.toLowerCase());
                System.out.println(3);
                System.out.println(socio.getTipoPersonaRelacionada());
            }

        }

        this.usuarioRepository.save(socio);

        Integer id = socio.getEmpresaByEmpresaIdEmpresa().getIdEmpresa();
        List<UsuarioEntity> listaUsuariosEmpresa = this.usuarioRepository.buscarUsuariosMismaEmpresa(id);
        for (
                UsuarioEntity u :
                listaUsuariosEmpresa) {
            System.out.println(u.getNombre() + " " + u.getTipoPersonaRelacionada());
        }
        model.addAttribute("listaUsuriosEmpresa", listaUsuariosEmpresa);


        return "Empresa/bloquearSocios";

    }

    @GetMapping("/Empresa/mostrarSoloSocios")
    public String mostrarSoloSocios(Integer idEmpresa, Model model, HttpSession httpSession) {
        UsuarioEntity socio = (UsuarioEntity) httpSession.getAttribute("socio");

        List<UsuarioEntity> listaSocios = this.empresaRepository.buscarSocios(idEmpresa);

        model.addAttribute("listaUsuriosEmpresa",listaSocios);
        model.addAttribute("socio",socio);
        httpSession.setAttribute("socio",socio);
        httpSession.setAttribute("listaUsuariosEmpresa",listaSocios);
        return "Empresa/bloquearSocios";

    }
    @GetMapping("/Empresa/mostrarSoloAutorizados")
    public String mostrarSoloAutorizados(Integer idEmpresa, Model model, HttpSession httpSession) {
        UsuarioEntity socio = (UsuarioEntity) httpSession.getAttribute("socio");
        List<UsuarioEntity> listaSocios = this.empresaRepository.buscarAutorizados(idEmpresa);
        model.addAttribute("listaUsuriosEmpresa",listaSocios);
        model.addAttribute("socio",socio);
        httpSession.setAttribute("socio",socio);
        httpSession.setAttribute("listaUsuariosEmpresa",listaSocios);
        return "Empresa/bloquearSocios";

    }   @GetMapping("/Empresa/mostrarTodos")
    public String mostrarTodos(Integer idEmpresa, Model model, HttpSession httpSession) {
        UsuarioEntity socio = (UsuarioEntity) httpSession.getAttribute("socio");
        List<UsuarioEntity> listaSocios = this.usuarioRepository.buscarUsuariosMismaEmpresa(idEmpresa);        model.addAttribute("listaUsuriosEmpresa",listaSocios);
        model.addAttribute("socio",socio);
        httpSession.setAttribute("socio",socio);
        httpSession.setAttribute("listaUsuariosEmpresa",listaSocios);
        return "Empresa/bloquearSocios";

    }


    @GetMapping("/Empresa/editarDatosSocio")
    public String editarSocio(Integer id, Model model, HttpSession session) {
        UsuarioEntity socio = this.usuarioRepository.getReferenceById(id);
        model.addAttribute("socio", socio);
        EmpresaEntity empresa = this.empresaRepository.getReferenceById(socio.getEmpresaByEmpresaIdEmpresa().getIdEmpresa());
        model.addAttribute("empresa", empresa);
        return "Empresa/editarDatosSocio";
    }

    @PostMapping("/guardarSocio")
    public String guardarSocio(@ModelAttribute("socio") UsuarioEntity socio) {
        this.usuarioRepository.save(socio);
        return "Empresa/sesionIniciadaEmpresa";
    }


    @RequestMapping("/Empresa/editarDatosEmpresa")
    public String editarEmpresa(Integer id, Model model, HttpSession session) {
        UsuarioEntity socio = (UsuarioEntity) session.getAttribute("socio");
        model.addAttribute("socio", socio);
        System.out.println(1);
        EmpresaEntity empresa = this.empresaRepository.getReferenceById(id);
        System.out.println(2);
        model.addAttribute("empresa", empresa);
        System.out.println(3);
        this.empresaRepository.save(empresa);
        System.out.println(4);
        return "Empresa/editarDatosEmpresa";
    }


}
