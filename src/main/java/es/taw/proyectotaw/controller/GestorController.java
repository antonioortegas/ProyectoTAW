package es.taw.proyectotaw.controller;

import es.taw.proyectotaw.Entity.EmpresaEntity;
import es.taw.proyectotaw.Entity.UsuarioEntity;
import es.taw.proyectotaw.dao.EmpresaRepository;
import es.taw.proyectotaw.dao.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GestorController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/gestor/usuarios")
    public String listarUsuarios(Model model){
        List<UsuarioEntity> listaUsuarios = this.usuarioRepository.findAll();
        model.addAttribute("listaUsuarios", listaUsuarios);
        List<EmpresaEntity> listaEmpresas = this.empresaRepository.findAll();
        model.addAttribute("listaEmpresas", listaEmpresas);
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

}
