package es.taw.proyectotaw.dao;

import es.taw.proyectotaw.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity,Integer> {

}
