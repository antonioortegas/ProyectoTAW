package es.taw.proyectotaw.dao;

import es.taw.proyectotaw.Entity.EmpresaEntity;
import es.taw.proyectotaw.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity,Integer> {

    @Query("select e from EmpresaEntity e inner join UsuarioEntity u on u.empresaByEmpresaIdEmpresa=e inner join PeticionEntity p on u=p.usuarioByUsuarioIdUsuario where p.estadoPeticion like 'noprocesada' and p.tipoPeticion like 'alta'")
    List<EmpresaEntity> buscarEmpresasConSolicitudDeAlta();


    @Query("select e from EmpresaEntity e inner join UsuarioEntity u on u.empresaByEmpresaIdEmpresa=e inner join CuentabancoEntity c on u.cuentabancoByCuentaBancoIdCuentaBanco=c inner join TransaccionEntity t on t.cuentabancoByCuentaBancoIdCuentaBanco=c where t.fechaInstruccion = all(select fechaInstruccion from TransaccionEntity where fechaInstruccion < :fecha and TransaccionEntity = t)")
    List<EmpresaEntity> buscarEmpresasConInactividadDe30Dias(Date fecha);

    @Query("select e from EmpresaEntity e inner join UsuarioEntity u on u.empresaByEmpresaIdEmpresa=e inner join CuentabancoEntity c on u.cuentabancoByCuentaBancoIdCuentaBanco=c inner join TransaccionEntity t on t.cuentabancoByCuentaBancoIdCuentaBanco=c inner join PagoEntity p on t.pagoByPagoIdPago=p inner join BeneficiarioEntity b on p.beneficiarioByBeneficiarioIdBeneficiario=b where b.numeroCuentaBeneficiario like c.iban and c.sospechoso=1")
    List<EmpresaEntity> buscarEmpresasConActividadSospechosa();

    @Query("select u from UsuarioEntity u where u.empresaByEmpresaIdEmpresa.idEmpresa = :idEmpresa and lower(u.tipoUsuario) like 'socio' ")
    List<UsuarioEntity> buscarSocios(@Param("idEmpresa")Integer idEmpresa);
    @Query("select u from UsuarioEntity u where u.empresaByEmpresaIdEmpresa.idEmpresa = :idEmpresa and lower(u.tipoUsuario) like 'autorizado' ")
    List<UsuarioEntity> buscarAutorizados(@Param("idEmpresa")Integer idEmpresa);


}
