package com.ironman.fashionstore.domain.port.out;

import com.ironman.fashionstore.domain.model.Category;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryOutputPort {
    Flux<Category> findAll();

    Mono<Category> findById(Integer id);

    Mono<Category> save(Category category);
}
