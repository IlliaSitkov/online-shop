package com.example.onlineshop.mapstruct.mappers;

import com.example.onlineshop.mapstruct.dtos.provider.ProviderGetDto;
import com.example.onlineshop.mapstruct.dtos.provider.ProviderPostDto;
import com.example.onlineshop.mapstruct.dtos.provider.ProviderPutDto;
import com.example.onlineshop.mapstruct.dtos.provider.ProviderSlimGetDto;
import com.example.onlineshop.models.Provider;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProviderMapper {

    ProviderGetDto providerToProviderGetDto(Provider provider);

    Iterable<ProviderGetDto> providersToProvidersGetDto(Iterable<Provider> providers);

    ProviderSlimGetDto providerToProviderSlimGetDto(Provider provider);

    Iterable<ProviderSlimGetDto> providersToProvidersSlimGetDto(Iterable<Provider> providers);

    Provider providerPutDtoToProvider(ProviderPutDto providerPutDto);

    Provider providerPostDtoToProvider(ProviderPostDto providerPostDto);
}
