package com.ironman.fashionstore.infrastructure.persistence.r2dbc.repository;

import com.ironman.fashionstore.infrastructure.persistence.r2dbc.entity.CategoryR2dbcEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface CategoryR2dbcRepository extends R2dbcRepository<CategoryR2dbcEntity, Integer> {
}
