package br.ufac.sgcmapi.model;

//import java.sql.Time;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


//TODO: está permitindo salvar mais de um atendimento na mesma data, horário e pro mesmo profissional
//@Entity
// @Table(
//     uniqueConstraints = {
//         @UniqueConstraint = (
//             columnNames = {
//                 "data", "hora", "profissional_id"
//             }
//         )
//     }
// )
@Entity
public class AtendimentoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private Time hora;

    @ManyToOne
    private ConvenioModel convenio;
    
    @ManyToOne(optional = false)
    private PacienteModel paciente;
    
    @ManyToOne(optional = false)
    private ProfissionalModel profissional;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEnum status = StatusEnum.AGENDADO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public ConvenioModel getConvenio() {
        return convenio;
    }

    public void setConvenio(ConvenioModel convenio) {
        this.convenio = convenio;
    }

    public PacienteModel getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteModel paciente) {
        this.paciente = paciente;
    }

    public ProfissionalModel getProfissional() {
        return profissional;
    }

    public void setProfissional(ProfissionalModel profissional) {
        this.profissional = profissional;
    }

    public void setStatusEnum(StatusEnum status) {
        this.status = status;
    }

    public StatusEnum getStatus() {
        return status;
    }
}
