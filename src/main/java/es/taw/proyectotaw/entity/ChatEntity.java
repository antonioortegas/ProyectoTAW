package es.taw.proyectotaw.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "chat", schema = "mydb", catalog = "")
public class ChatEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_chat", nullable = false)
    private Integer idChat;
    @Basic
    @Column(name = "fecha_inicio", nullable = false)
    private Timestamp fechaInicio;
    @Basic
    @Column(name = "fecha_cierre", nullable = true)
    private Timestamp fechaCierre;
    @OneToMany(mappedBy = "chatByChatIdChat")
    private Collection<MensajeEntity> mensajesByIdChat;
    @OneToMany(mappedBy = "chatByChatIdChat")
    private Collection<ServiciochatEntity> serviciochatsByIdChat;

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

    public Timestamp getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Timestamp fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatEntity that = (ChatEntity) o;
        return Objects.equals(idChat, that.idChat) && Objects.equals(fechaInicio, that.fechaInicio) && Objects.equals(fechaCierre, that.fechaCierre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idChat, fechaInicio, fechaCierre);
    }

    public Collection<MensajeEntity> getMensajesByIdChat() {
        return mensajesByIdChat;
    }

    public void setMensajesByIdChat(Collection<MensajeEntity> mensajesByIdChat) {
        this.mensajesByIdChat = mensajesByIdChat;
    }

    public Collection<ServiciochatEntity> getServiciochatsByIdChat() {
        return serviciochatsByIdChat;
    }

    public void setServiciochatsByIdChat(Collection<ServiciochatEntity> serviciochatsByIdChat) {
        this.serviciochatsByIdChat = serviciochatsByIdChat;
    }
}
