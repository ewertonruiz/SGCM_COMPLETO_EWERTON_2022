package br.ufac.sgcmapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufac.sgcmapi.model.ConvenioModel;

public interface ConvenioRepository extends JpaRepository<ConvenioModel, Long>{

    @Query("SELECT a FROM ConvenioModel a WHERE nome LIKE '%:termoBusca%'")
    List<ConvenioModel> findByAll(String termoBusca);
    
}
