package com.example.onlineshop.mapstruct.dtos.salesman;

import com.example.onlineshop.models.Contacts;
import com.example.onlineshop.models.PersonName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@ToString
public class SalesmanPostDto {

    @JsonProperty("full_name")
    @NotNull
    private PersonName personName;

    @JsonProperty("contacts")
    @NotNull
    private Contacts contacts;

    @JsonProperty("dateOfBirth")
    @NotNull
    private Date dateOfBirth;

    @JsonProperty("dateOfHiring")
    @NotNull
    private Date dateOfHiring;

    @JsonProperty("password")
    @NotNull
    private String password;

    @JsonProperty("role")
    @NotNull
    private String role;

}
