package com.ironman.fashionstore.application.service;

import com.ironman.fashionstore.application.dto.category.CategoryDetailResponse;
import com.ironman.fashionstore.application.dto.category.CategoryRequest;
import com.ironman.fashionstore.application.dto.category.CategoryResponse;
import com.ironman.fashionstore.application.dto.category.CategorySummaryResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryService {
    Flux<CategorySummaryResponse> findAll();

    Mono<CategoryDetailResponse> findById(Integer id);

    Mono<CategoryResponse> create(CategoryRequest request);

    Mono<CategoryResponse> update(Integer id, CategoryRequest request);

    Mono<CategoryResponse> disable(Integer id);
}
