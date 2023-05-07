package es.taw.proyectotaw.dao;

import es.taw.proyectotaw.Entity.PagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
//Carlos Dominguez
public interface PagoRepository extends JpaRepository<PagoEntity, Integer> {
}
