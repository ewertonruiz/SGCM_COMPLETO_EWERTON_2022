package br.ufac.sgcmapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufac.sgcmapi.model.ConvenioModel;
import br.ufac.sgcmapi.repository.ConvenioRepository;

@Service
public class ConvenioService implements ICrudService<ConvenioModel>{

    private final ConvenioRepository repo;

    @Autowired
    public ConvenioService(ConvenioRepository repo) {
        this.repo = repo;
    }

    @Override
    public void delete(Long id) {
        // ConvenioModel registro = repo.findById(id).orElse(null);
        // repo.delete(registro);
        repo.delete(repo.findById(id).orElse(null));
    }

    @Override
    public List<ConvenioModel> getAll() {
        return repo.findAll();
    }

    @Override
    public ConvenioModel getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public ConvenioModel save(ConvenioModel objeto) {
        return repo.save(objeto);
    }

    @Override
    public List<ConvenioModel> getByAll(String termoBusca) {
        return repo.findByAll(termoBusca);
    }
}
