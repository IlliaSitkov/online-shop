package com.example.onlineshop.services.interfaces;

import com.example.onlineshop.mapstruct.dtos.filterBoundsDtos.ProductFilterBoundsDto;
import com.example.onlineshop.models.Category;
import com.example.onlineshop.models.Product;
import com.example.onlineshop.models.Provider;

import java.util.List;

public interface ProductService {

    Product addProduct(String name, String description, int quantity, double price, Provider provider, Category category);
    Product addProduct(Product product);

    boolean productExistsByArticul(Long articul);
    //boolean productExistsByName(String name);

    boolean deleteProduct(Long articul); // throws ProductNotFoundException;
    Product updateProduct(Long articul, String name, String description, int quantity, double price, Provider provider, Category category);
    Product updateProduct(Product product);
    Product updateProductNoCheck(Product product);
    Product getProductByArticul(Long articul); // throws ProductNotFoundException;

    //Product getProductByName(String name) throws Exception;
    Iterable<Product> getAll();

    Iterable<Product> getFilteredProducts(int quantity, double price, List<Long> providersEdrpous, List<Long> categoriesIds);
    Iterable<Product> getFilteredProductsWithProduct(int quantity, double price, List<Long> providersEdrpous, List<Long> categoriesIds, Long productArticul);
    ProductFilterBoundsDto getProductFilterBounds();
}
