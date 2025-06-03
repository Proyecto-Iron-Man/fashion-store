package com.ironman.fashionstore.infrastructure.persistence.r2dbc.mapper;

import com.ironman.fashionstore.domain.model.Category;
import com.ironman.fashionstore.infrastructure.persistence.r2dbc.entity.CategoryR2dbcEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryR2dbcEntityMapper {

    Category toModel(CategoryR2dbcEntity entity);

    CategoryR2dbcEntity toEntity(Category model);
}
