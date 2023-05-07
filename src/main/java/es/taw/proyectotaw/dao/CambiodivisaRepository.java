package es.taw.proyectotaw.dao;

import es.taw.proyectotaw.Entity.CambiodivisaEntity;
import es.taw.proyectotaw.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
/*
  Created by IntelliJ IDEA.
  User: Carlos Dominguez
  Date: 06/05/2023
  Time: 14:00
        */

public interface CambiodivisaRepository extends JpaRepository<CambiodivisaEntity, Integer> {

    @Query("select cd from CambiodivisaEntity cd where cd.monedaCompra != :miMoneda and cd.monedaVenta = :miMoneda")
    public List<CambiodivisaEntity> listaCambioDivisa(@Param("miMoneda")String miMoneda);

    @Query("select cd from CambiodivisaEntity cd where cd.monedaCompra = :miMonedaCompra and cd.monedaVenta = :miMonedaVenta")
    public CambiodivisaEntity miCambioDivisa(@Param("miMonedaCompra")String miMonedaCompra, @Param("miMonedaVenta")String miMonedaVenta);

}
