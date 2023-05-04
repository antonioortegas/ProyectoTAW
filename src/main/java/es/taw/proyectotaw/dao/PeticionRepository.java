package es.taw.proyectotaw.dao;

import es.taw.proyectotaw.Entity.PeticionEntity;
import es.taw.proyectotaw.Entity.UsuarioEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.security.Timestamp;
import java.util.Date;
import java.util.List;

public interface PeticionRepository extends JpaRepository<PeticionEntity, Integer> {

    List<PeticionEntity> findAllByUsuarioByUsuarioIdUsuarioEqualsAndEstadoPeticionEquals(UsuarioEntity usuario, String estado);
    List<PeticionEntity> findAllByUsuarioByUsuarioIdUsuarioEqualsAndEstadoPeticionEqualsAndTipoPeticionEquals(UsuarioEntity usuario, String estado, String tipo);
}
