package es.taw.proyectotaw.dao;

import es.taw.proyectotaw.Entity.CuentabancoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuentabancoRepository extends JpaRepository<CuentabancoEntity, Integer> {
    List<CuentabancoEntity> findAllByUsuariosByIdCuentaBancoIsEmpty();

    List<CuentabancoEntity> findAllBySospechosoEquals(Integer sospechoso);
}
