package br.ufac.sgcmapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufac.sgcmapi.model.ProfissionalModel;

public interface ProfissionalRepository extends JpaRepository<ProfissionalModel, Long> {

    @Query("SELECT p FROM ProfissionalModel p WHERE nome LIKE '%:termoBusca%'")
    List<ProfissionalModel> findByAll(String termoBusca);

}
