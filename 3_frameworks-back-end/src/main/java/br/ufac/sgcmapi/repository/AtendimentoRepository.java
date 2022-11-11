package br.ufac.sgcmapi.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufac.sgcmapi.model.AtendimentoModel;


public interface AtendimentoRepository extends JpaRepository<AtendimentoModel, Long> {
    

    @Query("SELECT am FROM AtendimentoModel am" +
    " LEFT JOIN ProfissionalModel pm ON pm.id = am.profissional" +
    " LEFT JOIN PacienteModel pa ON pa.id = am.paciente" +
    " LEFT JOIN ConvenioModel cm ON cm.id = am.convenio" +
    " LEFT JOIN UnidadeModel um ON um.id = pm.unidade" +
    " WHERE pm.nome LIKE '%?1%'" +
    " OR pa.nome LIKE '%?1%'" +
    " OR cm.nome LIKE '%?1%'" +
    " OR um.nome LIKE '%?1%'")
    List<AtendimentoModel> findByAll(String termoBusca);

    
    @Query("SELECT am FROM AtendimentoModel am" +
           " LEFT JOIN ProfissionalModel pm ON am.profissional = pm.id" +
           " WHERE pm.id = :profissional_id AND am.data = :atendimento_dt")
    List<AtendimentoModel> findByProfissionalAndData(Long profissional_id, Date atendimento_dt);
}
