package br.ufac.sgcmapi.repository;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufac.sgcmapi.model.EspecialidadeModel;

public interface EspecialidadeRepository extends JpaRepository<EspecialidadeModel, Long>{
    
    @Query("SELECT e FROM EspecialidadeModel e WHERE nome LIKE '%:termoBusca%'")
    List<EspecialidadeModel> findByAll(String termoBusca);
}
