package com.ironman.fashionstore.domain.business;

import com.ironman.fashionstore.domain.business.enums.StatusEnum;
import com.ironman.fashionstore.domain.business.exception.DataNotFoundException;
import com.ironman.fashionstore.domain.model.Category;
import com.ironman.fashionstore.domain.port.in.CategoryUseCase;
import com.ironman.fashionstore.domain.port.out.CategoryOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class CategoryUseCaseImpl implements CategoryUseCase {

    private final CategoryOutputPort categoryOutputPort;


    @Override
    public Flux<Category> findAll() {
        return categoryOutputPort.findAll();
    }

    @Override
    public Mono<Category> findById(Integer id) {
        return categoryOutputPort.findById(id)
                .switchIfEmpty(notFoundCategory(id));

    }

    @Override
    public Mono<Category> create(Category category) {
        category.setStatus(StatusEnum.ENABLED.getCode());
        category.setCreatedAt(LocalDateTime.now());

        return categoryOutputPort.save(category);
    }

    @Override
    public Mono<Category> update(Integer id, Category category) {
        return categoryOutputPort.findById(id)
                .switchIfEmpty(notFoundCategory(id))
                .map(categoryFound -> {
                    BeanUtils.copyProperties(categoryFound, category);
                    categoryFound.setUpdatedAt(LocalDateTime.now());

                    return categoryFound;
                })
                .flatMap(categoryOutputPort::save);
    }

    @Override
    public Mono<Category> disable(Integer id) {
        return categoryOutputPort.findById(id)
                .switchIfEmpty(notFoundCategory(id))
                .map(categoryFound -> {
                    categoryFound.setStatus(StatusEnum.DISABLED.getCode());
                    categoryFound.setUpdatedAt(LocalDateTime.now());

                    return categoryFound;
                })
                .flatMap(categoryOutputPort::save);
    }

    private Mono<Category> notFoundCategory(Integer id) {
        return Mono.error(new DataNotFoundException("Category not found with id: " + id));
    }
}
