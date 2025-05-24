package com.ironman.fashionstore.domain.port.in;

import com.ironman.fashionstore.domain.model.Category;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryUseCase {
    Flux<Category> findAll();

    Mono<Category> findById(Integer id);

    Mono<Category> create(Category category);

    Mono<Category> update(Integer id, Category category);

    Mono<Category> disable(Integer id);
}
