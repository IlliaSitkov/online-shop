package com.example.onlineshop.mapstruct.dtos.customer;

import com.example.onlineshop.models.Address;
import com.example.onlineshop.models.Contacts;
import com.example.onlineshop.models.PersonName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class CustomerPostDto {

    @JsonProperty("full_name")
    @NotNull
    private PersonName personName;

    @JsonProperty("contacts")
    @NotNull
    private Contacts contacts;

    @JsonProperty("address")
    @NotNull
    private Address address;

}
