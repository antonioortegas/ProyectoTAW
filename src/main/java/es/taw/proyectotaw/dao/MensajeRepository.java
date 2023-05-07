package es.taw.proyectotaw.dao;

/*
    AUTOR : Edgar Antonio Álvarez González - 100%
 */

import es.taw.proyectotaw.Entity.MensajeEntity;
import es.taw.proyectotaw.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
//Edgar Álvarez
public interface MensajeRepository extends JpaRepository<MensajeEntity, Integer> {
    @Query("SELECT m FROM MensajeEntity m WHERE (m.usuarioByUsuarioOrigen.idUsuario = :userId1 AND m.usuarioByUsuarioDestino.idUsuario = :userId2) OR (m.usuarioByUsuarioOrigen.idUsuario = :userId2 AND m.usuarioByUsuarioDestino.idUsuario = :userId1) ORDER BY m.fechaEnvio")
    List<MensajeEntity> findAllMessagesBetweenTwoUsersOrderedByDate(@Param("userId1") Integer userId1, @Param("userId2") Integer userId2);
}
