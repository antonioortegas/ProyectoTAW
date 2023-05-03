package es.taw.proyectotaw.dao;

import es.taw.proyectotaw.Entity.CambiodivisaEntity;
import es.taw.proyectotaw.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CambiodivisaRepository extends JpaRepository<CambiodivisaEntity, Integer> {

    @Query("select cd.monedaCompra from CambiodivisaEntity cd where cd.monedaCompra != :miMoneda")
    public List<CambiodivisaEntity> listaCambioDivisa(@Param("miMoneda")String miMoneda);

    @Query("select cd from CambiodivisaEntity cd where cd.monedaCompra = :miMonedaCompra and cd.monedaVenta = :miMonedaVenta")
    public CambiodivisaEntity miCambioDivisa(@Param("miMonedaCompra")String miMonedaCompra, @Param("miMonedaVenta")String miMonedaVenta);

}
