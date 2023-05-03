package es.taw.proyectotaw.dao;

import es.taw.proyectotaw.Entity.TransaccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository <TransaccionEntity, Integer> {
}
