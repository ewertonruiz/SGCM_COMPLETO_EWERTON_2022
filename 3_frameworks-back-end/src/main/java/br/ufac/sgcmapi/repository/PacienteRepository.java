package br.ufac.sgcmapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufac.sgcmapi.model.PacienteModel;

public interface PacienteRepository extends JpaRepository<PacienteModel, Long> {
    
    @Query("SELECT p FROM PacienteModel p WHERE nome LIKE '%:termoBusca%'")
    List<PacienteModel> findByAll(String termoBusca);
}
