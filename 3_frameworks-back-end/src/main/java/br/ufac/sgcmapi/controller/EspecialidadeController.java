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

import br.ufac.sgcmapi.model.EspecialidadeModel;
import br.ufac.sgcmapi.service.EspecialidadeService;

@RestController
@RequestMapping("/config/especialidade")
public class EspecialidadeController implements ICrudController<EspecialidadeModel>{

    private final EspecialidadeService servico;

    @Autowired
    public EspecialidadeController(EspecialidadeService servico) {
        this.servico = servico;
    }

    @Override
    @DeleteMapping
    public ResponseEntity<?> delete(Long id) {
        servico.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<EspecialidadeModel>> getAll() {
        List<EspecialidadeModel> registros = servico.getAll();
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @Override
    @GetMapping("/busca/{termoBusca}")
    public ResponseEntity<List<EspecialidadeModel>> getByAll(@PathVariable("termoBusca") String termoBusca) {
        List<EspecialidadeModel> registros = servico.getByAll(termoBusca);
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadeModel> getById(@PathVariable("id") Long id) {
        EspecialidadeModel registro = servico.getById(id);
        return new ResponseEntity<EspecialidadeModel>(registro, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<EspecialidadeModel> insert(@RequestBody EspecialidadeModel objeto) {
        EspecialidadeModel registro = servico.save(objeto);
        return new ResponseEntity<>(registro, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<EspecialidadeModel> update(EspecialidadeModel objeto) {
        EspecialidadeModel registro = servico.save(objeto);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }


    
    
}
