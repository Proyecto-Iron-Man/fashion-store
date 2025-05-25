package com.ironman.fashionstore.application.service.impl;

import com.ironman.fashionstore.application.dto.category.CategoryDetailResponse;
import com.ironman.fashionstore.application.dto.category.CategoryRequest;
import com.ironman.fashionstore.application.dto.category.CategoryResponse;
import com.ironman.fashionstore.application.dto.category.CategorySummaryResponse;
import com.ironman.fashionstore.application.mapper.CategoryDtoMapper;
import com.ironman.fashionstore.application.service.CategoryService;
import com.ironman.fashionstore.domain.port.in.CategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryUseCase categoryUseCase;
    private final CategoryDtoMapper categoryDtoMapper;


    @Override
    public Flux<CategorySummaryResponse> findAll() {
        return categoryUseCase.findAll()
                .map(categoryDtoMapper::toSumnaryResponse);
    }

    @Override
    public Mono<CategoryDetailResponse> findById(Integer id) {
        return categoryUseCase.findById(id)
                .map(categoryDtoMapper::toDetailResponse);
    }

    @Override
    public Mono<CategoryResponse> create(CategoryRequest request) {
        return categoryUseCase.create(categoryDtoMapper.toModel(request))
                .map(categoryDtoMapper::toResponse);
    }

    @Override
    public Mono<CategoryResponse> update(Integer id, CategoryRequest request) {
        return categoryUseCase.update(id, categoryDtoMapper.toModel(request))
                .map(categoryDtoMapper::toResponse);
    }

    @Override
    public Mono<CategoryResponse> disable(Integer id) {
        return categoryUseCase.disable(id)
                .map(categoryDtoMapper::toResponse);
    }
}
