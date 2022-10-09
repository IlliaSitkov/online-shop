package com.example.onlineshop.mapstruct.dtos.provider;


import com.example.onlineshop.models.Address;
import com.example.onlineshop.models.Contacts;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProviderGetDto {

    @JsonProperty("edrpou")
    @NotNull
    private Long edrpou;

    @JsonProperty("name")
    @NotNull
    private String name;

    @JsonProperty("address")
    @NotNull
    private Address address;

    @JsonProperty("contacts")
    @NotNull
    private Contacts contacts;

}
