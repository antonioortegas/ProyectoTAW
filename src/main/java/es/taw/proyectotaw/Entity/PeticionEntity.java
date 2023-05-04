package es.taw.proyectotaw.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "peticion", schema = "mydb", catalog = "")
public class PeticionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_peticion", nullable = false)
    private Integer idPeticion;
    @Basic
    @Column(name = "tipo_peticion", nullable = false, length = 45)
    private String tipoPeticion;
    @Basic
    @Column(name = "fecha_peticion", nullable = true)
    private Timestamp fechaPeticion;
    @Basic
    @Column(name = "estado_peticion", nullable = false, length = 45)
    private String estadoPeticion;
    @ManyToOne
    @JoinColumn(name = "Usuario_id_usuario", referencedColumnName = "id_usuario", nullable = false)
    private UsuarioEntity usuarioByUsuarioIdUsuario;

    public Integer getIdPeticion() {
        return idPeticion;
    }

    public void setIdPeticion(Integer idPeticion) {
        this.idPeticion = idPeticion;
    }

    public String getTipoPeticion() {
        return tipoPeticion;
    }

    public void setTipoPeticion(String tipoPeticion) {
        this.tipoPeticion = tipoPeticion;
    }

    public Timestamp getFechaPeticion() {
        return fechaPeticion;
    }

    public void setFechaPeticion(Timestamp fechaPeticion) {
        this.fechaPeticion = fechaPeticion;
    }

    public String getEstadoPeticion() {
        return estadoPeticion;
    }

    public void setEstadoPeticion(String estadoPeticion) {
        this.estadoPeticion = estadoPeticion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeticionEntity peticion = (PeticionEntity) o;
        return Objects.equals(idPeticion, peticion.idPeticion) && Objects.equals(tipoPeticion, peticion.tipoPeticion) && Objects.equals(fechaPeticion, peticion.fechaPeticion) && Objects.equals(estadoPeticion, peticion.estadoPeticion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPeticion, tipoPeticion, fechaPeticion, estadoPeticion);
    }

    public UsuarioEntity getUsuarioByUsuarioIdUsuario() {
        return usuarioByUsuarioIdUsuario;
    }

    public void setUsuarioByUsuarioIdUsuario(UsuarioEntity usuarioByUsuarioIdUsuario) {
        this.usuarioByUsuarioIdUsuario = usuarioByUsuarioIdUsuario;
    }
}
