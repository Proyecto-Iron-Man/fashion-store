package com.ironman.fashionstore.infrastructure.persistence.r2dbc.adapter;

import com.ironman.fashionstore.domain.model.Category;
import com.ironman.fashionstore.domain.port.out.CategoryOutputPort;
import com.ironman.fashionstore.infrastructure.persistence.r2dbc.entity.CategoryR2dbcEntity;
import com.ironman.fashionstore.infrastructure.persistence.r2dbc.mapper.CategoryR2dbcEntityMapper;
import com.ironman.fashionstore.infrastructure.persistence.r2dbc.repository.CategoryR2dbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Repository
public class CategoryOutputPortR2dbcImpl implements CategoryOutputPort {

    private CategoryR2dbcRepository categoryR2dbcRepository;
    private CategoryR2dbcEntityMapper categoryR2dbcEntityMapper;

    @Override
    public Flux<Category> findAll() {
        return categoryR2dbcRepository.findAll()
                .map(categoryR2dbcEntityMapper::toModel);
    }

    @Override
    public Mono<Category> findById(Integer id) {
        return categoryR2dbcRepository.findById(id)
                .map(categoryR2dbcEntityMapper::toModel);
    }

    @Override
    public Mono<Category> save(Category category) {
        CategoryR2dbcEntity entity = categoryR2dbcEntityMapper.toEntity(category);

        return categoryR2dbcRepository.save(entity)
                .map(categoryR2dbcEntityMapper::toModel);
    }
}
