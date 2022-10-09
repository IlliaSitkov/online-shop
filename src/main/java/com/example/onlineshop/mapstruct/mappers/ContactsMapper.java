package com.example.onlineshop.mapstruct.mappers;

import com.example.onlineshop.mapstruct.dtos.contacts.ContactsPutDto;
import com.example.onlineshop.models.Contacts;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactsMapper {

    Contacts contactsPutDtoToContacts(ContactsPutDto contactsPutDto);

}
