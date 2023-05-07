/*
AUTOR : Edgar Antonio Álvarez González - 100%
 */
package es.taw.proyectotaw.controller;

import es.taw.proyectotaw.Entity.MensajeEntity;
import es.taw.proyectotaw.Entity.UsuarioEntity;
import es.taw.proyectotaw.dao.MensajeRepository;
import es.taw.proyectotaw.dao.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
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
    public String doListarMensajes(@RequestParam(name = "contactId", required = false) Integer contact, Model model, HttpSession httpSession)
    {
        UsuarioEntity usuarioLogeado = (UsuarioEntity) httpSession.getAttribute("usuario");

        if (httpSession.getAttribute("cliente") != null) {
            usuarioLogeado = (UsuarioEntity) httpSession.getAttribute("cliente");
        } else if (httpSession.getAttribute("socio") != null) {
            usuarioLogeado = (UsuarioEntity) httpSession.getAttribute("socio");
        } else {
            usuarioLogeado = (UsuarioEntity) httpSession.getAttribute("usuario");
        }

        if (usuarioLogeado == null) return "/Asistencia/loginAyuda";

        model.addAttribute("usuarioLogeado", usuarioLogeado);

        List<UsuarioEntity> listaUsuarios = usuarioRepository.findAll();
        model.addAttribute("listaUsuarios", listaUsuarios);

        UsuarioEntity contactUser;
        if (contact == null) contactUser = usuarioLogeado;
        else
        {
            contactUser = usuarioRepository.findById(contact).orElse(null);

        }

        model.addAttribute("contacto", contactUser);


        List<MensajeEntity> mensajesDelUsuarioAOtro = mensajeRepository.findAllMessagesBetweenTwoUsersOrderedByDate(usuarioLogeado.getIdUsuario(), contactUser.getIdUsuario());
        model.addAttribute("mensajesPersonales", mensajesDelUsuarioAOtro);

        return "/Asistencia/asistente";
    }


    @PostMapping("/Asistencia/asistente/sendMessage")
    public String sendMessage(@RequestParam("message") String message, @RequestParam(name = "contactId", required = true) Integer contact, HttpSession httpSession)
    {
        UsuarioEntity contactUser = usuarioRepository.findById(contact).orElse(null);
        UsuarioEntity usuarioLogeado = (UsuarioEntity) httpSession.getAttribute("usuario");
        List<UsuarioEntity> listaUsuarios = usuarioRepository.findAll();


        if (message != null && !message.isEmpty() && !message.isBlank() && contact != usuarioLogeado.getIdUsuario() )
        {
            // Retrieve the user information from the session

            // Create a new message entity and set its properties
            MensajeEntity mensaje = new MensajeEntity();
            mensaje.setContenido(message);
            mensaje.setUsuarioByUsuarioOrigen(usuarioRepository.findById(contactUser.getIdUsuario()).orElse(null));
            mensaje.setUsuarioByUsuarioDestino(usuarioRepository.findById(usuarioLogeado.getIdUsuario()).orElse(null));
            mensaje.setFechaEnvio(new Timestamp(System.currentTimeMillis()));

            // Save the message to the database
            mensajeRepository.save(mensaje);

        }

        // Redirect the user back to the chat page
        return "redirect:/Asistencia/asistente?contactId=" + contactUser.getIdUsuario();
    }

    @PostMapping("/Asistencia/loginAyuda")
    public String doLoginCredentials(@RequestParam("nif") String nif,
                                     @RequestParam("password") String password,
                                     Model model, HttpSession session)
    {
        UsuarioEntity userLogged = usuarioRepository.usuarioByNIFyContrasena(nif, password);

        session.setAttribute("usuario", userLogged);
        return "redirect:/Asistencia/asistente";

    }

    @PostMapping("/Asistencia/logout")
    public String doLogoutAndKillSessionID(HttpSession session)
    {
        session.invalidate();
        return "redirect:/Asistencia/asistente";
    }

}
