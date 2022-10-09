package com.example.onlineshop.mapstruct.dtos.user;

import com.example.onlineshop.models.Address;
import com.example.onlineshop.models.Contacts;
import com.example.onlineshop.models.PersonName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

@ToString
@Setter
@Getter
public class UserGetDto {

    @JsonProperty("id")
    @NotNull
    private Long id;

    @JsonProperty("full_name")
    @NotNull
    private PersonName personName;

    @JsonProperty("contacts")
    @NotNull
    private Contacts contacts;

    @JsonProperty("address")
    @Nullable
    private Address address;

    @JsonProperty("dateOfBirth")
    @Nullable
    private Date dateOfBirth;

    @JsonProperty("dateOfHiring")
    @Nullable
    private Date dateOfHiring;

}
