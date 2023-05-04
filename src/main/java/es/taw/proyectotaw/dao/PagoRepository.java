package es.taw.proyectotaw.dao;

import es.taw.proyectotaw.Entity.PagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<PagoEntity, Integer> {
}
