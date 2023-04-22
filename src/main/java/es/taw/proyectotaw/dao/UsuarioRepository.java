package es.taw.proyectotaw.dao;

import es.taw.proyectotaw.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    @Query("select u.nombre, c.saldo from UsuarioEntity u, CuentaEntity c  where u.cuentaByCuentaIdCuenta= c")
    List<UsuarioEntity> todosLosUsuarios();
    //u. from usuario u, cuenta c  where u.cuenta_id_cuenta=c.id_cuenta order by u.id_usuario
}
