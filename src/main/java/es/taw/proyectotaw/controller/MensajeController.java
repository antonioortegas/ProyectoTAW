package es.taw.proyectotaw.controller;

import es.taw.proyectotaw.Entity.MensajeEntity;
import es.taw.proyectotaw.Entity.UsuarioEntity;
import es.taw.proyectotaw.dao.MensajeRepository;
import es.taw.proyectotaw.dao.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class MensajeController
{
    @Autowired
    protected MensajeRepository mensajeRepository;
    @Autowired
    protected UsuarioRepository usuarioRepository;

    @GetMapping("/Asistencia/asistente")
    public String doListarMensajes(Model model, HttpSession httpSession)
    {
        UsuarioEntity usuarioLogeado = (UsuarioEntity) httpSession.getAttribute("nif");

        if (usuarioLogeado == null)
            usuarioLogeado = usuarioRepository.getReferenceById(21);

        model.addAttribute("usuaroLogeado", usuarioLogeado);

        List<UsuarioEntity> listaUsuarios = usuarioRepository.findAll();
        model.addAttribute("listaUsuarios", listaUsuarios);

        List<MensajeEntity> mensajesDelUsuarioAOtro = mensajeRepository.findAllMessagesBetweenTwoUsers(usuarioLogeado.getIdUsuario(), 1);
        model.addAttribute("mensajesPersonales", mensajesDelUsuarioAOtro);

        return "/Asistencia/asistente";
    }


    @PostMapping("/Asistencia/asistente/sendMessage")
    public String sendMessage(@RequestParam("message") String message, HttpSession httpSession)
    {

        if (message != null && !message.isEmpty() && !message.isBlank())
        {

            // Retrieve the user information from the session
            UsuarioEntity usuario = (UsuarioEntity) httpSession.getAttribute("nif");

            // Create a new message entity and set its properties
            MensajeEntity mensaje = new MensajeEntity();
            mensaje.setContenido(message);
            mensaje.setUsuarioByUsuarioOrigen(usuarioRepository.findById(1).orElse(null));
            mensaje.setUsuarioByUsuarioDestino(usuarioRepository.findById(21).orElse(null));
            mensaje.setFechaEnvio(new Timestamp(System.currentTimeMillis()));

            // Save the message to the database
            mensajeRepository.save(mensaje);

        }

        // Redirect the user back to the chat page
        return "redirect:/Asistencia/asistente";
    }

}
