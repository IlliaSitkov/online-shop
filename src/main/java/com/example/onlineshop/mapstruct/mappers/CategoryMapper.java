package com.example.onlineshop.mapstruct.mappers;

import com.example.onlineshop.mapstruct.dtos.category.CategoryGetDto;
import com.example.onlineshop.mapstruct.dtos.category.CategoryPostDto;
import com.example.onlineshop.mapstruct.dtos.category.CategoryPutDto;
import com.example.onlineshop.mapstruct.dtos.category.CategorySlimGetDto;
import com.example.onlineshop.models.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryGetDto categoryToCategoryGetDto(Category category);

    Iterable<CategoryGetDto> categoriesToCategoriesGetDto(Iterable<Category> categories);

    CategorySlimGetDto categoryToCategorySlimGetDto(Category category);

    Iterable<CategorySlimGetDto> categoriesToCategoriesSlimGetDto(Iterable<Category> categories);

    Category categoryPutDtoToCategory(CategoryPutDto categoryPutDto);

    Category categoryPostDtoToCategory(CategoryPostDto categoryPostDto);
}
