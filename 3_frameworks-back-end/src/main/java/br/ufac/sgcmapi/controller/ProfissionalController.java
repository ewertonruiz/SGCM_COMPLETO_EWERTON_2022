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

import br.ufac.sgcmapi.model.ProfissionalModel;
import br.ufac.sgcmapi.service.ProfissionalService;


@RestController
@RequestMapping("/")
public class ProfissionalController implements ICrudController<ProfissionalModel>{

    private final ProfissionalService servico;

    @Autowired
    public ProfissionalController(ProfissionalService servico) {
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
    public ResponseEntity<List<ProfissionalModel>> getAll() {
        List<ProfissionalModel> registros = servico.getAll();
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @Override
    @GetMapping("/busca/{termoBusca}")
    public ResponseEntity<List<ProfissionalModel>> getByAll(@PathVariable("termoBusca") String termoBusca) {
        List<ProfissionalModel> registros = servico.getByAll(termoBusca);
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalModel> getById(@PathVariable("id") Long id) {
        ProfissionalModel registro = servico.getById(id);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<ProfissionalModel> insert(@RequestBody ProfissionalModel objeto) {
        ProfissionalModel registro = servico.save(objeto);
        return new ResponseEntity<>(registro, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<ProfissionalModel> update(ProfissionalModel objeto) {
        ProfissionalModel registro = servico.save(objeto);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }
}
