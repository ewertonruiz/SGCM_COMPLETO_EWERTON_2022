package br.ufac.sgcmapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufac.sgcmapi.model.UnidadeModel;

public interface UnidadeRepository extends JpaRepository<UnidadeModel, Long>{
    @Query("SELECT a FROM UnidadeModel a WHERE nome LIKE '%:termoBusca%'")
    List<UnidadeModel> findByAll(String termoBusca);
}
