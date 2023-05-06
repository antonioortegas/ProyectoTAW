package es.taw.proyectotaw.dao;

import es.taw.proyectotaw.Entity.CambiodivisaEntity;
import es.taw.proyectotaw.Entity.CuentabancoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CuentabancoRepository extends JpaRepository<CuentabancoEntity, Integer> {
    List<CuentabancoEntity> findAllByUsuariosByIdCuentaBancoIsEmpty();

    List<CuentabancoEntity> findAllByEmpresasByIdCuentaBancoIsEmpty();

    List<CuentabancoEntity> findAllBySospechosoEquals(Integer sospechoso);

    @Query("select cuenta from CuentabancoEntity cuenta where cuenta.iban = :iban")
    public CuentabancoEntity cuentaDestinatario(@Param("iban")String iban);
}
