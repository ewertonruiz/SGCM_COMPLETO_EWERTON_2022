package br.ufac.sgcmapi.controller;

import java.sql.Date;
import java.util.ArrayList;
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

import br.ufac.sgcmapi.model.AtendimentoModel;
import br.ufac.sgcmapi.service.AtendimentoService;


@RestController
@RequestMapping("/atendimento")
public class AtendimentoController implements ICrudController<AtendimentoModel> {

    private final AtendimentoService servico;

    @Autowired
    public AtendimentoController(AtendimentoService servico) {
        this.servico=servico;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<AtendimentoModel>> getAll() {
        List<AtendimentoModel> registros = servico.getAll();
        System.out.println(registros);
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<AtendimentoModel> getById(@PathVariable("id") Long id) {
        AtendimentoModel registros = servico.getById(id);
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<AtendimentoModel> insert(@RequestBody AtendimentoModel objeto) {
        AtendimentoModel registros = servico.save(objeto);
        return new ResponseEntity<>(registros, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<AtendimentoModel> update(AtendimentoModel objeto) {
        AtendimentoModel registros = servico.save(objeto);
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        servico.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<AtendimentoModel> updateStatus(@PathVariable("id") Long id) {
        AtendimentoModel registro = servico.updateStatus(id);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }


    @Override
    @PostMapping("/busca/{termoBusca}")
    public ResponseEntity<List<AtendimentoModel>> getByAll(@PathVariable("termoBusca") String termoBusca) {

        List<AtendimentoModel> registros = servico.getByAll(termoBusca);
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @GetMapping("/{id}/{data}")
    public ResponseEntity<List<String>> getByProfissionalAndData(@PathVariable("id") Long id, @PathVariable("data") Date data) {
        List<AtendimentoModel> registros = servico.getByProfissionalAndData(id, data);
        List<String> resposta = new ArrayList<>();

        for (AtendimentoModel r : registros) {
            resposta.add(r.getHora().toString());
        }

        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    //Criar um endpoint quer permita filtrar os atendimentos por status.
    @GetMapping("/busca/status/{termoBusca2}")
    public ResponseEntity<List<AtendimentoModel>> getByStatus(@PathVariable("termoBusca2") String termoBusca2) {
        
        List<AtendimentoModel> registros = servico.getAll();
        List<AtendimentoModel> selecionados = new ArrayList<>();
        
        for (AtendimentoModel item: registros) {
            if(termoBusca2.contains(item.getStatus().name())){
                selecionados.add(item);
            }
        }
        return new ResponseEntity<>(selecionados, HttpStatus.OK);
    }

}
