package com.example.onlineshop.mapstruct.mappers;

import com.databases.shop.mapstruct.dtos.contacts.ContactsPutDto;
import com.databases.shop.models.Contacts;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactsMapper {

    Contacts contactsPutDtoToContacts(ContactsPutDto contactsPutDto);

}
