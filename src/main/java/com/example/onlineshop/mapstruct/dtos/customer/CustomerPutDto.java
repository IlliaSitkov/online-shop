package com.example.onlineshop.mapstruct.dtos.customer;

import com.example.onlineshop.mapstruct.dtos.contacts.ContactsPutDto;
import com.example.onlineshop.models.Address;
import com.example.onlineshop.models.PersonName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CustomerPutDto {

    @JsonProperty("full_name")
    @NotNull
    private PersonName personName;

    @JsonProperty("contacts")
    @NotNull
    private ContactsPutDto contacts;

    @JsonProperty("address")
    @NotNull
    private Address address;

}
