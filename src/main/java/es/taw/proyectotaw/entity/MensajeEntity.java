package es.taw.proyectotaw.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "mensaje", schema = "mydb", catalog = "")
public class MensajeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_mensaje", nullable = false)
    private Integer idMensaje;
    @Basic
    @Column(name = "contenido", nullable = true, length = 256)
    private String contenido;
    @Basic
    @Column(name = "fecha_envio", nullable = true)
    private Timestamp fechaEnvio;
    @ManyToOne
    @JoinColumn(name = "Chat_id_chat", referencedColumnName = "id_chat", nullable = false)
    private ChatEntity chatByChatIdChat;

    public Integer getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Timestamp getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Timestamp fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MensajeEntity that = (MensajeEntity) o;
        return Objects.equals(idMensaje, that.idMensaje) && Objects.equals(contenido, that.contenido) && Objects.equals(fechaEnvio, that.fechaEnvio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMensaje, contenido, fechaEnvio);
    }

    public ChatEntity getChatByChatIdChat() {
        return chatByChatIdChat;
    }

    public void setChatByChatIdChat(ChatEntity chatByChatIdChat) {
        this.chatByChatIdChat = chatByChatIdChat;
    }
}
