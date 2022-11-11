package br.ufac.sgcmapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class ProfissionalModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String registroConselho;
    
    @Column(nullable = false)
    private String telefone;

    @ManyToOne(optional=false)
    private EspecialidadeModel especialidade;

    @ManyToOne(optional=false)
    private UnidadeModel unidade;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getRegistroConselho() {
        return registroConselho;
    }
    public void setRegistroConselho(String registroConselho) {
        this.registroConselho = registroConselho;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public EspecialidadeModel getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(EspecialidadeModel especialidade) {
        this.especialidade = especialidade;
    }
    public UnidadeModel getUnidade() {
        return unidade;
    }
    public void setUnidade(UnidadeModel unidade) {
        this.unidade = unidade;
    }

    
}
