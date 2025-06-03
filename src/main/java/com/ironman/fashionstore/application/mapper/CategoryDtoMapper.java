package com.ironman.fashionstore.application.mapper;

import com.ironman.fashionstore.application.dto.category.CategoryDetailResponse;
import com.ironman.fashionstore.application.dto.category.CategoryRequest;
import com.ironman.fashionstore.application.dto.category.CategoryResponse;
import com.ironman.fashionstore.application.dto.category.CategorySummaryResponse;
import com.ironman.fashionstore.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryDtoMapper {

    CategorySummaryResponse toSummaryResponse(Category category);

    CategoryDetailResponse toDetailResponse(Category category);

    CategoryResponse toResponse(Category category);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "urlKey", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Category toModel(CategoryRequest categoryRequest);
}
