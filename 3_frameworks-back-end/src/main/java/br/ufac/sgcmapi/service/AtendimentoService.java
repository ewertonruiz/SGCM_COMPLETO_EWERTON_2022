package br.ufac.sgcmapi.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufac.sgcmapi.model.AtendimentoModel;
import br.ufac.sgcmapi.model.StatusEnum;
import br.ufac.sgcmapi.repository.AtendimentoRepository;

@Service
public class AtendimentoService implements ICrudService<AtendimentoModel> {

    // o atributo abaixo que acessará o equivalente ao DAO
    private final AtendimentoRepository repo;

    // O que faz a injeçao de dependencia e toda vez que AtendimentoService for instanciado
    // será acessado os dados por meio do atributo repo
    @Autowired
    public AtendimentoService(AtendimentoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<AtendimentoModel> getAll() {
        /*
         * o equivalente seria:
         *  List<AtendimentoModel> atendimentos = repo.findAll();
         *  return atendimentos;
         */
        return repo.findAll();
    }

    @Override
    public AtendimentoModel getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public AtendimentoModel save(AtendimentoModel objeto) {
        return repo.save(objeto);
    }
    
    @Override
    public void delete(Long id) {
        AtendimentoModel registro = repo.findById(id).orElse(null);
        registro.setStatusEnum(StatusEnum.CANCELADO);
        repo.save(registro);
    }

    /*
     * Todos os métodos acima foram implementados a partir da interface, com um @Override
     * Porém o metodo abaixo trata-se de uma regra de negócio exclusiva do Atendimento.
     * Portanto, ele é implementado apenas aqui e não deve ir para a Interface
     */
    public AtendimentoModel updateStatus(Long id){
        AtendimentoModel registro = repo.findById(id).orElse(null);
        registro.setStatusEnum(registro.getStatus().proximo());
        repo.save(registro);
        return registro;
    }
    

    public List<AtendimentoModel> getByAll(String termoBusca) {
        return repo.findByAll(termoBusca);
    }

    public List<AtendimentoModel> getByProfissionalAndData(Long profissional_id, Date atendimento_dt) {
        return repo.findByProfissionalAndData(profissional_id, atendimento_dt);
    }
}
