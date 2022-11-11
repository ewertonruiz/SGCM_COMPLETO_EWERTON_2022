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

import br.ufac.sgcmapi.model.PacienteModel;
import br.ufac.sgcmapi.service.PacienteService;


@RestController
@RequestMapping("/paciente")
public class PacienteController implements ICrudController<PacienteModel> {

    private final PacienteService servico;

    @Autowired
    public PacienteController(PacienteService servico) {
        this.servico = servico;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<PacienteModel>> getAll() {
        List<PacienteModel> registros = servico.getAll();
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<PacienteModel> getById(@PathVariable("id") Long id) {
        PacienteModel registro = servico.getById(id);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @GetMapping("/busca/{termoBusca}")
    public ResponseEntity<List<PacienteModel>> getByAll(@PathVariable("termoBusca") String termoBusca) {
        List<PacienteModel> registros = servico.getByAll(termoBusca);
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<PacienteModel> insert(@RequestBody PacienteModel objeto) {
        PacienteModel registro = servico.save(objeto);
        return new ResponseEntity<>(registro, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<PacienteModel> update(@RequestBody PacienteModel objeto) {
        PacienteModel registro = servico.save(objeto);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        servico.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
