package br.ufac.sgcmapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufac.sgcmapi.model.ProfissionalModel;
import br.ufac.sgcmapi.repository.ProfissionalRepository;

@Service

public class ProfissionalService implements ICrudService<ProfissionalModel>{
    
    private final ProfissionalRepository repo;

    @Autowired
    public ProfissionalService(ProfissionalRepository repo) {
        this.repo = repo;
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<ProfissionalModel> getAll() {
        return repo.findAll();
    }

    @Override
    public List<ProfissionalModel> getByAll(String termoBusca) {
        return repo.findByAll(termoBusca);
    }

    @Override
    public ProfissionalModel getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public ProfissionalModel save(ProfissionalModel objeto) {
        return repo.save(objeto);
    }
}
