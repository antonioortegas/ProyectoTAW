package es.taw.proyectotaw.dao;

import es.taw.proyectotaw.Entity.EmpresaEntity;
import es.taw.proyectotaw.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
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

    List<UsuarioEntity> findAllByEmpresaByEmpresaIdEmpresa(EmpresaEntity orElse);

    List<UsuarioEntity> findByCuentabancoByCuentaBancoIdCuentaBancoIsNotNullAndEmpresaByEmpresaIdEmpresaEquals(EmpresaEntity empresa);

    //Search for users with a pending "alta" request
    @Query("select u from UsuarioEntity u inner join PeticionEntity p on u=p.usuarioByUsuarioIdUsuario where p.estadoPeticion like 'noprocesada' and p.tipoPeticion like 'alta'")
     public List<UsuarioEntity> buscarUsuariosConSolicitudDeAlta();

    @Query("select u from UsuarioEntity u inner join CuentabancoEntity c on u.cuentabancoByCuentaBancoIdCuentaBanco=c inner join TransaccionEntity t on t.cuentabancoByCuentaBancoIdCuentaBanco=c inner join PagoEntity p on t.pagoByPagoIdPago=p inner join BeneficiarioEntity b on p.beneficiarioByBeneficiarioIdBeneficiario=b where b.numeroCuentaBeneficiario like c.iban and c.sospechoso=1")
    public List<UsuarioEntity> buscarUsuariosConActividadSospechosa();

    @Query("select u from UsuarioEntity u where u not in (select u from UsuarioEntity u inner join CuentabancoEntity c on u.cuentabancoByCuentaBancoIdCuentaBanco=c inner join TransaccionEntity t on t.cuentabancoByCuentaBancoIdCuentaBanco=c where t.fechaInstruccion > :fecha or c.transaccionsByIdCuentaBanco is empty)")
    public List<UsuarioEntity> buscarUsuariosConInactividadDe30Dias(Date fecha);
}
