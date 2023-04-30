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

    @GetMapping("/Empresa/crearUsuarioEmpresa")
    public String crearNuevoSocio() {
        return "Empresa/crearUsuarioEmpresa";
    }


    public String iniciarSesionEmpresa() {


        return "Empresa/login";
    }

    @PostMapping("/loginSocio")
    public String doAutenticar(@RequestParam("nif") String nif,@RequestParam("contrasena") String contrasena,
                               Model model, HttpSession session) {
        String urlTo = "/Empresa/sesionIniciadaEmpresa";
        UsuarioEntity socio = this.usuarioRepository.autenticarUsuarioEmpresa(nif, contrasena);
        if (socio == null) {
            model.addAttribute("error", "Credenciales incorrectas");
            urlTo = "loginSocio";
        } else {
            model.addAttribute("socio", socio);
            session.setAttribute("socio", socio);
        }

        return urlTo;
    }

    @GetMapping("/Empresa/loginSocio")
    public String iniciarSesionEmpleadp() {
        return "Empresa/login";
    }

    @GetMapping("/Empresa/bloquearSocios")
    public String bloquarSocios(Model model, HttpSession httpSession) {
        UsuarioEntity usuario = (UsuarioEntity) httpSession.getAttribute("nif");

        //List<UsuarioEntity> listaUsuriosEmpresa = this.usuarioRepository.buscarUsuariosMismaEmpresa(usuario.getEmpresaByEmpresaIdEmpresa().getIdEmpresa());
        List<UsuarioEntity> listaUsuriosEmpresa = this.usuarioRepository.buscarUsuariosMismaEmpresa("1");
        model.addAttribute("listaUsuriosEmpresa", listaUsuriosEmpresa);

        for (UsuarioEntity u :
                listaUsuriosEmpresa) {
            System.out.println(u.getNombre());
        }

        return "Empresa/bloquearSocios";
    }

    @GetMapping("/Empresa/editarDatosSocio")
    public String editarCliente(Integer id, Model model, HttpSession session) {
        UsuarioEntity socio = this.usuarioRepository.getReferenceById(id);
        model.addAttribute("socio", socio);
        return "Empresa/editarDatosSocio";
    }


}
