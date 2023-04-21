package es.taw.proyectotaw.controller;

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

    @GetMapping("/")
    public String listar(Model model){
        List<UsuarioEntity> lista = this.usuarioRepository.findAll();
        model.addAttribute("lista", lista);
        return "entrada";
    }

}
