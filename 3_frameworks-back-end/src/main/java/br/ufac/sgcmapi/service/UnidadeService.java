package br.ufac.sgcmapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufac.sgcmapi.model.UnidadeModel;
import br.ufac.sgcmapi.repository.UnidadeRepository;

@Service
public class UnidadeService implements ICrudService<UnidadeModel> {

    private final UnidadeRepository repo;

    @Autowired
    public UnidadeService(UnidadeRepository repo) {
        this.repo=repo;
    }

    @Override
    public void delete(Long id) {
        repo.delete(repo.findById(id).orElse(null));
        
    }

    @Override
    public List<UnidadeModel> getAll() {
        return repo.findAll();
    }

    @Override
    public UnidadeModel getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public UnidadeModel save(UnidadeModel objeto) {
        return repo.save(objeto);
    }

    @Override
    public List<UnidadeModel> getByAll(String termoBusca) {
        return repo.findByAll(termoBusca);
    }
}
