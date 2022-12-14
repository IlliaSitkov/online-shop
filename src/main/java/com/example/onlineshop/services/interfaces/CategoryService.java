package com.example.onlineshop.services.interfaces;

import com.example.onlineshop.mapstruct.dtos.filterBoundsDtos.CategoryFilterBoundsDto;
import com.example.onlineshop.models.Category;

public interface CategoryService {

    Category addCategory(String name, String description);
    Category addCategory(Category category);

    boolean categoryExistsById(Long id);
    //boolean categoryExistsByName(String name);

    boolean deleteCategory(Long id); // throws CategoryNotFoundException;
    Category updateCategory(Long id, String name, String description);
    Category updateCategory(Category category);
    Category updateCategoryNoCheck(Category category);
    Category getCategoryById(Long id); // throws CategoryNotFoundException;

    //Category getCategoryByName(String name) throws Exception;
    Iterable<Category> getAll();
    CategoryFilterBoundsDto getCategoryFilterBounds();

    Iterable<Category> getCategoriesFilteredByCustomersAndProductsQuantity(int customersQuant, int productsQuant);
    Iterable<Category> getCategoriesFilteredByCustomersAndProductsQuantityWithMaxProductsQuantity(int customersQuant, int productsQuant);
}
