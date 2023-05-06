package es.taw.proyectotaw.controller;

import es.taw.proyectotaw.Entity.EmpresaEntity;
import es.taw.proyectotaw.dao.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/")
    public String listar(Model model) {
        return "index";
    }

    @GetMapping("/Empresa/empresaPrincipal")
    public String goEmpresa(Model model) {

        return "Empresa/empresaPrincipal";

    }

    @GetMapping("/Cliente/clientePrincipal")
    public String goCliente(Model model) {
        return "Cliente/clientePrincipal";
    }

}
