package es.taw.proyectotaw.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "mensaje", schema = "mydb", catalog = "")
public class MensajeEntity
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_mensaje", nullable = false)
    private Integer idMensaje;
    @Basic
    @Column(name = "contenido", nullable = false, length = 256)
    private String contenido;
    @Basic
    @Column(name = "fecha_envio", nullable = false)
    private Timestamp fechaEnvio;
    @ManyToOne
    @JoinColumn(name = "usuario_destino", referencedColumnName = "id_usuario", nullable = false)
    private UsuarioEntity usuarioByUsuarioDestino;
    @ManyToOne
    @JoinColumn(name = "usuario_origen", referencedColumnName = "id_usuario", nullable = false)
    private UsuarioEntity usuarioByUsuarioOrigen;

    public Integer getIdMensaje()
    {
        return idMensaje;
    }

    public void setIdMensaje(Integer idMensaje)
    {
        this.idMensaje = idMensaje;
    }

    public String getContenido()
    {
        return contenido;
    }

    public void setContenido(String contenido)
    {
        this.contenido = contenido;
    }

    public Timestamp getFechaEnvio()
    {
        return fechaEnvio;
    }

    public void setFechaEnvio(Timestamp fechaEnvio)
    {
        this.fechaEnvio = fechaEnvio;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MensajeEntity that = (MensajeEntity) o;

        if (idMensaje != null ? !idMensaje.equals(that.idMensaje) : that.idMensaje != null) return false;
        if (contenido != null ? !contenido.equals(that.contenido) : that.contenido != null) return false;
        if (fechaEnvio != null ? !fechaEnvio.equals(that.fechaEnvio) : that.fechaEnvio != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = idMensaje != null ? idMensaje.hashCode() : 0;
        result = 31 * result + (contenido != null ? contenido.hashCode() : 0);
        result = 31 * result + (fechaEnvio != null ? fechaEnvio.hashCode() : 0);
        return result;
    }

    public UsuarioEntity getUsuarioByUsuarioDestino()
    {
        return usuarioByUsuarioDestino;
    }

    public void setUsuarioByUsuarioDestino(UsuarioEntity usuarioByUsuarioDestino)
    {
        this.usuarioByUsuarioDestino = usuarioByUsuarioDestino;
    }

    public UsuarioEntity getUsuarioByUsuarioOrigen()
    {
        return usuarioByUsuarioOrigen;
    }

    public void setUsuarioByUsuarioOrigen(UsuarioEntity usuarioByUsuarioOrigen)
    {
        this.usuarioByUsuarioOrigen = usuarioByUsuarioOrigen;
    }
}
