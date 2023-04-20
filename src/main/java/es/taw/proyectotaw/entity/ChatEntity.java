package es.taw.proyectotaw.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "chat", schema = "mydb", catalog = "")
public class ChatEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idChat", nullable = false)
    private Integer idChat;
    @Basic
    @Column(name = "fechaInicio", nullable = false)
    private Timestamp fechaInicio;
    @Basic
    @Column(name = "fechaFinal", nullable = true)
    private Timestamp fechaFinal;
    @Basic
    @Column(name = "Asistente_idAsistente", nullable = false)
    private Integer asistenteIdAsistente;
    @OneToMany(mappedBy = "chatByChatIdChat")
    private Collection<MensajeEntity> mensajesByIdChat;
    @OneToMany(mappedBy = "chatByChatId")
    private Collection<UsuarioEntity> usuariosByIdChat;

    public Integer getIdChat() {
        return idChat;
    }

    public void setIdChat(Integer idChat) {
        this.idChat = idChat;
    }

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Timestamp getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Timestamp fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Integer getAsistenteIdAsistente() {
        return asistenteIdAsistente;
    }

    public void setAsistenteIdAsistente(Integer asistenteIdAsistente) {
        this.asistenteIdAsistente = asistenteIdAsistente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatEntity that = (ChatEntity) o;
        return Objects.equals(idChat, that.idChat) && Objects.equals(fechaInicio, that.fechaInicio) && Objects.equals(fechaFinal, that.fechaFinal) && Objects.equals(asistenteIdAsistente, that.asistenteIdAsistente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idChat, fechaInicio, fechaFinal, asistenteIdAsistente);
    }

    public Collection<MensajeEntity> getMensajesByIdChat() {
        return mensajesByIdChat;
    }

    public void setMensajesByIdChat(Collection<MensajeEntity> mensajesByIdChat) {
        this.mensajesByIdChat = mensajesByIdChat;
    }

    public Collection<UsuarioEntity> getUsuariosByIdChat() {
        return usuariosByIdChat;
    }

    public void setUsuariosByIdChat(Collection<UsuarioEntity> usuariosByIdChat) {
        this.usuariosByIdChat = usuariosByIdChat;
    }
}
