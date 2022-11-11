package br.ufac.sgcmapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufac.sgcmapi.model.EspecialidadeModel;
import br.ufac.sgcmapi.repository.EspecialidadeRepository;

@Service
public class EspecialidadeService implements ICrudService<EspecialidadeModel> {

    private final EspecialidadeRepository repo;

    @Autowired
    public EspecialidadeService(EspecialidadeRepository repo) {
        this.repo = repo;
    }

    @Override
    public void delete(Long id) {
        // EspecialidadeModel registro = repo.findById(id).orElse(null);
        // repo.delete(registro);
        repo.delete(repo.findById(id).orElse(null));
    }

    @Override
    public List<EspecialidadeModel> getAll() {
        return repo.findAll();
    }

    @Override
    public List<EspecialidadeModel> getByAll(String termoBusca) {
        return repo.findByAll(termoBusca);
    }

    @Override
    public EspecialidadeModel getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public EspecialidadeModel save(EspecialidadeModel objeto) {
        return repo.save(objeto);
    }    
}
