package br.zupacademy.pedro.casadocodigo.pais;

import br.zupacademy.pedro.casadocodigo.validator.ExistIdValue;

import javax.validation.constraints.NotNull;

public class EstadoAndPaisRequestDTO {

    private Long estadoId;
    @NotNull
    @ExistIdValue(domainClass = Pais.class)
    private Long paisId;


    public EstadoAndPaisRequestDTO( Long estadoId, @NotNull Long paisId) {
        this.estadoId = estadoId;
        this.paisId = paisId;
    }

    public EstadoAndPaisRequestDTO( @NotNull Long paisId) {
        this.paisId = paisId;
    }


    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

    public Long getPaisId() {
        return paisId;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }
}
