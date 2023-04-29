package es.taw.proyectotaw.dao;

import es.taw.proyectotaw.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    @Query("select u.nombre, c.saldo from UsuarioEntity u, CuentabancoEntity c  where u.cuentabancoByCuentaBancoIdCuentaBanco= c")
    List<UsuarioEntity> todosLosUsuarios();
    //u. from usuario u, cuenta c  where u.cuenta_id_cuenta=c.id_cuenta order by u.id_usuario

    @Query("select u from UsuarioEntity u where u.nif = :nif and u.contrasena = :contrasena")
    public UsuarioEntity usuarioByNIFyContrasena (@Param("nif") String nif, @Param("contrasena")String contrasena);

    @Query("select u from UsuarioEntity u where u.nif = :nif and u.contrasena = :contrasena")
    public UsuarioEntity autenticarUsuarioEmpresa (@Param("nif") String nif, @Param("contrasena")String contrasena);

    @Query("select distinct u.nif, u.nombre from UsuarioEntity u, EmpresaEntity e where  u.empresaByEmpresaIdEmpresa.cif = :idEmpresa")
    public List<UsuarioEntity> buscarUsuariosMismaEmpresa(@Param("idEmpresa")String idEmpresa);
}
