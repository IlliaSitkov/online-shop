package com.example.onlineshop.services.interfaces;

import com.example.onlineshop.models.Address;
import com.example.onlineshop.models.Contacts;
import com.example.onlineshop.models.Provider;
import com.example.onlineshop.repositories.queryinterfaces.MinMaxValues;

public interface ProviderService {

    Provider addProvider(String name, Address address, Contacts contacts);
    Provider addProvider(Provider provider);

    boolean providerExistsByEdrpou(Long edrpou);
    //boolean providerExistsByName(String name);

    boolean deleteProvider(Long edrpou); // throws ProviderNotFoundException;
    Provider updateProvider(Long edrpou, String name, Address address, Contacts contacts);
    Provider updateProvider(Provider provider);
    Provider updateProviderNoCheck(Provider provider);
    Provider getProviderByEdrpou(Long edrpou); // throws ProviderNotFoundException;

    //Provider getProviderByName(String name) throws Exception;
    Iterable<Provider> getAll();

    Iterable<Provider> getProvidersFilteredByProductsQuantity(int quantity);
    Iterable<Provider> getProvidersFilteredByProductsQuantityAndJustSalesmenOfProvider(int quantity, Long providerEdrpou);
    MinMaxValues getMinMaxProductsQuantity();

    Iterable<Provider> findName(String name);
}
