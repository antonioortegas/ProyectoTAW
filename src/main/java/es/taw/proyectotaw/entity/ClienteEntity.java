package es.taw.proyectotaw.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cliente", schema = "mydb", catalog = "")
public class ClienteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "Clientecol", nullable = true, length = 45)
    private String clientecol;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientecol() {
        return clientecol;
    }

    public void setClientecol(String clientecol) {
        this.clientecol = clientecol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteEntity that = (ClienteEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(clientecol, that.clientecol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientecol);
    }
}
