package br.ufac.sgcmapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import org.hibernate.annotations.ValueGenerationType;

@Entity
public class ConvenioModel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(nullable=false, updatable=false)
    private Long id;

    @Column(nullable=false)
    private Boolean ativo;

    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String razaoSocial;

    @Column(nullable = false)
    private String representante;

    @Column(nullable = false)
    private String telefone;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Boolean getAtivo() {
        return ativo;
    }
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
    public String getRazaoSocial() {
        return razaoSocial;
    }
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    public String getRepresentante() {
        return representante;
    }
    public void setRepresentante(String representante) {
        this.representante = representante;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    

}
