package br.ufac.sgcmapi.model;

public enum StatusEnum {
    CANCELADO,
    AGENDADO,
    CONFIRMADO,
    CHEGADA,
    ATENDIMENTO,
    ENCERRADO;

    // mudança de status conforme o atendimento "prossegue"
    public StatusEnum proximo() {
        StatusEnum status = this;

        try {
            status = values()[ordinal() + 1];
        } 
        catch (IndexOutOfBoundsException e) {
            status = values()[ordinal()];
        }

        return status;
    }
}
