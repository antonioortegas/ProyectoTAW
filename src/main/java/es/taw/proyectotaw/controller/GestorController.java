package es.taw.proyectotaw.controller;

import es.taw.proyectotaw.Entity.CuentabancoEntity;
import es.taw.proyectotaw.Entity.EmpresaEntity;
import es.taw.proyectotaw.Entity.UsuarioEntity;
import es.taw.proyectotaw.dao.CuentabancoRepository;
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

    @Autowired
    private CuentabancoRepository cuentabancoRepository;

    @GetMapping("/gestor/usuarios")
    public String listarUsuarios(Model model){
        List<UsuarioEntity> listaUsuarios = this.usuarioRepository.findAll();
        model.addAttribute("listaUsuarios", listaUsuarios);
        List<EmpresaEntity> listaEmpresas = this.empresaRepository.findAll();
        model.addAttribute("listaEmpresas", listaEmpresas);
        return "/gestor/listadoUsuarios";
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
        //if persona fisica
        if(usuario.getTipoUsuario().equals("cliente")){
            if(this.cuentabancoRepository.findAllByUsuariosByIdCuentaBancoIsEmpty().size() > 0){
                CuentabancoEntity cuenta = this.cuentabancoRepository.findAllByUsuariosByIdCuentaBancoIsEmpty().get(0);
                usuario.setCuentabancoByCuentaBancoIdCuentaBanco(cuenta);
                setActivo(usuario);
            } else{
                System.out.println("No hay cuentas disponibles");
            }
        }
        //if socio o autorizado
        if(usuario.getTipoUsuario().equals("socio")||usuario.getTipoUsuario().equals("autorizado")){
            //if first user of the company
            if(usuario.getEmpresaByEmpresaIdEmpresa().getUsuariosByIdEmpresa().size() == 1){
                CuentabancoEntity cuenta = this.cuentabancoRepository.findAllByUsuariosByIdCuentaBancoIsEmpty().get(0);
                usuario.setCuentabancoByCuentaBancoIdCuentaBanco(cuenta);

            }
            //if not first user of the company
            else{
                List<UsuarioEntity> listaUsuarios = this.usuarioRepository.findByCuentabancoByCuentaBancoIdCuentaBancoIsNotNullAndEmpresaByEmpresaIdEmpresaEquals(usuario.getEmpresaByEmpresaIdEmpresa());
                if(listaUsuarios.size() > 0 ){
                    usuario.setCuentabancoByCuentaBancoIdCuentaBanco(listaUsuarios.get(0).getCuentabancoByCuentaBancoIdCuentaBanco());
                }

            }
            setActivo(usuario);
        }

        this.usuarioRepository.save(usuario);
        return "redirect:/gestor/usuarios";
    }

    public void setActivo(UsuarioEntity usuario){
        usuario.setEstadoUsuario("activo");
    }
}
