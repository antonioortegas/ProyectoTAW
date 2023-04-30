package es.taw.proyectotaw.dao;

import es.taw.proyectotaw.Entity.PeticionEntity;
import es.taw.proyectotaw.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeticionRepository extends JpaRepository<PeticionEntity, Integer> {
    List<PeticionEntity> findAllByUsuarioByUsuarioIdUsuarioEqualsAndEstadoPeticionEqualsAndTipoPeticionEquals(UsuarioEntity usuario, String estado, String tipo);
}
