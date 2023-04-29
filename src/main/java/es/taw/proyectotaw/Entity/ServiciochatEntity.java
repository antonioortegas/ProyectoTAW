package es.taw.proyectotaw.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "serviciochat", schema = "mydb", catalog = "")
public class ServiciochatEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_servicio_chat", nullable = false, length = 45)
    private String idServicioChat;
    @ManyToOne
    @JoinColumn(name = "Usuario_id_usuario", referencedColumnName = "id_usuario", nullable = false)
    private UsuarioEntity usuarioByUsuarioIdUsuario;
    @ManyToOne
    @JoinColumn(name = "Chat_id_chat", referencedColumnName = "id_chat", nullable = false)
    private ChatEntity chatByChatIdChat;

    public String getIdServicioChat() {
        return idServicioChat;
    }

    public void setIdServicioChat(String idServicioChat) {
        this.idServicioChat = idServicioChat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiciochatEntity that = (ServiciochatEntity) o;
        return Objects.equals(idServicioChat, that.idServicioChat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServicioChat);
    }

    public UsuarioEntity getUsuarioByUsuarioIdUsuario() {
        return usuarioByUsuarioIdUsuario;
    }

    public void setUsuarioByUsuarioIdUsuario(UsuarioEntity usuarioByUsuarioIdUsuario) {
        this.usuarioByUsuarioIdUsuario = usuarioByUsuarioIdUsuario;
    }

    public ChatEntity getChatByChatIdChat() {
        return chatByChatIdChat;
    }

    public void setChatByChatIdChat(ChatEntity chatByChatIdChat) {
        this.chatByChatIdChat = chatByChatIdChat;
    }
}
