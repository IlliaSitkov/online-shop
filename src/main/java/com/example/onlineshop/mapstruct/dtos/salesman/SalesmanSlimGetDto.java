package com.example.onlineshop.mapstruct.dtos.salesman;

import com.example.onlineshop.models.PersonName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SalesmanSlimGetDto {

    @JsonProperty("id")
    @NotNull
    private Long id;

    @JsonProperty("full_name")
    @NotNull
    private PersonName personName;

}
