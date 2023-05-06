package es.taw.proyectotaw.dao;

import es.taw.proyectotaw.Entity.CuentabancoEntity;
import es.taw.proyectotaw.Entity.TransaccionEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TransaccionRepository extends JpaRepository <TransaccionEntity, Integer> {

    List<TransaccionEntity> findAllByCuentabancoByCuentaBancoIdCuentaBancoEqualsAndPagoByPagoIdPagoNotNull(CuentabancoEntity c, Sort by);
    List<TransaccionEntity> findAllByCuentabancoByCuentaBancoIdCuentaBancoEqualsAndCambiodivisaByCambioDivisaIdCambioDivisaNotNull(CuentabancoEntity c, Sort by);

    List<TransaccionEntity> findAllByCuentabancoByCuentaBancoIdCuentaBanco(Sort by, CuentabancoEntity c);
}
