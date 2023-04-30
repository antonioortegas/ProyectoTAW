<%@ page import="es.taw.proyectotaw.Entity.MensajeEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="es.taw.proyectotaw.Entity.UsuarioEntity" %>
<%@ page import="java.util.LinkedList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>WhatsApp</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.2/css/bootstrap.min.css"
          integrity="sha512-1tRCOH/5z5Z0NfN5d5r5Q5tJSpAdtCnMnktP/XtB8Y2/Y5hGzyPmtwz5Z/Hg45ZjdBlyfELO1JaxQy+oGy/yvw=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            padding: 0;
            font-family: sans-serif;


        }

        html,
         body,
         .container,
         .conversations,
         .chat {
             width: 100%;
             height: 100%;
             margin: 0;
             padding: 0;
             overflow-x: hidden;
         }

        .containers {
            display: flex;
            height: 100vh;
        }

        .conversations {
            flex: 2;
            padding: 20px;
            background-color: #f2f2f2;
        }

        .conversations h2 {
            margin-top: 0;
        }

        .conversations ul {
            list-style: none;
            margin: 0;
            padding: 0;
        }

        .conversations li {
            padding: 10px;
            cursor: pointer;
        }

        .conversations li.active {
            background-color: #e6e6e6;
        }

        .header {
            padding: 20px;
            background-color: #075e54;
            color: #fff;
        }

        .header h2 {
            margin-top: 0;
        }

        .messages {
            flex: 1;
            display: flex;
            flex-direction: column;
            padding: 30px;
            overflow-y: scroll;
        }

        .message {
            display: flex;
            flex-direction: column;
        }

        .message p {
            padding: 10px;
            border-radius: 10px;
            max-width: 60%;
            word-wrap: break-word;
        }

        .message.received p {
            background-color: #f2f2f2;
            align-self: flex-start;
        }

        .message.sent p {
            background-color: #075e54;
            color: #fff;
            align-self: flex-end;
        }

        .time-stamp {
            font-size: 12px;
            color: #565656;
            padding-bottom: 54px;
        }


        .chat {
            flex: 8;
            display: flex;
            flex-direction: column;
            position: relative;
            padding-bottom: 40px; /* add padding bottom to create some space between messages and input container */
        }


        .input-container {
            position: absolute;
            bottom: 0;
            left: 0;
            right: 0;
            height: 60px; /* adjust height to match the original size */
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 10px;
            background-color: #f2f2f2;
        }
        .input-container input {
            flex: 1;
            padding: 10px;
            border: none;
            border-radius: 30px;
            background-color: #fff;
            margin-right: 10px;
        }

        .input-container button {
            width: 40px;
            height: 40px;
            border: none;
            border-radius: 50%;
            background-color: #075e54;
            color: #fff;
            cursor: pointer;
        }
        .contact:hover {
            background-color: white;
            cursor: pointer;
        }

        #wrapper {
            margin-left: 10%;
            margin-right: 10%;

        }
    </style>

</head>
<body>

<%
    UsuarioEntity usuarioLogeado = (UsuarioEntity) request.getAttribute("usuarioLogeado");
    List<MensajeEntity> mensajesPersonales = (List<MensajeEntity>) request.getAttribute("mensajesPersonales");
    List<UsuarioEntity> listaUsuarios = (List<UsuarioEntity>) request.getAttribute("listaUsuarios");
    List<UsuarioEntity> asistentes = new LinkedList<>();

    for (UsuarioEntity asistente : listaUsuarios)
    {
        if (asistente.getTipoUsuario().equals("asistente"))
        {
            asistentes.add(asistente);
        }
    }

%>
 <div id="wrapper">
     <div class="containers">
         <div class="conversations">
             <div class="header">
                 <h2>Conversations</h2>
             </div>
             <% for (UsuarioEntity contacto : listaUsuarios) {
             %>
             <ul>
                 <li class="contact" onclick="selectContact('<%= contacto.getNombre() %>')">
                     <%= contacto.getNombre() %>
                 </li>
             </ul>

             <%
                 }
             %>


             <br><br><br><br><br><td>${pageContext.session.id}</td>
         </div>
         <div class="chat">
             <div class="header">
                 <h2>Contact 1</h2>
             </div>
             <div class="messages">


                 <%
                     for (MensajeEntity mensaje : mensajesPersonales)
                     {
                         if (mensaje.getUsuarioByUsuarioOrigen().getIdUsuario() == 1) {
                 %>
                 <div class="message received">

                     <%
                         }
                         if (mensaje.getUsuarioByUsuarioDestino().getIdUsuario() != 1) {
                     %>
                     <div class="message sent">
                         <%
                             }
                         %>
                         <p> <%= mensaje.getContenido()%>  <%
                             SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                             String time = format.format(mensaje.getFechaEnvio());
                         %> <span class="time-stamp"><%= time %></span></p>
                     </div>

                     <%    }
                     %>

                 </div>
                 <form action="/Asistencia/asistente/sendMessage" method="POST" onsubmit="return validateForm();">
                     <div class="input-container">
                         <input type="text" name="message" id="message" placeholder="Type a message...">
                         <button type="submit" class="send-btn"><i class="fas fa-paper-plane"></i></button>
                     </div>
                 </form>




             </div>
         </div>
     </div>

 </div>
    <script>
        function validateForm() {
            var message = document.getElementById("message").value;
            if (message.trim() == "") {

                return false;
            }
            inputField.focus()
            return true;
        }
    </script>

    <script> // Script para que siempre esté abajo del todo de la conver
        const messagesContainer = document.querySelector(".messages");
        messagesContainer.scrollTop = messagesContainer.scrollHeight;
        const inputField = document.querySelector("input[type='text']");
        inputField.addEventListener("focus", () => {
            messagesContainer.scrollTop = messagesContainer.scrollHeight;
        });
        const sendButton = document.querySelector(".send-btn");
        sendButton.addEventListener("click", () => {
            messagesContainer.scrollTop = messagesContainer.scrollHeight;
        });inputField.focus();
    </script>

    <script>
        function selectContact(contactName) {
            // Remove the 'active' class from any previously active contact
            let activeContact = document.querySelector('.contact.active');
            if (activeContact) {
                activeContact.classList.remove('active');
            }

            // Add the 'active' class to the clicked contact
            let clickedContact = event.target;
            clickedContact.classList.add('active');
        }
    </script>


    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.2/js/bootstrap.min.js"
            integrity="sha512-fJ1tpzsHwKjNliDARaL2IbgH9KspJ2G8fYrT3nqOraln0zaMhKgI+Brn/qmee0UsG9ILH2Q1yEYfT0AtukKs7w=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>