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

import br.ufac.sgcmapi.model.UnidadeModel;
import br.ufac.sgcmapi.service.UnidadeService;

@RestController
@RequestMapping("/config/unidade")
public class UnidadeController implements ICrudController<UnidadeModel>{

    public final UnidadeService servico;

    @Autowired
    public UnidadeController(UnidadeService servico)
    {
        this.servico = servico;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<UnidadeModel>> getAll() {
        List<UnidadeModel> registros = servico.getAll();
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UnidadeModel> getById(@PathVariable("id") Long id) {
        UnidadeModel registro = servico.getById(id);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{termoBusca}")
    public ResponseEntity<List<UnidadeModel>> getByAll(@PathVariable("termoBusca") String termoBusca) {
        List<UnidadeModel> registros = servico.getByAll(termoBusca);
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<UnidadeModel> insert(@RequestBody UnidadeModel objeto) {
        UnidadeModel registro = servico.save(objeto);
        return new ResponseEntity<>(registro, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<UnidadeModel> update(@RequestBody UnidadeModel objeto) {
        UnidadeModel registro = servico.save(objeto);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        servico.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
