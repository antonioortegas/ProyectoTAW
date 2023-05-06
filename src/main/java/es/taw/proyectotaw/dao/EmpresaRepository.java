package es.taw.proyectotaw.dao;

import es.taw.proyectotaw.Entity.EmpresaEntity;
import es.taw.proyectotaw.Entity.UsuarioEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity,Integer> {


    @Query("select u from UsuarioEntity u where u.empresaByEmpresaIdEmpresa.idEmpresa = :idEmpresa and lower(u.tipoUsuario) like 'socio' ")
    List<UsuarioEntity> buscarSocios(@Param("idEmpresa")Integer idEmpresa);
    @Query("select u from UsuarioEntity u where u.empresaByEmpresaIdEmpresa.idEmpresa = :idEmpresa and lower(u.tipoUsuario) like 'autorizado' ")
    List<UsuarioEntity> buscarAutorizados(@Param("idEmpresa")Integer idEmpresa);

    //Antonio vvv
    @Query("select e from EmpresaEntity e inner join PeticionEntity p on e.idEmpresa = p.empresaByEmpresaIdEmpresa.idEmpresa where p.estadoPeticion = 'noprocesada' and p.tipoPeticion = :tipo")
    public List<EmpresaEntity> buscarEmpresasConSolicitudDeTipo(Sort by, String tipo);

    @Query("SELECT e FROM EmpresaEntity e WHERE e NOT IN (SELECT DISTINCT e FROM EmpresaEntity e JOIN e.cuentabancoByCuentaEmpresaIdCuentaBanco c JOIN c.transaccionsByIdCuentaBanco t WHERE t.fechaInstruccion >= :fecha)")
    public List<EmpresaEntity> buscarEmpresasConInactividadDe30Dias(Sort by, Date fecha);
    //Antonio ^^^
}
