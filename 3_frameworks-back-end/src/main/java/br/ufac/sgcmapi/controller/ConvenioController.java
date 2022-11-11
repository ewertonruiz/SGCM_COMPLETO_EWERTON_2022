package br.ufac.sgcmapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufac.sgcmapi.model.ConvenioModel;
import br.ufac.sgcmapi.service.ConvenioService;

@RestController
@RequestMapping("/convenio")
public class ConvenioController implements ICrudController<ConvenioModel> {
    
    private final ConvenioService servico;

    @Autowired
    public ConvenioController(ConvenioService servico) {
        this.servico = servico;
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        servico.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<ConvenioModel>> getAll() {
        List<ConvenioModel> registros = servico.getAll();
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @Override
    @GetMapping("/busca/{termoBusca}")
    public ResponseEntity<List<ConvenioModel>> getByAll(@PathVariable("termoBusca") String termoBusca) {
        List<ConvenioModel> registros = servico.getByAll(termoBusca);
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ConvenioModel> getById(@PathVariable("id") Long id) {
        ConvenioModel registro = servico.getById(id);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<ConvenioModel> insert(@RequestBody ConvenioModel objeto) {
        ConvenioModel registro = servico.save(objeto);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<ConvenioModel> update(ConvenioModel objeto) {
        ConvenioModel registro = servico.save(objeto);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    
}
