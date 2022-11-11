package br.ufac.sgcmapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufac.sgcmapi.model.PacienteModel;
import br.ufac.sgcmapi.repository.PacienteRepository;

@Service
public class PacienteService implements ICrudService<PacienteModel> {

    private final PacienteRepository repo;

    @Autowired
    public PacienteService(PacienteRepository repo) {
        this.repo = repo;
    }

    @Override
    public void delete(Long id) {
        repo.delete(repo.findById(id).orElse(null));
        
    }

    @Override
    public List<PacienteModel> getAll() {
        return repo.findAll();
    }

    @Override
    public PacienteModel getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public PacienteModel save(PacienteModel objeto) {
        return repo.save(objeto);
    }

    @Override
    public List<PacienteModel> getByAll(String termoBusca) {
        return null;
    }

    
}
