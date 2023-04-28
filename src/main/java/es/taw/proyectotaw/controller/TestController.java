package es.taw.proyectotaw.controller;

import es.taw.proyectotaw.entity.EmpresaEntity;
import es.taw.proyectotaw.dao.EmpresaRepository;
import es.taw.proyectotaw.dao.UsuarioRepository;
import es.taw.proyectotaw.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/")
    public String listar(Model model) {
        List<UsuarioEntity> lista = this.usuarioRepository.findAll();
        model.addAttribute("listaUsuarios", lista);
        List<EmpresaEntity> listaEmpresa = this.empresaRepository.findAll();
        model.addAttribute("listaEmpresas", listaEmpresa);

        return "index";
    }

    @GetMapping("/Empresa/empresaPrincipal")
    public String goEmpresa(Model model) {
        List<EmpresaEntity> listaEmpresa = this.empresaRepository.findAll();

        model.addAttribute("empresa", listaEmpresa);
        return "Empresa/empresaPrincipal";

    }

    @GetMapping("/Cliente/clientePrincipal")
    public String goCliente(Model model) {
        return "Cliente/clientePrincipal";
    }

}
